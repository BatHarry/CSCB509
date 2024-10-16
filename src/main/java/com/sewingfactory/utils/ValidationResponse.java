package com.sewingfactory.utils;

public class ValidationResponse {
    private boolean hasError;
    private String errorMessage = "";
    
    public boolean hasError() {
        return hasError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ValidationResponse(boolean hasError) {
        this.hasError = hasError;
    }

    public ValidationResponse(boolean hasError, String errorMessage) {
        this.hasError = hasError;
        this.errorMessage = errorMessage;
    }
}
