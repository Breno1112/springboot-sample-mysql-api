package com.breno.api.sample.mysql.domain.dtos.response;

public class UserDTO {
    
    private String id;
    
    private String name;
    
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer newAge) {
        this.age = newAge;
    }
}
