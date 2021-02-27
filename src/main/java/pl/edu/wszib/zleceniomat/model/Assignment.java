package pl.edu.wszib.zleceniomat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity(name = "tassignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int ownerId;
    private String availability;


    public Assignment(int id, String name, String description, int ownerId, String availability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
        this.availability = availability;
    }

    public Assignment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getAvailability() { return availability; }

    public void setAvailability(String availability) { this.availability = availability; }

    @Override
    public String toString() {
        return "Assignment{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", owner=" + ownerId + '}';
    }
}
