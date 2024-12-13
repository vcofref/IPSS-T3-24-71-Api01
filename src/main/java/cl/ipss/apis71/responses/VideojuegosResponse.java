package cl.ipss.apis71.responses;

import java.util.List;

import cl.ipss.apis71.models.Videojuego;
import lombok.Data;

@Data
public class VideojuegosResponse {
    private int status;
    private String message;
    private List<Videojuego> videojuego;
}
