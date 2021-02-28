package pl.edu.wszib.zleceniomat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.AdditionModel;
import pl.edu.wszib.zleceniomat.services.IAssignmentService;
import pl.edu.wszib.zleceniomat.services.IOfferService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CustomerController {
    @Autowired
    IAssignmentService assignmentService;

    @Resource
    SessionObject sessionObject;

    @Resource
    IOfferService offerService;


    @RequestMapping(value = "/addAssignment", method = RequestMethod.GET)
    public String addAssignmentForm(Model model){
        model.addAttribute("additionModel", new AdditionModel());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "addAssignment";
    }
    @RequestMapping(value = "/addAssignment", method = RequestMethod.POST)
    public String addAssignment(@ModelAttribute AdditionModel additionModel){

        if(this.assignmentService.addAssignment(additionModel)) {
            return "redirect:/main";
        } else {
            this.sessionObject.setInfo("Assignment name is taken!");
            return "redirect:/addAssignment";
        }
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable int id, Model model) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }
        Assignment assignment = this.assignmentService.getAssignmentById(id);
        model.addAttribute("assignment", assignment);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@ModelAttribute Assignment assignment) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }
        this.assignmentService.updateAssignment(assignment);

        return "redirect:/main";
    }

    @RequestMapping(value = "/assignmentOffers/{id}", method = RequestMethod.GET)
    public String assignmentOffers(@PathVariable int id, Model model){
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }
        model.addAttribute("assignmentOffers", this.offerService.getAllOffersForAssignment(id));
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "assignmentOffers";
    }

}
