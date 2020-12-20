import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class menu extends JFrame{

	private Image screenImage;
	private Graphics screenGraphic;


	private ImageIcon startButtonEnteredImage = new ImageIcon("image/select1.png");
	private ImageIcon startButtonBasicImage = new ImageIcon("image/select1.png");
	private ImageIcon quitButtonEnteredImage = new ImageIcon("image/shop.png");
	private ImageIcon quitButtonBasicImage = new ImageIcon("image/shop.png");
	private ImageIcon loginButtonEnteredImage = new ImageIcon("image/logout.png");
	private ImageIcon loginButtonBasicImage = new ImageIcon("image/logout.png");
	private ImageIcon mycBasicImage = new ImageIcon("image/3.png");
	
	
	
	private Image background = new ImageIcon("image/back.png")
			.getImage();

	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton loginButton = new JButton(loginButtonBasicImage);
	private JButton myc = new JButton(mycBasicImage);
	
	private int mouseX, mouseY;
	
	public menu() {
		setUndecorated(true);
		setTitle("ï¿½ï¿½ï¿½Æ¿ï¿½ ï¿½ï¿½ï¿½ï¿½");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);



		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				;
				startButton.setVisible(false);
				quitButton.setVisible(false);
				background = new ImageIcon("image/back.png")
						.getImage();
				new choose();
			}
		});
		add(startButton);
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			/*@Override
			public void mousePressed(MouseEvent e) {
				;
				
				new store();
			}*/
			}
		
			
		);
		
		quitButton.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
			new store();
		}
		});
		add(quitButton);
		
		loginButton.setBounds(-100, 500, 400, 100);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusPainted(false);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setIcon(loginButtonEnteredImage);
				loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setIcon(loginButtonBasicImage);
				loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
				}
			}
			
		);
		add(loginButton);
		
		myc.setBounds(500, 175, 400, 300);
		myc.setBorderPainted(false);
		myc.setContentAreaFilled(false);
		myc.setFocusPainted(false);
		myc.addMouseListener(new MouseAdapter() {
		}
		
				);
				add(myc);


		
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}

///Copyright 2020 Hyun Min///

class store {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					store window = new store();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public store() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon img1;
		ImageIcon img2;
		ImageIcon img3;
		ImageIcon img4;
		
		frame = new JFrame("Ä³¸¯ÅÍ »óÁ¡");
		frame.setBounds(100, 100, 717, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		img1 = new ImageIcon("store_images/1.PNG");
		img2 = new ImageIcon("store_images/2.PNG");
		img3 = new ImageIcon("store_images/3.PNG");
		img4 = new ImageIcon("store_images/4.PNG");
		BufferedImage img = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB );
		
		JLabel lblNewLabel_2 = new JLabel("\uC0C1\uC810\uC5D0 \uC624\uC2E0\uAC78 \uD658\uC601\uD569\uB2C8\uB2E4!!");
		lblNewLabel_2.setFont(new Font("HY±×·¡ÇÈM", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 7;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel(img1);
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.gridwidth = 5;
		gbc_lblNewLabel_1_1.gridheight = 8;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 4;
		gbc_lblNewLabel_1_1.gridy = 3;
		frame.getContentPane().add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel(img2);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 8;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 12;
		gbc_lblNewLabel_1.gridy = 3;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel(img3);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridheight = 8;
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 16;
		gbc_lblNewLabel_3.gridy = 3;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton = new JButton("±¸¸Å");
		btnNewButton.setFont(new Font("HY½Å¸íÁ¶", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 14;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1_1.setIcon(img2);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Àû¿ë");
		btnNewButton_1.setFont(new Font("HY½Å¸íÁ¶", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 14;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1_1.setIcon(img4);
				try {
					Robot robot = new Robot();
					int x = 133;
				    int y = 158;
				    int width = 199;
				    int height = 229;
					Rectangle rectangle = new Rectangle(x, y, width, height);

					BufferedImage bi = robot.createScreenCapture(rectangle);
					ImageIO.write(bi, "jpg", new File("C:\\Users\\hyunm\\Downloads\\screenshot.jpg"));
				} catch(IOException ioe) {
					ioe.printStackTrace();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				//try { ImageIO.write(img, "PNG", new File("C:\\Users\\hyunm\\Downloads\\yourImageName.PNG")); }
				//catch (IOException e1) { e1.printStackTrace(); }
			}
		});
		
		JButton btnNewButton_2 = new JButton("±¸¸Å");
		btnNewButton_2.setFont(new Font("HY½Å¸íÁ¶", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 12;
		gbc_btnNewButton_2.gridy = 14;
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setIcon(img1);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Àû¿ë");
		btnNewButton_3.setFont(new Font("HY½Å¸íÁ¶", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 13;
		gbc_btnNewButton_3.gridy = 14;
		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setIcon(img4);
				try {
					Robot robot = new Robot();
					int x = 355;
				    int y = 160;
				    int width = 199;
				    int height = 229;
					Rectangle rectangle = new Rectangle(x, y, width, height);

					BufferedImage bi = robot.createScreenCapture(rectangle);
					ImageIO.write(bi, "jpg", new File("C:\\Users\\hyunm\\Downloads\\screenshot.jpg"));
				} catch(IOException ioe) {
					ioe.printStackTrace();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		JButton btnNewButton_2_1 = new JButton("±¸¸Å");
		btnNewButton_2_1.setFont(new Font("HY½Å¸íÁ¶", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_btnNewButton_2_1 = new GridBagConstraints();
		gbc_btnNewButton_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2_1.gridx = 16;
		gbc_btnNewButton_2_1.gridy = 14;
		frame.getContentPane().add(btnNewButton_2_1, gbc_btnNewButton_2_1);
		
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_3.setIcon(img1);
			}
		});
		
		JButton btnNewButton_3_1 = new JButton("Àû¿ë");
		btnNewButton_3_1.setFont(new Font("HY½Å¸íÁ¶", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_btnNewButton_3_1 = new GridBagConstraints();
		gbc_btnNewButton_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3_1.gridx = 17;
		gbc_btnNewButton_3_1.gridy = 14;
		frame.getContentPane().add(btnNewButton_3_1, gbc_btnNewButton_3_1);
		
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_3.setIcon(img4);
				try {
					Robot robot = new Robot();
					int x = 590;
				    int y = 156;
				    int width = 199;
				    int height = 229;
					Rectangle rectangle = new Rectangle(x, y, width, height);

					BufferedImage bi = robot.createScreenCapture(rectangle);
					ImageIO.write(bi, "jpg", new File("C:\\Users\\hyunm\\Downloads\\screenshot.jpg"));
				} catch(IOException ioe) {
					ioe.printStackTrace();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

}
