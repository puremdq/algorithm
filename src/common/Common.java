package common;

public class Common {


    private void common() {
    }

    public static int[] copyArray(int[] arr, int... args) {

        int start = 0;
        int end = arr.length - 1;
        if (args.length >= 2) {
            start = args[0];
            end = args[1];

        }
        int[] newArr = new int[end - start + 1];

        for (int i = start; i <= end; i++) {
            newArr[i - start] = arr[i];
        }
        return newArr;

    }

    public static int[] copyArray(int[] arr) {
        return copyArray(arr, 0, arr.length - 1);
    }

    public static void swap(int arr[], int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    //首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    //首字母转大写
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }


    public static void printArr(int[] arr) {
        System.out.println();
        System.out.println();
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + "  ");

            if (i % 20 == 0 && i != 0) {
                System.out.println();
            }
        }

    }

    public static boolean isArraySorted(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int getNumberInRange(int min, int max) {
        int sub = max - min;
        return (int) (Math.random() * sub + min);
    }

    public static int[] getArr(int min, int max, int length) {

        if (min > max) {
            return null;
        }

        int i;
        int[] resArr = new int[length];

        for (i = 0; i < length; i++) {
            resArr[i] = getNumberInRange(min, max);
        }
        return resArr;
    }
}
