package pl.edu.wszib.zleceniomat.services;

import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.RegistrationModel;

public interface IUserService {
    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
        //Added late for Webservice purposes, not considered during the creation of the project
    boolean addNewContractor(RegistrationModel registrationModel);
    boolean addNewCustomer(RegistrationModel registrationModel);
}
