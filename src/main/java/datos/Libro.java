/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author DAM1A28
 */
public class Libro {
    private int idLibro;
    private int idAutor;
    private String titulo;
    private String fEscritura;
    private String fPublicacion;

    public Libro(int idLibro, int idAutor, String titulo, String fEscritura, String fPublicacion) {
        this.idLibro = idLibro;
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.fEscritura = fEscritura;
        this.fPublicacion = fPublicacion;
    }

    


    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", idAutor=" + idAutor + ", titulo=" + titulo + ", fEscritura=" + fEscritura + ", fPublicacion=" + fPublicacion + '}';
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFEscritura() {
        return fEscritura;
    }

    public void setFEscritura(String fEscritura) {
        this.fEscritura = fEscritura;
    }

    public String getFPublicacion() {
        return fPublicacion;
    }

    public void setFPublicacion(String fPublicacion) {
        this.fPublicacion = fPublicacion;
    }
}
