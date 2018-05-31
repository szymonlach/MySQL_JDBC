import java.sql.SQLException;
import java.util.Scanner;

public class ConnectMySQL {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "-Masseffect3-";

        BookDao bookDao = new BookDao();
        Scanner scan = new Scanner(System.in);

        boolean dalej = true;
        while (dalej) {
            System.out.println("Wybierz opcję:\n1 - Dodaj nową książkę\n2 - Wyświetl książkę na podstawie isbn\n3 - Usuń książkę\n4 - Auktualizuj książkę\n5 - Koniec");
            int choice = scan.nextInt();
            String isbn;
            String title;
            String author;
            String year;
            long id;
            Book book;
            switch (choice) {
                case 1:
                    System.out.println("Podaj tytuł");
                    title = scan.next();
                    System.out.println("Podaj autora");
                    author = scan.next();
                    System.out.println("Podaj ISBN");
                    isbn = scan.next();
                    System.out.println("Podaj rok wydania");
                    year = scan.next();
                    book = new Book(title, author, year, isbn);
                    bookDao.doSave(book);
                    break;
                case 2:
                    System.out.println("Podaj ISBN");
                    isbn = scan.next();
                    bookDao.doRead(isbn);
                    break;
                case 3:
                    System.out.println("Podaj ID książki");
                    id = scan.nextLong();
                    bookDao.doDelete(id);
                    break;
                case 4:
                    System.out.println("Podaj nowy tytuł");
                    title = scan.next();
                    System.out.println("Podaj nowego autora");
                    author = scan.next();
                    System.out.println("Podaj nowy ISBN");
                    isbn = scan.next();
                    System.out.println("Podaj nowy rok wydania");
                    year = scan.next();
                    System.out.println("Podaj ID książki którą chcesz zmienić");
                    id = scan.nextLong();
                    book = new Book(title, author, year, isbn);
                    book.setId(id);
                    bookDao.doUpdate(book);
                    break;
                case 5:
                    dalej = false;
                    break;
            }


        }
        bookDao.close();
    }


}
