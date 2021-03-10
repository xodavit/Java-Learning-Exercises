package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String SQLQueryCreateUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id BIGINT NOT NULL AUTO_INCREMENT, "
                + "name VARCHAR(45) NOT NULL, "
                + "lastName VARCHAR(45) NOT NULL, "
                + "age SMALLINT NOT NULL, "
                + "PRIMARY KEY (id), "
                + "UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE)";

        try (PreparedStatement preparedStatement = Util.getConnectionJDBC().prepareStatement(SQLQueryCreateUsersTable)) {
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String SQLQueryDropUsersTable = "DROP TABLE IF EXISTS users";
        try (PreparedStatement preparedStatement = Util.getConnectionJDBC().prepareStatement(SQLQueryDropUsersTable)) {
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQLQuerySaveUser = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = Util.getConnectionJDBC().prepareStatement(SQLQuerySaveUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("User с именем – " + name + " добавлен в базу данных");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String SQLQueryRemoveUserById = "DELETE FROM users WHERE id=?";

        try (PreparedStatement preparedStatement = Util.getConnectionJDBC().prepareStatement(SQLQueryRemoveUserById)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String SQLQueryGetAllUsers = "SELECT * FROM users";

        try (PreparedStatement preparedStatement = Util.getConnectionJDBC().prepareStatement(SQLQueryGetAllUsers);
             ResultSet resultSet = preparedStatement.executeQuery(SQLQueryGetAllUsers)) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                allUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allUsers;
    }

    public void cleanUsersTable() {
        String SQLQueryCleanUsersTable = "TRUNCATE TABLE users";

        try (PreparedStatement preparedStatement = Util.getConnectionJDBC().prepareStatement(SQLQueryCleanUsersTable)) {
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
