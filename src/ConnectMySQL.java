import java.sql.SQLException;
import java.util.Scanner;

public class ConnectMySQL {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "-Masseffect3-";


        BookDao bookDao = new BookDao();
        //Book book = new Book("Title3", "Author3", "2003", "1947583917463");
        Book book2 = new Book("Title4", "Author4", "2011", "8573649501736");
        book2.setId(3);
        System.out.println(book2);
        //bookDao.doDelete(2L);
        //bookDao.doUpdate(book2);
        //bookDao.doRead(isbn);

        Scanner scan = new Scanner(System.in);

        boolean dalej = true;
        while (dalej) {
            System.out.println("Wybierz opcję:\n1 - Dodaj nową książkę\n2 - Wyświetl książkę na podstawie isbn\n3 - Usuń książkę\n4 - Auktualizuj książkę\n5 - Koniec");
            int choice = scan.nextInt();
            String isbn;
            switch (choice) {
                case 1:
                    System.out.println("Podaj tytuł");
                    String title = scan.next();
                    System.out.println("Podaj autora");
                    String author = scan.next();
                    System.out.println("Podaj ISBN");
                    isbn = scan.next();
                    System.out.println("Podaj rok wydania");
                    String year = scan.next();
                    Book book = new Book(title, author, year, isbn);
                    bookDao.doSave(book);
                    break;
                case 2:
                    System.out.println("Podaj ISBN");
                    isbn = scan.next();
                    bookDao.doRead(isbn);
                    break;
                case 3:
                    System.out.println("Podaj ID książki");
                    break;
                case 4:

                    break;
                case 5:
                    dalej = false;
                    break;
            }


        }
        bookDao.close();
    }


}
