import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    
    // Submit callable task and get Future
    Future<Integer> future = executor.submit(new CallableTask());
    
    try {
      // Get the result (blocks until task completes)
      Integer result = future.get();
      System.out.println("Result from callable: " + result);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    executor.shutdown();
  }
  
}


class CallableTask implements Callable<Integer>{
  public Integer call() {
    int sum=0;
    return sum+2;
  }
}