import org.sqlite.SQLiteDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static final String SQCONN = "jdbc:sqlite:wordcount.sqlite";
    private static SQLiteDataSource ds;

    static {
            ds = new SQLiteDataSource();
            ds.setUrl(SQCONN);
//            Class.forName("org.sqlite.JDBC");
//            conn = DriverManager.getConnection(SQCONN);
    }

    public static Connection getConn() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
