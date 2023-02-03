package com.alurahotel.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	private JPanel window;
	private JLabel labelExit;
	
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
		
		// Btn Exit
		JPanel btnExit = new JPanel();
		btnExit.setBounds(251, 0, 53, 36);
		imagePanel.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnExit.setBackground(new Color(12, 138, 199));
		btnExit.setLayout(null);
		btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelExit);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Image Logo
		JLabel imageLogo = new JLabel("");
		imageLogo.setHorizontalAlignment(SwingConstants.CENTER);
		imageLogo.setIcon(new ImageIcon(Login.class.getResource("/com/alurahotel/views/images/lOGO-50PX.png")));
		imageLogo.setBounds(65, 65, 48, 59);
		contentPanel.add(imageLogo);
	}
}
