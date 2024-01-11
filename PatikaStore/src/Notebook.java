import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product implements Operation {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Notebook> notebooks = new ArrayList<>();

    public Notebook(int id, int price, double discountRate, int stock, String productName, String brand,
                    int memorySize, double screenSize, int ram) {
        super(id, price, discountRate, stock, productName, brand, memorySize, screenSize, ram);
    }

    public Notebook() {
        super();
    }

    static {
        notebooks.add(new Notebook(1, 25000, 0.25, 50, "M1", "Apple", 512, 13, 8));
        notebooks.add(new Notebook(2, 20000, 0.10, 75, "MateBook", "Huawei", 512, 14, 8));
        notebooks.add(new Notebook(3, 20000, 0.10, 25, "Nirvana", "Casper", 512, 14, 8));
    }

    @Override
    public void showProductList() {
        System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s  %-6s%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Stok", "İndirim");

        for (Notebook notebook : notebooks) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s  %-6s%n",
                    notebook.getId(), notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                    notebook.getMemorySize(), notebook.getScreenSize(), notebook.getRam(), notebook.getStock(),
                    notebook.getDiscountRate());
        }
    }

    @Override
    public void runMenu() {
        Notebook notebookManager = new Notebook();

        while (true) {
            System.out.println("\nNotebook Yönetim Paneli");
            System.out.println("1- Notebook Listele");
            System.out.println("2- Notebook Ekle");
            System.out.println("3- Notebook Sil");
            System.out.println("4- İD'ye Göre Filtrele");
            System.out.println("5- Markaya Göre Filtrele");
            System.out.println("0- Ana Menü");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    notebookManager.showProductList();
                    break;
                case 2:
                    notebookManager.addProduct();
                    break;
                case 3:
                    notebookManager.deleteProduct();
                    break;
                case 4:
                    notebookManager.filterByProductID();
                    break;
                case 5:
                    notebookManager.filterByProductBrand();
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

        System.out.println("Filtre sonuçları");
        for (Notebook notebook : notebooks) {
            if (notebook.getBrand().equalsIgnoreCase(filterBrand)) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s%n",
                        notebook.getId(), notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                        notebook.getMemorySize(), notebook.getScreenSize(), notebook.getRam());
            }
        }
    }

    @Override
    public void filterByProductID() {
        System.out.println("Filtrelemek istediğiniz ID'yi giriniz:");
        int filterID = scanner.nextInt();

        System.out.println("Filtre sonuçları");
        for (Notebook notebook : notebooks) {
            if (notebook.getId() == filterID) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s%n",
                        notebook.getId(), notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                        notebook.getMemorySize(), notebook.getScreenSize(), notebook.getRam());
            }
        }
    }

    @Override
    public void addProduct() {
        System.out.println("Lütfen yeni bir ID giriniz:");
        int newNotebookID = scanner.nextInt();
        scanner.nextLine();

        if (findNotebookById(newNotebookID) == null) {
            System.out.println("Lütfen ismini giriniz:");
            String newNotebookName = scanner.nextLine();

            System.out.println("Lütfen markasını giriniz:");
            String newNotebookBrand = scanner.nextLine();

            System.out.println("Lütfen fiyatını giriniz:");
            int newNotebookPrice = scanner.nextInt();

            System.out.println("Lütfen indirim oranını giriniz:");
            double newNotebookDiscount = scanner.nextDouble();

            System.out.println("Lütfen stok bilgisi giriniz:");
            int newNotebookStock = scanner.nextInt();

            System.out.println("Lütfen hafızasını giriniz:");
            int newNotebookMemorySize = scanner.nextInt();

            System.out.println("Lütfen ekran boyutunu giriniz:");
            double newNotebookScreenSize = scanner.nextDouble();

            System.out.println("Lütfen RAM giriniz(GB ile):");
            int newNotebookRam = scanner.nextInt();

            notebooks.add(new Notebook(newNotebookID, newNotebookPrice, newNotebookDiscount, newNotebookStock,
                    newNotebookName, newNotebookBrand, newNotebookMemorySize, newNotebookScreenSize, newNotebookRam));

            System.out.println("Yeni notebook eklendi.");
            System.out.println("----------------------");

        } else {
            System.out.println("Bu ürün daha önce eklenmiş. Lütfen tekrar deneyin");
        }
    }

    @Override
    public void deleteProduct() {
        System.out.println("Silmek istediğiniz ürünün ID'sini giriniz:");
        int deleteSelection = scanner.nextInt();

        Notebook notebookToDelete = findNotebookById(deleteSelection);

        if (notebookToDelete != null) {
            notebooks.remove(notebookToDelete);
            System.out.println("Ürün silindi.");
        } else {
            System.out.println("ID bulunamadı.");
        }
    }

    private Notebook findNotebookById(int id) {
        for (Notebook notebook : notebooks) {
            if (notebook.getId() == id) {
                return notebook;
            }
        }
        return null;
    }
}
