public class Logam extends Sampah {

    public Logam(double berat) {
        super(berat);
    }

    @Override
    public double hitungNilai() {
        return getBerat() * 5000;
    }
}