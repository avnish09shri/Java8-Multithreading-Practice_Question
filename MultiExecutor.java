import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    // Add any necessary member variables here
    private final List<Runnable> tasks;
    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        this.tasks=tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        List<Thread> threads=new ArrayList<>(tasks.size());
        for(Runnable task: tasks){
            Thread thread=new Thread(task);
            threads.add(thread);
        }
        // complete your code here
        for(Thread thread: threads){
            thread.start();
        }
    }
}
