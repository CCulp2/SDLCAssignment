import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WordDb {
    Connection conn = DBConnection.getConn();
    ArrayList<WordCount> wordCountList = new ArrayList<>();

    public void addWord(String wordToAdd, int instance) {
        String word = wordToAdd.toLowerCase();
        String findIfWordExists = "SELECT * FROM counts WHERE instance = ? AND word = ?";
        try {
            PreparedStatement wordExists = conn.prepareStatement(findIfWordExists);
            wordExists.setInt(1, instance);
            wordExists.setString(2, word);
            ResultSet rs = wordExists.executeQuery();
            if (rs.next()) {
                int occurrence = rs.getInt(4);
                int id = rs.getInt(1);
                occurrence++;
                String updateRecord = "UPDATE counts SET count = ? WHERE id = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateRecord);
                updateStatement.setInt(1, occurrence);
                updateStatement.setInt(2, id);
                updateStatement.executeUpdate();
            } else {
                String insertRecord = "INSERT INTO counts (instance, word, count)" +
                        "VALUES(?, ?, ?)";
                PreparedStatement insertStatement = conn.prepareStatement(insertRecord);
                insertStatement.setInt(1, instance);
                insertStatement.setString(2, word);
                insertStatement.setInt(3, 1);
                insertStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int findInstance() {
        int instance = 0;
        String findInstanceSql = "SELECT MAX(instance) FROM counts";
        try {
            PreparedStatement findInstanceStatement = conn.prepareStatement(findInstanceSql);
            ResultSet rs = findInstanceStatement.executeQuery();
            if (rs.next()) {
                instance = rs.getInt(2);
            } else {
                instance = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }




}
