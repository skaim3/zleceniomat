package pl.edu.wszib.zleceniomat.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.zleceniomat.dao.IOfferDAO;
import pl.edu.wszib.zleceniomat.model.Assignment;
import pl.edu.wszib.zleceniomat.model.Offer;
import pl.edu.wszib.zleceniomat.model.User;
import pl.edu.wszib.zleceniomat.model.view.OfferModel;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HibernateOfferDAOImpl implements IOfferDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Offer getOfferById(int id){
        Session session = this.sessionFactory.openSession();
        Query<Offer> query = session.createQuery("FROM pl.edu.wszib.zleceniomat.model.Offer WHERE id = :id");
        query.setParameter("id", id);
        Offer offer = null;
        try {
            offer = query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("Offer not found!");
        }
        session.close();
        return offer;
    }

    @Override
    public List<Offer> getAllOffers() {
        Session session = this.sessionFactory.openSession();
        Query<Offer> query = session.createQuery("FROM pl.edu.wszib.zleceniomat.model.Offer");
        List<Offer> offers = query.getResultList();
        session.close();
        return offers;
    }

    @Override
    public List<Offer> getAllOffersForAssignment(int id){
        Session session = this.sessionFactory.openSession();
        Query<Offer> query = session.createQuery("FROM pl.edu.wszib.zleceniomat.model.Offer WHERE assignment.id = :assignment");
        query.setParameter("assignment", id);
        List<Offer> offers = query.getResultList();
        session.close();
        return offers;
    }

    @Override
    public List<Offer> getOwnedOffers(User user){
        Session session = this.sessionFactory.openSession();
        Query<Offer> query = session.createQuery("FROM pl.edu.wszib.zleceniomat.model.Offer WHERE user = :owner");
        query.setParameter("owner", user);
        List<Offer> offers = query.getResultList();
        session.close();
        return offers;
    }

    @Override
    public boolean addOffer(Offer offer){
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(offer);
            tx.commit();
            return true;
        } catch (Exception e){
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public void updateOffer(Offer offer){
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(offer);
            tx.commit();
        } catch (Exception e){
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
    }
}
