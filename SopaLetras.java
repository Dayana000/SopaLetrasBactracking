public class SopaLetras {
    static int[] filas = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] columnas = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean buscarPalabraDesdePosicion(char[][] sopa, String palabra, int fila, int columna, int direccion, int index) {
        if (index == palabra.length()) {
            return true;
        }

        if (fila < 0 || fila >= sopa.length || columna < 0 || columna >= sopa[0].length ||
                Character.toLowerCase(sopa[fila][columna]) != Character.toLowerCase(palabra.charAt(index))) {
            return false;
        }

        char temp = sopa[fila][columna];
        sopa[fila][columna] = '#';

        boolean encontrada = buscarPalabraDesdePosicion(sopa, palabra, fila + filas[direccion], columna + columnas[direccion], direccion, index + 1);

        sopa[fila][columna] = temp;
        return encontrada;
    }

    public static boolean buscarEnDirecciones(char[][] sopa, String palabra, int fila, int columna, int direccion) {
        if (direccion >= 8) {
            return false;
        }

        if (buscarPalabraDesdePosicion(sopa, palabra, fila, columna, direccion, 0)) {
            return true;
        }

        return buscarEnDirecciones(sopa, palabra, fila, columna, direccion + 1);
    }

    public static void buscarEnSopaRecursivo(char[][] sopa, String palabra, int fila, int columna) {
        if (fila >= sopa.length) {
            System.out.println("La palabra \"" + palabra + "\" no fue encontrada.");
            return;
        }

        if (columna >= sopa[0].length) {
            buscarEnSopaRecursivo(sopa, palabra, fila + 1, 0); // Pasamos a la siguiente fila
            return;
        }

        if (buscarEnDirecciones(sopa, palabra, fila, columna, 0)) {
            System.out.println("La palabra \"" + palabra + "\" fue encontrada.");
            return;
        }

        buscarEnSopaRecursivo(sopa, palabra, fila, columna + 1);
    }

    public static void buscarEnSopa(char[][] sopa, String palabra) {
        buscarEnSopaRecursivo(sopa, palabra, 0, 0);
    }

    public static void buscarVariasPalabras(char[][] sopa, String[] palabras, int index) {
        if (index >= palabras.length) {
            return;
        }

        buscarEnSopa(sopa, palabras[index]);
        buscarVariasPalabras(sopa, palabras, index + 1);
    }
}