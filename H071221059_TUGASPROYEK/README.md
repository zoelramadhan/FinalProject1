## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

Workspace ini memiliki dua folder default:

- `src`: folder untuk menyimpan file-source kode
- `lib`: folder untuk menyimpan dependensi

Sementara itu, file output yang telah dikompilasi akan dihasilkan dalam folder bin secara default.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


# App.java
Di dalam file App.java, terdapat objek showMenu. Tujuannya adalah untuk menampilkan menu yang memungkinkan Anda melakukan operasi Read, Insert, Edit, Delete, dan Exit.

# com 
Ada beberapa paket di sini:

- config
- controllers
- layout
- models

## 1. config
MyConfig : berfungsi untuk menghubungkan kode dengan localhost yang sesuai

## 2. Controllers
DbController : berfungsi sebagai pengontrol akses ke database

## 3.layout
delete: untuk menampilkan menu penghapusan data produk.

Edit: untuk menampilkan menu edit pada data produk.
Insert: untuk menampilkan menu insert atau penambahan sebuah produk ke database.
Menu: untuk memilih menu dari delete, edit, insert, dan read.
Read: untuk menampilkan semua data yang sudah ada di database.

## 4. Models
produk : class untuk merepresentasikan data produk.


