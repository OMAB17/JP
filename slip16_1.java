import java.util.*;
class slip16_1
{
   public static void main(String args[])
   {
    TreeSet t1=new TreeSet();
       Scanner s=new Scanner(System.in);
     System.out.println("Enter number of records");
      int n=s.nextInt();
System.out.println("Enter"+ n +"colors");
       for(int i=1;i<=n;i++)
       {
           String c=s.next();
           t1.add(c);
       }
  System.out.println("records of treeset is");
    Iterator i=t1.iterator();
        while(i.hasNext())
        {
              System.out.println(i.next());
        }  



   }


}