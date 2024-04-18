package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Warehouse {
    private HashMap<MaterialType, Integer> materials;

    private List<WarehouseSubscriber> warehouseSubscriberList = new ArrayList<>();

    public Warehouse() {
    }

    public Warehouse(HashMap<MaterialType, Integer> materials) {
        this.materials = materials;
    }

    public void addMaterial(Material material) {
        int currentQuantity = materials.getOrDefault(material.getType(), 0);
        if (currentQuantity + material.getQuantity() > material.getType().getMaxCapacity()) {
            throw new IllegalArgumentException("You pass limit of max capacity  " + material.getType().getName() +
                    "Max capacity is " + material.getType().getMaxCapacity());
        }
        materials.put(material.getType(), currentQuantity + material.getQuantity());
    }

    public void relocateMaterial(MaterialType type, Warehouse target, int amount) {
        removeMaterial(type, amount);
        try {
            target.addMaterial(new Material(type, amount));
            System.out.println("Success! Material relocated to the warehouse.");
        } catch (IllegalArgumentException exception) {
            addMaterial(new Material(type, amount));
            System.out.println("You don't have enough " + type.getName() + " to relocate.");
        }
    }

    public void removeMaterial(MaterialType type, int quantity) throws IllegalArgumentException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive value");
        }
        int currentQuantity = materials.getOrDefault(type, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("You don't have that much material " + type.getName());
        }
        materials.put(type, currentQuantity - quantity);
    }

    public void addSubscriber(WarehouseSubscriber warehouseSubscriber) {
        warehouseSubscriberList.add(warehouseSubscriber);
    }

    public void removeSubscriber(WarehouseSubscriber warehouseSubscriber) {
        warehouseSubscriberList.remove(warehouseSubscriber);
    }

    public void notifySubscribers(String message) {
        for (WarehouseSubscriber sub : warehouseSubscriberList) {
            sub.update(message);
        }
    }

    public int getMaterialQuantity(MaterialType type) {
        return materials.getOrDefault(type, 0);
    }

    public List<WarehouseSubscriber> getWarehouseSubscriberList() {
        return warehouseSubscriberList;
    }

    public void setWarehouseSubscriberList(List<WarehouseSubscriber> warhouseSubscriberList) {
        this.warehouseSubscriberList = warhouseSubscriberList;
    }

    public HashMap<MaterialType, Integer> getMaterials() {
        return materials;
    }

}