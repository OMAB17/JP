import java.util.*;
class Square extends Thread
{
 int x;
 Square(int n)
 {
 x = n;
 }
 public void run()
 {
 int sqr = x * x;
 System.out.println("Square of " + x + " = " + sqr );
 }
}
class Cube extends Thread
{
 int x;
 Cube(int n)
 {
 x = n;
 }
 public void run()
 {
 int cub = x * x * x;
 System.out.println("Cube of " + x + " = " + cub );
 }
}
class Number extends Thread
{
 public void run()
 {
 Random r1 = new Random();
 for(int i =0; i<10; i++)
 {
 int r = r1.nextInt(100);
 System.out.println("Random Integer generated : " + r);

  if(r%2==0)
{
 Square s = new Square(r);
 s.start();
}
else
{
 Cube c = new Cube(r);
 c.start();
}
 try {
 Thread.sleep(1000);

 } catch (InterruptedException ex)
 {
 System.out.println(ex);
}
 }
 }
}
class slip7_1 {
 public static void main(String args[])
 {
 Number n = new Number();
 n.start();
 }
}