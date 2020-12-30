package service;

import application.domain.User;
import application.model.dao.impl.UserDAO;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchUserException;
import application.model.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    UserService userService;
    UserDAO dao;

    @Before
    public void setUp() {
        dao = mock(UserDAO.class);
        userService = new UserService();
    }

    @Test(expected = NoSuchUserException.class)
    public void findUserByNonExistentUserNameTest() throws MySQLException {
        userService.findByName("falseUsername");
    }

    @Test
    public void findUserByExistentUsernameTest() throws MySQLException {
        User expectedUser = new User(UUID.fromString("9b21c9cd-34e5-11eb-a409-fda63698461d"),
                "user", "user", "pass", "user@gmail.com", true);
        when(dao.findEntityByName("user")).thenReturn(expectedUser);
        User user = userService.findByName("user");
        assertEquals(expectedUser,user);
    }


    @Test(expected = NoSuchUserException.class)
    public void editStatusOfNonExistentUserTest() throws MySQLException {
        User user = new User(UUID.fromString("b6cc6a50-a70c-4048-8a9b-6d37048ea68f"),
                "user", "test", "test", "test@gmail.com", true);
        userService.editStatus(user);
    }

    @Test
    public void editUserStatusTest() throws MySQLException {
        User expectedUser = new User(UUID.fromString("496a8c4b-add0-40c1-80d7-7f52fdd86e56"),
                "user", "katia", "katia", "katia@gmail.com", false);
       userService.editStatus(expectedUser);
        User user = userService.findByName("katia");
        assertEquals(user, expectedUser);
    }

    @Test
    public void getAllUsersTest() throws MySQLException {
        assertNotNull(userService.getUsers());
    }

}
