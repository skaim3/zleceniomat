package pl.edu.wszib.zleceniomat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.Offer;
import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.AdditionModel;
import pl.edu.wszib.zleceniomat.model.view.OfferModel;
import pl.edu.wszib.zleceniomat.services.IAssignmentService;
import pl.edu.wszib.zleceniomat.services.IOfferService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class ContractorController {
    @Autowired
    IOfferService offerService;

    @Resource
    SessionObject sessionObject;

    @Resource
    IAssignmentService assignmentService;

    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public String offers(Model model){
        model.addAttribute("ownedOffers", this.offerService.getOwnedOffers(this.sessionObject.getLoggedUser()));
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        model.addAttribute("owner",this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getId() : null);
        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        else
            return "main";
    }

    @RequestMapping(value = "/addOffer/{id}", method = RequestMethod.GET)
    public String addOfferForm(@PathVariable int id, Model model){
        this.sessionObject.setAssignment(assignmentService.getAssignmentById(id));
        model.addAttribute("offerModel", new OfferModel());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "addOffer";
    }
    @RequestMapping(value = "/addOffer/{id}", method = RequestMethod.POST)
    public String addOffer(@ModelAttribute OfferModel offerModel){
        if(this.offerService.addOffer(offerModel)) {
            return "redirect:/main";
        } else {
            this.sessionObject.setInfo("Offer already exists!");
            return "redirect:/addOffer";
        }
    }
    @RequestMapping(value = "/editOffer/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable int id, Model model) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.CONTRACTOR) {
            return "redirect:/login";
        }
        Offer offer = this.offerService.getOfferById(id);
        model.addAttribute("offer", offer);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "edit";
    }

    @RequestMapping(value = "/editOffer/{id}", method = RequestMethod.POST)
    public String edit(@ModelAttribute Offer offer) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.CONTRACTOR) {
            return "redirect:/login";
        }
        this.offerService.updateOffer(offer);

        return "redirect:/main";
    }
}
