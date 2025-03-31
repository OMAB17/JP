import java.util.*;
public class slip2_1
{
   public static void main(String args[]) 
{
      Set  h = new HashSet();
      h.add("sagar");
      h.add("amit");
      h.add("vivek");
      h.add("archan");
      h.add("tanmay");
      h.add("aditya");
      System.out.println("HashSet elements "+ h);
      Set t= new TreeSet(h);
      System.out.println("Sorted elements"+ t);
   }
}