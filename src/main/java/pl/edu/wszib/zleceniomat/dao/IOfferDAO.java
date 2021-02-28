package pl.edu.wszib.zleceniomat.dao;

import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.Offer;
import pl.edu.wszib.zleceniomat.model.User;

import java.util.List;

public interface IOfferDAO {
    List<Offer> getAllOffers();
    Offer getOfferById(int id);
    List<Offer> getAllOffersForAssignment(int id);
    boolean addOffer(Offer offer);
    void updateOffer(Offer offer);
    List<Offer> getOwnedOffers(User user);
}
