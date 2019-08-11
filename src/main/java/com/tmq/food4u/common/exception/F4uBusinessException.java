package com.tmq.food4u.common.exception;

import com.tmq.food4u.common.constant.F4UErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: quytm
 * Email : minhquylt95@gmail.com
 * Date  : Aug 07, 2019
 */
@Getter
@Setter
public class F4uBusinessException extends RuntimeException {

    protected String code;
    protected String data;

    public F4uBusinessException(String code) {
        super();
        this.code = code;
    }

    public F4uBusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public F4uBusinessException(String code, String data, String message) {
        super(data + " : " + message);
        this.code = code;
        this.data = data;
    }

    public static class InvalidInputException extends F4uBusinessException {

        private static final long serialVersionUID = 4835774135375067631L;

        public InvalidInputException() {
            super(F4UErrorCode.INVALID_INPUT_CODE, F4UErrorCode.INVALID_INPUT_MESSAGE);
        }

        public InvalidInputException(String message) {
            super(F4UErrorCode.INVALID_INPUT_CODE, message);
        }

        public InvalidInputException(String field, String message) {
            super(F4UErrorCode.INVALID_INPUT_CODE, field, message);
        }

    }

    public static class NotFoundEntityException extends F4uBusinessException {

        private static final long serialVersionUID = -5447173555951242083L;

        public NotFoundEntityException() {
            super(F4UErrorCode.NOT_FOUND_ENTITY_CODE, F4UErrorCode.NOT_FOUND_ENTITY_MESSAGE);
        }

        public NotFoundEntityException(String message) {
            super(F4UErrorCode.NOT_FOUND_ENTITY_CODE, message);
        }

        public NotFoundEntityException(String field, String message) {
            super(F4UErrorCode.NOT_FOUND_ENTITY_CODE, field, message);
        }

    }

    public static class FailedToExecuteException extends F4uBusinessException {

        private static final long serialVersionUID = 2125777865234583584L;

        public FailedToExecuteException() {
            super(F4UErrorCode.FAILED_TO_EXECUTE_CODE, F4UErrorCode.FAILED_TO_EXECUTE_MESSAGE);
        }

        public FailedToExecuteException(String message) {
            super(F4UErrorCode.FAILED_TO_EXECUTE_CODE, message);
        }

        public FailedToExecuteException(String field, String message) {
            super(F4UErrorCode.FAILED_TO_EXECUTE_CODE, field, message);
        }

    }

}
