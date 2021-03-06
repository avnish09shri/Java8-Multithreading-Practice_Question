public class InterruptingThread {
    public static void main(String[] args){
        Thread t=new Thread(new BlockingTask());
        t.start();
        t.interrupt();
    }
    private static class BlockingTask implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Exiting Blocking Thread");
            }
        }
    }
}
