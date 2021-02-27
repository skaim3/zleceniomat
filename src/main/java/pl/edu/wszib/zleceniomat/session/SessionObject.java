package pl.edu.wszib.zleceniomat.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.User;

import java.util.Date;

@Component
@SessionScope
public class SessionObject {
    private User loggedUser = null;
    private String info = null;
    private Assignment assignment = null;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public boolean isLogged() {
        return this.loggedUser != null;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Assignment getAssignment() {
        Assignment temp = this.assignment;
        this.assignment = null;
        return temp;
    }

    public void setAssignment(Assignment assignment) { this.assignment = assignment; }

    public String getInfo() {
        String temp = this.info;
        this.info = null;
        return temp;
    }
}
