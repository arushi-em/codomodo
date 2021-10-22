import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
class remmax
{  public static void main (String[] args)
   {  Scanner sc=new Scanner(System.in);
	  System.out.println("enter t");
       int T=sc.nextInt();
	  if((T>=1) && (T<=100))
	  {for(int i=1;i<=T;i++)
	  {  System.out.println("enter n");
	      long n=sc.nextLong();
	     long max=0;
	     if(n<=11)
	     {  System.out.println(n);
	        continue;
	     }
	     else
	     {  while(n>0)
	        {  long num=n;
	           long rev=0;
	           for(long j=num;j>0;j/=10)
	           {  rev=rev*10+(j%10);
	           }
	           if(rev>max)
	              max=rev;
	           n--;
	        }
	        System.out.println(max);
	     }
	  }
	  }
   }
}
