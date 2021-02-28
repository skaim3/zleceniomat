package pl.edu.wszib.zleceniomat.services;

import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.Offer;
import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.OfferModel;

import java.util.List;

public interface IOfferService {
    Offer getOfferById(int id);
    List<Offer> getAllOffersForAssignment(int id);
    boolean addOffer(OfferModel offerModel);
    void updateOffer(Offer offer);
    List<Offer> getOwnedOffers(User user);
    List<Offer> getAllOffers();
}
