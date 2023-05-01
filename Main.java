import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<TestCase> testCases = Pruebas.generateArraysOrdenado();

        for (TestCase testCase : testCases) {
            BusquedaBinaria solution = new BusquedaBinaria();
            int result = solution.busquedaBinaria(testCase.getLista(), testCase.getBusqueda());
            testCase.setPos(result);
            System.out.println(testCase.toString());
        }

        // Listas desordenadas

        // List<int[]> testCases = Pruebas.generateArraysDesorden(8);

        // for (int[] testCase : testCases) {
        // System.out.println(Pruebas.arrayToString(testCase));

        // BusquedaBinaria solution = new BusquedaBinaria();
        // int result = solution.busquedaBinaria(testCase, 8);

        // if (result == -1) {
        // System.out.println("objetivo no encontrado en la matriz");
        // } else {
        // System.out
        // .println(
        // "El objetivo se encuentra en la posicion: " + result + " longitud: " +
        // testCase.length);
        // }
        // }
    }

}
