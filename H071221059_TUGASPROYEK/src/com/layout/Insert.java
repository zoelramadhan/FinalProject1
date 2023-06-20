package com.layout;

import java.util.Scanner;

import com.controllers.DbController;

public class Insert {
    public static void showInsertData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Silahkan Input Data Produk");
        System.out.println("================================");

        System.out.print("Nama Produk : ");
        String NAMA = sc.nextLine();
        System.out.print("HARGA : ");
        long HARGA = sc.nextLong();
        System.out.print("Jumlah : ");
        int JUMLAH = sc.nextInt();
        System.out.println("================================");

        if (DbController.insertData(NAMA, HARGA, JUMLAH)) {
            System.out.println("Berhasil Insert Data");
        } else {
            System.out.println("Gagal Insert Data");
        }

        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }
}

