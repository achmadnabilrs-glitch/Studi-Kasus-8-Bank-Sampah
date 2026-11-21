public abstract class Sampah {
    private double berat;

    public Sampah(double berat) {
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    public abstract double hitungNilai();
}