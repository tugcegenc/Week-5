import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Sofie'nin Dünyası", 550, "Jostein Gaarder", "1991");
        Book book2 = new Book("Küçük Prens", 150, "Antoine de Saint-Exupéry", "1943");
        Book book3 = new Book("Simyacı", 180, "Paulo Coelho", "1988");
        Book book4 = new Book("Uçurtma Avcısı", 375, "Khaled Hosseini", "2003");
        Book book5 = new Book("Bülbülü Öldürmek", 350, "Harper Lee", "1960");

        // Kitapları isme göre sıralayan Set
        Set<Book> ismeGoreSiralama = new TreeSet<>();
        ismeGoreSiralama.add(book1);
        ismeGoreSiralama.add(book2);
        ismeGoreSiralama.add(book3);
        ismeGoreSiralama.add(book4);
        ismeGoreSiralama.add(book5);

        System.out.println("**KİTAP İSMİNE GÖRE SIRALAMA**");
        for (Book book : ismeGoreSiralama) {
            System.out.println(book);
        }

        // Kitapları sayfa sayısına göre sıralayan Comparator
        Comparator<Book> sayfaSiralama = Comparator.comparingInt(Book::getPageCount);

        // Kitapları sayfa sayısına göre sıralayan Set
        Set<Book> sayfaSayisinaGoreSiralama = new TreeSet<>(sayfaSiralama);
        sayfaSayisinaGoreSiralama.addAll(ismeGoreSiralama);

        System.out.println("\n**SAYFA SAYISINA GÖRE SIRALAMA**");
        for (Book book : sayfaSayisinaGoreSiralama) {
            System.out.println(book);
        }
    }
}

