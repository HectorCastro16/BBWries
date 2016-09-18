package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
public class conexion {
	public static Connection getConnection() throws Exception {
        Connection con = null;
        try {            
            String url = "jdbc:mysql://localhost:3306/bdgr";
            String user = "root";
            String clave = "system2015";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, clave);
            System.out.println("Exito conexion BD");
        } catch (Exception e) {
            System.out.println("Error conexion BD " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
