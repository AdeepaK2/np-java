class Ways {
  public static void main(String[] args) {
    MyThread t1=new MyThread();
    MyThread t2=new MyThread();
    t1.start();
    t2.start();


    // Using Runnable interface
    Thread t3=new Thread(new MyRunnable());
    Thread t4=new Thread(new MyRunnable());
    t4.start();
    t3.start();

    //using anonymous class
    Thread t5=new Thread(new Runnable(){
      public void run(){
        System.out.println("Thread using Anonymous class is running...");
      }
    });
    t5.start();

    //using lambda expression
    Thread t6=new Thread(()->{
      System.out.println("Thread using Lambda expression is running...");
    });
    t6.start();

  }
}

class MyThread extends Thread{
  public void run(){
    System.out.println("Thread using Thread class is running...");
  }
}

class MyRunnable implements Runnable{
  public void run(){
    System.out.println("Thread using Runnable interface is running...");
  }
}

