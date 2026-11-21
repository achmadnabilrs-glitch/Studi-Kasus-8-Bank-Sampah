import java.util.ArrayList;

public class Setoran {
    private ArrayList<Sampah> daftarSampah;

    public Setoran() {
        daftarSampah = new ArrayList<>();
    }

    public void tambahSampah(Sampah sampah) {
    boolean valid = sampah.getBerat() > 0;

    daftarSampah.addAll(
        valid ? java.util.List.of(sampah) : java.util.List.of()
    );
}

    public double hitungNilai() {
        double total = 0;

        for (Sampah sampah : daftarSampah) {
            total += sampah.hitungNilai();
        }

        return total;
    }

    public double hitungTotalBerat() {
        double total = 0;

        for (Sampah sampah : daftarSampah) {
            total += sampah.getBerat();
        }

        return total;
    }

    public double hitungBonus() {
        return hitungTotalBerat() >= 10
                ? hitungNilai() * 0.05
                : 0;
    }

    public double hitungTotalSetoran() {
        return hitungNilai() + hitungBonus();
    }

    public int hitungJumlahSetoran() {
        return daftarSampah.size();
    }
}