import dao.BookDao;
import model.Book;

import java.util.Scanner;

public class ConnectMySQL {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "toor";

        BookDao bookDao = new BookDao();
        Scanner scan = new Scanner(System.in);

        boolean next = true;
        while (next) {
            System.out.println("Select option:\n1 - Add new book\n2 - Show book by isbn\n3 - Remove book\n4 - Update book\n5 - End");
            int choice = scan.nextInt();
            String isbn;
            String title;
            String author;
            String year;
            long id;
            Book book;
            switch (choice) {
                case 1:
                    System.out.println("Enter Title");
                    title = scan.next();
                    System.out.println("Enter Author");
                    author = scan.next();
                    System.out.println("Enter ISBN");
                    isbn = scan.next();
                    System.out.println("Enter release year");
                    year = scan.next();
                    book = new Book(title, author, year, isbn);
                    bookDao.doSave(book);
                    break;
                case 2:
                    System.out.println("Enter ISBN");
                    isbn = scan.next();
                    bookDao.doRead(isbn);
                    break;
                case 3:
                    System.out.println("Enter Book ID");
                    id = scan.nextLong();
                    bookDao.doDelete(id);
                    break;
                case 4:
                    System.out.println("Enter new title");
                    title = scan.next();
                    System.out.println("Enter new author");
                    author = scan.next();
                    System.out.println("Enter new ISBN");
                    isbn = scan.next();
                    System.out.println("Enter new release year");
                    year = scan.next();
                    System.out.println("Enter Book ID witch you want to change");
                    id = scan.nextLong();
                    book = new Book(title, author, year, isbn);
                    book.setId(id);
                    bookDao.doUpdate(book);
                    break;
                case 5:
                    next = false;
                    break;
            }


        }
        bookDao.close();
    }


}
