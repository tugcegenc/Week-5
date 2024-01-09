package Products;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Scanner;

public class Brand {
    private int id;
    private String name;
    public static boolean isMenu = true;
    private static Scanner scan = new Scanner(System.in);

    public Brand() {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static TreeSet<String> brandMenu() {
        TreeSet<String> brands = new TreeSet<>();
        System.out.println();
        System.out.println("Markalarımız");
        System.out.println("----------------");
        brands.add("Samsung");
        brands.add("Lenovo");
        brands.add("Apple");
        brands.add("Huawei");
        brands.add("Casper");
        brands.add("Asus");
        brands.add("HP");
        brands.add("Monster");


        return brands;
    }

    public static void listBrands() {
        Iterator<String> itr = brandMenu().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());

        }
    }
}






