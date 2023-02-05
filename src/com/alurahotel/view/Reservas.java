package com.alurahotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Reservas extends JFrame {
	private JPanel window;
	int xMouse, yMouse;
	
	// Show View
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create Frame
	public Reservas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reservas.class.getResource("/com/alurahotel/view/images/aH-40px.png")));
		// TODO Modificar tipo de cerrado
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		window = new JPanel();
		window.setBackground(SystemColor.control);
		window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(window);
		window.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		// Panel de Contenido
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 910, 560);
		window.add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel contentPanelHeader = new JPanel();
		contentPanelHeader.setBounds(0, 0, 910, 36);
		contentPanelHeader.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		contentPanelHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		contentPanelHeader.setLayout(null);
		contentPanelHeader.setBackground(Color.WHITE);
		contentPanel.add(contentPanelHeader);
	}
	
	// Window Move
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
