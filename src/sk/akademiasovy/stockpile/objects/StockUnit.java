package sk.akademiasovy.stockpile.objects;

public class StockUnit {
    private String name;
    private String quantity;
    private String recipient;
    private String origin;

    public StockUnit() {
    }

    public StockUnit(String name, String quantity, String origin) {
        this.name = name;
        this.quantity = quantity;
        this.origin = origin;
    }

    public StockUnit(String name, String quantity, String recipient, String origin) {
        this.name = name;
        this.quantity = quantity;
        this.recipient = recipient;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
