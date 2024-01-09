package Menus;

import Products.Notebook;

import java.util.ArrayList;
import java.util.Scanner;

public class NotebookMenu extends Menu {
    static Scanner scanner = new Scanner(System.in);

    public NotebookMenu() {
        super("Notebook Menüsü");
    }

    @Override
    public boolean onMenu() {

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Notebook Menüsü");
            System.out.println("1- Notebook Listele");
            System.out.println("2- Notebook Ekle");
            System.out.println("3- Notebook Sil");
            System.out.println("0- Ana Menü");

            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    showNotebooks();
                    break;
                case 2:
                    addNotebook(notebooks);
                    break;
                case 3:
                    deleteNotebook(notebooks);
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

    static ArrayList<Notebook> notebooks = new ArrayList<>();

    static {
        notebooks.add(new Notebook(201, 5000, 0.20, 100, "M1", "Apple", 500, 13.0, 8));
        notebooks.add(new Notebook(202, 6000, 0.10, 50, "M2", "Apple", 1024, 15.6, 16));

    }

    private static void showNotebooks() {
        System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Pil", "Renk", "Stok", "İndirim");

        for (Notebook notebook : notebooks) {
            System.out.printf("%-8s %-25s %-12s %-16s %-10s %-6s %-6s %-6s %-6s%n",
                    notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand(), notebook.getStorage(),
                    notebook.getScreenSize(), notebook.getRam(), notebook.getStockNum(), notebook.getDiscountRate());
        }
    }

    public void deleteNotebook(ArrayList<Notebook> notebook) {
        showNotebooks();
        System.out.println("Lütfen silmek istediğiniz ürünün ID'sini giriniz");
        int deletionSelection = scanner.nextInt();


        int indexToRemove = -1;
        for (int i = 0; i < notebook.size(); i++) {
            if (notebook.get(i).getId() == deletionSelection) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            notebook.remove(indexToRemove);
            System.out.println("Ürün silindi.");
            showNotebooks();
        } else {
            System.out.println("ID bulunamadı.");
        }
    }

    public static void addNotebook(ArrayList<Notebook> notebooks) {
        ArrayList<Integer> notebookIDList = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            notebookIDList.add(notebook.getId());
        }
        System.out.println("Lütfen yeni bir ID giriniz: ");
        int newNotebookID = scanner.nextInt();
        scanner.nextLine();
        if (!notebookIDList.contains(newNotebookID)) {

            System.out.println("Lütfen fiyatını giriniz: ");
            int newNotebookPrice = scanner.nextInt();

            System.out.println("Lütfen indirim oranını giriniz: ");
            Double newNotebookDiscount = scanner.nextDouble();

            System.out.println("Lütfen stok bilgisi giriniz: ");
            int newNotebookStockNum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Lütfen ismini giriniz: ");
            String newNotebookName = scanner.next();
            scanner.nextLine();

            System.out.println("Lütfen markasını giriniz: ");
            String newNotebookBrand = scanner.next();

            System.out.println("Lütfen hafızasını giriniz: ");
            int newNotebookStorage = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Lütfen ekran boyutunu giriniz: ");
            Double newNotebookScreenSize = scanner.nextDouble();

            System.out.println("Lütfen RAM giriniz(GB ile): ");
            int newNotebookRam = scanner.nextInt();

            notebooks.add(new Notebook(newNotebookID, newNotebookPrice, newNotebookDiscount, newNotebookStockNum, newNotebookName,
                    newNotebookBrand, newNotebookStorage, newNotebookScreenSize, newNotebookRam));

            System.out.println("Yeni notebook eklendi.");
            System.out.println("----------------------");
            showNotebooks();
        } else {
            System.out.println("ID hali hazırda var. Lütfen tekrar deneyiniz.");
        }
    }
}