package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private final String driver = "org.h2.Driver";
    private final String url = "jdbc:h2:file:~/leyl_2023_java_tdd";
    private final String username = "sa";
    private final String password = "sa";

    private Connection connection = null;

    public Connection conn() {
        try {
            if ( connection == null || connection.isClosed() ) {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            }
        }catch (Exception ex) {
            System.err.println("Connection Error :" + ex);
        }
        return connection;
    }

    public boolean close() {
        try {
            if ( connection != null && !connection.isClosed() ) {
                connection.close();
                return true;
            }
        }catch (Exception ex) {
            System.err.println("close Error :" + ex);
        }
        return false;
    }

}
