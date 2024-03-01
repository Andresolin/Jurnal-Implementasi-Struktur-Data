import java.util.ArrayList;

public class Jurnal02 {

    public static void main(String[] args) {

        ArrayList<AlatTulisKantor> inventaris1 = new ArrayList<>();
        ArrayList<AlatTulisKantor> inventaris2 = new ArrayList<>();
        ArrayList<AlatTulisKantor> inventaris3 = new ArrayList<>();

        AlatTulisKantor AlatTulisKantor1 = new AlatTulisKantor("A001", "ATK", "Spidol", 15);
        AlatTulisKantor AlatTulisKantor2 = new AlatTulisKantor("A002", "ATK", "Pulpen", 10);
        AlatTulisKantor AlatTulisKantor3 = new AlatTulisKantor("A003", "ATK", "Pensil", 12);
        AlatTulisKantor AlatTulisKantor4 = new AlatTulisKantor("B001", "ATK", "HVS", 10);
        AlatTulisKantor AlatTulisKantor5 = new AlatTulisKantor("B002", "ATK", "Karton", 5);
        AlatTulisKantor AlatTulisKantor6 = new AlatTulisKantor("C001", "Bag", "Tas", 20);
        AlatTulisKantor AlatTulisKantor7 = new AlatTulisKantor("C002", "Bag", "Kotak Pensil", 7);

        inventaris1.add(AlatTulisKantor1);
        inventaris1.add(AlatTulisKantor2);
        inventaris1.add(AlatTulisKantor3);
        inventaris2.add(AlatTulisKantor4);
        inventaris2.add(AlatTulisKantor5);
        inventaris3.add(AlatTulisKantor6);
        inventaris3.add(AlatTulisKantor7);

        inventaris1.remove(AlatTulisKantor2);

        inventaris2.get(1).setStok(50);

        for (AlatTulisKantor alat : inventaris1) {
            System.out.println(alat);
        }
        System.out.println();
        for (AlatTulisKantor alat : inventaris2) {
            System.out.println(alat);
        }
        System.out.println();
        for (AlatTulisKantor alat : inventaris3) {
            System.out.println(alat);
        }
        System.out.println();
    }
}

class AlatTulisKantor {

    String Kode;
    String Jenis;
    String Nama;
    int Stok;

    public AlatTulisKantor(String kode, String jenis, String nama, int stok) {
        this.Kode = kode;
        this.Jenis = jenis;
        this.Nama = nama;
        this.Stok = stok;
    }

    @Override
    public String toString() {
        return "AlatTulisKantor [Kode = " + Kode + ", Jenis = " + Jenis + ", Nama = " + Nama + ", Stok = " + Stok + " ]";
    }

    public void setKode(String kode) {
        Kode = kode;
    }

    public void setJenis(String jenis) {
        Jenis = jenis;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public void setStok(int stok) {
        Stok = stok;
    }
}
