/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAM1A28
 */
public class DerbyUtil {
    private static final String CONECTOR_DERBY = "org.apache.derby.client.ClientAutoloadedDriver";
    private static final String URL_CONEXION = "jdbc:derby://localhost:1527/bookstore";
    private static final String USUARIO= "bookstore";
    private static final String CONTRASEGNA = "bookstore";
                        
    public static Connection abrirConexion()  
            throws ClassNotFoundException, SQLException{
        Class.forName(CONECTOR_DERBY);
        Connection conexion = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASEGNA);
        return conexion;
    }
    
    public static void cerrarConexion(Connection conexion) throws SQLException{
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }

}
