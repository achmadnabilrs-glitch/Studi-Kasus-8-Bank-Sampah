public class Logam extends Sampah {

    public Logam(double berat) {
        super(berat);
    }

    @Override
    public double hitungNilai() {
        double nilaiLogam = getBerat() * 5000;
        return nilaiLogam;
    }
}
