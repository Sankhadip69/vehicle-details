package com.learn2code.api.vehicle.details.exception;

public class MandatoryFieldsMissingException extends RuntimeException {
    public MandatoryFieldsMissingException(String allErrors) {
        super(allErrors);
    }
}
