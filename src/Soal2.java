public class Soal2 {
    public static void main(String[] args) {
        Integer n = 5;

        System.out.println("Soal 2A:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println();

        // b. pattern
        System.out.println("Soal 2B:");
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();

        // c. pattern
        System.out.println("Soal 2C:");
        for (int i = 1; i <= n; i++) {
            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                num++;
            }
            System.out.println();
        }


        System.out.println();

        // d. pattern
        System.out.println("Soal 2D:");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((i + j * n) + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}