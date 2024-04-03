package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "planets")
public class Planet {
    
    @Id
    @Column(name = "planet_id")
    private int planetId;
    @Column(name = "planet_name")
    private String planetName;
    @Column(name = "owner_id")
    private int ownerId;

}
