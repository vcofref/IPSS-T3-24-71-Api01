package cl.ipss.apis71.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.ipss.apis71.models.Videojuego;

public interface VideojuegoRepository extends MongoRepository<Videojuego, String>{

}
