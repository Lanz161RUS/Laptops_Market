package gb.NotebooksMarket;

import java.util.*;

public class Laptops {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Acer", 4, 256));
        laptops.add(new Laptop("Asus", 8, 1024));
        laptops.add(new Laptop("Macbook", 16, 2048));
        laptops.add(new Laptop("Huawei", 8, 512));
        laptops.add(new Laptop("Xiaomi", 32, 2048));
        laptops.add(new Laptop("Macbook", 16, 2048));
        laptops.add(new Laptop("Huawei", 8, 512));
        laptops.add(new Laptop("Asus", 16, 1024));
        laptops.add(new Laptop("Macbook", 32, 2048));
        laptops.add(new Laptop("Xiaomi", 8, 1024));
        laptops.add(new Laptop("Huawei", 16, 1024));
        laptops.add(new Laptop("Acer", 8, 1024));
        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "Производитель");
        criteria.put(2, "RAM");
        criteria.put(3, "HDD");

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        boolean continueFiltering = true;
        while (continueFiltering) {
            System.out.println("Выбери критерий поиска:");
            for (Map.Entry<Integer, String> entry :
                    criteria.entrySet()) {
                System.out.println(entry.getKey() + " - " +
                        entry.getValue());
            }
            int criterion = scanner.nextInt();
            scanner.nextLine();
            switch (criterion) {
                case 1:
                    System.out.print("Введите производителя ноутбука (Acer, Asus, Dell, Macbook, Huawei, Xiaomi: ");
                    filters.put("brand", scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Сколько минимум оперативной памяти2 (GB)?: ");
                    filters.put("RAM", scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Какой минимальный объем HDD (GB)?: ");
                    filters.put("HDD", scanner.nextInt());
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Некорректный критерий.");
            }
            System.out.print("Хотите добавить еще один критерий? (yes/no): ");
            String response = scanner.nextLine();
            continueFiltering = response.equalsIgnoreCase("yes");
        }
        filterLaptops(laptops, filters);
    }

    public static void filterLaptops(Set<Laptop> laptops,
                                     Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = !filters.containsKey("RAM") || laptop.getRam() >= (int) filters.get("RAM");
            if (filters.containsKey("HDD") && laptop.getHdd() <
                    (int) filters.get("HDD")) {
                matches = false;
            }
            if (filters.containsKey("brand") &&
                    !laptop.getBrand().equalsIgnoreCase((String) filters.get("brand"))) {
                matches = false;
            }

            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
