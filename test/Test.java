public class Test {

    public static void main(String[] args) {
        int[] a = new int[2];
        int[] b = new int[2];
        a[0] = a[1] = 2;
        b = a;
        a[0] = 0;

        System.out.println(b[0]);
    }

    public static void test(String arg, String... args) {
        System.out.println(arg);
        System.out.println("----------------");
        for (String s : args) {
            System.out.println(s);
        }

        System.out.println("----------------我是分割线----------------");
    }
}