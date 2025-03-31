import java.util.*;
class slip21_1
{
   public static void main(String args[])
   {
    LinkedList l1=new LinkedList();
       Scanner s=new Scanner(System.in);
     System.out.println("Enter how many records");
      int n=s.nextInt();
System.out.println("Enter"+ n +"subject name");
       for(int i=1;i<=n;i++)
       {       
           String c=s.next();
           l1.add(c);
       }
  System.out.println("records of linkledlist is");
    Iterator i=l1.iterator();
        while(i.hasNext())
        {
              System.out.println(i.next());
        } 
   }
}