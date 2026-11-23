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

        String ketPenarikan;

        if (!nominalValid) {
            ketPenarikan = "Penarikan Ditolak! Minimal penarikan Rp20.000";
        } else if (!saldoCukup) {
            ketPenarikan = "Penarikan Ditolak! Saldo tidak mencukupi";
        } else {
            saldo -= jumlah;
            ketPenarikan = "Penarikan Berhasil";
        }

        return ketPenarikan;
    }
}