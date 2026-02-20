import java.util.Scanner;

public class RestaurantMain{
    public static void main (String[] args){
        Restaurant menu = new Restaurant();
        Scanner input= new Scanner(System.in);
        int ID_makanan = 0,Jumlah_pesanan;

        menu.tambahMenuMakanan("Pizza",250000,20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);
        menu.tampilMenuMakanan();

        for (;;){
            System.out.println("Silahkan pilih makanan yang ingin anda pesan(ketik angka -1 untuk keluar): ");
            ID_makanan=input.nextInt();
             if (ID_makanan == -1) {
                System.out.println("Terima kasih telah berbelanja");
                input.close();
                break;
            }
            System.out.println("Masukan jumlah yang ingin dipesan: ");
            Jumlah_pesanan=input.nextInt();
            menu.pesanMakanan(ID_makanan - 1, Jumlah_pesanan);
            System.out.println("\n");
            menu.tampilMenuMakanan();
        }
    }
}