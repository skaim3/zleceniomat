package pl.edu.wszib.zleceniomat.services.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.zleceniomat.dao.IAssignmentDAO;
import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.services.IAssignmentService;

import java.util.List;

@Service
public class AssignmentServiceImpl implements IAssignmentService {

    @Autowired
    IAssignmentDAO assignmentDAO;

    @Override
    public Assignment getAssignmentById(int id){ return this.assignmentDAO.getAssignmentById(id);}

    @Override
    public void updateAssignment(Assignment assignment){
        Assignment assignmentFromDB = this.assignmentDAO.getAssignmentById(assignment.getId());
        assignmentFromDB.setName(assignment.getName());
        assignmentFromDB.setDescription(assignment.getDescription());

        this.assignmentDAO.updateAssignment(assignmentFromDB);
    }

    @Override
    public List<Assignment> getAllAssignments(){ return this.assignmentDAO.getAllAssignments(); }
}
