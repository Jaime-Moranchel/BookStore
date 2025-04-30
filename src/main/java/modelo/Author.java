/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author DAM1A02
 */
public class Author {
    private int idAuthor;
    private String nombre;
    private String apellido;
    private String fechaDeNaciemento;

    public Author(String nombre, String apellido, String fechaDeNaciemento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNaciemento = fechaDeNaciemento.replace('/', '.');
    }

    @Override
    public String toString() {
        return "Author{" + "idAuthor=" + idAuthor + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNaciemento=" + fechaDeNaciemento.replace('.', '/') + '}';
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaDeNaciemento() {
        return fechaDeNaciemento;
    }

    public void setFechaDeNaciemento(String fechaDeNaciemento) {
        this.fechaDeNaciemento = fechaDeNaciemento;
    }
    
    
}
