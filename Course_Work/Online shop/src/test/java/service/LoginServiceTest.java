package service;

import application.domain.User;
import application.model.dao.impl.UserDAO;
import application.model.dto.LoginDTO;
import application.model.exception.BlockedUserException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchUserException;
import application.model.exception.WrongPasswordException;
import application.model.service.LoginService;
import org.junit.*;

import static org.junit.Assert.*;


import java.util.UUID;

import static org.mockito.Mockito.*;

public class LoginServiceTest {

    private LoginService loginService;
    private UserDAO dao;

    @Before
    public void setUp() {
        dao = mock(UserDAO.class);
        loginService = new LoginService();
    }

    @Test(expected = NoSuchUserException.class)
    public void loginWithNonExistentUserDataTest() throws MySQLException {
        LoginDTO nonExistentUser = new LoginDTO("noname", "noPassword");
        loginService.login(nonExistentUser);
    }

    @Test(expected = WrongPasswordException.class)
    public void loginWithWrongPasswordTest() throws MySQLException {
        LoginDTO user = new LoginDTO("nastia", "noPassword");
        loginService.login(user);
    }

    @Test(expected = BlockedUserException.class)
    public void blockedUserLoginTest() throws MySQLException {
        LoginDTO blockedUser = new LoginDTO("masha","masha");
        loginService.login(blockedUser);
    }

    @Test
    public void successfullLoginTest() throws MySQLException {
        LoginDTO testUser = new LoginDTO("nastia", "lapa");
        User expectedUser = new User(UUID.fromString("b6cc6a50-a70c-4048-8a9b-6d37048ea68f"),
                "admin", "nastia", "lapa", "anastasia.lapa111@gmail.com", true);
        when(dao.findEntityByName(testUser.getUsername())).thenReturn(expectedUser);
        User user = loginService.login(testUser);
        assertNotNull(user);
        assertEquals(user,expectedUser);
    }


}