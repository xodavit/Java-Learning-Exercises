package ru.dns.qa;

public class VirtualProduct {
    private String name;
    private int price;
    private String description;
    private boolean warranty;

    public VirtualProduct(String name) {
        this.name = name;
        this.price = 0;
        this.description = "нет описания";
        this.warranty = false;
    }

    public VirtualProduct(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "VirtualProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", warranty=" + warranty +
                '}';
    }
}
