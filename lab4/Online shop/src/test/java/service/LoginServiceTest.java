package service;

import application.model.dao.DAOFactory;
import application.model.dao.impl.UserDAO;
import application.model.service.LoginService;
import org.junit.Before;

import static org.mockito.Mockito.mock;

public class LoginServiceTest {
    private LoginService loginService;
    private DAOFactory daoFactory;
    private UserDAO dao;

    @Before
    public void setUp() throws Exception {
        daoFactory = mock(DAOFactory.class);
        dao = mock(UserDAO.class);
        loginService = new LoginService();
    }

    @Before
    public void before() {
        UserDAO dao = mock(UserDAO.class);
    }



}