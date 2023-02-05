package com.alurahotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Reservas extends JFrame {
	private JPanel window;
	int xMouse, yMouse;
	private JLabel labelExit;
	
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
		
		// Panel Imagenes
		JPanel imagesPanel = new JPanel();
		imagesPanel.setBounds(428, 0, 482, 560);
		imagesPanel.setBackground(new Color(12, 138, 199));
		imagesPanel.setLayout(null);
		contentPanel.add(imagesPanel);
		
		// Logo
		JLabel imageLogo = new JLabel("");
		imageLogo.setBounds(197, 68, 104, 107);
		imageLogo.setIcon(new ImageIcon(Reservas.class.getResource("/com/alurahotel/view/images/Ha-100px.png")));
		imagesPanel.add(imageLogo);
		
		// Imagen Fondo
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 500, 409);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(Reservas.class.getResource("/com/alurahotel/view/images/reservas-img-3.png")));
		imagesPanel.add(imagenFondo);
		
		// Content Panel Header
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
		
		// Btn Exit Close windows
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
				dispose();
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
		btnExit.setLayout(null);
		btnExit.setBackground(new Color(12, 138, 199));
		btnExit.setBounds(429, 0, 53, 36);
		imagesPanel.add(btnExit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnExit.add(labelExit);
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
