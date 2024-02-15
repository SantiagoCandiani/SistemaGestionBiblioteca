package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private String nombre;
    private String apellido;
    private String numeroIdentificacion;
    private List<Libro> librosPrestados;
    final LocalDate altaUsuario = LocalDate.now();

}
