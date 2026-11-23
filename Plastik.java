public class Plastik extends Sampah {

    public Plastik(double berat) {
        super(berat);
    }

    @Override
    public double hitungNilai() {
        double nilaiPlastik = getBerat() * 2000;
        return nilaiPlastik;
    }
}
