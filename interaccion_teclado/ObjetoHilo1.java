
import javax.swing.*;

class ObjetoHilo1 implements Runnable{
	JButton btn2;

	public ObjetoHilo1(JButton btn2)
	{
		this.btn2 = btn2;
	}

	@Override
	public void run()
	{
		while(true)
		{
			//System.out.println("Hola, soy un proceso paralelo");

			for (int x=0; x<400; x=x+5) 
			{
				this.btn2.setLocation(x,400);
				retardo(100);
			}

			for (int x=400; x>-1; x=x-5) 
			{
				this.btn2.setLocation(x,400);
				retardo(100);
			}


		}

	}

	public void retardo(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}catch(Exception e){
			System.out.println("Error: al ejecuar el sleep.");
		}

	}
	
}