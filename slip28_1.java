class MyThread extends Thread {
    public void run() {
        System.out.println("Currently executing thread: " + Thread.currentThread().getName());
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            MyThread thread = new MyThread();
            thread.setName("Thread-" + i);
            thread.start();
        }
    }
}