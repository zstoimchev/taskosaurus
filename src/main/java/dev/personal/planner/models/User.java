package dev.personal.planner.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Specify table name if needed
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}