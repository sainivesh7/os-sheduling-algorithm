import java.util.*;
class Sjf
{
	String p_id;
	int bur_time;
	Scanner sc=new Scanner(System.in);
	Sjf()
	{
	}
	Sjf(Sjf x)
	{
		p_id=x.p_id;
		bur_time=x.bur_time;
	}
	void read()
	{
		System.out.println("Enter the process id: ");
		p_id=sc.next();
		System.out.println("Enter process burst time: ");
		bur_time=sc.nextInt();
	}
	void disp()
	{
		System.out.println(p_id+" "+bur_time);
	}		
}
class SjfDemo
{
	public static void main(String[] args)
	{
		int i=0,j=0,et=0,s=0;
		Sjf t;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no.of process: ");
		int n=sc.nextInt();
		Sjf p[]=new Sjf[n];
		for(i=0;i<n;i++)
			p[i]=new Sjf();
		for(i=0;i<n;i++)
			p[i]=new Sjf();
		for(i=0;i<n;i++)
			p[i].read();
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(p[i].bur_time<p[j].bur_time)
				{
					t=new Sjf(p[i]);
					p[i]=new Sjf(p[j]);
					p[j]=new Sjf(t);
				}
			}
		}
		int a[]=new int[n];
		System.out.println("Process after sorting: ");
		for(i=0;i<n;i++)
			p[i].disp();
		for(i=0;i<n;i++)
		{
			et+=p[i].bur_time;
			a[i]=et;
		}
		for(i=0;i<(n-1);i++)
			s+=a[i];
		System.out.println(s/n);
	}
}