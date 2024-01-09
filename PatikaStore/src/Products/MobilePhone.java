package Products;

import java.util.*;

public class MobilePhone extends Product {
    private int batteryPower;
    private String color;
    private static Scanner scanner = new Scanner(System.in);
    static ArrayList<MobilePhone> phones = new ArrayList<>();

    public MobilePhone() {
        super();
    }

    public MobilePhone(int id, int price, double discountRate, int stock, String productName, String brand,
                       int memorySize, double screenSize, int ram, int batteryPower, String color) {
        super(id, price, discountRate, stock, productName, brand, memorySize, screenSize, ram);
        this.batteryPower = batteryPower;
        this.color = color;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void initializePhones() {
        phones.add(new MobilePhone(100, 30000, 0.1, 10, "Galaxy S23", "Samsung", 128, 6.1, 6, 4000, "Black"));
        phones.add(new MobilePhone(200, 25000, 0.2, 15, "Iphone 12", "Apple", 64, 6.1, 6, 4000, "Mavi"));
    }

    public static boolean isMenu() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println();
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
                    System.out.println("Ana menüye dönüş işlemi gerçekleştiriliyor.");
                    return false;
                default:
                    System.out.println("Geçersiz seçenek girdiniz.");
                    break;
            }
        }
        return true;
    }

    public static void showPhones() {
        System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Pil", "Renk", "Stok", "İndirim");

        for (MobilePhone phone : phones) {
            System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    phone.getId(), phone.getProductName(), phone.getPrice(), phone.getBrand(), phone.getMemorySize(),
                    phone.getScreenSize(), phone.getRam(), phone.getBatteryPower(), phone.getColor(),
                    phone.getStock(), phone.getDiscountRate());
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
                    newPhoneBrand, newPhoneStorage, newPhoneScreenSize, newPhoneRam, newPhoneBatterySize, newPhoneColor));

            System.out.println("Yeni telefon eklendi.");
            System.out.println("----------------------");
            showPhones();
        } else {
            System.out.println("Bu ürün daha önce eklenmiş. Lütfen tekrar deneyin");
        }
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

}

