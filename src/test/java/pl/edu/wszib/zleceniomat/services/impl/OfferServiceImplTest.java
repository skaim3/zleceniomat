package pl.edu.wszib.zleceniomat.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import pl.edu.wszib.zleceniomat.model.view.AdditionModel;
import pl.edu.wszib.zleceniomat.model.view.OfferModel;
import pl.edu.wszib.zleceniomat.services.IOfferService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;
import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class OfferServiceImplTest {
    @Autowired
    IOfferService offerService;

    @MockBean
    IAssignmentDAO assignmentDAO;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IOfferDAO offerDAO;

    @Resource
    SessionObject sessionObject;

    @Test
    public void addOfferFailed(){
        OfferModel offerModel = new OfferModel();
        offerModel.setPrice(50);
        offerModel.setDate((Date.valueOf("2021-02-02")));
        offerModel.setOfferOwnerId(1);

        boolean result = offerService.addOffer(offerModel);

        Assert.assertFalse(result);
    }


    private User generateUser(){
        User user = new User();
        user.setId(2);
        user.setLogin("sebastian");
        user.setPass("sebastian");
        user.setRole(User.Role.CUSTOMER);

        return user;
    }
}
