package edu.mccc.cos210.woodworld;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;


public class WoodWorld {
	JPanel jp;
	JTextField textfield;
	JPanel2D scriptp;
	private ScriptEngine se;
	final static String STARTPANEL = "Test start";
	final static String WOODWORLD = "Test WoodWorld";
	final static String SCRIPTTEST = "Test Panel for scripting";
	private JPanel wwjp;
	private JPanel wwjp2d;
	private JRadioButton s1;
	private JRadioButton s2;
	private JRadioButton s3;
	private JCheckBox rb;
	private JCheckBox eb;
	private JCheckBox sb;
	private JCheckBox cb;
	private JToggleButton tglbtnMrGreeen;
	private JToggleButton tglbtnProfPlum;
	private JToggleButton tglbtnMissScarlet;
	private JToggleButton tglbtnElCapitan;
	private JRadioButton rdbtnStage;
	private JRadioButton rdbtnStage_1;
	private JRadioButton rdbtnStage_2;
	WoodWorld() {
		ScriptEngineManager sem = new ScriptEngineManager();
		se = sem.getEngineByName("ECMAScript");
		JFrame jf = new JFrame("Wood World");
		JPanel startjp = createStart();
		JPanel wwjp = createWoodWorld();
		JPanel scripttest = createScriptTest();
		jf.setLayout(new BorderLayout());
		init();
		//textfield = createConsole();
		//jf.add(textfield, BorderLayout.SOUTH);
		
		jp= new JPanel(new CardLayout());
		jp.add(startjp, STARTPANEL);
		jp.add(wwjp, WOODWORLD);
		jp.add(scripttest, SCRIPTTEST);
		jp.setPreferredSize(startjp.getPreferredSize());
		jf.add(jp);
		jf.setJMenuBar(createMenu());
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
	}
	private void init() {
		try (BufferedReader br = new BufferedReader(new FileReader("./init.js"))) {
			String s;
			while ((s = br.readLine()) != null) {
				se.eval(s);
			}
		} catch (Exception ex) {
			System.err.println("Unable to initialize");
		}
	}
	public JPanel createScriptTest() {
		wwjp2d = new JPanel();
		wwjp2d.setBackground(new Color(160, 82, 45));
		wwjp2d.setPreferredSize(new Dimension(1080, 725));
		wwjp2d.setLayout(null);
		
		textfield = new JTextField();
		textfield.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textfield.setBounds(129, 604, 935, 60);
		wwjp2d.add(textfield);
		textfield.setColumns(12);
		scriptp = new JPanel2D();
		scriptp.setVisible(true);
		scriptp.setBounds(115, 20, 930, 525);
		wwjp2d.add(scriptp);
	
		textfield.addActionListener(
			(ae) -> {
				try {
					System.out.println(textfield.getText());
					Object o = se.eval(textfield.getText());
					if (o != null) {
						System.out.println(o.toString());
					}
				} catch (Exception ex) {
					System.err.println("Script Exception");
				}
				textfield.setText("");
				scriptp.repaint();
			}
		);

		
		
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tutorial tut = new Tutorial();
				tut.NewScreen();
			}
		});
		btnTutorial.setBounds(20, 553, 85, 40);
		wwjp2d.add(btnTutorial);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits cred = new Credits();
				cred.NewScreen();
			}
		});
		btnCredits.setBounds(20, 614, 85, 40);
		wwjp2d.add(btnCredits);

		JButton btnNewButton = new JButton("Walk");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(20, 20, 85, 40);
		wwjp2d.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Run");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(20, 100, 85, 40);
		wwjp2d.add(btnNewButton_1);
		
		JButton btnSit = new JButton("Sit");
		btnSit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSit.setBounds(20, 180, 85, 40);
		wwjp2d.add(btnSit);
		
		JButton btnStand = new JButton("Stand");
		btnStand.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStand.setBounds(20, 260, 85, 40);
		wwjp2d.add(btnStand);
		
		JButton btnJump = new JButton("Jump");
		btnJump.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnJump.setBounds(20, 340, 85, 40);
		wwjp2d.add(btnJump);
		
		JButton btnDance = new JButton("Dance");
		btnDance.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDance.setBounds(20, 420, 85, 40);
		wwjp2d.add(btnDance);
		
		JToggleButton tglbtnColMustard = new JToggleButton("Col. Mustard");
		tglbtnColMustard.setBounds(170, 565, 121, 28);
		wwjp2d.add(tglbtnColMustard);
		
		JToggleButton tglbtnMissScarlet = new JToggleButton("Miss Scarlet");
		tglbtnMissScarlet.setBounds(404, 565, 121, 28);
		wwjp2d.add(tglbtnMissScarlet);
		
		JToggleButton tglbtnProfessorPlum = new JToggleButton("Professor Plum");
		tglbtnProfessorPlum.setBounds(631, 565, 121, 28);
		wwjp2d.add(tglbtnProfessorPlum);
		
		JToggleButton tglbtnMrGreen = new JToggleButton("Mr. Green");
		tglbtnMrGreen.setBounds(861, 565, 121, 28);
		wwjp2d.add(tglbtnMrGreen);
		
		
		return wwjp2d;
	}	
	public JPanel createWoodWorld() {
		wwjp = new JPanel();
		wwjp.setBackground(new Color(160, 82, 45));
		wwjp.setLayout(null);

		JPanel3D panel = new JPanel3D();
		
		wwjp.setPreferredSize(new Dimension(1080, 725));
		panel.setBounds(115, 20, 930, 525);
		wwjp.add(panel);
		//end of test code
		
		//testing code
		panel.setVisible(true);
		//end of test code
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tutorial tut = new Tutorial();
				tut.NewScreen();
			}
		});
		btnTutorial.setBounds(20, 553, 85, 40);
		wwjp.add(btnTutorial);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits cred = new Credits();
				cred.NewScreen();
			}
		});
		btnCredits.setBounds(20, 614, 85, 40);
		wwjp.add(btnCredits);
//Action Methods
		JButton btnNewButton = new JButton("Walk");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(20, 20, 85, 40);
		wwjp.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Run");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(20, 100, 85, 40);
		wwjp.add(btnNewButton_1);
		
		JButton btnSit = new JButton("Sit");
		btnSit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSit.setBounds(20, 180, 85, 40);
		wwjp.add(btnSit);
		
		JButton btnStand = new JButton("Stand");
		btnStand.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStand.setBounds(20, 260, 85, 40);
		wwjp.add(btnStand);
		
		JButton btnJump = new JButton("Jump");
		btnJump.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnJump.setBounds(20, 340, 85, 40);
		wwjp.add(btnJump);
		
		JButton btnDance = new JButton("Dance");
		btnDance.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDance.setBounds(20, 420, 85, 40);
		wwjp.add(btnDance);
//Woodworld Mannequin Buttons		
		JToggleButton tglbtnColMustard = new JToggleButton("Col. Mustard");
		tglbtnColMustard.setBounds(170, 565, 121, 28);
		wwjp.add(tglbtnColMustard);
		
		JToggleButton tglbtnMissScarlet = new JToggleButton("Miss Scarlet");
		tglbtnMissScarlet.setBounds(404, 565, 121, 28);
		wwjp.add(tglbtnMissScarlet);
		
		JToggleButton tglbtnProfessorPlum = new JToggleButton("Professor Plum");
		tglbtnProfessorPlum.setBounds(631, 565, 121, 28);
		wwjp.add(tglbtnProfessorPlum);
		
		JToggleButton tglbtnMrGreen = new JToggleButton("Mr. Green");
		tglbtnMrGreen.setBounds(861, 565, 121, 28);
		wwjp.add(tglbtnMrGreen);
		return wwjp;
	}
	private JTextField createConsole() {
		JTextField textField = new JTextField();
		textField.setColumns(12);
		textField.addActionListener(
			(ae) -> {
				loadScript();
			}
		);
		scriptp.setVisible(true);
		return textField;
	}
	public JPanel createStart() {
		JPanel start = new JPanel();
		start.setLayout(null);
		start.setPreferredSize(new Dimension(1080, 725));
//Start Button		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStart.addActionListener(ae->{
			CardLayout cl = (CardLayout)(jp.getLayout());
			cl.show(jp, WOODWORLD);
		});
		btnStart.setBounds(490, 569, 115, 45);
		start.add(btnStart);
//TITLE		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Wonders of");
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setBounds(10, 11, 1044, 44);
		start.add(lblWelcomeToThe);
		
		JLabel lblWoodworld = new JLabel("WOODWORLD");
		lblWoodworld.setForeground(new Color(139, 69, 19));
		lblWoodworld.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblWoodworld.setHorizontalAlignment(SwingConstants.CENTER);
		lblWoodworld.setBounds(10, 56, 1044, 50);
		start.add(lblWoodworld);
//Tutorial Button		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutorial tut = new Tutorial();
				tut.NewScreen();
			}
		});
		btnTutorial.setBounds(10, 630, 100, 40);
		start.add(btnTutorial);
//Credits Button		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits cred = new Credits();
				cred.NewScreen();
			}
		});
		btnCredits.setBounds(954, 630, 100, 40);
		start.add(btnCredits);
//Mannequin images		
		Manny1 man1 = new Manny1();
		man1.setBounds(56, 110, 160, 175);
		start.add(man1);

		Manny2 man2 = new Manny2();
		man2.setBounds(310, 110, 160, 175);
		start.add(man2);
		
		Manny3 man3 = new Manny3();
		man3.setBounds(588, 110, 160, 175);
		start.add(man3);
		
		Manny4 man4 = new Manny4();
		man4.setBounds(848, 110, 160, 175);
		start.add(man4);
		tglbtnElCapitan = new JToggleButton("Col. Mustard");
		tglbtnElCapitan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (tglbtnElCapitan.isSelected()) {
					eb.setSelected(true);
				} else {
					eb.setSelected(false);
				}
			}
		});
		tglbtnElCapitan.setBounds(75, 296, 121, 23);
		start.add(tglbtnElCapitan);
		
		tglbtnMissScarlet = new JToggleButton("Miss Scarlet");
		tglbtnMissScarlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnMissScarlet.isSelected()) {
					cb.setSelected(true);
				} else {
					cb.setSelected(false);
				}
			}
		});
		tglbtnMissScarlet.setBounds(331, 296, 121, 23);
		start.add(tglbtnMissScarlet);
		
		tglbtnProfPlum = new JToggleButton("Prof. Plum");
		tglbtnProfPlum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnProfPlum.isSelected()) {
					sb.setSelected(true);
				} else {
					sb.setSelected(false);
				}
			}
		});
		tglbtnProfPlum.setBounds(608, 296, 121, 23);
		start.add(tglbtnProfPlum);
		
		tglbtnMrGreeen = new JToggleButton("Mr. Green");
		tglbtnMrGreeen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnMrGreeen.isSelected()) {
					rb.setSelected(true);
				} else {
					rb.setSelected(false);
				}
			}
		});
		tglbtnMrGreeen.setBounds(869, 296, 121, 23);
		start.add(tglbtnMrGreeen);
//Stage Images		
		Stage1 stage1 = new Stage1();
		stage1.setBounds(30, 335, 300, 175);
		start.add(stage1);
		
		Stage2 stage2 = new Stage2();
		stage2.setBounds(395, 335, 300, 175);
		start.add(stage2);
		
		Stage3 stage3 = new Stage3();
		stage3.setBounds(760, 335, 300, 175);
		start.add(stage3);
		rdbtnStage = new JRadioButton("Stage 1", true);
		rdbtnStage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			s1.setSelected(true);
			}
		});
		rdbtnStage.setBounds(140, 510, 75, 25);
		start.add(rdbtnStage);
		
		rdbtnStage_1 = new JRadioButton("Stage 2");
		rdbtnStage_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s2.setSelected(true);
			}
		});
		rdbtnStage_1.setBounds(510, 510, 75, 25);
		start.add(rdbtnStage_1);

		rdbtnStage_2 = new JRadioButton("Stage 3");
		rdbtnStage_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s3.setSelected(true);
			}
		});
		rdbtnStage_2.setBounds(875, 510, 75, 25);
		start.add(rdbtnStage_2);
//Grouping of Buttons		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnStage);
		bg.add(rdbtnStage_1);
		bg.add(rdbtnStage_2); 
		return start;
	}
	public JMenuBar createMenu(){
		JMenuBar mb = new JMenuBar();
		
		JMenu fm = new JMenu("File");
		JMenuItem startb = new JMenuItem("Start Menu");
		startb.addActionListener(al->{
			CardLayout cl = (CardLayout)(jp.getLayout());
			cl.show(jp, STARTPANEL);
		});
		fm.add(startb);
		JMenuItem scripttest = new JMenuItem("Script Test");
		scripttest.addActionListener(al->{
			CardLayout cl = (CardLayout)(jp.getLayout());
			cl.show(jp, SCRIPTTEST);
		});
		fm.add(scripttest);
		JMenuItem lb = new JMenuItem("Load Script");
		lb.addActionListener(ae -> {loadScript();});
		fm.add(lb);
		mb.add(fm);
		
		JMenu mm = new JMenu("Mannequin");
		eb = new JCheckBox("Elliot");
		cb = new JCheckBox("Catherine");
		sb = new JCheckBox("Sergey");
		rb = new JCheckBox("Rich");
//JMenu and Toggle button Linking
		eb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (eb.isSelected()) {
					tglbtnElCapitan.setSelected(true);
				} else {
					tglbtnElCapitan.setSelected(false);
				}
			}
		});		
		cb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (cb.isSelected()) {
					tglbtnMissScarlet.setSelected(true);
				} else {
					tglbtnMissScarlet.setSelected(false);
				}
			}
		});
		sb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (sb.isSelected()) {
					tglbtnProfPlum.setSelected(true);
				} else {
					tglbtnProfPlum.setSelected(false);
				}
			}
		});
		rb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (rb.isSelected()) {
					tglbtnMrGreeen.setSelected(true);
				} else {
					tglbtnMrGreeen.setSelected(false);
				}
			}
		});
		
		mm.add(eb);
		mm.add(cb);
		mm.add(sb);
		mm.add(rb);
		mb.add(mm);
	
		JMenu sm = new JMenu("Scene");
		s1 = new JRadioButton("Standard", true);
		s2 = new JRadioButton("Irish");
		s3 = new JRadioButton("Ballet");

		ButtonGroup sbg = new ButtonGroup();
		sbg.add(s1);
		sbg.add(s2);
		sbg.add(s3);
		sm.add(s1);
		sm.add(s2);
		sm.add(s3);	
		
		s1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (s1.isSelected()) {
					rdbtnStage.setSelected(true);
				}
			}
		});
		s2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (s2.isSelected()) {
					rdbtnStage_1.setSelected(true);
				}
			}
		});
		s3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (s3.isSelected()) {
					rdbtnStage_2.setSelected(true);
				}
			}
		});

		mb.add(mm);
		mb.add(sm);		
		
		return mb;
	}	
	private void loadScript() {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File sf = fc.getSelectedFile();
		String fn = sf.getAbsolutePath();
		try {
			FileReader reader = new FileReader(fn);
			BufferedReader br = new BufferedReader(reader);
			textfield.read(br, null);
			br.close();
			textfield.requestFocus();
		} catch (Exception e){
			System.err.println("TXT file type required");
		}
		
	}
	public static void main(String[] sa) {
		EventQueue.invokeLater(WoodWorld::new);
	}
		class JPanel2D extends JPanel {
		private static final long serialVersionUID = 1L;
		private Ball ball1 = new Ball(0, 0);
		private Ball ball2 = new Ball(100, -100);
		private Ball ball3 = new Ball(-100, -100);
		public JPanel2D() {
			setBackground(Color.WHITE);
			se.put("ball1", ball1);
			se.put("ball2", ball2);
			se.put("ball3", ball3);
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			AffineTransform gat = new AffineTransform();
			gat.translate(getWidth() / 2.0, getHeight() / 2.0);
			gat.scale(1.0, -1.0);
			g2d.transform(gat);
			g2d.setPaint(ball1.getColor());
			AffineTransform at1 = AffineTransform.getTranslateInstance(
				-ball1.width / 2,
				-ball1.height / 2
			);
			Shape s1 = at1.createTransformedShape(ball1);
			g2d.fill(s1);
			g2d.setPaint(ball2.getColor());
			AffineTransform at2 = AffineTransform.getTranslateInstance(
				-ball2.width / 2,
				-ball2.height / 2
			);
			Shape s2 = at2.createTransformedShape(ball2);
			g2d.fill(s2);
			g2d.setPaint(ball3.getColor());
			AffineTransform at3 = AffineTransform.getTranslateInstance(
				-ball3.width / 2,
				-ball3.height / 2
			);
			Shape s3 = at3.createTransformedShape(ball3);
			g2d.fill(s3);
			g2d.dispose();
		}
	}
	public class Ball extends Ellipse2D.Double {
		private static final long serialVersionUID = 1L;
		private Color color = Color.BLUE;
		public Ball(int x, int y) {
			this.x = x;
			this.y = y;
			this.width = 128.0;
			this.height = 128.0;
		}
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
		public void setPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public void setSize(int w, int h) {
			this.width = w;
			this.height = h;
		}
	} 
}