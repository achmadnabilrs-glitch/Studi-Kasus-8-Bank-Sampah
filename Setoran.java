import java.util.ArrayList;

public class Setoran {

    private ArrayList<Sampah> daftarSampah;

    public Setoran() {
        daftarSampah = new ArrayList<>();
    }

    public void tambahSampah(Sampah sampah) {
        boolean valid = sampah.getBerat() > 0;

        if (valid) {
            daftarSampah.add(sampah);
        }
    }

    public double hitungHargaSetoranSampah() {
        double hargaSetoranSampah = 0;

        for (Sampah sampah : daftarSampah) {
            hargaSetoranSampah += sampah.hitungNilai();
        }

        return hargaSetoranSampah;
    }

    public double hitungTotalBeratSampah() {
        double totalBeratSampah = 0;

        for (Sampah sampah : daftarSampah) {
            totalBeratSampah += sampah.getBerat();
        }

        return totalBeratSampah;
    }

    public double hitungBonus() {
        double totalBeratSampah = hitungTotalBeratSampah();
        double hargaSetoranSampah = hitungHargaSetoranSampah();
        double bonus;

        if (totalBeratSampah >= 10) {
            bonus = hargaSetoranSampah * 0.05;
        } else {
            bonus = 0;
        }

        return bonus;
    }

    public double hitungSetoranAkhirDiterima() {
        double hargaSetoranSampah = hitungHargaSetoranSampah();
        double bonus = hitungBonus();

        double setoranAkhirDiterima = hargaSetoranSampah + bonus;

        return setoranAkhirDiterima;
    }

    public int hitungJumlahJenisSampah() {
        int jumlahJenisSampah = daftarSampah.size();

        return jumlahJenisSampah;
    }
}
