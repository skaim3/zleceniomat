package pl.edu.wszib.zleceniomat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.zleceniomat.services.IAssignmentService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {
    @Autowired
    IAssignmentService assignmentService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage(){return "redirect:/main";}

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("assignments", this.assignmentService.getAllAvailableAssignments("YES"));
        model.addAttribute("ownedAssignments", this.assignmentService.getOwnedAssignments(this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getId() : 0));
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        model.addAttribute("owner",this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getId() : null);

        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "contact";
    }

}
