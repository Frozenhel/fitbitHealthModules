package com.anext.ihealthmodule.exception;

/**
 * Created by Jiri on 02/08/17.
 */

public class HttpCodeException extends Exception {
    private int code;

    public HttpCodeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public HttpCodeException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
