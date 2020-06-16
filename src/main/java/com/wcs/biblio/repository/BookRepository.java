package com.wcs.biblio.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wcs.biblio.dao.BookDao;
import com.wcs.biblio.model.Book;
import com.wcs.biblio.util.JdbcUtils;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements BookDao {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/bibliWCS?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    @Override
    public Book create() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book findById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM Book WHERE book_id = ? ;"
            );

            statement.setLong(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                return new Book(id, title, author, description);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM Book;"
            );
            resultSet = statement.executeQuery();

            List<Book> books = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                books.add(new Book(id, title, author, description ));
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    @Override
    public Book update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Book> findByKeyWord(String keyWord) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM Book WHERE description LIKE '%?%' OR author LIKE '%?%' OR title LIKE '%?%';"
            );

            statement.setString(1,keyWord);
            statement.setString(2,keyWord);
            statement.setString(3,keyWord);

            resultSet = statement.executeQuery();

            List<Book> books = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id_book");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                books.add(new Book(id, title, author, description ));
            }
            return books;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(statement);
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }
    
}