package com.test;



import java.awt.*;

import javax.swing.*;

public class test extends JFrame{
	
	JPanel jphy1,jphy2,jphy3;
	JButton jbhy1,jbhy2,jbhy3;
	JScrollPane jsp;
	
	public static void main(String[] args) {
		new test();
	}
	
	public test() {
		
	jbhy1=new JButton("MY FRIENDS");
	jbhy2=new JButton("STRANGER");
	jbhy3=new JButton("BLACKLIST");
	
	jphy1=new JPanel(new BorderLayout());
	jphy2=new JPanel(new GridLayout(20, 1,4,4));
	
	
	JLabel []jbls=new JLabel[20];
	for(int i=0;i<jbls.length;i++) {
		jbls[i]=new JLabel(i+1+" ", new ImageIcon("images/mm.jpg"),JLabel.LEFT);
		jphy2.add(jbls[i]);
	}
	
	jphy3=new JPanel(new GridLayout(2, 1));
	jphy3.add(jbhy2);
	jphy3.add(jbhy3);
	
	jsp=new JScrollPane(jphy2);	
	
	jphy1.add(jbhy1,"North");	
	jphy1.add(jsp,"Center");
	jphy1.add(jphy3,"South");
	
		
		JFrame flmb=new JFrame();
		flmb.add(jphy1);
		flmb.setTitle("FriendList");
		flmb.setBackground(Color.blue);
		flmb.setSize(200, 450);
		flmb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		flmb.setBackground(Color.BLUE);
		flmb.setVisible(true);
	}
}
