package com.example.authmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name="roles")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="role_id")
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    public RoleEntity(String name) {
        this.name = name;
    }
}
