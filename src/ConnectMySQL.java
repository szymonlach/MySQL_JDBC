import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMySQL {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "Student140";
        Connection connection = (Connection) DriverManager.getConnection(url, username, password);


        Statement statement = connection.createStatement();
        String query = "select * from books";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String year = resultSet.getString("year");
            String isbn = resultSet.getString("isbn");
            System.out.println(id + " " + title + " " + author + " " + year + " " + isbn);

        }


        connection.close();
    }


}
