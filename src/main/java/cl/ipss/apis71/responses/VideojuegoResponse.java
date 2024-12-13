package cl.ipss.apis71.responses;

import cl.ipss.apis71.models.Videojuego;
import lombok.Data;

@Data
public class VideojuegoResponse {
    private int status;
    private String message;
    private Videojuego videojuego;
}
