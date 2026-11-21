public class Kertas extends Sampah {

    public Kertas(double berat) {
        super(berat);
    }

    @Override
    public double hitungNilai() {
        return getBerat() * 1500;
    }
}