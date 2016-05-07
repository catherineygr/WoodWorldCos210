package edu.mccc.cos210.woodworld;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;


public class WoodWorld {
	
	WoodWorld() {
		JFrame jf = new JFrame("Wood World");
		JMenu m = new JMenu("Menu");
		JPanel3D jp3d = new JPanel3D();
		jf.setJMenuBar(createMenu());
		jf.add(jp3d);
		jf.pack();
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
	}
	private JMenuBar createMenu(){
			JMenuBar mb = new JMenuBar();
			
			JMenu fm = new JMenu("File");
			JMenuItem lb = new JMenuItem("Load Script");
			fm.add(lb);
			mb.add(fm);
			
			JMenu mm = new JMenu("Mannequin");
			JCheckBox rb = new JCheckBox("Rich");
			JCheckBox eb = new JCheckBox("Elliot");
			JCheckBox sb = new JCheckBox("Sergey");
			JCheckBox cb = new JCheckBox("Catherine");
			mm.add(rb);
			mm.add(eb);
			mm.add(sb);
			mm.add(cb);
			mb.add(mm);
			
			
			JMenu sm = new JMenu("Scene");
			JRadioButton s1 = new JRadioButton("Irish", true);
			JRadioButton s2 = new JRadioButton("Ballet");
			JRadioButton s3 = new JRadioButton("Ninties");
			ButtonGroup sbg = new ButtonGroup();
			
			sbg.add(s1);
			sbg.add(s2);
			sbg.add(s3);
			sm.add(s1);
			sm.add(s2);
			sm.add(s3);	
			
			mb.add(mm);
			mb.add(sm);		
			
			return mb;
		}	
	
	public static void main(String[] sa) {
		EventQueue.invokeLater(WoodWorld::new);
	}

}