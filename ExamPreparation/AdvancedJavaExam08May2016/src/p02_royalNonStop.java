import java.math.BigDecimal;
import java.util.Scanner;

public class p02_royalNonStop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] matrixArgs = in.nextLine().trim().split("\\s+");
        int rows = Integer.parseInt(matrixArgs[0]);
        int cols = Integer.parseInt(matrixArgs[1]);

        String[] productsPrice = in.nextLine().trim().split("\\s+");
        BigDecimal lukanka = new BigDecimal(productsPrice[0]);
        BigDecimal rakiya = new BigDecimal(productsPrice[1]);

        BigDecimal total = BigDecimal.ZERO;
        int customerCount = 0;

        String command = in.nextLine();
        while (!"Royal Close".equals(command)) {
            String[] customerArgs = command.trim().split("\\s+");
            int customerRow = Integer.parseInt(customerArgs[0]);
            int customerCol = Integer.parseInt(customerArgs[1]);

            BigDecimal currentCustomer = BigDecimal.ZERO;

            if (customerRow >= customerCol) {
                for (int i = 0; i <= customerCol; i++) {
                    BigDecimal currentCol = new BigDecimal(Integer.toString(i + 1));
                    BigDecimal currentRow = new BigDecimal(Integer.toString(customerRow + 1));

                    if (customerRow % 2 == 0)
                        currentCustomer = currentCustomer.add(currentCol.multiply(currentRow).multiply(lukanka));
                    else
                        currentCustomer = currentCustomer.add(currentCol.multiply(currentRow).multiply(rakiya));
                }


                for (int i = 1; i < customerRow; i++) {
                    BigDecimal currentRow = new BigDecimal(Integer.toString(i + 1));

                    if (i % 2 == 0)
                        currentCustomer = currentCustomer.add(currentRow.multiply(lukanka));
                    else
                        currentCustomer = currentCustomer.add(currentRow.multiply(rakiya));
                }
            } else {
                for (int i = 1; i <= customerCol; i++) {
                    BigDecimal currentCol = new BigDecimal(Integer.toString(i + 1));

                    currentCustomer = currentCustomer.add(currentCol.multiply(lukanka));
                }

                for (int i = 1; i <= customerRow; i++) {
                    BigDecimal currentRow = new BigDecimal(Integer.toString(i + 1));
                    BigDecimal currentCol = new BigDecimal(Integer.toString(customerCol + 1));

                    if (i % 2 == 0)
                        currentCustomer = currentCustomer.add(currentRow.multiply(currentCol).multiply(lukanka));
                    else
                        currentCustomer = currentCustomer.add(currentRow.multiply(currentCol).multiply(rakiya));
                }
            }


            total = total.add(currentCustomer);
            customerCount++;

            command = in.nextLine();
        }

        System.out.println(total.setScale(6, BigDecimal.ROUND_HALF_EVEN));
        System.out.println(customerCount);
    }
}
