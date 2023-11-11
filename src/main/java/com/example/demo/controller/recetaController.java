package com.example.demo.controller;

import com.example.demo.model.recetaModel;
import com.example.demo.service.recetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/receta")
public class recetaController {
    private final recetaService RecetaService;

    @Autowired
    public recetaController(recetaService RecetaService){
        this.RecetaService = RecetaService;
    }

    @GetMapping("/all")
    public List<recetaModel> getReceta(){
        return RecetaService.getReceta();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getReceta(@PathVariable Long id){
        return this.RecetaService.getOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> nuevaReceta(@RequestBody recetaModel receta){
        return this.RecetaService.newReceta(receta);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarReceta(@PathVariable Long id,@RequestBody recetaModel receta){
        return this.RecetaService.updateReceta(id,receta);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarReceta(@PathVariable Long id) {

        return this.RecetaService.eliminar(id);

    }

    @GetMapping("/buscarTitulo")
    public ResponseEntity<Object> buscarRecetas(@RequestParam String cadena) {
        List<recetaModel> recetas = RecetaService.buscarRecetasPorCadena(cadena);

        return ResponseEntity.ok(recetas);
    }

}
