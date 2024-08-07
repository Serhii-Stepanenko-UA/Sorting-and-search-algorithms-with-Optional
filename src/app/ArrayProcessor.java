package app;

import java.util.Arrays;
import java.util.Optional;

public class ArrayProcessor {

    // Метод для швидкого сортування масиву
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length -1);
    }

    // Рекурсивний метод швидкого сортування
    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex -1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    // Метод для розбиття масиву навколо опорного елемента
    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                // Обмін елементів
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Обмін pivot з елементом, що розташований після всіх менших за pivot
        int temp = array[i +1];
        array[i +1] = array[right];
        array[right] = temp;
        return i + 1;
    }

    // Метод для лінійного пошуку в Optional масиві
    public static Optional<Integer> linearSearch(int[] array, int target) {
        // Перебирння кожного елементу масиву
        for (int i = 0; i < array.length; i++) {
            // Порівняння поточного елемента з цільвим значеням
            if (array[i] == target) {
                // Елемент знайдено, поверненя першого знайденого індекса елемента, створення Optional
                return Optional.of(i);
            }
        }
        // Елемент не знайдено, повернення -1, створення Optional
        return Optional.of(-1);
    }

    public static void main(String[] args) {
        // Створення масиву, виведення не сортованого
        int[] array = {9, 3, 7, 1, 5, 2, 8, 4, 6};
        System.out.println("Масив перед сортуванням: " + Arrays.toString(array));

        // Сортування масиву, виведення
        quickSort(array);
        System.out.println("Відсортований масив: " + Arrays.toString(array));

        // Пошук елемента у відсортованому масиві, виведення результату
        int target = 5;
        Optional<Integer> result = linearSearch(array, target);
        if (result.isPresent()) {
            System.out.println("Елемент " + target + " знайдено на позиції " + result.get());
        } else {
            System.out.println("Елемент " + target + " не знайдено у масиві");
        }
    }
}