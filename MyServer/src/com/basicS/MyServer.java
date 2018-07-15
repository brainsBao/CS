package com.basicS;
import java.util.*;

import javax.management.remote.JMXPrincipal;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class MyServer extends JFrame implements ActionListener{
	
	JPanel jp1,jp2,jp3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer ms=new MyServer();

	}
	
	JTextField jtf=null;
	JTextArea jta=null;
	JButton jb=null;
	JScrollPane jsp=null;
	PrintWriter pw=null;
	public MyServer() {
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jta=new JTextArea(10,25);
		jsp=new JScrollPane(jta);
		jtf=new JTextField(15);
		jp3.add(jtf,FlowLayout.LEFT);
		jb=new JButton("send");
		jb.addActionListener(this);
		jp3.add(jb);
		
		this.add(jsp,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		this.setTitle("SERVER");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(200, 0);
		
		
		try {
			ServerSocket ss=new ServerSocket(9988);
			Socket s=ss.accept();
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			pw=new PrintWriter(s.getOutputStream(),true);
			while(true) {
				String info=br.readLine();
				jta.append("Client to Server say:"+info+"\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb) {
			String text_from_jtf=jtf.getText();
			//System.out.println(text_from_jtf.length());
			jta.append("Server to Client say:"+text_from_jtf+"\n");
			pw.println(text_from_jtf);
			jtf.setText("");
			jtf.grabFocus();
			
		}
		
	}

}
