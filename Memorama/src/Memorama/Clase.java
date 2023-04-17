package Memorama;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Clase extends JFrame {
	
	static String img[] = {"ft1.jfif","ft2.jfif","ft3.jfif","ft4.jfif"};
	static JButton botones[] = new JButton[8];

	static int numGen[] = new int[8];
	static int [][] tablero = new int[4][2];
	//int descubrirPar=0;
	private JPanel contentPane;
	String foto1, foto2;
	int btn1Click=0,btn2Click=0,btn3Click=0;
	//int fila, columna;
	int cartasVolteadas=0;
	int paresRestantes=4;
	boolean iniciarGame=false;
	
	
	static JLabel lblNewLabel = new JLabel();
	Timer timer = new Timer();
	public static int segundos=0,minutos=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		//ssss
		 Clase cronometro = new Clase();
	        cronometro.iniciar();
	        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {
					genTablero();
					Clase frame = new Clase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		while(true) {
			
			
			lblNewLabel.setText("Tiempo:      "+minutos+" : "+segundos);
			if(segundos>=60) {
				minutos++;
				segundos=0;
			}

		}
	
	
	}

	/**
	 * Create the frame.
	 */
	
	
	  TimerTask tarea = new TimerTask() {
	        public void run() {
	            segundos++;
	            lblNewLabel.setText("Tiempo: "+segundos);
	            //Clase g= new Clase();
	            System.out.println(segundos);
	        }
	    };

	    public void iniciar() {
	        timer.scheduleAtFixedRate(tarea, 1000, 1000);
	    }

	   
	
	//++++++++++++++++++++++++++++++++++++++++++++++
	public static void genTablero() {
		
		Random rand = new Random();
		for(int i=0;i<4;i++) {
			
			for(int i2=0;i2<2;i2++) {
				tablero[i][i2]=0;
				
				System.out.print(tablero[i][i2]+" , ");
			}
			System.out.println();
		}
		revolver();
		
		
	}
	
	
	public void esPar() {
		
		

			if(foto1==foto2) {
				
				btn1Click=btn3Click;
				foto1=img[numGen[btn3Click]];
				paresRestantes--;
				System.out.println("pares: "+paresRestantes);
				if(paresRestantes==0) {
					//JOptionPane.showMessageDialog(null,"Has encontrado todos los pares!!");

				}
				System.out.println("es par");
			}else {
				System.out.println("1: "+btn1Click+"  2:  "+btn2Click);

					ImageIcon imagen = new ImageIcon("");
					botones[btn1Click].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(botones[btn1Click].getWidth(),botones[btn2Click].getHeight(), Image.SCALE_SMOOTH)));
					botones[btn2Click].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(botones[btn1Click].getWidth(),botones[btn2Click].getHeight(), Image.SCALE_SMOOTH)));
					
					btn1Click=btn3Click;
					foto1=img[numGen[btn3Click]];
				
				
				
			}
		
		
			
		
	}
	public Clase() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		//JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 0));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botones[0]=btnNewButton;
				ImageIcon imagen = new ImageIcon(img[numGen[0]]);
				btnNewButton.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton.getWidth(),btnNewButton.getHeight(), Image.SCALE_SMOOTH)));
				
				if(cartasVolteadas==1) {
					foto2=img[numGen[0]];
					cartasVolteadas++;
					btn2Click=0;
				}else {
					if(cartasVolteadas==0) {
						foto1=img[numGen[0]];
						cartasVolteadas++;
						btn1Click=0;
					}else {
						if(cartasVolteadas==2) {
							btn3Click=0;
							cartasVolteadas=1;
							esPar();
						}
					}
					
				}
				
				

				
			}
		});
		
		
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botones[1]=btnNewButton_2;
				ImageIcon imagen = new ImageIcon(img[numGen[1]]);
				btnNewButton_2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton.getWidth(),btnNewButton.getHeight(), Image.SCALE_SMOOTH)));
			
				if(cartasVolteadas==1) {
					foto2=img[numGen[1]];
					cartasVolteadas++;
					btn2Click=1;
				}else {
					if(cartasVolteadas==0) {
						foto1=img[numGen[1]];
						cartasVolteadas++;
						btn1Click=1;
					}else {
						if(cartasVolteadas==2) {
							btn3Click=1;
							cartasVolteadas=1;
							esPar();
						}
					}
					
				}
				
				
					

				
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				botones[2]=btnNewButton_4;
				ImageIcon imagen = new ImageIcon(img[numGen[2]]);
				btnNewButton_4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton.getWidth(),btnNewButton.getHeight(), Image.SCALE_SMOOTH)));
			
				if(cartasVolteadas==1) {
					foto2=img[numGen[2]];
					cartasVolteadas++;
					btn2Click=2;
				}else {
					if(cartasVolteadas==0) {
						foto1=img[numGen[2]];
						cartasVolteadas++;
						btn1Click=2;
					}else {
						if(cartasVolteadas==2) {
							btn3Click=2;
							cartasVolteadas=1;
							esPar();
						}
					}
					
				}
				
				

				
			}
		});
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botones[3]=btnNewButton_1;
				ImageIcon imagen = new ImageIcon(img[numGen[3]]);
				btnNewButton_1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton.getWidth(),btnNewButton.getHeight(), Image.SCALE_SMOOTH)));
				
				if(cartasVolteadas==1) {
					foto2=img[numGen[3]];
					cartasVolteadas++;
					btn2Click=3;
				}else {
					if(cartasVolteadas==0) {
						foto1=img[numGen[3]];
						cartasVolteadas++;
						btn1Click=3;
					}else {
						if(cartasVolteadas==2) {
							btn3Click=3;
							cartasVolteadas=1;
							esPar();
						}
					}
					
				}
				
					
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botones[4]=btnNewButton_3;
				ImageIcon imagen = new ImageIcon(img[numGen[4]]);
				btnNewButton_3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton.getWidth(),btnNewButton.getHeight(), Image.SCALE_SMOOTH)));
				
				if(cartasVolteadas==1) {
					foto2=img[numGen[4]];
					cartasVolteadas++;
					btn2Click=4;
				}else {
					if(cartasVolteadas==0) {
						foto1=img[numGen[4]];
						cartasVolteadas++;
						btn1Click=4;
					}else {
						if(cartasVolteadas==2) {
							btn3Click=4;
							cartasVolteadas=1;
							esPar();
						}
					}
					
				}
				
					

				
			}
		});
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("5");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botones[5]=btnNewButton_6;
				ImageIcon imagen = new ImageIcon(img[numGen[5]]);
				btnNewButton_6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton.getWidth(),btnNewButton.getHeight(), Image.SCALE_SMOOTH)));
				
				if(cartasVolteadas==1) {
					foto2=img[numGen[5]];
					cartasVolteadas++;
					btn2Click=5;
				}else {
					if(cartasVolteadas==0) {
						foto1=img[numGen[5]];
						cartasVolteadas++;
						btn1Click=5;
					}else {
						if(cartasVolteadas==2) {
							btn3Click=5;
							cartasVolteadas=1;
							esPar();
						}
					}
					
				}
				

				
			}
		});
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botones[6]=btnNewButton_5;
				ImageIcon imagen = new ImageIcon(img[numGen[6]]);
				btnNewButton_5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton.getWidth(),btnNewButton.getHeight(), Image.SCALE_SMOOTH)));
			
				if(cartasVolteadas==1) {
					foto2=img[numGen[6]];
					cartasVolteadas++;
					btn2Click=6;
				}else {
					if(cartasVolteadas==0) {
						foto1=img[numGen[6]];
						cartasVolteadas++;
						btn1Click=6;
					}else {
						if(cartasVolteadas==2) {
							btn3Click=6;
							cartasVolteadas=1;
							esPar();
						}
					}
					
				}
				

				
			}
		});
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("7");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botones[7]=btnNewButton_7;
				ImageIcon imagen = new ImageIcon(img[numGen[7]]);
				btnNewButton_7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton.getWidth(),btnNewButton.getHeight(), Image.SCALE_SMOOTH)));
				
				if(cartasVolteadas==1) {
					foto2=img[numGen[7]];
					cartasVolteadas++;
					btn2Click=7;
				}else {
					if(cartasVolteadas==0) {
						foto1=img[numGen[7]];
						cartasVolteadas++;
						btn1Click=7;
					}else {
						if(cartasVolteadas==2) {
							btn3Click=7;
							cartasVolteadas=1;
							esPar();
						}
					}
					
				}
				
				
				
			}
		});
		panel_1.add(btnNewButton_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 192));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_8 = new JButton("Reiniciar");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon imagen = new ImageIcon("");
				
				btnNewButton.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton_2.getWidth(),btnNewButton_2.getHeight(), Image.SCALE_SMOOTH)));
				btnNewButton_1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton_2.getWidth(),btnNewButton_2.getHeight(), Image.SCALE_SMOOTH)));
				btnNewButton_2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton_2.getWidth(),btnNewButton_2.getHeight(), Image.SCALE_SMOOTH)));
				btnNewButton_3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton_2.getWidth(),btnNewButton_2.getHeight(), Image.SCALE_SMOOTH)));
				btnNewButton_4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton_2.getWidth(),btnNewButton_2.getHeight(), Image.SCALE_SMOOTH)));
				btnNewButton_5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton_2.getWidth(),btnNewButton_2.getHeight(), Image.SCALE_SMOOTH)));
				btnNewButton_6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton_2.getWidth(),btnNewButton_2.getHeight(), Image.SCALE_SMOOTH)));
				btnNewButton_7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNewButton_2.getWidth(),btnNewButton_2.getHeight(), Image.SCALE_SMOOTH)));
				cartasVolteadas=0;
				btn1Click=10;
				btn2Click=10;
				btn3Click=10;

				minutos=0;
				segundos=0;
				revolver();
			}
		});
		panel_2.add(btnNewButton_8);
	
		
		
		if(iniciarGame==true) {
			esPar();
		}else {
			iniciarGame=true;
		}
		
		

	}
	
	public static void revolver() {
		Random rand = new Random();
		
	
		for(int i=0;i<8;i++) {
			numGen[i]=0;
		}
		
		/*numGen[0]=0;
		numGen[1]=0;
		numGen[2]=1;
		numGen[3]=1;
		numGen[4]=2;
		numGen[5]=2;
		numGen[6]=3;
		numGen[7]=3;*/
		
		int i=0;
		int i2=0;
		int numYaGenerado=0;
		
		while(true) {
			
			 int num=rand.nextInt(4);
				System.out.println("i   "+num);
			while(true) {
				
				if(numGen[i2]==num) {
					numYaGenerado++;
				}
				i2++;
				if(numYaGenerado==2) {
					i2=0;
					break;
				}
				if(i2==numGen.length) {
					i2=0;
					numYaGenerado=0;
					break;
				}
			}
			if(numYaGenerado<2) {
				numGen[i]=num;
				
				i++;
			}
			numYaGenerado=0;
			//los ultimos osn 0 por que lo limitas a 6.... creo por que todos lo numeros ya se generaron mas de 2 veces...
			if(i==6) {
				i=0;
				break;
			}
			
		}
		
		for(int i3=0;i3<numGen.length;i3++) {
			
			System.out.print(numGen[i3]+" , ");
		}
		
		
		
	}

}
