package pl.edu.wszib.zleceniomat.model.view;

import java.sql.Date;

public class OfferModel {
    private float price;
    private Date date;
    private int offerOwnerId;
    private int assignmentId;

    public OfferModel(float price, Date date, int offerOwnerId, int assignmentId) {
        this.price = price;
        this.date = date;
        this.offerOwnerId = offerOwnerId;
        this.assignmentId = assignmentId;
    }

    public OfferModel() {
    }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public int getOfferOwnerId() { return offerOwnerId; }

    public void setOfferOwnerId(int offerOwnerId) { this.offerOwnerId = offerOwnerId; }

    public int getAssignmentId() { return assignmentId; }

    public void setAssignmentId(int assignmentId) { this.assignmentId = assignmentId; }
}
