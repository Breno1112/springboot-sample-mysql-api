package com.breno.api.sample.mysql.domain.dtos.response;

public class DeleteResponseDTO {

    private boolean deleted;

    public DeleteResponseDTO() {

    }

    public DeleteResponseDTO(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean newDeleted) {
        this.deleted = newDeleted;
    }
}
