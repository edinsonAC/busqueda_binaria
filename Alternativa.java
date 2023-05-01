import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Alternativa {
    public static List<int[]> generateArrays(int busqueda) {
        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            int size = getRandomNumber(2, 100);
            int[] array = generarListado(size);

            if (i < 15) {
                //inicio
                colocarEnPosicion(array, busqueda, 0);
            } else if (i >= 15 && i < 25) {
                //mitad
                colocarEnPosicion(array, busqueda, 1);
            } else if (i >= 25 && i < 40) {
                //final
                colocarEnPosicion(array, busqueda, 2);
            } else{
                //no esta
                reemplazarNumero(array, busqueda,1);
            }

            arrays.add(array);
        }

        for (int i = 0; i < 50; i++) {
            int size = getRandomNumber(1, 99); // Tamaño impar
            int[] array = generarListado(size);

            if (i < 15) {
                //inicio
                colocarEnPosicion(array, busqueda, 0);
            } else if (i >= 15 && i < 25) {
                //mitad
                colocarEnPosicion(array, busqueda, 1);
            } else if (i >= 25 && i < 40) {
                //final
                colocarEnPosicion(array, busqueda, 2);
            } else{
                //no esta
                reemplazarNumero(array, busqueda,1);
            }
            arrays.add(array);
        }

        return arrays;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int[] generarListado(int size) {
        int[] array = new int[size];
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int i = 0; i < size; i++) {
            array[i] = numbers.get(i);
        }

        return array;
    }

    public static void reemplazarNumero(int[] arreglo, int numeroBuscar, int numeroReemplazo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == numeroBuscar) {
                arreglo[i] = numeroReemplazo;
                break;
            }
        }
    }

    public static void colocarEnPosicion(int[] arreglo, int numero, int cas) {
        int mitad = arreglo.length / 2;
        int fin = arreglo.length - 1;
        int posicion = 0;

        boolean numeroRepetido = false;
        int posicionNumeroRepetido = -1;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == numero) {
                numeroRepetido = true;
                posicionNumeroRepetido = i;
                break;
            }
        }

        if (cas == 1) {
            posicion = mitad;
        } else if (cas == 2) {
            posicion = fin;
        }

        if (numeroRepetido) {
            int temp = arreglo[posicion];
            arreglo[posicion] = numero;
            arreglo[posicionNumeroRepetido] = temp;
        } else {
            arreglo[posicion] = numero;
        }
    }

    public static void main(String[] args) {
        List<int[]> arrays = generateArrays();
        for (int[] array : arrays) {
            System.out.println("Array: " + arrayToString(array));
        }
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
