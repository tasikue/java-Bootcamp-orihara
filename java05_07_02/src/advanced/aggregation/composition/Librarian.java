package advanced.aggregation.composition;

import java.util.ArrayList;
import java.util.List;

import advanced.aggregation.composition.entity.Book;
import advanced.aggregation.composition.entity.Library;

/**
 * 図書館司書を扱うクラス
 * 構成 Composition の概念を説明する Java プログラム
 */
public class Librarian {

    public static void main(String[] args) {

        Book[] booksArray = {
            new Book("Effective Java", "Joshua Bloch"),
            new Book("Refactoring", "Martin Fowler"),
            new Book("Clean Coder", "Robert C. Martin"),
            new Book("Domain-Driven Design", "Eric Evans"),
        };

        List<Book> books = new ArrayList<>();
        
        books.add(booksArray[0]);
        books.add(booksArray[2]);
        books.add(booksArray[3]);
        
        Library library = new Library(books);
        List<Book> allBooksInLibrary = library.getAllBooksInLibrary();
        
        for (Book book : allBooksInLibrary) {
            book.showDetails();
        }
    }
}