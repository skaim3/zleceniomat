package pl.edu.wszib.zleceniomat.services;

import pl.edu.wszib.zleceniomat.model.Assignment;

import java.util.List;

public interface IAssignmentService {
    Assignment getAssignmentById(int id);
    void updateAssignment(Assignment assignment);
    List<Assignment> getAllAssignments();
}
