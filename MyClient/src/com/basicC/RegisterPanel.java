package com.basicC;

import java.awt.*;

import javax.swing.*;

public class RegisterPanel extends JFrame{
	
	public RegisterPanel(){
		Color bgColor=new Color(30,189,120);
		this.setBackground(bgColor);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Register");
		this.setSize(400, 500);
	}
}
