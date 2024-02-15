package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    private List<Libro> libros;

    // Aquí van los métodos para agregar libros, buscar libros, etc.

}
