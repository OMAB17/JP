import java.util.*;
class slip17_1
{
   public static void main(String args[])
   {
    TreeSet t1=new TreeSet();
       Scanner s=new Scanner(System.in);
     System.out.println("Enter how many records");
      int n=s.nextInt();
System.out.println("Enter"+ n +"integers");
       for(int i=1;i<=n;i++)
       {
           
           int c=s.nextInt();
           t1.add(c);
       }
  System.out.println("records of treeset is"+t1);
    Iterator i=t1.iterator();
        while(i.hasNext())
        {
              System.out.println(i.next());
        }  



   }


}