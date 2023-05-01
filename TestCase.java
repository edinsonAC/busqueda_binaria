
class TestCase {
    private int longitud;
    private int busqueda;
    private int[] lista;
    private int pos;

    public TestCase() {
    }

    public TestCase(int l, int b, int[] lista, int pos) {
        this.longitud = l;
        this.busqueda = b;
        this.lista = lista;
        this.pos = pos;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getBusqueda() {
        return busqueda;
    }

    public int[] getLista() {
        return lista;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int p) {
        this.pos = p;
    }

    @Override
    public String toString() {
        if (this.pos == -1) {
            return "el elemento no se encuentra en el listado";
        } else {
            return "El numero " + busqueda + " se encuentra en la posicion " + pos + " del listado de longitud "
                    + longitud
                    + " \n  arreglo: " + arrayToString();
        }
    }

    public String arrayToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.lista.length; i++) {
            sb.append(this.lista[i]);
            if (i < this.lista.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}