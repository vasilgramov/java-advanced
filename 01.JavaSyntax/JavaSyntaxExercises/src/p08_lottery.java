public class p08_lottery {
    static int[] combinations = new int[3];
    public static void main(String[] args) {
        printAllCombinations(0, 1);
    }

    private static void printAllCombinations(int index, int startNum) {
        if (index == 3) {
            System.out.printf("%d %d %d\n", combinations[0], combinations[1], combinations[2]);
            return;
        }

        for (int j = startNum; j <= 10 ; j++) {
            combinations[index] = j;
            printAllCombinations(index + 1,  j + 1);
        }
    }
}
