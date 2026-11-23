
public class Nasabah {

    private String nama;
    private double saldo = 0;

    public Nasabah(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public double getSaldo() {
        return saldo;
    }

    public void tambahSaldo(double jumlah) {
        saldo += jumlah;
    }

    public String tarikSaldo(double jumlah) {
        boolean nominalValid = Double.isFinite(jumlah)
                && jumlah >= 20000;

        boolean saldoCukup = jumlah <= saldo;

        boolean berhasil = nominalValid && saldoCukup;

        saldo -= berhasil ? jumlah : 0;

        String ketPenarikan = !nominalValid
                ? "Penarikan Ditolak! Minimal penarikan Rp20.000"
                : !saldoCukup
                    ? "Penarikan Ditolak! Saldo tidak mencukupi"
                    : "Penarikan Berhasil";

        return ketPenarikan;
    }
}