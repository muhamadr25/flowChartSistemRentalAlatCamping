package uasAlgoritma.uas2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class modulAlat {
    static String[][] alat = {
        {"ALAT TIDUR", "Matras spons", "5", "10"},
        {"ALAT TIDUR", "Sleeping bag polar", "10", "5"},
        {"TENDA", "Tenda kap 2 DB", "25", "3"},
        {"TENDA", "Tenda kap 3-4 DB", "30", "2"},
        {"LENSA SMARTPHONE", "Lensa apexel 18x25", "7", "7"},
        {"LENSA SMARTPHONE", "Lensa apexel 28x25", "10", "5"},
        {"CARRIER", "Carrier 45L", "20", "4"},
        {"CARRIER", "Carrier 70L", "30", "3"},
        {"CARRIER", "Hydropack", "15", "6"},
        {"PENERANGAN", "Senter mini LED cas", "5", "10"},
        {"PENERANGAN", "Headlamp cas", "7", "8"},
        {"PENERANGAN", "Lampu cas", "7", "7"},
        {"PENERANGAN", "Lampu bakpao", "5", "6"},
        {"ALAT MASAK & MAKAN", "Cooking set", "7", "5"},
        {"ALAT MASAK & MAKAN", "Kompor kotak", "10", "4"},
        {"ALAT MASAK & MAKAN", "Kompor Mawar", "12", "3"},
        {"ALAT MASAK & MAKAN", "Kompor Koper", "15", "2"},
        {"ALAT MASAK & MAKAN", "Gas refill", "7", "10"},
        {"ALAT MASAK & MAKAN", "Gas baru", "15", "5"},
        {"ALAT LAIN", "Kursi lipat", "10", "8"},
        {"ALAT LAIN", "Kursi lipat portable", "15", "6"},
        {"ALAT LAIN", "Meja besi", "15", "4"},
        {"ALAT LAIN", "Sepatu hiking", "15", "3"},
        {"ALAT LAIN", "Tracking pool", "10", "5"},
        {"ALAT LAIN", "Tripod remote", "10", "7"},
        {"ALAT LAIN", "Hammock", "5", "10"}
    };
    static void tampilkanAlat() {
        System.out.println("\nDaftar Alat Camping:");
        String kategoriTerakhir = "";
        for (String[] item : alat) {
            if (!item[0].equals(kategoriTerakhir)) {
                System.out.println("\n" + item[0] + ":");
                kategoriTerakhir = item[0];
            }
            String status = Integer.parseInt(item[3]) > 0 ? "Tersedia" : "Habis";
            System.out.println("- " + item[1] + " - " + item[2] + "k - Stok: " + item[3] + " - " + status);
        }
    }

    static void sewaAlat() {
        Scanner scanner = new Scanner(System.in);
        int totalHarga = 0;
        StringBuilder daftarSewa = new StringBuilder("\nBarang yang Anda sewa:\n");

        while (true) {
            System.out.print("\nMasukkan nama alat yang ingin disewa (atau ketik 'selesai' untuk selesai): ");
            String nama = scanner.nextLine();
            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }

            boolean ditemukan = false;
            for (String[] item : alat) {
                if (item[1].toLowerCase().contains(nama.toLowerCase())) {
                    if (Integer.parseInt(item[3]) > 0) {
                        System.out.print("Masukkan jumlah yang ingin disewa: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine(); // Membuang newline setelah input angka

                        if (jumlah <= Integer.parseInt(item[3])) {
                            int hargaItem = jumlah * Integer.parseInt(item[2]);
                            item[3] = String.valueOf(Integer.parseInt(item[3]) - jumlah);
                            totalHarga += hargaItem;
                            daftarSewa.append("- ").append(jumlah).append(" ").append(item[1]).append(" - Total: ").append(hargaItem).append("k\n");
                        } else {
                            System.out.println("Maaf, stok tidak mencukupi.");
                        }
                    } else {
                        System.out.println("Maaf, " + item[1] + " sedang habis.");
                    }
                    ditemukan = true;
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Alat tidak ditemukan.");
            }
        }

        if (totalHarga > 0) {
            double diskon = 0;
            if (totalHarga >= 100) {
                diskon = 0.10 * totalHarga;
            } else if (totalHarga >= 50) {
                diskon = 0.05 * totalHarga;
            }

            double totalAkhir = totalHarga - diskon;
            System.out.println(daftarSewa);
            System.out.println("Total harga sebelum diskon: " + totalHarga + "k");
            System.out.println("Diskon: " + (double) diskon + "k");
            System.out.println("Total yang harus dibayar: " + (double) totalAkhir + "k");

            System.out.print("Masukkan jumlah uang pembayaran: ");
            int bayar = scanner.nextInt();
            scanner.nextLine();

            if (bayar >= totalAkhir) {
                System.out.println("Pembayaran berhasil! Kembalian Anda: " + (bayar - (int) totalAkhir) + "k");
            } else {
                System.out.println("Maaf, saldo Anda kurang.");
            }
        } else {
            System.out.println("Anda tidak menyewa barang apa pun.");
        }
    }

        // if (totalHarga > 0) {
        //     System.out.println(daftarSewa);
        //     System.out.println("Total biaya yang harus dibayar: " + totalHarga + "k");
        //     System.out.print("Masukkan jumlah uang pembayaran: ");
        //     int bayar = scanner.nextInt();
        //     scanner.nextLine();

        //     if (bayar >= totalHarga) {
        //         System.out.println("Pembayaran berhasil! Kembalian Anda: " + (bayar - totalHarga) + "k");
        //     } else {
        //         System.out.println("Maaf, saldo Anda kurang.");
        //     }
        // } else {
        //     System.out.println("Anda tidak menyewa barang apa pun.");
        // }


    static void cariAlat(String keyword) {
        boolean ditemukan = false;
        System.out.println("\nHasil Pencarian:");
        for (String[] item : alat) {
            if (item[1].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("- " + item[1] + " - " + item[2] + "k - Stok: " + item[3]);
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Alat tidak ditemukan.");
    }

    static void urutkanAlat() {
        Arrays.sort(alat, Comparator.comparingInt(a -> Integer.parseInt(a[2])));
        System.out.println("\nDaftar Alat Setelah Diurutkan (Termurah - Termahal):");
        tampilkanAlat();
    }
}