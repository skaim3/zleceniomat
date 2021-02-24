package pl.edu.wszib.zleceniomat.model.view;

public class AdditionModel {
    private String name;
    private String description;
    private int ownerId;

    public AdditionModel(String name, String description, int ownerId) {
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
    }

    public AdditionModel() {
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getOwnerId() { return ownerId; }

    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
}
