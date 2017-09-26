import java.util.*;
public class Factorialdemo 
{
	public static void main(String args[])
	{
		int n,fact=1;
		Scanner sc=new Scanner(System.in);
		System.out.print("enter a number:");
		n=sc.nextInt();
		for(int i=1;i<=n;i++)
			fact=fact*i;
		System.out.println("factorial of number:" +fact);
	}
}
