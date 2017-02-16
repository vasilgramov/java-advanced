import java.util.Scanner;

public class p05_transactions {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Runnable taks = () -> {
            for (int i = 0; i < 100; i++) {
                account.add(1);
                Thread.yield();
            }
        };

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(taks);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(account.getBalance());
    }

    static class Account {
        private int balance;

        public Account() {
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        // safe / unsafe
        /*synchronized*/ public void add(int amount) {
            balance = balance + amount;
        }
    }
}