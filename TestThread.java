public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //System.out.println("We are now in thread "+Thread.currentThread().getName());
                //System.out.print("Current thread priority "+Thread.currentThread().getPriority());

                throw new RuntimeException("Intentional Exception");
            }
        });


        thread.setName("New Worker thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened: "+t.getName()+
                        " the error is: "+e.getMessage());
            }
        });

        thread.setPriority(Thread.MAX_PRIORITY);

        //System.out.println("We are in thread: "+ Thread.currentThread().getName() + " before starting" +
                //"a new thread");
        thread.start();
        //System.out.println("We are in thread: "+ Thread.currentThread().getName() + " after starting" +
                //"a new thread");

        Thread.sleep(10000);
    }
}
