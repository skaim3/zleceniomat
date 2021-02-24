package pl.edu.wszib.zleceniomat.database;

import pl.edu.wszib.zleceniomat.model.User;

public interface IUsersRepository {
    User authenticate(User user);
    boolean register(User user);
}
