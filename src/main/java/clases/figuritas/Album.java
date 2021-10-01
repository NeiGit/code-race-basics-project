package clases.figuritas;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final List<Pagina> paginas;

    public Album() {
        this.paginas = new ArrayList<>();
    }

    public void addPagina(Pagina pagina) {
        paginas.add(pagina);
    }

    public Pagina getPagina(int index) {
        return paginas.get(index);
    }
}
