package com.basicC;
import com.basicC.FriendList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.nio.channels.NonReadableChannelException;
import java.sql.*;
import com.sqldata.sqlLogin;


import javax.swing.*;
import javax.swing.border.Border;

public class ClientPanelLogin extends JFrame {
	
	JLabel jl_username,jl_password;
	JPasswordField jpf;
	JTextField jtf_username;
	JButton jb_login,jb_register;
	
	JPanel panel1,panel2,panel3;
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ClientPanelLogin CPL=new ClientPanelLogin();

	}
	
	public ClientPanelLogin() throws SQLException {
		jl_username=new JLabel("USERNAME:",JLabel.CENTER);
		jtf_username=new JTextField(15);
		jl_password=new JLabel("PASSWORD:",JLabel.CENTER);
		jpf=new JPasswordField(15);
		jb_login=new JButton("LOGIN");
		jb_register=new JButton("REGISTER");
		
		
		
		panel1=new JPanel();
		panel1.setBackground(Color.red);
		

		panel2=new JPanel();
		panel2.add(jl_username);
		panel2.add(jtf_username);
		panel2.add(jl_password);
		panel2.add(jpf);
		
		
		panel3=new JPanel();
		panel3.setLayout(null);
		jb_login.setBounds(100,220,70,40);
		panel3.add(jb_login);
		panel3.add(jb_register);
		
		
		
		jb_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String username=jtf_username.getText();
				String password=String.valueOf(jpf.getPassword());
				
				sqlLogin sl=new sqlLogin();
				try {
					ResultSet rs=sl.sqlLogin("select * from loginadmin");
					while(rs.next()) {
						String username1=rs.getString("username");
						String password1=rs.getString("password");
						
						System.out.println(username1);
						System.out.println(password1);
						
						if(e.getSource()==jb_login&&username.equals(username1)&&password.equals(password1)) {
							//use database to valida login
							
							System.out.println(jpf.getPassword());
							FriendList fl=new FriendList();
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "password and username is not null");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});	
		this.add(jl_username);
		jl_username.setBounds(40,90,100,40);
		this.add(jtf_username);
		jtf_username.setBounds(140,90,200,30);
		this.add(jl_password);
		jl_password.setBounds(40,130,100,40);
		this.add(jpf);
		jpf.setBounds(140,130,200,30);
		
		this.setLayout(null);
		this.add(jb_login);
		jb_login.setBounds(80, 200, 100, 40);
		
		this.add(jb_register);
		jb_register.setBounds(220,200, 100, 40);
		
		this.setSize(400, 300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("LOGIN");
		this.setResizable(true);
		this.setVisible(true);
		
	}
	
	/*class myPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image imgBackground=new ImageIcon("images/background.jpg").getImage();
			g.drawImage(imgBackground, 0, 0,this);
		}
	}
*/
}
