public class p02_multiThread {

    public static void main(String[] args) throws InterruptedException /*throws InterruptedException*/ {
        Runnable taks = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.printf("[%d] ", i);
            }
        };

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(taks);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
