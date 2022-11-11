import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbLoad {
    static Connection dbConnection;

    public static void load() {
        try {
            dbConnection = DBConnection.getConn();
            Statement createTable = dbConnection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS counts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "instance INTEGER NOT NULL," +
                    "word VARCHAR(50) NOT NULL," +
                    "count INTEGER NOT NULL" +
                    ")";


            createTable.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
