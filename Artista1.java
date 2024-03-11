class Artista {
    String nombre;
    String nacionalidad;

    public Artista(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return nombre + ", " + nacionalidad;
    }
}