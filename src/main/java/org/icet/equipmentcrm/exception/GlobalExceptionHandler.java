package org.icet.equipmentcrm.exception;

import org.icet.equipmentcrm.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    ResponseEntity<ErrorResponse> handlePersonNotFoundException(PersonNotFoundException ex){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .status("FAILED")
                .build();
        return ResponseEntity.ok().body(errorResponse);
    }
}