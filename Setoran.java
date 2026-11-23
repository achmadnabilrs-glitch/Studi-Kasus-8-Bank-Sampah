import java.util.ArrayList;

public class Setoran {

    private ArrayList<Sampah> daftarSampah;

    public Setoran() {
        daftarSampah = new ArrayList<>();
    }

    public void tambahSampah(Sampah sampah) {
        boolean valid = sampah.getBerat() > 0;

        daftarSampah.addAll(
            valid ? java.util.List.of(sampah)
                  : java.util.List.of()
        );
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
        double bonus = hitungTotalBeratSampah() >= 10
                ? hitungHargaSetoranSampah() * 0.05
                : 0;

        return bonus;
    }

    public double hitungSetoranAkhirDiterima() {
        double setoranAkhirDiterima =
                hitungHargaSetoranSampah() + hitungBonus();

        return setoranAkhirDiterima;
    }

    public int hitungJumlahJenisSampah() {
        int jumlahJenisSampah = daftarSampah.size();

        return jumlahJenisSampah;
    }
}
