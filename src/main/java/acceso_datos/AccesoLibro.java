/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import datos.Libro;


/**
 *
 * @author DAM1A28
 */
public class AccesoLibro {
    public static void insertar(Libro libro) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaInsercion = "INSERT INTO libros (idLibro, idAutor, titulo, fEscritura, fPublicacion) " + "VALUES (" + libro.getIdLibro() + ", " +  libro.getIdAutor() + ", '" + libro.getTitulo() + "', '" + libro.getFEscritura().replace('/', '.') + "', '" + libro.getFPublicacion().replace('/', '.')+"')";
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sentenciaInsercion);
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
    }
    
    public static List consultarTodos() throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        List<Libro> listaLibros = new ArrayList<>();
        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaConsultar = "SELECT * FROM libros";
            Statement sentencia = conexion.createStatement();
            ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);
            Libro libro;
            while (resultados.next()) {
                libro = new Libro(resultados.getInt("idLibro"), resultados.getInt("idAutor"), resultados.getString("titulo"), resultados.getString("fEscritura").replace('.', '/'), resultados.getString("fPublicacion").replace('.', '/'));
                listaLibros.add(libro);
            }
            resultados.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return listaLibros;
    }
    
    public static Libro consultarUno(int codigo)  
            throws ClassNotFoundException, SQLException{
        Connection conexion = null;
        Libro libro = null;
        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaConsultar = "SELECT * FROM libros " +
                    " WHERE codigo = " + codigo;
            Statement sentencia = conexion.createStatement();
            ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);
            if (resultados.next()) {
                libro = new Libro(resultados.getInt("idLibro"), resultados.getInt("idAutor"), resultados.getString("titulo"), resultados.getString("fEscritura").replace('.', '/'), resultados.getString("fPublicacion").replace('.', '/'));
            }
            resultados.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return libro;
    }
    
    public static boolean actualizar(Libro libro) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean modificado = false;
        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaActualizacion = "UPDATE libro " +
                    " SET idLibro = '" + libro.getIdLibro()+ "', "
                    + "idAutor = '" + libro.getIdAutor() + "', "
                    + "titulo= '" + libro.getTitulo() + "', "
                    + "fEscritura= '" + libro.getFEscritura().replace('/', '.') + "', "
                    + "fPublicacion= '" + libro.getFPublicacion().replace('/', '.') + "', "
                    
                    + "WHERE codigo = " + libro.getIdLibro();
            Statement sentencia = conexion.createStatement();
            if(sentencia.executeUpdate(sentenciaActualizacion) == 1){
                modificado = true;
            }
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return modificado;
    }
    
    public static void eliminar (int idLibro) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        try {
            conexion = DerbyUtil.abrirConexion();
            // DELETE FROM libros WHERE idLibro = libro.getIdLibro
            String sentenciaInsercion = "DELETE FROM libros WHERE idLibro = ('" + idLibro + "')";
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sentenciaInsercion);
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
    }
}
