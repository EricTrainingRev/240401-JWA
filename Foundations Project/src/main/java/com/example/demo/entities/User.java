package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@ToString(exclude = {"userPassword"})
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_username")
    private String userUsername;
    @Column(name = "user_password")
    private String userPassword;

}
