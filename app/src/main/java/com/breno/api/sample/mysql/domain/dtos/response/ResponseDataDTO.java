package com.breno.api.sample.mysql.domain.dtos.response;

public class ResponseDataDTO<T> {
    
    private T data;

    private String error;

    public ResponseDataDTO() {

    }

    public ResponseDataDTO(T data, String error) {
        this.error = error;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public String getError() {
        return this.error;
    }

    public void setData(T newData) {
        this.data = newData;
    }

    public void setError(String newError) {
        this.error = newError;
    }
}
