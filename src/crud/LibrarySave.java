package crud;

import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibrarySave {


    Connection connection;

    public LibrarySave(Connection connection) {
        this.connection = connection;
    }


    public void save(Book book) {
        final String sql = "insert into books (title,author,year,isbn) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getYear());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }

    }


}
