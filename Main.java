import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import java.util.Date;


public class Main {
    private static LinkedList<Tugas> toDoList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Input Tugas Baru");
            System.out.println("2. Hapus Tugas");
            System.out.println("3. Lihat List Tugas");
            System.out.println("0. Keluar");
            System.out.print("Pilih operasi yang ingin dilakukan: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    tambahDataTugas();
                    break;
                case 2:
                    hapusDataTugas();
                    break;
                case 3:
                    lihatListTugas();
                    break;
                case 0:
                    System.out.println("Program berakhir.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 0);
    }

   
    private static void tambahDataTugas() {
        System.out.print("Masukkan Mata Kuliah: ");
        String mataKuliah = scanner.nextLine();
        System.out.print("Masukkan Nama Tugas: ");
        String namaTugas = scanner.nextLine();
        System.out.print("Masukkan Deadline Tugas: ");
        String deadline = scanner.nextLine();

        Tugas newTugas = new Tugas(mataKuliah, namaTugas, deadline);
        toDoList.add(newTugas);

        toDoList.sort(null);
        System.out.println("Data tugas berhasil ditambahkan.");
    }

    private static void hapusDataTugas() {
        if (toDoList.isEmpty()) {
            System.out.println("List tugas kosong.");
            return;
        }
        System.out.print("Masukkan nama tugas yang ingin dihapus: ");
        String namaTugas = scanner.nextLine();
        boolean found = false;
        ListIterator<Tugas> iterator = toDoList.listIterator();
        while (iterator.hasNext()) {
            Tugas tugas = iterator.next();
            if (tugas.namaTugas.equals(namaTugas)) {
                iterator.remove();
                System.out.println("Data tugas dengan nama \"" + namaTugas + "\" berhasil dihapus.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Tidak ada data tugas dengan nama \"" + namaTugas + "\".");
        }
    }


    private static void lihatListTugas() {
        if (toDoList.isEmpty()) {
            System.out.println("List tugas kosong.");
            return;
        }
        System.out.println("Pilih cara untuk mencetak list tugas:");
        System.out.println("1. Print dari Depan");
        System.out.println("2. Print dari Belakang");
        System.out.println("3. Berdasarkan Deadline");
        System.out.println("4. Berdasarkan Nama Mata Kuliah");
        System.out.println("5. Berdasarkan Nama Tugas");
        System.out.print("Pilih operasi yang ingin dilakukan: ");
        int printChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (printChoice) {
            case 1:
                cetakDataTugasDariAwal();
                break;
            case 2:
                cetakDataTugasDariAkhir();
                break;
            case 3:
            cetakDataTugasBerdasarkanDeadline();
                break;
            case 4:
                cetakDataTugasBerdasarkanMataKuliah();
                break;
            case 5:
                cetakDataTugasBerdasarkanNamaTugas();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }


    private static void cetakDataTugasDariAkhir() {
        System.out.println("Data tugas:");
        for (Tugas tugas : toDoList) {
            System.out.println(tugas);
        }
    }

   
    private static void cetakDataTugasDariAwal() {
        System.out.println("Data tugas:");
        ListIterator<Tugas> iterator = toDoList.listIterator(toDoList.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    
    public class DeadlineUtil {
   
    public static int[] parseDeadlineToInt(String deadline) {
        SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy");
        Date date;
        try {
            date = sdf.parse(deadline);
        } catch (ParseException e) {
            System.out.println("Format deadline tidak valid.");
            return null;
        }
        
        int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
        
        int[] parsedDeadline = {day, month, year};
        return parsedDeadline;
    }
}

   
    private static void cetakDataTugasBerdasarkanDeadline() {
        if (toDoList.isEmpty()) {
            System.out.println("List tugas kosong.");
            return;
        }
       
        Collections.sort(toDoList, new Comparator<Tugas>() {
            @Override
            public int compare(Tugas t1, Tugas t2) {
               
                int[] deadline1 = DeadlineUtil.parseDeadlineToInt(t1.deadline);
                int[] deadline2 = DeadlineUtil.parseDeadlineToInt(t2.deadline);
               
                for (int i = 2; i >= 0; i--) {
                    if (deadline1[i] != deadline2[i]) {
                        return Integer.compare(deadline1[i], deadline2[i]);
                    }
                }
                return 0; 
            }
        });
    
        System.out.println("Data tugas berdasarkan deadline:");
        for (Tugas tugas : toDoList) {
            System.out.println(tugas);
        }
    }




private static void cetakDataTugasBerdasarkanNamaTugas() {
    if (toDoList.isEmpty()) {
        System.out.println("List tugas kosong.");
        return;
    }
   
    Collections.sort(toDoList, new Comparator<Tugas>() {
        @Override
        public int compare(Tugas t1, Tugas t2) {
            return t1.namaTugas.compareTo(t2.namaTugas);
        }
    });

    System.out.println("Data tugas berdasarkan nama tugas:");
    for (Tugas tugas : toDoList) {
        System.out.println(tugas);
    }
}


private static void cetakDataTugasBerdasarkanMataKuliah() {
    if (toDoList.isEmpty()) {
        System.out.println("List tugas kosong.");
        return;
    }
    
    Collections.sort(toDoList, new Comparator<Tugas>() {
        @Override
        public int compare(Tugas t1, Tugas t2) {
            return t1.mataKuliah.compareTo(t2.mataKuliah);
        }
    });

    System.out.println("Data tugas berdasarkan nama mata kuliah:");
    for (Tugas tugas : toDoList) {
        System.out.println(tugas);
    }
}

}


