package com.example.videostreaming.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "A video with this name already exists")
public class VideoAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    public VideoAlreadyExistsException(String msg) {
        super(msg);
    }

    public VideoAlreadyExistsException(String msg, int code) {
        super(msg);
        this.code = code;
    }
}
