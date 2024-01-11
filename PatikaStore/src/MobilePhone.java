import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone extends Product implements Operation {
    private int batteryPower;
    private String color;
    private static Scanner scanner = new Scanner(System.in);
    static ArrayList<MobilePhone> phones = new ArrayList<>();

    public MobilePhone(int id, int price, double discountRate, int stock, String productName, String brand,
                       int memorySize, double screenSize, int ram, int batteryPower, String color) {
        super(id, price, discountRate, stock, productName, brand, memorySize, screenSize, ram);
        this.batteryPower = batteryPower;
        this.color = color;
    }
    public MobilePhone(){

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

    static {
        phones.add(new MobilePhone(100, 30000, 0.1, 10, "Galaxy S23", "Samsung", 128, 6.1, 6, 4000, "Black"));
        phones.add(new MobilePhone(200, 25000, 0.2, 15, "Iphone 12", "Apple", 64, 6.1, 6, 4000, "Mavi"));
    }

    @Override
    public void showProductList() {
        System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Pil", "Renk", "Stok", "İndirim");

        for (MobilePhone phone : phones) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    phone.getId(), phone.getProductName(), phone.getPrice(), phone.getBrand(), phone.getMemorySize(),
                    phone.getScreenSize(), phone.getRam(), phone.getBatteryPower(), phone.getColor(),
                    phone.getStock(), phone.getDiscountRate());
        }
    }

    @Override
    public void runMenu() {
        MobilePhone mobilePhoneManager = new MobilePhone();

        while (true) {
            System.out.println("\nTelefon Yönetim Paneli");
            System.out.println("1- Telefon Listele");
            System.out.println("2- Telefon Ekle");
            System.out.println("3- Telefon Sil");
            System.out.println("4- İD'ye Göre Filtrele");
            System.out.println("5- Markaya Göre Filtrele");
            System.out.println("0- Ana Menü");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    mobilePhoneManager.showProductList();
                    break;
                case 2:
                    mobilePhoneManager.addProduct();
                    break;
                case 3:
                    mobilePhoneManager.deleteProduct();
                    break;
                case 4:
                    mobilePhoneManager.filterByProductID();
                    break;
                case 5:
                    mobilePhoneManager.filterByProductBrand();
                    break;
                case 0:
                    System.out.println("Ana menüye dönülüyor.");
                    return;
                default:
                    System.out.println("Geçersiz seçenek girdiniz.");
            }
        }
    }

    @Override
    public void filterByProductBrand() {
        System.out.println("Filtrelemek istediğiniz markayı giriniz:");
        String filterBrand = scanner.next();

        System.out.println("Filtre sonuçları:");
        for (MobilePhone phone : phones) {
            if (phone.getBrand().equalsIgnoreCase(filterBrand)) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                        phone.getId(), phone.getProductName(), phone.getPrice(), phone.getBrand(),
                        phone.getMemorySize(), phone.getScreenSize(), phone.getRam(), phone.getBatteryPower(),
                        phone.getColor(), phone.getStock(), phone.getDiscountRate());
            }
        }
    }


    @Override
    public void addProduct() {
        System.out.println("Lütfen yeni bir ID giriniz:");
        int newPhoneID = scanner.nextInt();
        scanner.nextLine();

        if (findPhoneById(newPhoneID) == null) {
            System.out.println("Lütfen ismini giriniz:");
            String newPhoneName = scanner.nextLine();

            System.out.println("Lütfen markasını giriniz:");
            String newPhoneBrand = scanner.nextLine();

            System.out.println("Lütfen fiyatını giriniz:");
            int newPhonePrice = scanner.nextInt();

            System.out.println("Lütfen indirim oranını giriniz:");
            double newPhoneDiscount = scanner.nextDouble();

            System.out.println("Lütfen stok bilgisi giriniz:");
            int newPhoneStock = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Lütfen hafızasını giriniz:");
            int newPhoneStorage = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Lütfen ekran boyutunu giriniz:");
            double newPhoneScreenSize = scanner.nextDouble();

            System.out.println("Lütfen RAM giriniz(GB ile):");
            int newPhoneRam = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Lütfen renk giriniz:");
            String newPhoneColor = scanner.nextLine();

            System.out.println("Lütfen pil gücü giriniz:");
            int newPhoneBatterySize = scanner.nextInt();

            phones.add(new MobilePhone(newPhoneID, newPhonePrice, newPhoneDiscount, newPhoneStock, newPhoneName,
                    newPhoneBrand, newPhoneStorage, newPhoneScreenSize, newPhoneRam, newPhoneBatterySize, newPhoneColor));

            System.out.println("Yeni telefon eklendi.");
            System.out.println("----------------------");

        } else {
            System.out.println("Bu ürün daha önce eklenmiş. Lütfen tekrar deneyin");
        }
    }

    @Override
    public void deleteProduct() {
        System.out.println("Silmek istediğiniz ürünün ID'sini giriniz:");
        int deleteSelection = scanner.nextInt();

        MobilePhone phoneToDelete = findPhoneById(deleteSelection);

        if (phoneToDelete != null) {
            phones.remove(phoneToDelete);
            System.out.println("Ürün silindi.");

        } else {
            System.out.println("ID bulunamadı.");
        }
    }

    @Override
    public void filterByProductID() {
        System.out.println("Filtrelemek istediğiniz ID'yi giriniz:");
        int filterID = scanner.nextInt();

        MobilePhone filteredPhone = findPhoneById(filterID);

        if (filteredPhone != null) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s%n",
                    "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Pil", "Renk", "Stok", "İndirim");

            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    filteredPhone.getId(), filteredPhone.getProductName(), filteredPhone.getPrice(),
                    filteredPhone.getBrand(), filteredPhone.getMemorySize(), filteredPhone.getScreenSize(),
                    filteredPhone.getRam(), filteredPhone.getBatteryPower(), filteredPhone.getColor(),
                    filteredPhone.getStock(), filteredPhone.getDiscountRate());
        } else {
            System.out.println("ID'ye göre ürün bulunamadı.");
        }
    }

    private MobilePhone findPhoneById(int id) {
        for (MobilePhone phone : phones) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }
}
