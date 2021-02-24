package pl.edu.wszib.zleceniomat.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.zleceniomat.dao.IAssignmentDAO;
import pl.edu.wszib.zleceniomat.model.Assignment;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HibernateAssignmentDAOImpl implements IAssignmentDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Assignment getAssignmentById(int id){
        Session session = this.sessionFactory.openSession();
        Query<Assignment> query = session.createQuery("FROM pl.edu.wszib.zleceniomat.model.Assignment WHERE id = :id");
        query.setParameter("id", id);
        Assignment assignment = null;
        try {
            assignment = query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("Assignment not found!");
        }
        session.close();
        return assignment;
    }

    @Override
    public void updateAssignment(Assignment assignment){
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(assignment);
            tx.commit();
        } catch (Exception e){
            if(tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Assignment> getAllAssignments(){
        Session session = this.sessionFactory.openSession();
        Query<Assignment> query = session.createQuery("FROM pl.edu.wszib.zleceniomat.model.Assignment");
        List<Assignment> assignments = query.getResultList();
        session.close();
        return assignments;
    }
}
