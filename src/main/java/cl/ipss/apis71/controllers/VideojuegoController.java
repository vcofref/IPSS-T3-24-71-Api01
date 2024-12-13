package cl.ipss.apis71.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.apis71.models.Videojuego;
import cl.ipss.apis71.responses.VideojuegoResponse;
import cl.ipss.apis71.responses.VideojuegosResponse;
import cl.ipss.apis71.services.VideojuegoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("api")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @PostMapping(value="crear", produces = "application/json")
    public ResponseEntity<Object> createVideojuego(@RequestBody Videojuego videojuego){

        if(videojuego.getTitle().equals("")){
            throw new RuntimeException("El titulo es requerido");
        }

        videojuegoService.crear(videojuego);

        VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
        videojuegoResponse.setStatus(200);
        videojuegoResponse.setMessage("VideoJuego agregado correctamente");
        videojuegoResponse.setVideojuego(videojuego);

        return ResponseEntity.ok()
        .body(videojuegoResponse);
    }

    @GetMapping(value="listar", produces = "application/json")
    public ResponseEntity<Object> getVideojuegos(){
        VideojuegosResponse videojuegosResponse = new VideojuegosResponse();
        videojuegosResponse.setStatus(200);
        videojuegosResponse.setMessage("Listado Correcto");
        videojuegosResponse.setVideojuego(videojuegoService.ListarTodos());

        return ResponseEntity.ok()
        .body(videojuegosResponse);
    }

    //Buscar GET
    @GetMapping(value="buscar/{id}", produces = "application/json")
    public ResponseEntity<Object> getVideoJuego(@PathVariable String id){

        VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
        videojuegoResponse.setStatus(200);
        videojuegoResponse.setMessage("VideoJuego Encontrado");
        videojuegoResponse.setVideojuego(videojuegoService.buscar(id));

        return ResponseEntity.ok()
        .body(videojuegoResponse);
    }


    //Actualizar PUT

    @PutMapping(value="actualizar/{id}", produces = "application/json")
    public ResponseEntity<Object> setVideoJuego(@PathVariable String id, @RequestBody Videojuego videojuegoRequest){

        Videojuego videojuego = new Videojuego();
        videojuego = videojuegoService.buscar(id);
        videojuego.setTitle(videojuegoRequest.getTitle());
        videojuego.setFabricante(videojuegoRequest.getFabricante());
        videojuegoService.crear(videojuego);

        VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
        videojuegoResponse.setStatus(200);
        videojuegoResponse.setMessage("VideoJuego Actualizado");
        videojuegoResponse.setVideojuego(videojuego);

        return ResponseEntity.ok()
        .body(videojuegoResponse);
    }

    // Eliminar DELETE

    @DeleteMapping(value="eliminar/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteVideoJuego(@PathVariable String id){
        
        videojuegoService.eliminar(id);
        
        VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
        videojuegoResponse.setStatus(200);
        videojuegoResponse.setMessage("VideoJuego Eliminado");

        return ResponseEntity.ok()
        .body(videojuegoResponse);
    }
    
    

}
