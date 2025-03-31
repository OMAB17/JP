class MyThread extends Thread {
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.setName("Custom-Thread");
        thread1.setPriority(Thread.MAX_PRIORITY); // Setting priority to 10
        
        thread1.start();
    }
}