class demothread implements Runnable
{
    int n;
String msg;
    demothread(String m,int i)
    {
      msg=m;
   n=i;
Thread t=new Thread(this,msg);
t.start();
   }
public void run()
{
   try
    {
    for(int i=1;i<=n;i++)
     {
   System.out.println(msg);
Thread.sleep(500);
     }
   }catch(InterruptedException e){}
}
    
}
class slip81
{
   public static void main(String args[])
    {
           new demothread("COVID19",10);
 new demothread("LOCKDOWN2020",20);
 new demothread("VACCINATED2021",30);
     }

}
