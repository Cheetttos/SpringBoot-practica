package com.example.demo.repository;

import com.example.demo.model.recetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface recetaRepository extends JpaRepository<recetaModel,Long> {
    List<recetaModel> findByTituloContainingIgnoreCase(String titulo);
}
