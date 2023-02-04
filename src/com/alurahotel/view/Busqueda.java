package com.alurahotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Busqueda extends JFrame {
	private JPanel window;
	
	// Show View
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create Frame
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/com/alurahotel/view/images/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		window = new JPanel();
		window.setBackground(Color.WHITE);
		window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(window);
		window.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
}
