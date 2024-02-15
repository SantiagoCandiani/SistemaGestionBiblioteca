package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private int cantExistente;
    private boolean disponibilidad;
    final LocalDate altaLibro = LocalDate.now();

    // Aquí van los métodos getter y setter para cada atributo

}
