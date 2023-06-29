package com.breno.api.sample.mysql.domain.dtos.response;

public class CreateUserResponseDTO {
    private boolean success;

    private String error;

    public boolean getSuccess() {
        return this.success;
    }

    public String getError() {
        return this.error;
    }

    public void setSuccess(boolean newSuccess) {
        this.success = newSuccess;
    }

    public void setError(String newError) {
        this.error = newError;
    }
}
