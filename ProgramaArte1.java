import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class ProgramaArte {
    static ArrayList<Artista> artistas = new ArrayList<>();
    static ArrayList<Obra1> obras = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }
    static void menu() {
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Añadir obra");
            System.out.println("2. Añadir artista");
            System.out.println("3. Buscar obra por nombre");
            System.out.println("4. Buscar obras por artista");
            System.out.println("5. Eliminar obra");
            System.out.println("6. Encontrar obra más barata");
            System.out.println("7. Encontrar obra más moderna");
            System.out.println("8. Imprimir artistas");
            System.out.println("9. Imprimir Obras");
            System.out.println("10. Salir");


            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    añadirObra();
                    break;
                case 2:
                    añadirArtista();
                    break;
                case 3:
                    buscarObraPorNombre();
                    break;
                case 4:
                    buscarObrasPorArtista();
                    break;
                case 5:
                    eliminarObra();
                    break;
                case 6:
                    encontrarObraMasBarata();
                    break;
                case 7:
                    encontrarObraMasModerna();
                    break;
                case 8:
                    printArtistas();
                    break;
                case 9:
                    printObras();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
    static void añadirObra() {
        System.out.println("Introduce el nombre de la obra:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el tipo de obra:");
        String tipo = scanner.nextLine();
        System.out.println("Introduce el precio de la obra:");
        double precio = scanner.nextDouble();
        System.out.println("Introduce el año de realización de la obra:");
        int año = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce el nombre del artista:");
        String nombreArtista = scanner.nextLine();
        Artista artista = buscarArtista(nombreArtista);
        if (artista == null) {
            System.out.println("Artista no encontrado. Debes añadirlo primero.");
            return;
        }

        obras.add(new Obra1(nombre, tipo, precio, año, artista));
        System.out.println("Obra añadida con éxito.");
    }

    static void añadirArtista() {
        System.out.println("Introduce el nombre del artista:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la nacionalidad del artista:");
        String nacionalidad = scanner.nextLine();

        artistas.add(new Artista(nombre, nacionalidad));
        System.out.println("Artista añadido con éxito.");
    }

    static void buscarObraPorNombre() {
        System.out.println("Introduce el nombre de la obra a buscar: ");
        String nombre = scanner.nextLine();

        boolean encontrada = false;
        for (Obra1 obra : obras) {
            if (obra.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Obra encontrada: " + obra);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("Obra no encontrada.");
        }
    }

    static void buscarObrasPorArtista() {
        System.out.println("Introduce el nombre del artista:");
        String nombreArtista = scanner.nextLine();

        boolean encontrada = false;
        for (Obra1 obra : obras) {
            if (obra.artista.nombre.equalsIgnoreCase(nombreArtista)) {
                System.out.println(obra);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontraron obras para el artista especificado.");
        }
    }

    static void eliminarObra() {
        System.out.println("Introduce el nombre de la obra a eliminar:");
        String nombre = scanner.nextLine();

        for (int i = 0; i < obras.size(); i++) {
            if (obras.get(i).nombre.equalsIgnoreCase(nombre)) {
                obras.remove(i);
                System.out.println("Obra eliminada con éxito.");
                return;
            }
        }
        System.out.println("Obra no encontrada.");
    }

    static void encontrarObraMasBarata() {
        if (obras.isEmpty()) {
            System.out.println("No hay obras disponibles.");
            return;
        }

        Obra1 obraMasBarata = obras.get(0);
        for (Obra1 obra : obras) {
            if (obra.precio < obraMasBarata.precio) {
                obraMasBarata = obra;
            }
        }
        System.out.println("La obra más barata es: " + obraMasBarata);
    }

    static void encontrarObraMasModerna() {
        if (obras.isEmpty()) {
            System.out.println("No hay obras disponibles.");
            return;
        }

        Obra1 obraMasModerna = obras.get(0);
        for (Obra1 obra : obras) {
            if (obra.año > obraMasModerna.año) {
                obraMasModerna = obra;
            }
        }
        System.out.println("La obra más moderna es: " + obraMasModerna);
    }

    static Artista buscarArtista(String nombre) {
        for (Artista artista : artistas) {
            if (artista.nombre.equalsIgnoreCase(nombre)) {
                return artista;
            }
        }
        return null;
    }
    private static void printArtistas() {
        System.out.println("Lista de artistas:");
        ListIterator<Artista> iterator = artistas.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    private static void printObras() {
        System.out.println("Lista de obras:");
        ListIterator<Obra1> iterator = obras.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


