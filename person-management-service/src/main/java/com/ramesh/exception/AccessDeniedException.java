package com.ramesh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ramesh.Yaleru on 2/1/2020
 */
@ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Invalid/Missing Token Found")
public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(){
        super();
    }

    public AccessDeniedException (Throwable cause){
        super(cause);
    }

    public AccessDeniedException (String message, Throwable cause){
        super(message, cause);
    }

    public AccessDeniedException (String messgae ){
        super(messgae);
    }

}
