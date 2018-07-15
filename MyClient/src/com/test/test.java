package com.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class test extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t=new test();
	}
	
	public test() {
		JButton jb=new JButton("button");
		JLabel jl=new JLabel("jlabel");
		JTextField jtf=new JTextField(0);
		JTextArea jta=new JTextArea("please input...");
		
		JPasswordField jpf=new JPasswordField(50);
		
		this.setLayout(null);
		this.add(jb);
		jb.setBounds(100, 0, 200, 300);
		jb.setSize(100, 40);
		
		this.add(jpf);
		jpf.setBounds(200, 0, 200, 300);
		jpf.setSize(100, 40);
		System.out.println(jpf.getText());
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb) {
					System.out.println("JB");
					System.out.println(jpf.getPassword());
					
				}
			}
		} );
		
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
