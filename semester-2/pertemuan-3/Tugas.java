import java.util.Scanner;

public class Tugas {
    public static void main(String[] args) {
        // DEKLARASI DAN INISIALISASI VARIABEL
        Scanner input = new Scanner(System.in);
        String nama;
        String status;
        int jumlah_lembur;
        double bayaran_lembur = 150000;
        double gaji_karyawan_tetap = 5000000;
        double gaji_karyawan_kontrak = 2000000;
        double gaji_pokok;
        double total_gaji;


        // catatan
        System.out.println("=======================================================  ");
        System.out.println("   PROGRAM PERHITUNGAN GAJI KARYAWAN PT. BANGUN GAYA     ");
        System.out.println("=======================================================\n");
        System.out.println("kode status  :  KT  =  Karyawan Tetap                    ");
        System.out.println("                KK  =  Karyawan Kontrak                \n");
        System.out.println("gaji pokok   :  Karyawan Tetap       =  Rp. 5.000.000    ");
        System.out.println("                Karyawan Kontrak     =  Rp. 2.000.000  \n");
        System.out.println("bayaran lembur per hari              =  Rp.   150.000  \n");
        System.out.println("=======================================================\n");
        
        
        // INPUT
        System.out.print("Masukan Nama            :  ");
        nama = input.nextLine();        
        System.out.print("Status Karyawan [kode]  :  ");
        status = input.nextLine();
        System.out.print("Jumlah Lembur           :  ");
        jumlah_lembur = input.nextInt();
        
        
        // PROSES
        gaji_pokok = status.equals("KT")  ? gaji_karyawan_tetap : (status.equals("KK") ? gaji_karyawan_kontrak : 0);
            // kalo status sama dengan "KT" maka gaji pokoknya sesuai dengan gaji karyawan tetap
            // kalo bukan maka (kalo status nya "KK" maka gaji pokoknya sesuai karyawan kontrak kalo
            // bukan "KT" dan "KK" maka gajinya 0)

        total_gaji = status.equals("KT") || status.equals("KK") ? gaji_pokok + (bayaran_lembur * jumlah_lembur) : 0;
            // kalo status sama dengan "KT" atau "KK" maka gaji pokoknya ditambah biaya lembur
            // kalo bukan keduanya maka total gajinya 0
            // ini mencegah selain karyawan kontrak dan karyawan tetap agar tidak dapat biaya lembur

        status = status.equals("KT") ? "Karyawan Tetap" : (status.equals("KK") ? "Karyawan Kontrak" : "Bukan karyawan") ;
            // ini merubah kode status menjadi status karyawan itu sendiri untuk nantinya ditampilkan
        
        
        // OUTPUT
        System.out.println("\n=======================================================\n");
        System.out.println("Nama Karyawan    :  " + nama);
        System.out.println("Status Karyawan  :  " + status);
        System.out.println("Gaji Pokok       :  Rp. " + gaji_pokok);
        System.out.println("Bayaran Lembur   :  Rp. " + bayaran_lembur * jumlah_lembur);
        System.out.println("Total Gaji       :  Rp. " + total_gaji);
        System.out.println("\n=======================================================");
    }
}

