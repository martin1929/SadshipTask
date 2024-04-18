package models;

import java.util.Objects;

public class Material {

    private MaterialType type;

    private int quantity;

    public Material(MaterialType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "type=" + type +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material materials = (Material) o;
        return quantity == materials.quantity && Objects.equals(type, materials.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, quantity);
    }
}
