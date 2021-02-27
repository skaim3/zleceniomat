package pl.edu.wszib.zleceniomat.services;

import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.view.AdditionModel;

import java.util.List;

public interface IAssignmentService {
    Assignment getAssignmentById(int id);
    void updateAssignment(Assignment assignment);
    List<Assignment> getAllAssignments();
    List<Assignment> getAllAvailableAssignments(String availability);
    boolean addAssignment(AdditionModel additionModel);
    List<Assignment> getOwnedAssignments(int ownerId);
}
