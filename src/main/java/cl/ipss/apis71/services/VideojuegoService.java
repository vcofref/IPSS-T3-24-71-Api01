package cl.ipss.apis71.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.apis71.models.Videojuego;
import cl.ipss.apis71.repositories.VideojuegoRepository;

@Service
public class VideojuegoService {

    @Autowired
    public VideojuegoRepository videojuegoRepository;

    //CREAR
    public Videojuego crear(Videojuego videojuego){
        return videojuegoRepository.save(videojuego);
    }

    //Listar
    public List<Videojuego> ListarTodos(){
        return videojuegoRepository.findAll();
    }

    //Buscar
    public Videojuego buscar(String id) {
        return videojuegoRepository.findById(id).orElse(null);
    }

    //Eliminar

    public void eliminar(String id){
        videojuegoRepository.deleteById(id);
    }

}
