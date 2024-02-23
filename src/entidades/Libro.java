package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private int cantExistente;
    private ArrayList<String> resenias;
    private ArrayList<Integer> calificaciones;
    private boolean disponibilidad;
    final LocalDate altaLibro = LocalDate.now();
    private boolean activo;


    public double getPromedioCalificaciones() {
        return calificaciones.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public int getCantidadCalificaciones() {
        return calificaciones.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Autor: ").append(autor).append("\n");
        sb.append("ISBN: ").append(ISBN).append("\n");
        sb.append("Género: ").append(genero).append("\n");
        sb.append("Cantidad Existente: ").append(cantExistente).append("\n");
        sb.append("Reseñas: ").append(resenias.isEmpty() ? "Sin reseñas todavía" : resenias.toString()).append("\n");
        sb.append("Calificación: ").append(calificaciones.isEmpty() ? "Sin calificaciones todavía" : getPromedioCalificaciones()).append("\n");
        sb.append("Cantidad de calificaciones: ").append(getCantidadCalificaciones()).append("\n");
        sb.append("Disponibilidad: ").append(disponibilidad ? "Disponible" : "No disponible").append("\n");
        sb.append("Fecha de alta: ").append(altaLibro).append("\n");
        sb.append("Activo: ").append(activo ? "Sí" : "No").append("\n");
        return sb.toString();
    }
}
