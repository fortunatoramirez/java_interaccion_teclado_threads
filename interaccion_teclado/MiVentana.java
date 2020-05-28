import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class MiVentana extends JFrame implements KeyListener{

	JPanel panel;
	JButton btn1;
	JButton btn2;
	Thread hilo1;

	public MiVentana()
	{
		panel = new JPanel();
		panel.setLayout(null);
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		btn1 = new JButton("B");
		btn1.setBounds(100,100,50,30);
		btn2 = new JButton("Hilo 1");
		btn2.setBounds(0,400,100,30);

		panel.add(btn1);
		panel.add(btn2);

		this.add(panel);
		this.setTitle("Interracion con el teclado");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		panel.addKeyListener(this);

		crearHilo1();
	}

	public void keyPressed(KeyEvent e)
	{
		//System.out.println("Tecla presionada = "+e.getKeyCode());
		int t = e.getKeyCode();


		Point pos = btn1.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		//System.out.println( (int) pos.getX() );

		if(t==68)
		{
			x = x+5;
		}

		else if(t==65)
		{
			x = x-5;
		}

		else if(t==83)
		{
			y = y+5;
		}
		else if(t==87)
		{
			y = y-5;
		}


		btn1.setLocation(x,y);


	}

	public void keyReleased(KeyEvent e)
	{
		//System.out.println("Tecla liberada.");
	}

	public void keyTyped(KeyEvent e)
	{
		//System.out.println("Tecla en el buffer.");

	}

	public void crearHilo1()
	{

		ObjetoHilo1 oh1 = new ObjetoHilo1(this.btn2);
		hilo1 = new Thread(oh1);
		hilo1.start();

	}

}

