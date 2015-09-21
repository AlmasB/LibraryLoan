package com.almasb.libraryloan;

import java.util.List;

public class Library {

    private BookDAO bookDAO;

    public Library(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        try {
            bookDAO.connect();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addNewBook(String name, String authors, int year) {
        Book book = new Book();
        book.setAvailable(true);
        book.setName(name);
        book.setAuthors(authors);
        book.setPublishedYear(year);

        bookDAO.insertBook(book);
    }

    public void loanBook(long uniqueID) {
        List<Book> books = bookDAO.findBookByProperty(BookSearchType.ID, uniqueID);
        if (books.size() > 0) {
            books.get(0).setAvailable(false);
            bookDAO.updateBook(books.get(0));
        }
    }

    public void returnBook(long uniqueID) {
        List<Book> books = bookDAO.findBookByProperty(BookSearchType.ID, uniqueID);
        if (books.size() > 0) {
            books.get(0).setAvailable(true);
            bookDAO.updateBook(books.get(0));
        }
    }

    public List<Book> search(BookSearchType searchType, String value) {
        return bookDAO.findBookByProperty(searchType, value);
    }

    public void close() {
        try {
            bookDAO.close();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
