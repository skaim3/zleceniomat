package pl.edu.wszib.zleceniomat.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.zleceniomat.dao.IAssignmentDAO;
import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.AdditionModel;
import pl.edu.wszib.zleceniomat.services.IAssignmentService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AssignmentServiceImpl implements IAssignmentService {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IAssignmentDAO assignmentDAO;

    @Override
    public Assignment getAssignmentById(int id){ return this.assignmentDAO.getAssignmentById(id);}

    @Override
    public List<Assignment> getOwnedAssignments(int ownerId){ return this.assignmentDAO.getOwnedAssignments(ownerId); }

    @Override
    public void updateAssignment(Assignment assignment){
        Assignment assignmentFromDB = this.assignmentDAO.getAssignmentById(assignment.getId());
        assignmentFromDB.setName(assignment.getName());
        assignmentFromDB.setDescription(assignment.getDescription());

        this.assignmentDAO.updateAssignment(assignmentFromDB);
    }

    @Override
    public List<Assignment> getAllAssignments(){ return this.assignmentDAO.getAllAssignments(); }

    @Override
    public List<Assignment> getAllAvailableAssignments(String availability){ return this.assignmentDAO.getAllAvailableAssignments(availability); }

    @Override
    public boolean addAssignment(AdditionModel additionModel){
        if(this.assignmentDAO.getAssignmentByName(additionModel.getName()) != null) {
            return false;
        }

        Assignment newAssignment = new Assignment(0, additionModel.getName(), additionModel.getDescription(), this.sessionObject.getLoggedUser().getId(), "YES");

        return this.assignmentDAO.addAssignment(newAssignment);
    }
}
