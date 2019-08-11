package com.tmq.food4u.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import com.github.benmanes.caffeine.cache.Ticker;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 11, 2019
 */
@Data
@Configuration
@PropertySource(value = "classpath:cache.properties")
@ConfigurationProperties(prefix = "caching")
public class CachingConfig {

    private static final Logger logger = LoggerFactory.getLogger(CachingConfig.class);

    // Model for get Caching config ------------------------------------------------------------------------------------

    private Map<String, CacheSpec> specs;

    @Data
    private static class CacheSpec {
        private String name;
        private Integer timeout;
        private Integer max;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Bean
    public CacheManager cacheManager(Ticker ticker) {
        SimpleCacheManager manager = new SimpleCacheManager();
        if (specs == null) return manager;

        List<CaffeineCache> caches =
                specs.entrySet().stream()
                        .map(entry -> buildCache(entry.getValue(), ticker))
                        .collect(Collectors.toList());
        manager.setCaches(caches);

        return manager;
    }

    private CaffeineCache buildCache(CacheSpec cacheSpec, Ticker ticker) {
        logger.info("Cache {} specified timeout of {} min, max of {}", cacheSpec.getName(), cacheSpec.getTimeout(), cacheSpec.getMax());
        final Caffeine<Object, Object> caffeineBuilder
                = Caffeine.newBuilder()
                .expireAfterWrite(cacheSpec.getTimeout(), TimeUnit.SECONDS)
                .maximumSize(cacheSpec.getMax())
                .removalListener(new CustomRemovalListener())
                .ticker(ticker);
        return new CaffeineCache(cacheSpec.getName(), caffeineBuilder.build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }

    class CustomRemovalListener implements RemovalListener<Object, Object> {
        @Override
        public void onRemoval(Object key, Object value, RemovalCause cause) {
            logger.info("removal listener called with key [{}], cause [{}], evicted [{}]", key, cause, cause.wasEvicted());
        }
    }

}
