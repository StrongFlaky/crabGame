package myAPComputerClass;
import java.util.Scanner;
public class crap {
	public static int rollDice(int x)
	{
		int result=0;
		for(int i=1; i<=x; i++)
		{
			result=result+ (int)(Math.random()*6);
		}
		return result;
	}
	public static void main (String args[]) throws InterruptedException
	{
		rollDice(2);
		int money=(int)(Math.random()*10000);
		System.out.println("What is your name?");
		Scanner identity=new Scanner(System.in);
		String name=identity.nextLine();
		System.out.println("Welcome to Crap Games, "+name);
		Thread.sleep(1000);
		while(money>0)
		{
			System.out.println("Currently you possess "+money+" dollars, your goal is to rise your money up to 50000 to win the game, and if your money drop to 0, you lose.");
			Thread.sleep(1000);
			System.out.println("Now enter the amount of money you want to bet to start the roll, remember, think carefully before entering.");
			int now=identity.nextInt();
			if(now>money||now<0)
			{
				System.out.println("Are you seriously about this "+name+"? You are not allowed to play anymore.");
				break;
			}
			else
			{
				int sum=rollDice(2);
				if(sum==2||sum==12)
				{	
					System.out.println("You got "+sum+". Ops, "+name+", you lose, and your money dropped to "+(money-now)+" dollars");
					Thread.sleep(1000);
					money=money-now;
				}
				else if(sum==7||sum==11)
				{
					System.out.println("You got "+sum+". Ah hah, "+name+" you win, and your money now is: "+(money+now)+" dollars");
					Thread.sleep(1000);
					money=money+now;
				}
				else
				{
					System.out.println("You got "+sum+". Well, now that is your current point");
					Thread.sleep(1000);
					boolean win=false;
					while(win==false)
					{
						int result=rollDice(2);
						if(result==7)
						{
							System.out.println("You got... "+result+"!!! Oh no,  you lose, and your money dropped to "+(money-now)+" dollars");
							Thread.sleep(1000);
							money=money-now;
							break;
						}
						else if(result==sum)
						{
							System.out.println("You got... "+result+"!!! Nice, you win, and your money now is: "+(money+now)+" dollars");
							money=money+now;
							Thread.sleep(1000);
							break;
						}
						else
						{
							System.out.println("You simply got "+result+". And now you need to keep rolling");
							Thread.sleep(1000);
						}
					}
				}
			}
			if(money==0)
			{
				System.out.println("You have no moeny, and you lose.");
				break;
			}
			else if(money>=50000)
			{
				System.out.println("You have achieved the goal and you win");
			}
		}
	}
}