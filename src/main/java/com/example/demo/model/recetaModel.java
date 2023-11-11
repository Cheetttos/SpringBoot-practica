package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class recetaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    @Column
    private String ingredientes;
    @Column
    private int tiempo_preparacion; //minutos
    @Column
    private String dificultad; // Facil, intermedio, dificil
    @Column
    private String imagen;
    @Column
    private String video;
}
