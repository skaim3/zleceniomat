package pl.edu.wszib.zleceniomat.services;

import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.view.AdditionModel;

import java.util.List;

public interface IAssignmentService {
    Assignment getAssignmentById(int id);
    Assignment getAssignmentByName(String name);
    void updateAssignment(Assignment assignment);
    List<Assignment> getAllAssignments();
    List<Assignment> getAllAvailableAssignments(String availability);
    boolean addAssignment(AdditionModel additionModel);
    List<Assignment> getOwnedAssignments(int ownerId);
    //Added late for Webservice purposes, not considered during the creation of the project
    boolean addDBAssignment(AdditionModel additionModel);
}
