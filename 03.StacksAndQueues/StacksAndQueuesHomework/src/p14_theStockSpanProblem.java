import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class p14_theStockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] price = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.addFirst(0);

        int[] S = new int[n];
        S[0] = 1;
        System.out.println(S[0]);
        if (n == 1)
            return;

        StringBuilder output = new StringBuilder();
        price[0] = Integer.parseInt(reader.readLine());
        for (int i = 1; i < n; i++) {
            price[i] = Integer.parseInt(reader.readLine());

            while (st.size() != 0 && price[st.peekFirst()] <= price[i])
                st.removeFirst();

            S[i] = (st.size() == 0) ? i + 1 : i - st.peekFirst();

            st.addFirst(i);

            output.append(S[i] + "\n");
        }

        System.out.println(output);
    }
}