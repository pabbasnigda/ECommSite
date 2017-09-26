
public class Fibonacciseries 
{
	public static void main(String args[])
	{
		int count=13;
		int fib[]=new int[count];
		fib[0]=0;
		fib[1]=1;
		
		//calculating the series
		for(int i=2;i<count;i++){
			fib[i]=fib[i-1]+fib[i-2];}
		
		//display the series
		for(int i : fib){
		System.out.print("\t" +i);}
	}
}
