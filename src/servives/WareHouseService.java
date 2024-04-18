package servives;

import models.MaterialType;
import models.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WareHouseService {
    private static WareHouseService instance;
    private List<Warehouse> warehouses;

    // Private constructor to prevent instantiation from outside
    private WareHouseService() {
        warehouses = new ArrayList<>();
    }

    // Static method to get the singleton instance
    public static WareHouseService getInstance() {
        if (instance == null) {
            instance = new WareHouseService();
        }
        return instance;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
        System.out.println("You have " + warehouses.size() + " wearhoues");
    }

    public int getAllMaterialsQuantity(MaterialType type) {
        int totalAmount = 0;
        for (Warehouse warehouse : warehouses) {
            totalAmount += warehouse.getMaterialQuantity(type);
        }
        return totalAmount;
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }

    public void printWarehouses(List<Warehouse> warehouseList) {
        warehouseList.stream().flatMap(list -> list.getMaterials().entrySet().stream())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WareHouseService that = (WareHouseService) o;
        return Objects.equals(warehouses, that.warehouses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouses);
    }

    @Override
    public String toString() {
        return "servives.WareHouseService{" +
                "warehouses=" + warehouses +
                '}';
    }
}
