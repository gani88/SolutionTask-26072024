import java.util.Arrays;

public class Soal3 {
    public static void main(String[] args) {
        int[] numList = {12, 9, 13, 6, 10, 4, 7, 2};

        numList = Arrays.stream(numList).filter(i -> i % 3 != 0).toArray();
        Arrays.sort(numList);
        System.out.print("n = [");
        for (int i = 0; i < numList.length; i++) {
            System.out.print(numList[i]);
            if (i < numList.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
