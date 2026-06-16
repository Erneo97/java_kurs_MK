package org.example;

public interface Car {
    void starEngine();

    static void gps() {
        System.out.print("Przekazanie lokalizacji");
    }

    private void ladowanieAkumulatora() {
        System.out.print("Ładuje akumulator");
    }
}
