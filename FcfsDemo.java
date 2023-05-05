import java.util.*;
class Fcfs
{
	String p_id;
	int arr_time;
	int bur_time;
	Scanner sc=new Scanner(System.in);
	Fcfs()
	{
	}
	Fcfs(Fcfs x)
	{
		p_id=x.p_id;
		arr_time=x.arr_time;
		bur_time=x.bur_time;
	}
	void read()
	{
		System.out.println("Enter the process id: ");
		p_id=sc.next();
		System.out.println("Enter process arrival time: ");
		arr_time=sc.nextInt();
		System.out.println("Enter process burst time: ");
		bur_time=sc.nextInt();
	}
	void disp()
	{
		System.out.println(p_id+" "+arr_time+" "+bur_time);
	}
	
		
}
class FcfsDemo
{
	public static void main(String[] args)
	{
		int i=0,j=0,s1=0,s2=0,f1=0,f2=0;
		int et=0,tt=0,wt=0;
		Fcfs t;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no.of process: ");
		int n=sc.nextInt();
		Fcfs p[]=new Fcfs[n];
		for(i=0;i<n;i++)
			p[i]=new Fcfs();
		for(i=0;i<n;i++)
			p[i]=new Fcfs();
		for(i=0;i<n;i++)
			p[i].read();
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(p[i].arr_time<p[j].arr_time)
				{
					t=new Fcfs(p[i]);
					p[i]=new Fcfs(p[j]);
					p[j]=new Fcfs(t);
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
		for(i=0;i<n;i++)
			System.out.println(a[i]);
		int b[]=new int[n];
		for(i=0;i<n;i++)
		{
			tt=a[i]-p[i].arr_time;
			b[i]=tt;
		}
		for(i=0;i<n;i++)
			System.out.println(b[i]);
		System.out.println("----------------------");
		for(i=0;i<n;i++)
			s1+=b[i];
		f1=s1/n;
		System.out.println("average turn around time is "+f1);
		int c[]=new int[n];
		for(i=0;i<n;i++)
		{
			wt=b[i]-p[i].bur_time;
			c[i]=wt;
		}
		
		for(i=0;i<n;i++)
			s2+=c[i];
		f2=s2/n;
		System.out.println("average waiting time is "+f2);
		System.out.println("----------------------");
		for(i=0;i<n;i++)
			System.out.println(c[i]);
	}
}
