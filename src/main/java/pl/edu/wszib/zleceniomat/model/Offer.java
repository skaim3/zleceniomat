package pl.edu.wszib.zleceniomat.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "toffer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Assignment assignment;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    private Date date;
    private float price;

    public Offer(int id, User user, Assignment assignment, Date date, float price) {
        this.id = id;
        this.user = user;
        this.assignment = assignment;
        this.date = date;
        this.price = price;
    }

    public Offer() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Assignment getAssignment() { return assignment; }

    public void setAssignment(Assignment assignment) { this.assignment = assignment; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }
}
