package com.appdevelopbog.app.ws.demo.exceptions;

import com.appdevelopbog.app.ws.demo.ui.model.response.AccountErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {AccountServiceException.class})
    public ResponseEntity<Object> handleAccountServiceException(AccountServiceException ex, WebRequest request){
        AccountErrorMessage errorMessage = new AccountErrorMessage(ex.getDetail(),ex.getStatus(),ex.getInstance());
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
}
