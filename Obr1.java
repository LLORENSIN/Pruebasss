class Obra1 {
    String nombre;
    String tipo;
    double precio;
    int año;
    Artista artista;

    public Obra1(String nombre, String tipo, double precio, int año, Artista artista) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.año = año;
        this.artista = artista;
    }

    @Override
    public String toString() {
        return nombre + ", " + tipo + ", €" + precio + ", " + año + ", " + artista.nombre;
    }
}
