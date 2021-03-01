package pl.edu.wszib.zleceniomat.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.AdditionModel;
import pl.edu.wszib.zleceniomat.services.IAssignmentService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class AssignmentServiceImplTest {
    @Autowired
    IAssignmentService assignmentService;

    @MockBean
    IAssignmentDAO assignmentDAO;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IOfferDAO offerDAO;

    @Resource
    SessionObject sessionObject;

    @Before
    public void configureMocks(){
        Mockito.when(this.assignmentDAO.getAssignmentByName("Name")).thenReturn(generateAssignment());
    }

    @Test
    public void addDBAssignmentFailed(){
        AdditionModel additionModel = new AdditionModel();
        additionModel.setName("Name");
        additionModel.setDescription("Description");
        additionModel.setOwnerId(2);

        boolean result = assignmentService.addDBAssignment(additionModel);

        Assert.assertFalse(result);
    }

    private Assignment generateAssignment(){
        Assignment assignment = new Assignment();
        assignment.setName("Name");
        assignment.setDescription("Description");
        assignment.setId(1);
        assignment.setOwnerId(2);
        assignment.setAvailability("YES");

        return assignment;
    }
}
