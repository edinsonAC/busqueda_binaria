
class TestCase {
    private int longitud;
    private int busqueda;
    private boolean existe;

    public TestCase(int l, int b, boolean e) {
        this.longitud = l;
        this.busqueda = b;
        this.existe = e;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getBusqueda() {
        return busqueda;
    }

    public boolean getExiste() {
        return existe;
    }

    @Override
    public String toString() {
        return "Longitud: " + longitud + ", Busqueda: " + busqueda + ",  Existe: " + existe;
    }
}
