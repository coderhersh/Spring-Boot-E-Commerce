package com.ecommerce.ECommerce.Exception;

public class DepartmenNotFoundException extends Exception {
    public DepartmenNotFoundException() {
        super();
    }

    public DepartmenNotFoundException(String message) {
        super(message);
    }

    public DepartmenNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmenNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartmenNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
