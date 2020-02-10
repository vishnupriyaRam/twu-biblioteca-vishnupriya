package com.twu.biblioteca.model;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Book {
    public final String title;
    public final String author;
    public final String year; // TODO - year as a string, sort of weird?
    private final String delimiter = " | ";

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(String title) { // TODO - this consturctor shows we went in wrong direction.
        this.title = title;
        this.author = null; // TODO - oops. Ouch. This is how it starts.
        this.year = null;
    }

    // TODO - new feature - books later than year 2000 (recent books only feature)
//    public boolean isRecent() {
//        if(year != null) {
//            return Integer.parseInt(year) > 2000;
//        } else {
//            throw new OperationNotSupportedException();
//        }
//    }

    public void view() {
        System.out.println(title + delimiter + author + delimiter + year); // TODO - " | " is a magic literal. Changing the delimiter right now will be difficult.
    }

    @Override
    public boolean equals(Object o) { // TODO - all the tests, if you're overrirding equals
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title); // TODO - we don't check for author or year... that can likely be very troublesome. How would you add get by author now? --> You'll need another method. You won't be able to easily change equals, because getByTitle (which is what we missed) already depends on this.
        // TODO - then there will be inconsistency - getByTitle works by equals, but getByAuthor works by separate method

        // TODO - what if title had to match flexibly / fuzzy.
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
