package com.basicC;
import com.basicC.ClientPanelLogin;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class MyClient extends JFrame implements ActionListener{
	
	JPanel jp1,jp2,jp3;

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientPanelLogin CPL=new ClientPanelLogin();

	}*/
	
	JTextField jtf=null;
	JTextArea jta=null;
	JButton jb=null;
	JScrollPane jsp=null;
	PrintWriter pw=null;
	
	public MyClient() {
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		
		
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		jtf=new JTextField(15);
		jp3.add(jtf,FlowLayout.LEFT);
		jb=new JButton("send");
		jb.addActionListener(this);
		jp3.add(jb);
		
		this.add(jsp,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		this.setTitle("CLIENT");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(400, 0);
		
		
		try {
			Socket s=new Socket("127.0.0.1", 9988);
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			pw=new PrintWriter(s.getOutputStream(),true);
			while(true) {
				String info=br.readLine();
				jta.append("Server to Client say:"+info+"\r\n");
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
			if(text_from_jtf.length()!=0) {
				jta.append("Client to Server say:"+text_from_jtf+"\n");
				pw.println(text_from_jtf);
				jtf.setText("");
				jtf.grabFocus();
			}else {
				jtf.setText("CONTENT IS NOT NULL!");
				PromptBox_Thread pbt=new PromptBox_Thread();
				pbt.start();				
			}
		}
		
	}
	
	public class PromptBox_Thread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				PromptBox_Thread.currentThread().sleep(2000);
				jtf.setText("");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("MyClient.PromptBox_Thread.run()");
		}
		
	}

}
