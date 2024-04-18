package models;


public class WarehouseSubscriber {

    private String name;
    private Warehouse warehouse = new Warehouse();

    public WarehouseSubscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println("Notify for " + getName() + message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
