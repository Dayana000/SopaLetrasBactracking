   public class MainApp {
        public static void main(String[] args) {
            char[][] sopa = {
                    {'C', 'A', 'M', 'I', 'N', 'O', 'H'},
                    {'P', 'E', 'R', 'R', 'E', 'A', 'T'},
                    {'Z', 'A', 'P', 'T', 'M', 'O', 'L'},
                    {'H', 'A', 'M', 'S', 'O', 'I', 'A'},
                    {'S', 'A', 'T', 'O', 'T', 'O', 'P'},
                    {'A', 'E', 'A', 'P', 'I', 'Z', 'I'},
                    {'R', 'Z', 'A', 'P', 'A', 'T', 'O'}
            };

            String[] palabras = {"camino", "perro", "hamster", "zapato", "foto", "lapiz"};

            for (String palabra : palabras) {
                SopaLetras.buscarEnSopa(sopa, palabra);
            }
        }
    }


