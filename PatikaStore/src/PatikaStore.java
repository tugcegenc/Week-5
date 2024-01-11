import java.util.*;

public class PatikaStore {
    private boolean isMenu = true;

    Scanner scan = new Scanner(System.in);

    public void showMenu() {
        while (isMenu) {
            System.out.println();
            System.out.println("--PatikaStore Ürün Yönetim Paneli--");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Markaları Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.println();
            System.out.print("Tercihiniz: ");
            System.out.println();

            int select = scan.nextInt();


            switch (select) {
                case 0:
                    isMenu = false;
                    break;
                case 1:
                    Notebook notebook=new Notebook();
                    notebook.runMenu();
                    break;
                case 2:
                    MobilePhone phone = new MobilePhone();
                    phone.runMenu();

                    break;
                case 3:
                    Brand brand = new Brand();
                    brand.printBrand();
                    break;
                default:
                    System.out.println("Geçersiz seçenek girdiniz, lütfen tekrar deneyin.");
            }
        }
    }
}
