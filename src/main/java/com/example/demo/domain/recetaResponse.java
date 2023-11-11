package com.example.demo.domain;

import com.example.demo.model.recetaModel;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class recetaResponse extends genericResponse {

    private recetaModel receta;
    private List<recetaModel> listReceta;
    HashMap<String,Object> datos= new HashMap<>();

    public recetaResponse(recetaModel receta, String message, int status, boolean flag){
        super(flag, message, status);
        this.receta=receta;
    }

    public recetaResponse(String message,int status,boolean flag){
        super(flag, message, status);
    }

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.receta);
        return datos;
    }

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listReceta);
        return datos;
    }
}
