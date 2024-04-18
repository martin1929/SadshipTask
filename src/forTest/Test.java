package forTest;

import models.Material;
import models.MaterialType;
import models.Warehouse;
import models.WarehouseSubscriber;

import java.util.HashMap;

import static servives.WareHouseService.getInstance;

public class Test {


    public void addItemsAndPrint() {
        Warehouse firstWarehouse = getOneTestWarehouse();
        Warehouse secondWarehouse = getOneTestWarehouse();
        Warehouse thirdWarehouse = getOneTestWarehouse();
        firstWarehouse.notifySubscribers(" Warehouse was added");
        getInstance().addWarehouse(firstWarehouse);
        getInstance().addWarehouse(secondWarehouse);
        getInstance().addWarehouse(thirdWarehouse);
        getInstance().printWarehouses(getInstance().getWarehouses());
    }

    public Warehouse getOneTestWarehouse() {
        Warehouse tesWarehouse = new Warehouse(new HashMap<>());
        tesWarehouse.addSubscriber(new WarehouseSubscriber("Artur"));
        tesWarehouse.addSubscriber(new WarehouseSubscriber("Jhon"));
        tesWarehouse.addMaterial(new Material(new MaterialType("Iron", 20), 10));
        tesWarehouse.addMaterial(new Material(new MaterialType("Wood", 20), 6));
        tesWarehouse.addMaterial(new Material(new MaterialType("Gold", 20), 5));
        return tesWarehouse;
    }

    public void removeItemAndPrint() {
        Warehouse firstWarehouse = getOneTestWarehouse();
        printWarehouseForTest("Before remove ", firstWarehouse);
        firstWarehouse.removeMaterial(new MaterialType("Iron", 20), 5);
        printWarehouseForTest("After remove ", firstWarehouse);
    }

    public void getItemAndPrint() {
        Warehouse firsWarehouse = getOneTestWarehouse();
        printWarehouseForTest("Added Warehouse", firsWarehouse);
        System.out.println("You have " + firsWarehouse.getMaterialQuantity(new MaterialType("Iron", 20)) + " Iron");
    }

    public void relocateItemAndPrint() {
        Warehouse firsWarehouse = getOneTestWarehouse();
        Warehouse secondWarehouse = getOneTestWarehouse();
        printWarehouseForTest("First", firsWarehouse);
        printWarehouseForTest("Second", secondWarehouse);
        try {
            secondWarehouse.relocateMaterial(new MaterialType("Iron", 20), firsWarehouse, 10);
            printWarehouseForTest("First", firsWarehouse);
            printWarehouseForTest("Second", secondWarehouse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllMaterialsQuantityAndPrint() {
        getInstance().printWarehouses(getInstance().getWarehouses());
        System.out.println(getInstance().getAllMaterialsQuantity(new MaterialType("Iron", 20)) + " Iron");
    }

    public void printWarehouseForTest(String message, Warehouse warehouse) {
        System.out.println(message);
        warehouse.getMaterials().entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

}
