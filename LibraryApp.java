import java.util.ArrayList;
import java.util.Scanner;

// Class untuk menyimpan data buku
class Book {
    String judul;
    String pengarang;
    int tahunTerbit;

    // Constructor
    public Book(String judul, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    // Method untuk menampilkan data buku
    public void tampilkan() {
        System.out.println("📖 Judul Buku   : " + judul);
        System.out.println("✍  Pengarang    : " + pengarang);
        System.out.println("📅 Tahun Terbit : " + tahunTerbit);
        System.out.println("-----------------------------------");
    }
}

// Class untuk mengelola daftar buku
class Library {
    private ArrayList<Book> daftarBuku = new ArrayList<>();

    // Constructor Library, otomatis menambah 2 buku awal
    public Library() {
        daftarBuku.add(new Book("Laskar Pelangi", "Andrea Hirata", 2005));
        daftarBuku.add(new Book("Bumi Manusia", "Pramoedya Ananta Toer", 1980));
    }

    // Method menambah buku baru
    public void tambahBuku(String judul, String pengarang, int tahun) {
        Book bukuBaru = new Book(judul, pengarang, tahun);
        daftarBuku.add(bukuBaru);
        System.out.println("\n✅ Buku berhasil ditambahkan!");
        System.out.println("Judul Buku  : " + judul);
        System.out.println("Pengarang   : " + pengarang);
        System.out.println("Tahun Terbit: " + tahun);
        System.out.println("-----------------------------------");
    }

    // Method menampilkan semua buku
    public void tampilkanSemua() {
        System.out.println("\n📚 DAFTAR SEMUA BUKU DI PERPUSTAKAAN:");
        if (daftarBuku.isEmpty()) {
            System.out.println("(Belum ada buku di perpustakaan)");
        } else {
            for (Book b : daftarBuku) {
                b.tampilkan();
            }
        }
    }
}

// Class utama (main)
public class LibraryApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library perpustakaan = new Library(); // sudah ada 2 buku awal

        System.out.println("=== APLIKASI DATA BUKU PERPUSTAKAAN ===");

        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = input.nextInt();
            input.nextLine(); // hapus newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul Buku: ");
                    String judul = input.nextLine();

                    System.out.print("Masukkan Nama Pengarang: ");
                    String pengarang = input.nextLine();

                    System.out.print("Masukkan Tahun Terbit: ");
                    int tahun = input.nextInt();

                    perpustakaan.tambahBuku(judul, pengarang, tahun);
                    break;

                case 2:
                    perpustakaan.tampilkanSemua();
                    break;

                case 3:
                    System.out.println("👋 Terima kasih telah menggunakan aplikasi!");
                    break;

                default:
                    System.out.println("❌ Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 3);

        input.close();
    }
}