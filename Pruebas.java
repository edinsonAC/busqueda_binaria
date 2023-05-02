import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Pruebas {

    public static List<TestCase> generateArraysOrdenado() {
        List<TestCase> arrays = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int size = i < 50 ? getRandomNumber(2, 100) : getRandomNumber(1, 99);
            int[] array = generarListado(size, true);

            TestCase temp = new TestCase();

            if (i < 30) {
                // inicio
                temp = new TestCase(size, array[0], array, -1);
            } else if (i >= 30 && i < 50) {
                // mitad
                int mitad = size / 2;
                temp = new TestCase(size, array[mitad], array, -1);
            } else if (i >= 50 && i < 80) {
                // final
                temp = new TestCase(size, array[size - 1], array, -1);
            } else {
                // no esta
                temp = new TestCase(size, size + 1, array, -1);
            }

            arrays.add(temp);
        }

        return arrays;
    }

    public static List<int[]> generateArraysDesorden(int busqueda) {
        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int size = i < 50 ? getRandomNumber(2, 100) : getRandomNumber(1, 99);
            int[] array = generarListado(size, false);

            if (i < 30) {
                // inicio
                colocarEnPosicion(array, busqueda, 0);
            } else if (i >= 30 && i < 50) {
                // mitad
                colocarEnPosicion(array, busqueda, 1);
            } else if (i >= 50 && i < 80) {
                // final
                colocarEnPosicion(array, busqueda, 2);
            } else {
                // no esta
                reemplazarNumero(array, busqueda, 1);
            }

            arrays.add(array);
        }

        return arrays;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int[] generarListado(int size, boolean order) {
        int[] array = new int[size];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        if (!order)
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
        List<int[]> arrays = generateArraysDesorden(8);
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
