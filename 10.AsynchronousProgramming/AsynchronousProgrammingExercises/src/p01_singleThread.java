public class p01_singleThread {

    public static void main(String[] args) throws InterruptedException {
        Runnable taks = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " ");
            }
        };

        Thread thread = new Thread(taks);
        thread.start();

        thread.join();
    }
}
