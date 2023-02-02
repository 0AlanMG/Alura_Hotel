package com.alurahotel.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
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

public class MenuPrincipal extends JFrame {
	private JPanel contentPanel;
	private JLabel labelExit;
	int xMouse, yMouse;
	
	// Show View
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create Frame
	public MenuPrincipal() {
		// Content Panel
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/com/alurahotel/views/images/aH-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		// Panel
		Panel panel = new Panel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 910, 537);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		// Panel Body Logo - Image
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(-50, 0, 732, 501);
		imagenFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/com/alurahotel/views/images/menu-img.png")));
		panel.add(imagenFondo);
		
		// Panel - Header
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		// Panel - Header - Btn Exit/Close
		JPanel btnExit = new JPanel();
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
				btnExit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnExit.setLayout(null);
		btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(857, 0, 53, 36);
		header.add(btnExit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnExit.add(labelExit);
		
		// Image Logo
		JLabel imageLogo = new JLabel("");
		imageLogo.setBounds(722, 80, 150, 156);
		imageLogo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/com/alurahotel/views/images/aH-150px.png")));
		panel.add(imageLogo);
		
		// Login
		JLabel labelLoginTitulo = new JLabel("LOGIN");
		labelLoginTitulo.setBounds(754, 265, 83, 24);
		labelLoginTitulo.setBackground(SystemColor.window);
		panel.add(labelLoginTitulo);
		labelLoginTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLoginTitulo.setForeground(SystemColor.textHighlight);
		labelLoginTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));
		
		JPanel btnLogin = new JPanel(); 
		btnLogin.setBounds(754, 300, 83, 70);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
				/*Login login = new Login();
				login.setVisible(true);
				dispose();*/
			}
		});
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setBackground(SystemColor.window);
		panel.add(btnLogin);
		
		JLabel imageLogin = new JLabel("");
		imageLogin.setBounds(0, 0, 80, 70);
		btnLogin.add(imageLogin);
		imageLogin.setHorizontalAlignment(SwingConstants.CENTER);
		imageLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/com/alurahotel/views/images/login.png")));
	}
	
	// Content Panel Move 
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
