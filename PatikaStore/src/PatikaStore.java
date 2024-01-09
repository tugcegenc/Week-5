import Products.Brand;
import Products.MobilePhone;
import Products.Notebook;

import java.util.*;

public class PatikaStore {
    private boolean isMenu = true;

    Scanner scan = new Scanner(System.in);

    public void showMenu() {
        MobilePhone.initializePhones();
        //Notebook.showNotebooks();
        while (isMenu) {
            System.out.println();
            System.out.println("--PatikaStore Ürün Yönetim Paneli--");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            int select = scan.nextInt();

            switch (select) {
                case 0:
                    isMenu = false;
                    break;
                case 1:
                    Notebook notebook=new Notebook();
                    notebook.isMenu();
                    break;
                case 2:
                    MobilePhone phone = new MobilePhone();
                    phone.isMenu();
                    break;
                case 3:
                    Brand brand = new Brand();
                    brand.listBrands();
                    break;
                default:
                    System.out.println("Geçersiz seçenek girdiniz, lütfen tekrar deneyin.");
            }
        }
    }

}
