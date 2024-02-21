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
    private boolean activo;
    private boolean adeudaLibro;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("USUARIO ").append(obtenerNumeroUsuario()).append(":\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Apellido: ").append(apellido).append("\n");
        sb.append("Número de Identificación: ").append(numeroIdentificacion).append("\n");
        sb.append("Fecha de Alta de Usuario: ").append(altaUsuario).append("\n");
        sb.append("Activo: ").append(activo).append("\n");
        sb.append("Adeuda Libro: ").append(adeudaLibro).append("\n");
        sb.append("Libros Prestados:\n");
        for (int i = 0; i < librosPrestados.size(); i++) {
            sb.append("\tLibro ").append(i + 1).append(":\n");
            sb.append("\t").append(librosPrestados.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    // Método privado para obtener el número de usuario
    private String obtenerNumeroUsuario() {
        String numeroUsuario = "";
        if (numeroIdentificacion.length() >= 2) {
            numeroUsuario = numeroIdentificacion.substring(numeroIdentificacion.length() - 2);
        } else {
            numeroUsuario = "0" + numeroIdentificacion;
        }
        return numeroUsuario;
    }

}
