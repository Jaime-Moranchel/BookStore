/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Author;

/**
 *
 * @author DAM1A02
 */
public class AccesoAuthor {
    
    
    
    

    public static void insertarAuthor (Author author) 
            throws ClassNotFoundException, SQLException{
        Connection connexion = null;
        try{
            connexion = DerbyUtil.abrirConexion();
            String consulta = "inser into Author (nombre,apellido,fecha_de_naciemento) values('"
                    +author.getNombre()+"','"+author.getApellido()
                    +"','"+author.getFechaDeNaciemento()+"');";
            Statement statement = connexion.createStatement();
            statement.executeUpdate(consulta);
            statement.close();
        }finally{
			DerbyUtil.cerrarConexion(connexion);
		}
    }
    
    
    public static Author consultarUnAuthor(int id_author)
            throws ClassNotFoundException, SQLException{
		Connection connexion = null;
		Author author = null;
		try{
			connexion = DerbyUtil.abrirConexion();
			String consulta = "Select * from Author where id_author = " + id_author + ";";
			Statement statement = connexion.createStatement();
			ResultSet resultados = statement.executeQuery(consulta);
			if(resultados.next()){
				author = new Author(resultados.getString("nombre")
                                        ,resultados.getString("apellido")
                                        ,resultados.getString("fechaDeNaciemnto"));
			}
			resultados.close();
			statement.close();
		}finally{
			DerbyUtil.cerrarConexion(connexion);
		}
		return author;
	}
    
    
    
    public static List<Author> consultarTodos()throws ClassNotFoundException, SQLException{
        Connection connexion = null;
        Author author = null;
        List<Author> listaDeAuthores = new ArrayList();  
        try{
        connexion = DerbyUtil.abrirConexion();
        String consulta = "Select * from author ";
        Statement statement = connexion.createStatement();
        ResultSet resultados = statement.executeQuery(consulta);
        if(resultados.next()){
        author = new Author(resultados.getString("nombre")
                ,resultados.getString("apellido")
                ,resultados.getString("fechaDeNaciemnto"));
        listaDeAuthores.add(author);
        }    
        }finally{
			DerbyUtil.cerrarConexion(connexion);
		}
        return listaDeAuthores;
    }
    
    
    public static boolean borrarAuthor(int idAuthor)throws ClassNotFoundException, SQLException{
        boolean borrado = false;
        Connection connexion = null;
        try{
        connexion = DerbyUtil.abrirConexion();
        String consulta = "delete from author where id_author = '"+idAuthor+"';";
        Statement statement = connexion.createStatement();
        if(statement.executeUpdate(consulta)==1){
            borrado = true;
        }
        }finally{
			DerbyUtil.cerrarConexion(connexion);
		}
        return borrado;
    }
    
    
    public static boolean actualizarAuthor(int idAuthor, String nombre, String apellido,String fechaDeNaciemento)
            throws ClassNotFoundException, SQLException{
      boolean actualizado = false;
      Connection connexion = null;
      try{
      connexion = DerbyUtil.abrirConexion();
      String consulta = "update author set nombre ='"+nombre+"',set apellido = '"
              +apellido+"',set fecha_de_naciemento = "+fechaDeNaciemento+"'where id_author = '"
              +idAuthor+"';";
      Statement statement = connexion.createStatement();
      if(statement.executeUpdate(consulta)==1){
          actualizado = true;
      }
      
      }finally{
			DerbyUtil.cerrarConexion(connexion);
		}
      return actualizado;
    }
    
    
    
    
}
