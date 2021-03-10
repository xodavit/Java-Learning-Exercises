package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.createUsersTable();

        userService.saveUser("Алексей","Навальный", (byte) 45);
        userService.saveUser("Кира","Ярмыш", (byte) 28);
        userService.saveUser("Любовь","Соболь", (byte) 35);
        userService.saveUser("Пладимир","Вутин", (byte) 55);

        List<User> users = userService.getAllUsers();
        for (User user: users
        ) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
        userService.dropUsersTable();
    }
}
