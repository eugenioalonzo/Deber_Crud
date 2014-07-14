

package CapaDato;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Eugenio
 */
public class Conexion 
{
 java.sql.Connection ConexionDatos= null;
    java.sql.PreparedStatement Sentencia= null;
    ResultSet ConjuntoDatos=null;
    static String Usuario = null;
    static String Cadena = null;
    static String Clave =null;

    public static void setUsuario(String Usuario) {
        Conexion.Usuario = Usuario;
    }
    
    public static void setCadena(String Cadena) {
        Conexion.Cadena = Cadena;
    } 
    
    public static void setClave(String Clave) {
        Conexion.Clave = Clave;
    } 
    
    private static Conexion Instancia=null;
    
    public static Conexion GetInstancia (){
        if (Instancia == null){
        Instancia=new Conexion( );       
        }
        return Instancia;
    }    
    
   public void Conectar (){
       try {
       ConexionDatos= DriverManager.getConnection(Cadena, Usuario, Clave);    
       }
       catch(SQLException ex){
         ex.getStackTrace();
       }
               
    }
     public void Desconectar ()       {
         try{
         ConexionDatos.close();    
         }
         catch(SQLException ex){
             ex.getStackTrace();
         }
     }
     
     public void Ejecutar (String Cadena) throws SQLException{
         try{
             Sentencia= ConexionDatos.prepareStatement(Cadena);
         Sentencia.executeUpdate();
         }
         catch(SQLException ex){
             throw ex;
         }
         
         
     }

    
    
}
