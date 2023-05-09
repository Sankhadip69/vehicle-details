package com.learn2code.api.vehicle.details.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseStatus
public class VehicleDetailsExceptionHandler {

    @ExceptionHandler(MandatoryFieldsMissingException.class)
    public ResponseEntity<ErrorResponse> handleMandatoryFieldsMissingException(MandatoryFieldsMissingException ex) {

        String message = ex.getMessage();
       List<String> errors = Arrays.stream(message.split(",")).collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                errors
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(VehicleNotSavedException.class)
    public ResponseEntity<ErrorResponse> handleVehicleNotSavedException(VehicleNotSavedException ex) {

        String message = ex.getMessage();
        List<String> errors = Arrays.stream(message.split(",")).collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.EXPECTATION_FAILED,
                errors
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(VehicleDetailsNotFound.class)
    public ResponseEntity<ErrorResponse> handleVehicleDetailsNotFound(VehicleDetailsNotFound ex) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                Arrays.asList(ex.getMessage())
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
