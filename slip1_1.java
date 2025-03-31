
class printchar implements  Runnable
{
         Thread t1;

            printchar()
            {
                                               
          t1 = new Thread(this);
           t1.start();
                              
            }

public void run()
            {
  char ch;
                        for(ch ='a'; ch<='z';ch++)
                        {
                             System.out.println(ch);
                                    try
                                    {
                                                Thread.sleep(2000);
                                    }
                                    catch(Exception  e)
                                    {
                                                
                                    }
                        }
            }
}
class slip1_1
{
           


            public static void main(String args[])
            {
                  printchar t5=new printchar();
            }   
}
