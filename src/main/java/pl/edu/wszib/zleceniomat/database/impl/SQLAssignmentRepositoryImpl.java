package pl.edu.wszib.zleceniomat.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import pl.edu.wszib.zleceniomat.database.IAssignmentRepository;
import pl.edu.wszib.zleceniomat.model.Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLAssignmentRepositoryImpl implements IAssignmentRepository {

    @Autowired
    Connection connection;

    @Override
    public List<Assignment> getAllAssignments() {
        List<Assignment> assignments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tassignment;";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                assignments.add(new Assignment(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("ownerId")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return assignments;
    }

    @Override
    public Assignment getAssignmentByOwnerId(int ownerId) {
        try {
            String sql = "SELECT * FROM tassignment WHERE ownerId = ?;";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, ownerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return new Assignment(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("ownerId"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addAssignment(Assignment assignment){
        if(isAssignmentInDB(assignment.getName())) {
            return false;
        }

        String sql = "INSERT INTO tassignment (name, description, ownerId) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, assignment.getName());
            preparedStatement.setString(2, assignment.getDescription());
            preparedStatement.setInt(3, assignment.getOwnerId());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    private boolean isAssignmentInDB(String name) {
        String sql = "SELECT * FROM tassignment WHERE name = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return true;
        }

        return false;
    }

    @Override
    public void updateAssignment(Assignment assignment) {
        String sql = "UPDATE tassignment SET name = ?, description = ?, ownerId = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, assignment.getName());
            preparedStatement.setString(2, assignment.getDescription());
            preparedStatement.setInt(3, assignment.getOwnerId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Assignment getAssignmentById(int id) {
        String sql = "SELECT * FROM tassignment WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return new Assignment(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("ownerId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
