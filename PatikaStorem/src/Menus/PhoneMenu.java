package Menus;

import Products.MobilePhone;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneMenu extends Menu {

    private static Scanner scanner = new Scanner(System.in);

    public PhoneMenu() {
        super("Telefon Menüsü");

    }

    @Override
    public boolean onMenu() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Telefon Menüsü");
            System.out.println("1- Telefon Listele");
            System.out.println("2- Telefon Ekle");
            System.out.println("3- Telefon Sil");
            System.out.println("0- Ana Menü");

            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    showPhones();
                    break;
                case 2:
                    addPhone(phones);
                    break;
                case 3:
                    deletePhone(phones);
                    break;
                case 0:
                    System.out.println("Ana menüye dönülüyor.");
                    return false;
                default:
                    System.out.println("Geçersiz seçenek.");
                    break;
            }

        }

        return true;
    }

    public static void deletePhone(ArrayList<MobilePhone> phone) {
        showPhones();
        System.out.println("Lütfen silmek istediğiniz ürünün ID'sini giriniz");
        int deletionSelection = scanner.nextInt();


        int indexToRemove = -1;
        for (int i = 0; i < phone.size(); i++) {
            if (phone.get(i).getId() == deletionSelection) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            phone.remove(indexToRemove);
            System.out.println("Ürün silindi.");
            showPhones();
        } else {
            System.out.println("ID bulunamadı.");
        }
    }

    public static void addPhone(ArrayList<MobilePhone> phone) {
        ArrayList<Integer> phoneIDList = new ArrayList<>();
        for (MobilePhone phones : phone) {
            phoneIDList.add(phones.getId());
        }
        System.out.println("Lütfen yeni ID giriniz: ");
        int newPhoneID = scanner.nextInt();
        scanner.nextLine();
        if (!phoneIDList.contains(newPhoneID)) {

            System.out.println("Lütfen fiyatını giriniz: ");
            int newPhonePrice = scanner.nextInt();

            System.out.println("Lütfen indirim oranını giriniz: ");
            Double newPhoneDiscount = scanner.nextDouble();

            System.out.println("Lütfen stok bilgisi giriniz: ");
            int newPhoneStock = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Lütfen ismini giriniz: ");
            String newPhoneName = scanner.next();
            scanner.nextLine();
            System.out.println("Lütfen markasını giriniz: ");
            String newPhoneBrand = scanner.next();

            System.out.println("Lütfen hafızasını giriniz: ");
            int newPhoneStorage = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Lütfen ekran boyutunu giriniz: ");
            Double newPhoneScreenSize = scanner.nextDouble();

            System.out.println("Lütfen RAM giriniz(GB ile): ");
            int newPhoneRam = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Lütfen renk giriniz: ");
            String newPhoneColor = scanner.nextLine();

            System.out.println("Lütfen batarya boyutunu giriniz: ");
            int newPhoneBatterySize = scanner.nextInt();

            phones.add(new MobilePhone(newPhoneID, newPhonePrice, newPhoneDiscount, newPhoneStock, newPhoneName,
                    newPhoneBrand, newPhoneStorage, newPhoneScreenSize, newPhoneRam, newPhoneColor, newPhoneBatterySize));

            System.out.println("Yeni telefon eklendi.");
            System.out.println("----------------------");
            showPhones();
        } else {
            System.out.println("ID hali hazırda var. Lütfen tekrar deneyin");

        }

    }

    static ArrayList<MobilePhone> phones = new ArrayList<>();

    static {
        phones.add(new MobilePhone(101, 1000, 0.20, 100, "Iphone 10", "Apple", 64, 6.1, 8, "Beyaz", 4000));
        phones.add(new MobilePhone(102, 2000, 0.10, 50, "Iphone 13", "Apple", 128, 6.4, 16, "Gri", 5000));

    }


    public static void showPhones() {
        System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Pil", "Renk", "Stok", "İndirim");

        for (MobilePhone phone : phones) {
            System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    phone.getId(), phone.getName(), phone.getPrice(), phone.getBrand(), phone.getStorage(),
                    phone.getScreenSize(), phone.getRam(), phone.getBatteryPower(), phone.getColor(),
                    phone.getStockNum(), phone.getDiscountRate());
        }
    }
}