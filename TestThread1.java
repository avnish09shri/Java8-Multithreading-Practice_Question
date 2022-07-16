public class TestThread1 extends Thread{

    public static void main(String[] args){
        Thread thread=new ExampleThread();
        thread.start();
    }


}

class ExampleThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from "+this.getName());
    }
}
