import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pruebas {
    public static List<TestCase> generarCasosPrueba() {
        List<TestCase> casosPruebas = new ArrayList<>();

        // Generar la mitad de los casos con tamano par y la otra mitad con tamaño impar
        int casosPar = 50;
        int casosImpar = 50;

        for (int i = 0; i < casosPar; i++) {
            int size = getRandomNumber(2, 100); // Tamano par
            int targetIndex = getRandomNumber(0, size - 1);
            boolean targetPresent = getRandomBoolean();
            casosPruebas.add(new TestCase(size, targetIndex, targetPresent));
        }

        for (int i = 0; i < casosImpar; i++) {
            int size = getRandomNumber(1, 99); // Tamano impar
            int targetIndex = getRandomNumber(0, size - 1);
            boolean targetPresent = getRandomBoolean();
            casosPruebas.add(new TestCase(size, targetIndex, targetPresent));
        }

        casosPruebas.add(new TestCase(10, 4, false)); // No esta el elemento
        casosPruebas.add(new TestCase(11, 5, true)); // Esta en la mitad
        casosPruebas.add(new TestCase(8, 0, true)); // Esta al inicio
        casosPruebas.add(new TestCase(9, 8, true)); // Esta al final

        return casosPruebas;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static void main(String[] args) {
        List<TestCase> testCases = generarCasosPrueba();
        System.out.println("El total de pruebas son " + testCases.size());
        for (TestCase testCase : testCases) {
            System.out.println(testCase);
        }
    }
}
