package com.controllers;

import java.sql.SQLException;

import com.config.MyConfig;
import com.models.Produk;

public class DbController extends MyConfig {

    public static void getDatabase() {
        connection();
        try {
            // query = "SELECT NAMA, HARGA, stok FROM tb_produk ORDER BY ID DESC";
            query = "SELECT NAMA, HARGA, JUMLAH FROM tb_produk";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println(
                    String.format("%s - Rp.%d - Stok %d", resultSet.getString("NAMA"), resultSet.getInt("HARGA"), resultSet.getInt("JUMLAH"))
                );
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Produk getProdukByNAMA(String NAMA) {
        Produk produk = null;
        connection();
        query = "SELECT * FROM tb_produk WHERE NAMA=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, NAMA);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produk = new Produk(resultSet.getInt("id"), resultSet.getString("NAMA"), resultSet.getLong("HARGA"), resultSet.getInt("JUMLAH"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produk;
    }

    public static boolean insertData(String NAMA, long HARGA, int JUMLAH) {
        connection();
        query = "INSERT INTO tb_produk (NAMA, HARGA, JUMLAH) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, NAMA);
            preparedStatement.setLong(2, HARGA);
            preparedStatement.setInt(3, JUMLAH);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateNAMA(int id, String NAMA) {
        connection();
        query = "UPDATE tb_produk SET NAMA=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, NAMA);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHARGA(int id, long HARGA) {
        connection();
        query = "UPDATE tb_produk SET HARGA=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, HARGA);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateJUMLAH(int id, int JUMLAH) {
        connection();
        query = "UPDATE tb_produk SET JUMLAH=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, JUMLAH);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteData(String NAMA) {
        connection();
        query = "DELETE FROM tb_produk WHERE NAMA=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, NAMA);
            int affectedRowDelete = preparedStatement.executeUpdate();
            if (affectedRowDelete > 0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
