package pl.edu.wszib.zleceniomat.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.zleceniomat.configuration.TestConfiguration;
import pl.edu.wszib.zleceniomat.dao.IAssignmentDAO;
import pl.edu.wszib.zleceniomat.dao.IOfferDAO;
import pl.edu.wszib.zleceniomat.dao.IUserDAO;
import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.RegistrationModel;
import pl.edu.wszib.zleceniomat.services.IUserService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {
    @Autowired
    IUserService userService;

    @MockBean
    IAssignmentDAO assignmentDAO;

    @MockBean
    IOfferDAO offerDAO;

    @MockBean
    IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    @Before
    public void configureMocks(){
        Mockito.when(this.userDAO.getUserByLogin("karol")).thenReturn(null);
        Mockito.when(this.userDAO.persistUser(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(this.userDAO.getUserByLogin("piotrek")).thenReturn(new User());
        Mockito.when(this.userDAO.getUserByLogin("sebastian")).thenReturn(generateUser());
        Mockito.when(this.userDAO.getUserByLogin("jan")).thenReturn(null);
    }

    @Test
    public void registerTest(){
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setLogin("karol");
        registrationModel.setPass("karol123");
        registrationModel.setPass2("karol123");

        boolean result = userService.register(registrationModel);

        Assert.assertTrue(result);
    }
    @Test
    public void registerLoginIncorrectTest(){
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setLogin("piotrek");
        registrationModel.setPass("piotrek000");
        registrationModel.setPass2("piotrek00");

        boolean result = userService.register(registrationModel);

        Assert.assertFalse(result);
    }

    @Test
    public void correctAuthenticationTest(){
        User user = new User();
        user.setLogin("sebastian");
        user.setPass("sebastian");

        this.userService.authenticate(user);

        Assert.assertNotNull(this.sessionObject.getLoggedUser());
    }

    @Test
    public void incorrectLoginAuthentication(){
        User user = new User();
        user.setLogin("jan");
        user.setPass("jan");

        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }

    @Test
    public void incorrectPassTest(){
        User user = new User();
        user.setLogin("sebastian");
        user.setPass("sebastian123");

        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }

    private User generateUser(){
        User user = new User();
        user.setId(4);
        user.setLogin("sebastian");
        user.setPass("sebastian");
        user.setRole(User.Role.CUSTOMER);

        return user;
    }


}
