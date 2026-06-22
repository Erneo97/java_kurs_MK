package org.telefon.model.telefon;

import java.awt.*;
import java.util.Objects;

public abstract class Telefon{
    protected String interfejsKomunikacyjny;
    protected Color color;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Telefon telefon = (Telefon) o;
        return Objects.equals(interfejsKomunikacyjny, telefon.interfejsKomunikacyjny) && Objects.equals(color, telefon.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interfejsKomunikacyjny, color);
    }
}
