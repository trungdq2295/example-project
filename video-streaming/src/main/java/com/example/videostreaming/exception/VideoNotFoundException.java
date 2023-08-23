package com.example.videostreaming.exception;

import lombok.Data;

@Data
public class VideoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    public VideoNotFoundException(String msg) {
        super(msg);
    }

    public VideoNotFoundException(String msg, int code) {
        super(msg);
        this.code = code;
    }
}
