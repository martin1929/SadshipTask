package models;

import java.util.List;
import java.util.Objects;

public class Player {
    private List<Warehouse> warehouseList;

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }
    public void setWarehouseList(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(warehouseList, player.warehouseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseList);
    }

    @Override
    public String toString() {
        return "models.Player{" +
                "warehouseList=" + warehouseList +
                '}';
    }

}
