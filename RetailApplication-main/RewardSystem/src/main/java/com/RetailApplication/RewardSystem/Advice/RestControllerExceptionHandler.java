package com.RetailApplication.RewardSystem.Advice;

import com.RetailApplication.RewardSystem.Exception.RewardServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestControllerExceptionHandler {

    //To handle the exception that is specific to class RewardServiceException and logs the error message
    @ExceptionHandler(value = RewardServiceException.class)
    public ResponseEntity<?> handleRewardServiceException(
            RuntimeException e) {
        log.error("Error occurred: {}", e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    //To handle the Runtime Exceptions and log the error messahe
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(
            RuntimeException e) {
        log.error("Error occurred: {}", e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    //To handle other than the above handled exceptions and return with a generic message
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e) {
        log.error("Internal Server Error {}", e.getLocalizedMessage(), e);
        return new ResponseEntity<>("System Error. Please contact support", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
