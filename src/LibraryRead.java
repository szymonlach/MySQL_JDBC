import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryRead {


    private Connection connection;

    LibraryRead(Connection connection) {
        this.connection = connection;
    }

    public Book read(String isbn) {
        final String sql = "select * from books WHERE isbn = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setYear(resultSet.getString("year"));

                System.out.println(book.toString());
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Nie znaleziono książki");
        return null;
    }
}
