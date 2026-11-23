import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static String inputNama() {
        System.out.print("Masukkan nama nasabah: ");
        String nama = input.nextLine().trim();

        while (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong, coba lagi!");
            System.out.print("Masukkan nama nasabah: ");
            nama = input.nextLine().trim();
        }

        return nama;
    }

    public static double inputAngka(String pesan) {
        double angka;

        while (true) {
            System.out.print(pesan);

            if (input.hasNextDouble()) {
                angka = input.nextDouble();
                input.nextLine();

                if (Double.isFinite(angka) && angka >= 0) {
                    return angka;
                } else {
                    System.out.println("Angka harus nol atau lebih, coba lagi!");
                }

            } else {
                System.out.println("Input harus berupa angka, coba lagi!");
                input.nextLine();
            }
        }
    }

    public static boolean inputLanjut() {
        System.out.print("\nIngin melakukan transaksi lagi? (Y/T): ");
        String pilihan = input.nextLine().trim();

        while (!pilihan.equalsIgnoreCase("Y")
                && !pilihan.equalsIgnoreCase("T")) {
            System.out.println("Masukkan Y atau T!");
            System.out.print("Ingin melakukan transaksi lagi? (Y/T): ");
            pilihan = input.nextLine().trim();
        }

        boolean lanjut;

        if (pilihan.equalsIgnoreCase("Y")) {
            lanjut = true;
        } else {
            lanjut = false;
        }

        return lanjut;
    }

    public static void cetakStruk(Nasabah nasabah, Setoran setoran) {
        String nama = nasabah.getNama();
        int jumlahJenisSampah = setoran.hitungJumlahJenisSampah();
        double totalBeratSampah = setoran.hitungTotalBeratSampah();
        double hargaSetoranSampah = setoran.hitungHargaSetoranSampah();
        double bonus = setoran.hitungBonus();
        double setoranAkhirDiterima = setoran.hitungSetoranAkhirDiterima();
        double saldo = nasabah.getSaldo();

        System.out.println("\n===== STRUK SETORAN =====");
        System.out.println("Nama Nasabah   : " + nama);
        System.out.println("Jumlah Jenis   : " + jumlahJenisSampah);
        System.out.println("Total Berat    : " + totalBeratSampah + " kg");
        System.out.printf("Nilai Sampah   : Rp%.0f%n", hargaSetoranSampah);
        System.out.printf("Bonus          : Rp%.0f%n", bonus);
        System.out.printf("Total Setoran  : Rp%.0f%n", setoranAkhirDiterima);
        System.out.printf("Saldo          : Rp%.0f%n", saldo);
    }

    public static void main(String[] args) {

        boolean lanjut;

        do {
            System.out.println("\n===== BANK SAMPAH =====");

            String nama = inputNama();

            double plastik = inputAngka("Masukkan berat Plastik (kg): ");
            double kertas = inputAngka("Masukkan berat Kertas (kg): ");
            double logam = inputAngka("Masukkan berat Logam (kg): ");

            Nasabah nasabah = new Nasabah(nama);
            Setoran setoran = new Setoran();

            setoran.tambahSampah(new Plastik(plastik));
            setoran.tambahSampah(new Kertas(kertas));
            setoran.tambahSampah(new Logam(logam));

            double totalSetoran = setoran.hitungSetoranAkhirDiterima();
            nasabah.tambahSaldo(totalSetoran);

            cetakStruk(nasabah, setoran);

            System.out.println("\n===== PENARIKAN SALDO =====");

            double penarikan = inputAngka("Masukkan nominal penarikan: Rp");

            String ketPenarikan = nasabah.tarikSaldo(penarikan);
            double sisaSaldoAkhir = nasabah.getSaldo();

            System.out.println(ketPenarikan);
            System.out.printf("Saldo Akhir    : Rp%.0f%n", sisaSaldoAkhir);

            lanjut = inputLanjut();

        } while (lanjut);

        System.out.println("\nSistem berakhir, terima kasih");

        input.close();
    }
}
