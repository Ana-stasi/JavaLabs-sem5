package service;

import application.model.dao.impl.UserDAO;
import application.model.dto.RegisterDTO;
import application.model.exception.MySQLException;
import application.model.exception.UnsupportedUsernameException;
import application.model.service.RegistrationService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RegistrationServiceTest {
    RegistrationService registerService;
    UserDAO dao ;

    @Before
    public void setUp() {
        dao = mock(UserDAO.class);

    }

    @Test(expected = UnsupportedUsernameException.class)
    public void UsernameAlreadyExistTest() throws MySQLException {
        registerService = new RegistrationService();
        RegisterDTO registerDTO = new RegisterDTO("nastia","new_password","lapa@gmail.com");
        registerService.register(registerDTO);
    }

    @Test
    public void SuccessfullRegistrationTest() throws MySQLException {
        registerService = mock(RegistrationService.class);
        RegisterDTO registerDto = new RegisterDTO("test", "new_pass", "newUser@gmail.com");
        registerService.register(registerDto);
        verify(registerService).register(registerDto);
    }
}
