package sort;

public class ShellSort {

    public static void shellSort(int[] arr) {

        int d = arr.length;
        int start;

        do {

            d = d / 3;
            d = d > 1 ? d : 1;

            for (start = 0; start < d; start++) {
                InsertSort.betterInsertSort(arr, start, d);
            }

        } while (d > 1);

    }
}
