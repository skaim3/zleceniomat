package pl.edu.wszib.zleceniomat.database;

import pl.edu.wszib.zleceniomat.model.Assignment;

import java.util.List;

public interface IAssignmentRepository {
    List<Assignment> getAllAssignments();
    Assignment getAssignmentByOwnerId(int ownerId);
    void updateAssignment(Assignment assignment);
    Assignment getAssignmentById(int id);
}
