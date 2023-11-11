package com.example.demo.service;

import com.example.demo.domain.recetaResponse;
import com.example.demo.model.recetaModel;
import com.example.demo.repository.recetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class recetaService {
    private final recetaRepository recetaRepository;

    recetaResponse response;

    @Autowired
    public recetaService(recetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public List<recetaModel> getReceta() {
        return recetaRepository.findAll();
    }

    public List<recetaModel> buscarRecetasPorCadena(String cadena) {
        return recetaRepository.findByTituloContainingIgnoreCase(cadena);
    }
    public  ResponseEntity<Object> newReceta(recetaModel receta) {
        this.recetaRepository.save(receta);
        response = new recetaResponse(receta, "Se creó la receta con éxito",200,true );
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    }

    public  ResponseEntity<Object> updateReceta(Long id, recetaModel receta) {
        if (recetaRepository.findById(id).isPresent()) {
            recetaModel existingReceta = recetaRepository.findById(id).get();
            //titulo
            existingReceta.setTitulo(receta.getTitulo());
            recetaRepository.save(existingReceta);
            //ingredientes
            existingReceta.setIngredientes(receta.getIngredientes());
            recetaRepository.save(existingReceta);
            //tiempo
            existingReceta.setTiempo_preparacion(receta.getTiempo_preparacion());
            recetaRepository.save(existingReceta);
            //dificultad
            existingReceta.setDificultad(receta.getDificultad());
            recetaRepository.save(existingReceta);
            //imagen
            existingReceta.setImagen(receta.getImagen());
            recetaRepository.save(existingReceta);
            //video
            existingReceta.setVideo(receta.getVideo());
            recetaRepository.save(existingReceta);
            response = new recetaResponse(existingReceta, "Se pudo actualizar", 200, true);
        } else {
            response = new recetaResponse("No existe el ID: " + id, 400, false);
        }
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    }

    public ResponseEntity<Object>  eliminar(Long id){
        //Verificar si esta vacio
        if(!this.recetaRepository.findById(id).isEmpty()){
            this.recetaRepository.deleteById(id);
            response = new recetaResponse("Se elimino la receta con el id: "+id,200,true );
        }else{
            response = new recetaResponse("No existe receta con el id: "+id,400,false );
        }
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getOne(Long id){
        if (recetaRepository.findById(id).isPresent()) {
            recetaModel receta = recetaRepository.findById(id).get();
            response = new recetaResponse(receta, "Si encontró el ID: " + id, 200, true);
        } else {
            response = new recetaResponse("No existe el ID: " + id, 400, false);
        }
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    }


}
