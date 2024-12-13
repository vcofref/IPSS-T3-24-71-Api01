package cl.ipss.apis71.models;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "videoJuegos")
public class Videojuego {
    
    @Id
    private String id;
    @Indexed(unique=true)
    private String title;
    private List<Fabricante> fabricante;

}
