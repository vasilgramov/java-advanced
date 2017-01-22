import java.util.ArrayDeque;
import java.util.Scanner;

public class p14_theStockSpanProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] price = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.addFirst(0);

        int[] S = new int[n];
        S[0] = 1;
        System.out.println(S[0]);
        if (n == 1)
            return;

        price[0] = Integer.parseInt(in.nextLine());
        for (int i = 1; i < n; i++) {
            price[i] = Integer.parseInt(in.nextLine());

            while (st.size() != 0 && price[st.peekFirst()] <= price[i])
                st.removeFirst();

            S[i] = (st.size() == 0) ? i + 1 : i - st.peekFirst();

            st.addFirst(i);

            System.out.println(S[i]);
        }
    }
}