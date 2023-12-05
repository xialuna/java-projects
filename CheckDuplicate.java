import java.util.Scanner;
public class CheckDuplicate {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter size of array: ");
    int n = scanner.nextInt();

    int[] array = new int[n];
    System.out.println("Enter the elements:");

    for (int i = 0; i < n; i++) {
        System.out.print("Element " + (i + 1) + " : ");
        array[i] = scanner.nextInt();
    }

    int[] duplicates = findAndRemoveDuplicates(array);

    System.out.print("\nDuplicate elements in the array: ");
    for (int value : duplicates) {
        if (value != 0) {
            System.out.print(value + "   ");
        }
    }
    scanner.close();
}

private static int[] findAndRemoveDuplicates(int[] array) {
    int[] duplicates = new int[array.length];
    int duplicateCount = 0;

    for (int i = 0; i < array.length - 1; i++) {
        for (int j = i + 1; j < array.length; j++) {
            if (array[i] == array[j]) {
                if (!contains(duplicates, array[i])) {
                    duplicates[duplicateCount++] = array[i];
                }

                // Remove the duplicate from the array
                array[j] = array[array.length - 1];
                array = resizeArray(array, array.length - 1);
                j--;
            }
        }
    }

    return duplicates;
}

private static boolean contains(int[] array, int value) {
    for (int i : array) {
        if (i == value) {
            return true;
        }
    }
    return false;
}

private static int[] resizeArray(int[] array, int newSize) {
    int[] newArray = new int[newSize];
    System.arraycopy(array, 0, newArray, 0, newSize);
    return newArray;

    }
}