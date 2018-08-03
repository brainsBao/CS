package com.basicC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.test.test;

public class FriendList extends JFrame implements ActionListener{
	
	JPanel jphy1,jphy2,jphy3;
	JButton jbhy1,jbhy2,jbhy3;
	JScrollPane jsp;
	
	JPanel jpms1,jpms2,jpms3;
	JButton jbms1,jbms2,jbms3;
	JScrollPane jsms;
	
	JPanel jphmd1,jphmd2,jphmd3;
	JButton jbhmd1,jbhmd2,jbhmd3;
	JScrollPane jshmd;
	
	CardLayout cl;
	
	public static void main(String []args) {
		new FriendList();
	}
	
	public FriendList() {
		
	jbhy1=new JButton("MY FRIENDS");
	jbhy1.addActionListener(this);
	jbhy2=new JButton("STRANGER");
	jbhy3=new JButton("BLACKLIST");
	jbhy3.addActionListener(this);
	
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
	
	//deal with the Stranger panel
	jbms1=new JButton("MY FRIENDS");
	jbms2=new JButton("STRANGER");
	jbms2.addActionListener(this);
	jbms3=new JButton("BLACKLIST");
	
	jpms1=new JPanel(new BorderLayout());
	jpms2=new JPanel(new GridLayout(20,1,4,4));
	
	JLabel []jbls2=new JLabel[20];
	for(int i=0;i<jbls2.length;i++) {
		jbls2[i]=new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
		jpms2.add(jbls2[i]);
	}
	
	jpms3=new JPanel(new GridLayout(2, 1));
	
	jpms3.add(jbms1);
	jpms3.add(jbms2);
	
	jsms=new JScrollPane(jpms2);
	
	jpms1.add(jpms3,"North");
	jpms1.add(jsms,"Center");
	jpms1.add(jbms3,"South");
	
	
	//deal with the BLACKLIST part
	
	jbhmd1=new JButton("FRIEND LIST");
	jbhmd2=new JButton("STRANGER");
	jbhmd3=new JButton("BLOCKLIST");
	jbhmd3.addActionListener(this);
	
	jphmd1=new JPanel(new BorderLayout());
	jphmd2=new JPanel(new GridLayout(20, 1,4,4));
	
	JLabel []jlbs3=new JLabel[3];
	for(int i=0;i<jlbs3.length;i++) {
		jlbs3[i]=new JLabel(i+1+" ",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
		jphmd2.add(jlbs3[i]);
	}
	
	jphmd3=new JPanel(new GridLayout(2, 1));
	
	jphmd3.add(jbhmd1);
	jphmd3.add(jbhmd2);

	
	jshmd=new JScrollPane(jphmd2);
	
	jphmd1.add(jphmd3,"North");
	jphmd1.add(jbhmd3,"Center");
	//jphmd1.add(jshmd,"South");
	
	cl=new CardLayout();
	this.setLayout(cl);
	
	
		

	this.add(jphy1,"1");
	this.add(jpms1, "2");
	this.add(jphmd1, "3");
	this.setTitle("FriendList");
	this.setBackground(Color.blue);
	this.setSize(200, 450);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setBackground(Color.BLUE);
	this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbhy1) {
			cl.show(this.getContentPane(), "2");
			
		}
		if(e.getSource()==jbms2) {
			cl.show(this.getContentPane(), "1");
		}
		if(e.getSource()==jbhy3) {
			cl.show(this.getContentPane(), "3");
		}
	}
}
