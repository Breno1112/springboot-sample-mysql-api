package com.breno.api.sample.mysql.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "USUARIO")
public class UserEntity {

    @Id
    @Column(value = "ID")
    private String id;
    
    @Column(value = "NAME")
    private String name;
    
    @Column(value = "AGE")    
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