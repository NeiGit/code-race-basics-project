package clases.figuritas;

import java.time.LocalDateTime;

public class Figurita {
    private final int number;
    private final boolean special;
    private final LocalDateTime edition;

    public Figurita(int number, boolean special, LocalDateTime edition) {
        this.number = number;
        this.special = special;
        this.edition = edition;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Figurita)) {
            return false;
        }

        final Figurita other = (Figurita) obj;

        return this.number == other.number
                && this.special == other.special;
    }

    @Override
    public String toString() {
        return number + " - " + (special ? "special" : "standard");
    }
}
