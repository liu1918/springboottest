package com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private Long id;
    private String user_name;
    private String password;
    private String name;
}
