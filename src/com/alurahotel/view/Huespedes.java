package com.alurahotel.view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Huespedes extends JFrame {
	private JPanel window;
	
	// Show View
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Huespedes frame = new Huespedes(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create Frame
	public Huespedes(int reservaId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Huespedes.class.getResource("/com/alurahotel/view/images/lOGO-50PX.png")));
		// TODO Cambiar como se cierra
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		window = new JPanel();
		window.setBackground(SystemColor.text);
		window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(window);
		setLocationRelativeTo(null);
		setUndecorated(true);
		window.setLayout(null);
		
		System.out.println(reservaId);
	}
}
