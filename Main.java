
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static String inputNama() {
        System.out.print("Masukkan nama nasabah: ");
        String nama = input.nextLine().trim();

        while (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong!");
            System.out.print("Masukkan nama nasabah: ");
            nama = input.nextLine().trim();
        }

        return nama;
    }

    public static double inputBerat(String jenis) {
        System.out.print("Masukkan berat " + jenis + " (kg): ");

        while (!input.hasNextDouble()) {
            System.out.println("Input harus berupa angka, coba lagi!");
            input.next();
            System.out.print("Masukkan berat " + jenis + " (kg): ");
        }

        double berat = input.nextDouble();

        while (!Double.isFinite(berat) || berat < 0) {
            System.out.println("Berat harus berupa angka nol atau lebih. Coba lagi!");
            System.out.print("Masukkan berat " + jenis + " (kg): ");

            while (!input.hasNextDouble()) {
                System.out.println("Input harus berupa angka, coba lagi!");
                input.next();
                System.out.print("Masukkan berat " + jenis + " (kg): ");
            }

            berat = input.nextDouble();
        }

        return berat;
    }

    public static double inputPenarikan() {
        System.out.print("Masukkan nominal penarikan: Rp");

        while (!input.hasNextDouble()) {
            System.out.println("Input harus berupa angka, coba lagi!");
            input.next();
            System.out.print("Masukkan nominal penarikan: Rp");
        }

        double jumlah = input.nextDouble();

        while (!Double.isFinite(jumlah) || jumlah < 0) {
            System.out.println("Penarikan tidak valid. Coba lagi!");
            System.out.print("Masukkan nominal penarikan: Rp");

            while (!input.hasNextDouble()) {
                System.out.println("Input harus berupa angka, coba lagi!");
                input.next();
                System.out.print("Masukkan nominal penarikan: Rp");
            }

            jumlah = input.nextDouble();
        }

        return jumlah;
    }

    public static String inputLanjut() {
        System.out.print("\nIngin melakukan transaksi lagi? (Y/T): ");
        String lanjut = input.nextLine().trim();

        while (!lanjut.equalsIgnoreCase("Y")
                && !lanjut.equalsIgnoreCase("T")) {
            System.out.println("Masukkan Y atau T!");
            System.out.print("Ingin melakukan transaksi lagi? (Y/T): ");
            lanjut = input.nextLine().trim();
        }

        return lanjut;
    }

    public static void main(String[] args) {

        String lanjut;

        do {
            System.out.println("\n===== BANK SAMPAH =====");

            String nama = inputNama();

            double plastik = inputBerat("Plastik");
            double kertas = inputBerat("Kertas");
            double logam = inputBerat("Logam");

            Nasabah nasabah = new Nasabah(nama, 0);
            Setoran setoran = new Setoran();

            setoran.tambahSampah(new Plastik(plastik));
            setoran.tambahSampah(new Kertas(kertas));
            setoran.tambahSampah(new Logam(logam));

            nasabah.tambahSaldo(setoran.hitungTotalSetoran());

            System.out.println("\n===== STRUK SETORAN =====");
            System.out.println("Nama Nasabah   : " + nasabah.getNama());
            System.out.println("Total Berat    : " + setoran.hitungTotalBerat() + " kg");
            System.out.println("Jumlah Setoran : " + setoran.hitungJumlahSetoran());
            System.out.printf("Nilai Sampah   : Rp%.0f%n", setoran.hitungNilai());
            System.out.printf("Bonus          : Rp%.0f%n", setoran.hitungBonus());
            System.out.printf("Total Setoran  : Rp%.0f%n", setoran.hitungTotalSetoran());
            System.out.printf("Saldo          : Rp%.0f%n", nasabah.getSaldo());

            System.out.println("\n===== PENARIKAN SALDO =====");

            double penarikan = inputPenarikan();

            System.out.println(nasabah.tarikSaldo(penarikan));

            System.out.printf("Saldo Akhir    : Rp%.0f%n", nasabah.getSaldo());

            input.nextLine();
            lanjut = inputLanjut();

        } while (lanjut.equalsIgnoreCase("Y"));

        System.out.println("\nSistem berakhir, terima kasih");

        input.close();
    }
}
