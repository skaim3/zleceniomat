package pl.edu.wszib.zleceniomat.dao;

import pl.edu.wszib.zleceniomat.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    boolean persistUser(User user);
}
