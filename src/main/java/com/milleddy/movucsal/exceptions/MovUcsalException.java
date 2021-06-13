package com.milleddy.movucsal.exceptions;


import org.springframework.http.HttpStatus;

public class MovUcsalException extends RuntimeException {

    private final HttpStatus status;

    public MovUcsalException(String msg) {
        super(msg);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public MovUcsalException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

}
