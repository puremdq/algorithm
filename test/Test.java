import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        int[] arr = null;
        int[] arr1 = {1, 2, 3};
        arr = arr1;

        arr1[0]=6;
        System.out.println(arr[0]);

    }


}