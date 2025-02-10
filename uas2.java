package uasAlgoritma.uas2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class uas2 {
    

    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== RENTAL ALAT CAMPING =====");
            System.out.println("1. Tampilkan daftar alat");
            System.out.println("2. Sewa alat");
            System.out.println("3. Cari alat");
            System.out.println("4. Urutkan alat dari termurah ke termahal");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    modulAlat.tampilkanAlat();
                    break;
                case 2:
                    modulAlat.sewaAlat();
                    break;
                case 3:
                    System.out.print("Masukkan kata kunci alat yang dicari: ");
                    String keyword = scanner.nextLine();
                    modulAlat.cariAlat(keyword);
                    break;
                case 4:
                    modulAlat.urutkanAlat();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan rental kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}