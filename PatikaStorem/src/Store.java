import java.util.*;

import Menus.BrandMenu;
import Menus.Menu;
import Menus.NotebookMenu;
import Menus.PhoneMenu;

public class Store {

    Scanner scanner = new Scanner(System.in);

    private boolean isMenu = false;
    private int select;

    public void showMenu() {
        Menu menu = null;

        while (!isMenu) {
            System.out.println();
            System.out.println("***Patika Yönetim Paneli***");
            System.out.println();
            System.out.println("1- Notebook İşlemleri");
            System.out.println("2- Cep Telefonu İşlemleri");
            System.out.println("3- Marka Listele");
            System.out.println("0- Çıkış Yap");
            select = scanner.nextInt();
            System.out.println("Tercihiniz: " + select);
            switch (select) {
                case 1:
                    System.out.println();
                    menu = new NotebookMenu();
                    break;
                case 2:
                    System.out.println();
                    menu = new PhoneMenu();
                    break;
                case 3:
                    System.out.println();
                    menu = new BrandMenu();
                    break;
                case 0:
                    menu = null;
                    System.out.println("Bizi tercih ettiğiniz için teşekkürler");
                    isMenu = false;
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız");
                    isMenu = true;
                    break;
            }
            try {
                if (!menu.onMenu()) {
                }
            } catch (NullPointerException e) {
                System.out.println("İyi günler dileriz.");
                break;
            }

        }

    }

}