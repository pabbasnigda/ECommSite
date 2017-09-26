import java.util.Scanner;

public class Armstrong
{
	public static void main(String args[])
	{
		int n,c=0,a;
		int temp;
		Scanner sc =new Scanner(System.in);
		System.out.println("enter a number:");
		n=sc.nextInt();
		temp=n;
		while(n>0)
		{
			a=n%10;
			n=n/10;
			c=c+(a*a*a);
		}
		if(temp==c)
			System.out.println("armstrong number");
		else
			System.out.println("not a armstrong number");
	}
	
}
