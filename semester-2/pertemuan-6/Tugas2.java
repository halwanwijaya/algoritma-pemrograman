import java.util.ArrayList;
import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList barang = new ArrayList();
        // Menentukan di awal kalau barang yang dimasukan dalam gudang
        // akan selalu bertipe data ArrayList
        ArrayList<ArrayList> gudang = new ArrayList();

        // id_barang digunakan untuk memberikan ID unik untuk setiap barang yang masuk
        // dan akan selalu bertambah 1 jika hanya ada barang telah masuk gudang
        int id_barang = 1;
        while (true) {  // Hanya akan berhenti jika menu yang dipilih adalah 0
            System.out.println("=======================================================");
            System.out.println("       SISTEM PENGELOLAAN DATA BARANG DI GUDANG        ");
            System.out.println("=======================================================");
            System.out.println("\nMenu :");
            System.out.println("1. Input barang masuk");
            System.out.println("2. Input barang keluar");
            System.out.println("3. Tampilkan daftar barang di gudang");
            System.out.println("4. Tampilkan daftar barang yang sudah keluar gudang");
            System.out.println("5. Cari barang");
            System.out.println("0. Keluar Program");

            System.out.print("\nMasukan nomer Menu pilihan : ");
            int menu = input.nextInt();
            input.nextLine(); // untuk menangkap \n setelah enter pada nextInt,
                              // ini akan selalu ada setelah nextInt nantinya

            if (menu == 1) {
                System.out.print("\n");
                System.out.println("-------------------------------------------------------");

                while (true) { // Hanya berhenti jika memilih 0. keluar menu
                    System.out.println("Menu 1 (Input Barang Masuk)\n");
                    System.out.print("Input Kategori Barang           :  ");
                    String kategori_barang = input.nextLine().toLowerCase(); // merubah inputan jadi huruf kecil semua
                    System.out.print("Input Nama Barang               :  ");
                    String nama_barang = input.nextLine();
                    System.out.print("Input Tanggal Masuk [dd/mm/yy]  :  ");
                    String tanggal_masuk = input.nextLine();
                    System.out.print("Nama Petugas penerimaan barang  :  ");
                    String petugas_penerima = input.nextLine();

                    // Nilai default saat barang mau masuk gudang
                    String tanggal_keluar = "-";
                    String status = "IN";
                    String petugas_pengeluar = "-";

                    barang.add(id_barang);          // --> Index 0
                    barang.add(kategori_barang);    // --> Index 1
                    barang.add(nama_barang);        // --> Index 2
                    barang.add(status);             // --> Index 3
                    barang.add(tanggal_masuk);      // --> Index 4
                    barang.add(tanggal_keluar);     // --> Index 5
                    barang.add(petugas_penerima);   // --> Index 6
                    barang.add(petugas_pengeluar);  // --> Index 7

                    // Memasukan barang ke gudang, menggunakan new supaya membuat ArrayList baru
                    // dan nilainya tidak linked ke barang, sehingga saat barang di clear
                    // di gudangnya tidak ikut terhapus
                    gudang.add(new ArrayList(barang));
                    barang.clear();

                    System.out.println("\nBarang dengan ID " + id_barang + " Telah masuk Gudang.\n");
                    id_barang++; // Menambahkan id_barang supaya barang berikutnya yang masuk id nya tidak sama

                    System.out.println("1. Input barang lagi.");
                    System.out.println("0. Keluar Menu. ");
                    
                    // Ini upaya saya untuk membuat pilihanya hanya bisa 0 atau 1 selain itu
                    // akan diminta memasukan pilihan lagi hingga pilihanya 0 atau 1 baru keluar
                    // dan baru Akan keluar menu setelah pilihanya 0, karena exit nya jadi true
                    // kalo pilihanya 1 perulangan menu nya masih tetap dilakukan, dan hanya keluar
                    // dari perulangan pertanyaan pilihan saja.
                    // Ini akan dipakai lagi di Menu 2 dan tidak dijelaskan lagi disana
                    Boolean exit = false;
                    while (true) { 
                        System.out.print("\nMasukan pilihan : ");
                        int pilihan = input.nextInt();
                        input.nextLine();
                        if (pilihan == 0) {
                            exit = true;
                            break;
                        }
                        else if (pilihan == 1) {
                            System.out.print("\n\n");
                            break;
                        }
                    }
                    if (exit) {
                        break;
                    }
                }

                System.out.println("-------------------------------------------------------");
                System.out.print("\n");
            } 
            
            else if (menu == 2) {
                System.out.print("\n");
                System.out.println("-------------------------------------------------------");

                while (true) { // Hanya berhenti jika memilih 0. Keluar menu
                    System.out.println("Menu 2 (Input Barang Keluar)\n");

                    // membuat ArrayList baru yang isinya akan berisi
                    // ID barang dalam gudang hanya yang status nya IN saja
                    // yang artinya barang tersebut masih berada dalam gudang
                    ArrayList id_barang_dalam_gudang = new ArrayList();
                    for (ArrayList baris : gudang) {
                        if (baris.get(3).equals("IN")) {
                            id_barang_dalam_gudang.add(baris.get(0));
                        }
                    }

                    // Jika ada barang yang berada dalam gudang (belum keluar gudang/OUT),
                    if (id_barang_dalam_gudang.size() > 0) {
                        int id_barang_keluar;
                        // Jika barang dalam gudang yang berstatus IN ada yang
                        // punya ID sama dengan yang dicari maka keluar dari perulangan
                        // dan melanjutkan program,
                        // kalo ngga ada, tanyakan terus sampai ID barang yang ingin
                        // di keluarkan sesuai dengan salah satu barang di dalam gudang
                        while (true) { 
                            System.out.print("Input ID Barang  :  ");
                            id_barang_keluar = input.nextInt();
                            input.nextLine();

                            if (id_barang_dalam_gudang.contains(id_barang_keluar)) {
                                break;
                            }
                            else {
                                System.out.println("Masukan ID Barang yang ada di dalam Gudang.\n");
                            }
                        }

                        // barang_keluar diambil dari gudang dengan ID barang keluar
                        // dikurang 1 supaya mengambil barangnya sesuai index bukan id
                        // karena index dimulai dari 0, dan id nya dimulai dari 1
                        ArrayList barang_keluar = gudang.get((id_barang_keluar-1));
                        System.out.print("\n");
                        System.out.println("Detail barang");
                        System.out.println("----------------");
                        System.out.println("ID barang        : " + barang_keluar.get(0));
                        System.out.println("Kategori barang  : " + barang_keluar.get(1));
                        System.out.println("Nama barang      : " + barang_keluar.get(2));
                        System.out.println("Tanggal masuk    : " + barang_keluar.get(4));
                        System.out.println("Petugas penerima : " + barang_keluar.get(6));
                        System.out.print("\n");

                        System.out.print("Input Tanggal Keluar [dd/mm/yy]  :  ");
                        String tanggal_keluar = input.nextLine();

                        System.out.print("Nama Petugas Pengeluar Barang    :  ");
                        String petugas_pengeluar = input.nextLine();
                        System.out.print("\n");
                        String status = "OUT"; // Nilai default setiap barang yang dikeluarkan dari gudang

                        // Hanya keluar jika pilihanya y atau n,
                        // jika y maka perbarui status, tanggal_keluar, dan petugas_pengeluar
                        // dengan yang sudah dimasukan diatas,
                        // jika n maka tidak ada proses yang dilakukan,
                        // selain itu maka akan terus ditanya konfirmasinya sampai memilih y/n
                        while (true) { 
                            System.out.print("Konfirmasi [y/n]  :  ");
                            String konfirmasi = input.nextLine().toLowerCase(); // supaya tidak case sensitif

                            if (konfirmasi.equals("y")) {
                                barang_keluar.set(3, status);
                                barang_keluar.set(5, tanggal_keluar);
                                barang_keluar.set(7, petugas_pengeluar);
                                System.out.println("\nBarang dengan ID " + id_barang_keluar + " telah dikeluarkan dari gudang.\n");
                                break;
                            }
                            else if (konfirmasi.equals("n")) {
                                System.out.println("\nBatal Mengeluarkan Barang.\n");
                                break;
                            }
                        }

                    }
                    else {
                        System.out.println("Gudang Kosong.\n");
                    }

                    System.out.println("1. Keluarkan barang lagi.");
                    System.out.println("0. Keluar menu.");

                    // penjelasan di menu 1
                    Boolean exit = false;
                    while (true) { 
                        System.out.print("\nMasukan pilihan : ");
                        int pilihan = input.nextInt();
                        input.nextLine();
                        if (pilihan == 0) {
                            exit = true;
                            break;
                        }
                        else if (pilihan == 1) {
                            System.out.print("\n\n");
                            break;
                        }
                    }
                    if (exit) {
                        break;
                    }
                }

                System.out.println("-------------------------------------------------------");
                System.out.print("\n");
            } 
            
            else if (menu == 3) {
                System.out.print("\n");
                System.out.println("-------------------------------------------------------");
                System.out.println("Menu 3 (List Barang di Gudang)\n");
                
                // Membuat ArrayList baru yang akan menampung barang-barang
                // dalam gudang yang berstatus IN
                ArrayList<ArrayList> list_barang_in = new ArrayList();
                for (ArrayList baris : gudang) {
                    if (baris.get(3).equals("IN")) {
                        list_barang_in.add(baris);
                    }
                }

                // Kalo ada barang yang status nya IN dalam gudang
                if (list_barang_in.size() > 0) {
                    // Head Tabel
                    System.out.println("----------------------------------------------------------------------------------------------");
                    System.out.printf("|  %-3s  |  %-15s  |  %-15s  |  %-15s  |  %-20s  |\n",
                                        "ID", "Kategori", "Nama Barang", "Tanggal Masuk", "Petugas Penerima");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    // Baris-baris tabel, satu baris mewakili satu barang
                    for (ArrayList baris : list_barang_in) {
                                        // |   ID   | Kategori | Nama barang | Tanggal masuk | Petugas penerima |
                        System.out.printf("|  %-3d  |  %-15s  |  %-15s  |  %-15s  |  %-20s  |\n",
                                            baris.get(0), baris.get(1), baris.get(2), baris.get(4), baris.get(6) );
                    }
                    // Akhir Tabel
                    System.out.println("----------------------------------------------------------------------------------------------");

                    // maksud dari printf :
                    // %-15s :
                    //          %s = string
                    //          -  = rata kiri
                    //          15 = panjang minimal karakter 15, misal kalo "kulkas" jadi "kulkas         "
                }
                else {
                    System.out.println("Gudang Kosong.");
                }

                System.out.print("\nexit");
                input.nextLine(); // Menunggu Enter untuk exit menu
                System.out.println("-------------------------------------------------------");
                System.out.print("\n");
            }
            
            else if (menu == 4) {
                System.out.print("\n");
                System.out.println("-------------------------------------------------------");
                System.out.println("Menu 4 (List Barang yang sudah keluar dari Gudang)\n");
                // Sama saja dengan yang dilakukan di menu 3, hanya yang ditampilkan
                // yang status nya OUT saja dan tambahan menampilkan Tanggal keluar
                // serta petugas pengeluar dalam tabel.
                
                // Membuat ArrayList baru yang akan menampung barang-barang
                // dalam gudang yang berstatus OUT
                ArrayList<ArrayList> list_barang_out = new ArrayList();
                for (ArrayList baris : gudang) {
                    if (baris.get(3).equals("OUT")) {
                        list_barang_out.add(baris);
                    }
                }

                // Penjelasan sama dengan menu 3
                if (list_barang_out.size() > 0) {
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("|  %-3s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-20s  |  %-20s  |\n",
                                        "ID", "Kategori", "Nama Barang", "Tanggal Masuk", "Tanggal Keluar", "Petugas Penerima", "Petugas Pengeluar");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                    for (ArrayList baris : list_barang_out) {
                        System.out.printf("|  %-3s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-20s  |  %-20s  |\n",
                                            baris.get(0), baris.get(1), baris.get(2), baris.get(4), baris.get(5), baris.get(6), baris.get(7) );
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                }
                else {
                    System.out.println("Belum ada barang yang keluar dari Gudang.");
                }

                System.out.print("\nexit");
                input.nextLine(); // Menunggu Enter untuk exit menu
                System.out.println("-------------------------------------------------------");
                System.out.print("\n");
            }

            else if (menu == 5) {
                System.out.print("\n");
                System.out.println("-------------------------------------------------------");
                System.out.println("Menu 5 (Cari Barang di catatan Gudang)");

                while (true) { // Hanya berhenti jika pilihan yang dimasukanya adalah 0
                    System.out.print("\n");
                    System.out.println("1. Berdasarkan ID.");
                    System.out.println("2. Berdasarkan Kategori.");
                    System.out.println("3. Tampilkan Semua.");
                    System.out.println("0. Keluar menu.");
                    System.out.print("\nMasukan pilihan  :  ");
                    int pilihan = input.nextInt();
                    input.nextLine();

                    if (pilihan == 0) {
                        break;
                    }

                    // kalo gudang setidaknya pernah ada barang yang masuk
                    if (gudang.size() > 0) {
                        if (pilihan == 1) {

                            // perulangan akan berhenti hanya jika ID yang dicari
                            // antara 1 sampai jumlah barang di gudang,
                            // kalo selain itu maka tanyakan terus ID yang dicari
                            while (true) { 
                                System.out.print("\nMasukan ID Barang yang ingin dicari  :  ");
                                int id_cari = input.nextInt();
                                input.nextLine();

                                if (1 <= id_cari && id_cari <= gudang.size()) {
                                    // barang cariang mengambil dari gudang berdasarkan index, makanya id_cari - 1
                                    ArrayList barang_carian = gudang.get((id_cari-1));
                                    System.out.println("\nBarang Ditemukan");
                                    System.out.println("----------------------");
                                    System.out.println("ID Barang          :  " + barang_carian.get(0));
                                    System.out.println("Kategori Barang    :  " + barang_carian.get(1));
                                    System.out.println("Nama Barang        :  " + barang_carian.get(2));
                                    // Status yang ditampilkan menggunakan Ternary Operator, yang kiri kalau IN, kanan kalo OUT
                                    System.out.println("Status             :  " + (barang_carian.get(3).equals("IN") ? 
                                                                                    "Barang masih dalam Gudang" : "Barang sudah keluar Gudang" ));
                                    System.out.println("Tanggal Masuk      :  " + barang_carian.get(4));
                                    System.out.println("Tanggal Keluar     :  " + barang_carian.get(5));
                                    System.out.println("Petugas Penerima   :  " + barang_carian.get(6));
                                    System.out.println("Petugas Pengeluar  :  " + barang_carian.get(7));
                                    System.out.print("\nexit");
                                    input.nextLine();
                                    break;
                                }
                            }
                        }                    
                        else if (pilihan == 2) {
                            System.out.print("\nMasukan Kategori yang ingin dicari  :  ");
                            String kategori_barang = input.nextLine().toLowerCase(); // merubah input jadi huruf kecil semua
                            
                            // Membuat ArrayList baru yang akan menampung barang-barang
                            // dalam gudang yang kategorinya sama dengan kategori yang dicari
                            ArrayList<ArrayList> gudang_berdasarkan_kategori = new ArrayList();
                            for (ArrayList baris : gudang) {
                                if (baris.get(1).equals(kategori_barang)) {
                                    gudang_berdasarkan_kategori.add(baris);
                                }
                            }

                            // Penjelasan sama dengan Menu 3
                            if (gudang_berdasarkan_kategori.size() > 0) {
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                System.out.printf("|  %-3s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-20s  |  %-20s  |\n",
                                                    "ID", "Kategori", "Nama Barang", "Status", "Tanggal Masuk", "Tanggal Keluar", "Petugas Penerima", "Petugas Pengeluar");
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                for (ArrayList baris : gudang_berdasarkan_kategori) {
                                    System.out.printf("|  %-3s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-20s  |  %-20s  |\n",
                                                        baris.get(0), baris.get(1), baris.get(2), baris.get(3), baris.get(4), baris.get(5), baris.get(6), baris.get(7) );
                                }
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("\nAda " + gudang_berdasarkan_kategori.size() + " Barang dengan Kategori " + kategori_barang + " Ditemukan.\n");
                            }
                            else {
                                System.out.println("Tidak ada Barang dengan Kategori " + kategori_barang + " yang ditemukan.\n");
                            }
                            System.err.print("exit");
                            input.nextLine();
                        }
                        else if (pilihan == 3) {
                            // Menampilkan Semua yang ada di ArrayList Gudang
                            System.out.print("\n");
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.printf("|  %-3s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-20s  |  %-20s  |\n",
                                                "ID", "Kategori", "Nama Barang", "Status", "Tanggal Masuk", "Tanggal Keluar", "Petugas Penerima", "Petugas Pengeluar");
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            for (ArrayList baris : gudang) {
                                System.out.printf("|  %-3s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-15s  |  %-20s  |  %-20s  |\n",
                                                    baris.get(0), baris.get(1), baris.get(2), baris.get(3), baris.get(4), baris.get(5), baris.get(6), baris.get(7) );
                            }
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.print("\nexit");
                            input.nextLine();
                        }
                    }
                    else {
                        System.out.print("\nBelum pernah ada barang yang masuk ataupun keluar dari Gudang.");
                        input.nextLine();
                    }
                }

                System.out.println("-------------------------------------------------------");
                System.out.print("\n");
            }

            else if (menu == 0) {
                System.out.println("\nKeluar\n");
                System.out.println("=======================================================");
                // Keluar Program
                break;
            }

            else {
                System.out.println("\nnomer Menu yang anda pilih tidak ada");
                System.out.println("MASUKAN NOMER MENU YANG SESUAI!!!\n");
                input.nextLine();
                System.out.print("\n\n\n\n\n");
            }
        }
    }
}
