package hu.petrik.versenyeredmenyek;

public class Eredmenyek {
    private String reszIdo;
    private String nev;

    public Eredmenyek(String reszIdo, String nev) {
        this.reszIdo = reszIdo;
        this.nev = nev;
    }

    public String getReszIdo() {
        return reszIdo;
    }

    public String getNev() {
        return nev;
    }

    public int getReszidoPerc(){
        return Integer.parseInt(reszIdo.split(":")[0]);
    }

    public int getReszidoMasodperc(){
        return Integer.parseInt(reszIdo.split(":")[1]);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.nev, this.reszIdo);
    }
}
