package clases.figuritas;

import util.IOUtil;

import java.util.ArrayList;
import java.util.List;

public class Pagina {
    private Figurita escudo;
    private final List<Figurita> jugadores;

    public Pagina() {
        this.escudo = null;
        this.jugadores = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "";

        result += "Escudo: " + (escudo != null ? escudo : "-");
        result += "\n";

        result += "Jugadores: " + jugadores.size();
        result += "\n";

        for (Figurita jugador : jugadores) {
            result += jugador;
            result += "\n";
        }

        result += (this.isComplete() ? "COMPLETA" : "INCOMPLETA");

        return result;
    }

    public Pagina(Figurita escudo, List<Figurita> jugadores) {
        this.escudo = escudo;
        this.jugadores = jugadores;
    }

    public boolean isComplete() {
        return escudo != null && jugadores.size() == 11;
    }

    public void setEscudo(Figurita escudo) {
        this.escudo = escudo;
    }

    public void addJugador(Figurita jugador) {
        if (jugadores.size() < 11) {
            this.jugadores.add(jugador);

        } else {
            IOUtil.print("No hay más lugar para jugadores");
        }
    }


}
