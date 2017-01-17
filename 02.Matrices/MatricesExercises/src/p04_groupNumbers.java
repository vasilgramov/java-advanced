import java.util.ArrayList;
import java.util.Scanner;

public class p04_groupNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> remainderByThree = new ArrayList<>(3);
        String[] numsAsStr = in.nextLine().split(",\\s+");

        remainderByThree.add(0, new ArrayList<>());
        remainderByThree.add(1, new ArrayList<>());
        remainderByThree.add(2, new ArrayList<>());

        for (int i = 0; i < numsAsStr.length; i++) {
            int num = Integer.parseInt(numsAsStr[i]);

            remainderByThree.get(Math.abs(num % 3)).add(num);
        }

        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> arrayList = remainderByThree.get(i);

            for (int j = 0; j < arrayList.size(); j++) {
                System.out.print(arrayList.get(j) + " ");
            }

            System.out.println();
        }
    }
}
