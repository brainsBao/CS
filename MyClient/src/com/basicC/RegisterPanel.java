package com.basicC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.sqldata.sqlRegister;
import com.test.test;

public class RegisterPanel extends JFrame{
	JLayeredPane jlp;
	JPanel jp;
	JLabel jl_username,jl_password,jl_email,jl_phone,jlimg;
	JPasswordField jpf_password;
	JTextField jtf_username,jtf_email,jtf_phone;
	JButton jb_competeRe,jb_cancl;
	
	
	

	public RegisterPanel() throws SQLException{
		Init();
		
		Connection con=null;
		jb_competeRe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				String username=jtf_username.getText();
				String password=String.valueOf(jpf_password.getPassword());
				String e_mail=jtf_email.getText();
				String phone=jtf_phone.getText();
				
				sqlRegister sr=new sqlRegister();
				PreparedStatement psmt;
				try {
					psmt = sr.sqlRegister("insert into loginadmin (username,password,e_mail,phone)"+"values(?,?,?,?)");
					psmt.setString(1, username);
					psmt.setString(2, password);
					psmt.setString(3, e_mail);
					psmt.setString(4, phone);
						
						
					psmt.executeUpdate();
					psmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println(phone);}

		});
	}
	public void Init() {
		jlp=new JLayeredPane();
		//this.setLayout(null);
		jl_username=new JLabel("USERNAME:");
		jl_username.setBounds(60,80,130,25);
		jtf_username=new  JTextField("");
		jtf_username.setBounds(160,80,130,25);
		
		jl_password=new JLabel("PASSWORD:");
		jl_password.setBounds(60,120,130,25);
		jpf_password=new JPasswordField("");
		jpf_password.setBounds(160,120,130,25);
		
		jl_email=new JLabel("E-MAIL:");jl_email.setBounds(60,160,130,25);
		jtf_email=new JTextField("");jtf_email.setBounds(160,160,130,25);
		
		jl_phone=new JLabel("PHONE");jl_phone.setBounds(60,200,130,25);
		jtf_phone=new JTextField();jtf_phone.setBounds(160,200,130,25);
		
		jb_competeRe=new JButton("SUBMIT");jb_competeRe.setBounds(60,300,100,30);
		jb_cancl=new JButton("CANCL");jb_cancl.setBounds(180,300,100,30);
		
		jp=new JPanel();
		
		ImageIcon img=new ImageIcon("images/background.jpg");
		jp.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		JLabel jlimg=new JLabel(img);
		jlimg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		jp.add(jlimg);
		
		jlp.add(jp,JLayeredPane.DEFAULT_LAYER);
		jlp.add(jl_username, JLayeredPane.MODAL_LAYER);
		jlp.add(jtf_username,JLayeredPane.MODAL_LAYER);
		jlp.add(jl_password,JLayeredPane.MODAL_LAYER);
		jlp.add(jpf_password,JLayeredPane.MODAL_LAYER);
		jlp.add(jl_email,JLayeredPane.MODAL_LAYER);
		jlp.add(jtf_email,JLayeredPane.MODAL_LAYER);
		jlp.add(jl_phone,JLayeredPane.MODAL_LAYER);
		jlp.add(jtf_phone,JLayeredPane.MODAL_LAYER);
		jlp.add(jb_competeRe, JLayeredPane.MODAL_LAYER);
		jlp.add(jb_cancl, JLayeredPane.MODAL_LAYER);
		

		
		jb_cancl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		this.setLayeredPane(jlp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Register");
		this.setSize(400, 440);
	}
	
}
