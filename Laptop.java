package gb.NotebooksMarket;

import java.util.Objects;

public class Laptop {
    private final String brand;
    private final int RAM; // ОЗУ в ГБ
    private final int HDD; // Объем ЖД в ГБ
    public Laptop(String brand, int RAM, int HDD) {
        this.brand = brand;
        this.RAM = RAM;
        this.HDD = HDD;


    }
    public String getBrand() {
        return brand;
    }
    public int getRam() {
        return RAM;
    }
    public int getHdd() {
        return HDD;
    }


    @Override
    public String toString() {
        return "Ноутбук{" +
                "brand='" + brand + " ," +
                "RAM=" + RAM + " GB" +
                ", HDD=" + HDD + " GB" +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return brand.equals(laptop.brand) && RAM == laptop.RAM && HDD == laptop.HDD;
    }
    @Override
    public int hashCode() {
        return Objects.hash(brand, RAM, HDD);
    }
}