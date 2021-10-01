package clases;

import clases.figuritas.Figurita;
import clases.figuritas.Pagina;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static util.IOUtil.print;

public class Class4POOFiguritas {

    public static void main() {
        final List<Figurita> figuritasPerson1 = new ArrayList<>();
        final List<Figurita> figuritasPerson2 = new ArrayList<>();

        // popular listas
        figuritasPerson1.add(new Figurita(1, false, LocalDateTime.now()));
        figuritasPerson1.add(new Figurita(34, true, LocalDateTime.now()));
        figuritasPerson1.add(new Figurita(50, false, LocalDateTime.now()));
        figuritasPerson1.add(new Figurita(7, false, LocalDateTime.now()));
        figuritasPerson1.add(new Figurita(19, true, LocalDateTime.now()));

        figuritasPerson2.add(new Figurita(2, false, LocalDateTime.now()));
        figuritasPerson2.add(new Figurita(34, true, LocalDateTime.now().plusDays(-50)));
        figuritasPerson2.add(new Figurita(5, false, LocalDateTime.now()));
        figuritasPerson2.add(new Figurita(7, false, LocalDateTime.now()));
        figuritasPerson2.add(new Figurita(19, false, LocalDateTime.now()));


        // late - nola
        figuritasPerson2.forEach(figurita -> {
            if (figuritasPerson1.contains(figurita)) {
                print(figurita + ": late");
            } else {
                print(figurita + ": nola");
            }
        });

        // completar el album
        final Figurita f1 = new Figurita(1, false, LocalDateTime.now());
        final Figurita f2 = new Figurita(2, false, LocalDateTime.now());
        final Figurita f3 = new Figurita(3, false, LocalDateTime.now());
        final Figurita f4 = new Figurita(4, false, LocalDateTime.now());
        final Figurita f5 = new Figurita(5, false, LocalDateTime.now());
        final Figurita f6 = new Figurita(6, false, LocalDateTime.now());
        final Figurita f7 = new Figurita(7, false, LocalDateTime.now());
        final Figurita f8 = new Figurita(8, false, LocalDateTime.now());
        final Figurita f9 = new Figurita(9, false, LocalDateTime.now());
        final Figurita f10 = new Figurita(10, false, LocalDateTime.now());
        final Figurita f11 = new Figurita(11, false, LocalDateTime.now());

        final Figurita fEscudo = new Figurita(12, false, LocalDateTime.now());

        final Pagina argPagina = new Pagina();

        argPagina.addJugador(f1);
        argPagina.addJugador(f2);
        argPagina.addJugador(f3);
        argPagina.addJugador(f4);
        argPagina.addJugador(f5);
        argPagina.addJugador(f6);
        argPagina.addJugador(f7);
        argPagina.addJugador(f8);
        argPagina.addJugador(f9);
        argPagina.addJugador(f10);
        argPagina.addJugador(f11);

        argPagina.setEscudo(fEscudo);

        print(argPagina);
    }
}
