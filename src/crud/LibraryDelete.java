package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryDelete {

    Connection connection;

    public LibraryDelete(Connection connection) {
        this.connection = connection;
    }

    public void delete(long id) {
        final String sql = "delete from books where id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
