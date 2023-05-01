import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TestCase> testCases = Pruebas.generarCasosPrueba();

        for (TestCase testCase : testCases) {
            int[] nums = generateSortedArray(testCase.getLongitud());
            int target = nums[testCase.getBusqueda()];
            
            BusquedaBinaria solution = new BusquedaBinaria();
            int result = solution.busquedaBinaria(nums, target);
            
            if (result == -1 && testCase.getExiste()) {
                System.out.println("Prueba fallida: objetivo no encontrado en la matriz");
            } else if (result != -1 && !testCase.getExiste()) {
                System.out.println("Prueba fallida: se encontró el objetivo en la matriz, pero se esperaba que estuviera ausente");
            } else if (result != testCase.getBusqueda()) {
                System.out.println("Test failed: Incorrect index returned for target");
            } else {
                System.out.println("Test passed");
            }
        }
    }

    public static int[] generateSortedArray(int size) {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }
        return nums;
    }
}
