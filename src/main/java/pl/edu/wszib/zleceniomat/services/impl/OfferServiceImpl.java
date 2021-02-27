package pl.edu.wszib.zleceniomat.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.zleceniomat.dao.IAssignmentDAO;
import pl.edu.wszib.zleceniomat.dao.IOfferDAO;
import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.Offer;
import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.OfferModel;
import pl.edu.wszib.zleceniomat.services.IOfferService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OfferServiceImpl implements IOfferService {
    @Resource
    SessionObject sessionObject;

    @Autowired
    IOfferDAO offerDAO;

    @Override
    public Offer getOfferById(int id){ return this.offerDAO.getOfferById(id); }

    @Override
    public List<Offer> getAllOffersForAssignment(Assignment assignment){ return this.offerDAO.getAllOffersForAssignment(this.sessionObject.getAssignment()); }

    @Override
    public boolean addOffer(OfferModel offerModel){
        Offer newOffer = new Offer(0, this.sessionObject.getLoggedUser(), this.sessionObject.getAssignment(), offerModel.getDate(), offerModel.getPrice());

        return this.offerDAO.addOffer(newOffer);
    }

    @Override
    public void updateOffer(Offer offer){
        Offer offerFromDB = this.offerDAO.getOfferById(offer.getId());
        offerFromDB.setPrice(offer.getPrice());
        offerFromDB.setDate(offer.getDate());

        this.offerDAO.updateOffer(offerFromDB);
    }

    @Override
    public List<Offer> getOwnedOffers(User user){ return this.offerDAO.getOwnedOffers(this.sessionObject.getLoggedUser()); }
}
