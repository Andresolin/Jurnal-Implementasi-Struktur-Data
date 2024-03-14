import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        int choice;
        int choiceTwo;
        int choiceThree;
        do {
            System.out.println("==========Menu Utama=========");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cetak Daftar Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                        do {
                            System.out.println("==========Menu Dari Tambah Buku=========");
                            System.out.println("    1. Input Data Buku di Awal List");
                            System.out.println("    2. Input Data Buku di Akhir List");
                            System.out.println("    3. Input data sesuai indeks");
                            System.out.println("    4. Keluar");
                            System.out.print("      Pilih Menu: ");
                            choiceTwo = scanner.nextInt();

                            switch (choiceTwo) {
                                case 1:
                                    System.out.print("Masukkan judul buku: ");
                                    scanner.nextLine(); // Membersihkan buffer
                                    String judul = scanner.nextLine();
                                    System.out.print("Masukkan nama penulis: ");
                                    String penulis = scanner.nextLine();
                                    System.out.print("Masukkan tahun terbit: ");
                                    int tahunTerbit = scanner.nextInt();
                                    Buku bukuAwal = new Buku(judul, penulis, tahunTerbit);
                                    linkedList.addNodeAtBeginning(bukuAwal);
                                    break;
                                case 2:
                                    System.out.print("Masukkan judul buku: ");
                                    scanner.nextLine(); // Membersihkan buffer
                                    judul = scanner.nextLine();
                                    System.out.print("Masukkan nama penulis: ");
                                    penulis = scanner.nextLine();
                                    System.out.print("Masukkan tahun terbit: ");
                                    tahunTerbit = scanner.nextInt();
                                    Buku bukuAkhir = new Buku(judul, penulis, tahunTerbit);
                                    linkedList.addNodeAtEnd(bukuAkhir);
                                    break;
                                case 3: 
                                    System.out.print("Masukkan indeks untuk memasukkan data buku: ");
                                    int index = scanner.nextInt();
                                    System.out.print("Masukkan judul buku: ");
                                    scanner.nextLine(); // Membersihkan buffer
                                    String judulBuku = scanner.nextLine();
                                    System.out.print("Masukkan nama penulis: ");
                                    String penulisBuku = scanner.nextLine();
                                    System.out.print("Masukkan tahun terbit: ");
                                    int tahunTerbitBuku = scanner.nextInt();
                                    Buku bukuIndeks = new Buku(judulBuku, penulisBuku, tahunTerbitBuku);
                                    linkedList.addNodeAtIndex(index, bukuIndeks);
                                    break;
                                case 4: 
                                System.out.println("==========Keluar Dari Menu Tambah Buku=========");
                                    break;
                            }
                        } while (choiceTwo != 4);
                    break;
                case 2:
                        do {
                            System.out.println("==========Menu Hapus Buku=========");
                            System.out.println("    Menu:");
                            System.out.println("    1. Hapus Data Buku dari Awal List");
                            System.out.println("    2. Hapus Data Buku dari Akhir List");
                            System.out.println("    3. Hapus Data Sesuai Judul Buku");
                            System.out.println("    4. Keluar");
                            System.out.print("      Pilih Menu: ");
                            choiceThree = scanner.nextInt();

                            switch (choiceThree) {
                                case 1:
                                    linkedList.deleteNodeAtBeginning();
                                    break;

                                case 2:
                                    linkedList.deleteNodeAtEnd();
                                    break;
                                case 3:
                                    System.out.print("Masukkan judul buku yang ingin dihapus: ");
                                    scanner.nextLine(); // Membersihkan buffer
                                    String title = scanner.nextLine();
                                    linkedList.deleteNodeByTitle(title);
                                    break;
                                case 4: 
                                    System.out.println("==========Keluar Dari Menu Hapus Buku=========");
                                    break;

                            }
                        } while (choiceThree != 4);
                       break;
                case 3:
                    System.out.println("Daftar Buku:");
                    linkedList.printList();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
