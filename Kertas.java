public class Kertas extends Sampah {

    public Kertas(double berat) {
        super(berat);
    }

    @Override
    public double hitungNilai() {
        double nilaiKertas = getBerat() * 1500;
        return nilaiKertas;
    }
}
