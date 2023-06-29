package com.breno.api.sample.mysql.domain.dtos.request;

public class CreateUserRequestDTO {
    
    private String name;
    
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer newAge) {
        this.age = newAge;
    }
}
