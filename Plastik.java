public class Plastik extends Sampah {

    public Plastik(double berat) {
        super(berat);
    }

    @Override
    public double hitungNilai() {
        return getBerat() * 2000;
    }
}