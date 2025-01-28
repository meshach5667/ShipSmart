package com.mesh.delivery.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private float weight;
    private String code;

    public Item() {
    }

    public Item(Long id, String name, float weight, String code) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.code = code;
    }

}