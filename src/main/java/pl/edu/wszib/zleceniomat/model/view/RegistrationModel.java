package pl.edu.wszib.zleceniomat.model.view;

import pl.edu.wszib.zleceniomat.model.User.Role;

public class RegistrationModel {
    private String login;
    private String pass;
    private String pass2;
    private Role role;

    public RegistrationModel(String login, String pass, String pass2, Role role) {
        this.login = login;
        this.pass = pass;
        this.pass2 = pass2;
        this.role = role;
    }

    public RegistrationModel() {
    }
        //Added late for Webservice purposes, not considered during the creation of the project
    public RegistrationModel(String login, String pass, String pass2) {
        this.login = login;
        this.pass = pass;
        this.pass2 = pass2;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }
}