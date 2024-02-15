package persistence.dao;

import models.User;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public User findbyID(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            Connection connection = ConnectionProvider.getConnection();
            String query = "SELECT * FROM users";
            System.out.println("Executing query: " + query); // Registro de diagnóstico

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            List<User> users = new ArrayList<User>();

            while (resultSet.next()){
                User user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                users.add(user);
                System.out.println("Retrieved user: " + user); // Registro de diagnóstico
            }

            return users;

        }catch (SQLException e){
            e.printStackTrace();
                throw new MissingDataException(e);
        }
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public User findByName(String name) {
        return null;
    }
}
