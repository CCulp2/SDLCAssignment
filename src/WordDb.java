import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.ArrayList;

public class WordDb {
    Connection conn;
    int instance;

    public WordDb() {
        this.conn = DBConnection.getConn();
        instance = getInstance();
    }

    public void addListOfWords(ArrayList<String> listOfWords) {
        int instance = getInstance();
        for (String word : listOfWords) {
            addWord(word, instance);
        }
    }

    public ObservableList<WordCount> getTop20Observable() {
        ObservableList wordList = FXCollections.observableArrayList();
        String top20Words = "SELECT word, count FROM counts WHERE instance = ? ORDER BY count DESC LIMIT 20";
        try {
            PreparedStatement getTop20 = conn.prepareStatement(top20Words);
            getTop20.setInt(1, instance);
            ResultSet rs = getTop20.executeQuery();
            while (rs.next()) {
                WordCount wordCount = new WordCount(rs.getString(1), rs.getInt(2));
                wordList.add(wordCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wordList;
    }
    private void addWord(String wordToAdd, int instance) {
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

    private int getInstance() {
        int instance = 0;
        String findInstanceSql = "SELECT MAX(instance) FROM counts";
        try {
            PreparedStatement findInstanceStatement = conn.prepareStatement(findInstanceSql);
            ResultSet rs = findInstanceStatement.executeQuery();
            if (rs.next()) {
                instance = rs.getInt(1) + 1;
            } else {
                instance = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }




}
