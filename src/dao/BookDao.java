package dao;

import crud.LibraryDelete;
import crud.LibraryRead;
import crud.LibrarySave;
import crud.LibraryUpadte;
import model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDao {

    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String username = "root";
    private static final String password = "toor";

    private Connection connection;

    private LibraryRead libraryRead;
    private LibrarySave librarySave;
    private LibraryDelete libraryDelete;
    private LibraryUpadte libraryUpadte;

    public BookDao() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            librarySave = new LibrarySave(connection);
            libraryRead = new LibraryRead(connection);
            libraryDelete = new LibraryDelete(connection);
            libraryUpadte = new LibraryUpadte(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doSave(Book book) {
        librarySave.save(book);
    }

    public void doRead(String isbn) {
        libraryRead.read(isbn);
    }


    public void doUpdate(Book book) {
        libraryUpadte.update(book);
    }

    public void doDelete(long id) {
        libraryDelete.delete(id);
    }
}
