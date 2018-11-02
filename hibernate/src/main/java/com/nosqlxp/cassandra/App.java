package com.nosqlxp.cassandra;

import com.google.common.collect.Sets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        Book cleanCode = getBook(1L, "Clean Code", "Robert Cecil Martin", Sets.newHashSet("Java", "OO"));
        manager.merge(cleanCode);
        manager.getTransaction().commit();

        Book book = manager.find(Book.class, 1L);
        System.out.println("book: " + book);
    }


    private static Book getBook(long isbn, String name, String author, Set<String> categories) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setName(name);
        book.setAuthor(author);
        return book;
    }

}
