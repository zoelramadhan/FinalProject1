package com.layout;

import java.util.Scanner;

import com.controllers.DbController;
import com.models.Produk;

public class Edit {
    public static void showEditData(String NAMA) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Silahkan Pilih Data yang Ingin Diedit");
        System.out.println("================================");
        DbController.getDatabase();
        System.out.println("================================");
        System.out.println("**Note: Input NAMA produk dengan benar!!!");
        System.out.print("Pilih NAMA Produk: ");
        NAMA = sc.nextLine();

        System.out.println("================================");
        System.out.println("Silahkan Pilih Menu Update Data");
        System.out.println("================================");
        System.out.println("1. Update NAMA");
        System.out.println("2. Update HARGA");
        System.out.println("3. Update Jumlah");
        System.out.println("4. Back to Menu");

        System.out.println("================================");
        System.out.print("Pilihan: ");
        try {
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                    showEditNAMA(NAMA);
                    break;
                case 2:
                    showEditHARGA(NAMA);
                    break;
                case 3:
                    showEditJumlah(NAMA);
                    break;
                case 4:
                    Menu.showMenu();
                    break;
                default:
                    System.out.println("================================");
                    System.out.println("Maaf NAMA Produk atau Menu yang Dipilih Tidak Ada");
                    System.out.println("--------------------------------");
                    Menu.showMenu();
            }
        } catch (Exception e) {
            System.out.println("================================");
            System.out.println("Maaf NAMA Produk atau Menu yang Dipilih Tidak Ada");
            System.out.println("--------------------------------");
            Menu.showMenu();
        }
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditNAMA(String NAMA) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNAMA(NAMA);

        System.out.println("================================");
        System.out.println("Edit NAMA");
        System.out.println("================================");
        System.out.println("NAMA Awal: " + produk.getNama());
        System.out.println("--------------------------------");
        System.out.print("NAMA Baru: ");
        String NAMABaru = sc.nextLine();
        DbController.updateNAMA(produk.getId(), NAMABaru);

        System.out.println("================================");
        System.out.println("Berhasil Update Data NAMA");
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditHARGA(String NAMA) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNAMA(NAMA);

        System.out.println("================================");
        System.out.println("Edit NAMA");
        System.out.println("================================");
        System.out.println("HARGA Awal: " + produk.getHarga());
        System.out.println("--------------------------------");
        System.out.print("HARGA Baru: ");
        long HARGABaru = sc.nextLong();
        DbController.updateHARGA(produk.getId(), HARGABaru);

        System.out.println("================================");
        System.out.println("Berhasil Update Data HARGA");
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditJumlah(String NAMA) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNAMA(NAMA);

        System.out.println("================================");
        System.out.println("Edit NAMA");
        System.out.println("================================");
        System.out.println("Jumlah Awal: " + produk.getjumlah());
        System.out.println("--------------------------------");
        System.out.print("Jumlah Baru: ");
        int jumlahBaru = sc.nextInt();
        DbController.updateJUMLAH(produk.getId(), jumlahBaru);

        System.out.println("================================");
        System.out.println("Berhasil Update Data Stok");
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }
}

