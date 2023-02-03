package com.alurahotel.views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	private JPanel window;
	
	// Show View
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create Frame
	public Login() {
		// Window
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		window = new JPanel();
		window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(window);
		window.setLayout(null);
		setLocationRelativeTo(null);
		
		// Content Panel
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 788, 527);
		contentPanel.setBackground(Color.WHITE);
		window.add(contentPanel);
		contentPanel.setLayout(null);
		
		// Image Panel
		JPanel imagePanel = new JPanel();
		imagePanel.setBackground(new Color(12, 138, 199));
		imagePanel.setBounds(484, 0, 304, 527);
		contentPanel.add(imagePanel);
		imagePanel.setLayout(null);
	}
}
