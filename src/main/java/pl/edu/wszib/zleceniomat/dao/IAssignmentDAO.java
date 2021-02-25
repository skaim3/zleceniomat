package pl.edu.wszib.zleceniomat.dao;

import pl.edu.wszib.zleceniomat.model.Assignment;

import java.util.List;

public interface IAssignmentDAO {
    Assignment getAssignmentById(int id);
    void updateAssignment(Assignment assignment);
    List<Assignment> getAllAssignments();
    boolean addAssignment(Assignment assignment);
    Assignment getAssignmentByName(String name);
    List<Assignment> getOwnedAssignments(int ownerId);
}
