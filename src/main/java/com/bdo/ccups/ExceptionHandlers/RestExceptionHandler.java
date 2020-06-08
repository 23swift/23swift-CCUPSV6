package com.bdo.ccups.ExceptionHandlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // @Override
    // protected ResponseEntity<Object>
    // handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders
    // headers, HttpStatus status, WebRequest request) {
    // String error = "Malformed JSON request";
    // return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    // }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // @Override
    // protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
    //         org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
    //             String error = "Malformed JSON request";
    //             return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    //     // return super.handleHttpMessageNotReadable(ex, headers, status, request);
    // }

    @ExceptionHandler(com.bdo.ccups.ExceptionHandlers.EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    /**
     * Handle javax.persistence.EntityNotFoundException
     */
    @ExceptionHandler(javax.persistence.EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(javax.persistence.EntityNotFoundException ex) {
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, ex));
    }
   //other exception handlers below

   @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage("Validation error");
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
        return buildResponseEntity(apiError);
    }

}   