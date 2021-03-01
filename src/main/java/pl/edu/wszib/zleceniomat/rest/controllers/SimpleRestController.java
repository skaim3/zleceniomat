package pl.edu.wszib.zleceniomat.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.zleceniomat.model.view.AdditionModel;
import pl.edu.wszib.zleceniomat.model.view.RegistrationModel;
import pl.edu.wszib.zleceniomat.services.IAssignmentService;
import pl.edu.wszib.zleceniomat.services.IUserService;

@RestController
public class SimpleRestController {

    @Autowired
    IUserService userService;

    @Autowired
    IAssignmentService assignmentService;

    @RequestMapping(value = "/fillTheDatabase", method = RequestMethod.GET)
    public void fillTheDatabase(){
        this.userService.addNewContractor(new RegistrationModel("Andrzej", "andrzej", "andrzej"));
        this.userService.addNewCustomer(new RegistrationModel("Anton", "anton", "anton"));

        this.assignmentService.addDBAssignment(new AdditionModel("Stworzenie aplikacji webowej","Zlecenie polegające na stworzeniu prostej aplikacji webowej dla magazynu sklepu",2));
        this.assignmentService.addDBAssignment(new AdditionModel("Program do zarządzania biblioteką","Zlecenie polegające na stworzeniu aplikacji do zarządzania zasobami biblioteki",2));
        this.assignmentService.addDBAssignment(new AdditionModel("Aplikacja do zleceń IT","Zlecenie polegające na stworzeniu *lepszej* aplikacji webowej niż ta z której właśnie korzystamy",2));
    }
}
