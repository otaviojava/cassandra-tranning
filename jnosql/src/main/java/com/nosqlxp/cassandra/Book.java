package com.nosqlxp.cassandra;



import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.util.Objects;
import java.util.Set;

@Entity("book")
public class Book {

    @Id("isbn")
    private Long isbn;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private Set<String> categories;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("isbn=").append(isbn);
        sb.append(", name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }
}
