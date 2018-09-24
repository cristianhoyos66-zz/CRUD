package co.com.cedesistemas.shared.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by HP-15-AX2005la on 23/09/2018.
 */
public class DBConnect {

    private static final String host = "jdbc:mariadb://localhost:3306/java_I_DB";
    private static final String username = "root";
    private static final String password = "admin";
    private static Connection con;

    public static Connection getCon() throws SQLException {
        if (con == null) {
            con = DriverManager.getConnection(host, username, password);
        }
        return con;
    }

}
