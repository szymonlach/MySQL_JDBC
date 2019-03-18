package crud;

import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryUpadte {

    Connection connection;

    public LibraryUpadte(Connection connection) {
        this.connection = connection;
    }


    public void update(Book book) {
        final String sql = "UPDATE books set title=?, author=?, year = ?, isbn=? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getYear());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setLong(5, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
