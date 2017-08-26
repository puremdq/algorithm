package common;

import sort.QuickSort;

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
        printArr(arr, 0, arr.length - 1);

    }


    /*打印一个数组*/
    public static void printArr(int[] arr, int start, int end) {

        if (start > end) {
            return;
        }

        System.out.println("\n--------------------start print arr------------------------");

        for (int i = start; i <= end; i++) {

            System.out.print(arr[i] + "  ");
            if ((i - start) % 20 == 0 && i != 0) {
                System.out.println();
            }
        }

        System.out.println("\n--------------------print arr end------------------------");
    }

    /*判断数组是否从小到大排列有序*/
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


    /**
     * 根据指定的最大值 最小值 和长度 生成一个随机的数组
     */
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


    /**
     * 生成一个几乎有序的数组(只交换几个元素)
     *
     * @param length  给定数组的长度
     * @param swapNum 要交换的个数
     */
    public static int[] getNearlyOrderly(int length, int swapNum) {


        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {

            arr[i] = i;
        }

        for (int j = 0; j < swapNum; j++) {
            Common.swap(arr, Common.getNumberInRange(0, length - 1), Common.getNumberInRange(0, length - 1));
        }
        return arr;
    }


    /**
     * 返回 a b中较小的一个
     */
    public static int getMin(int a, int b) {

        return a < b ? a : b;

    }
}
