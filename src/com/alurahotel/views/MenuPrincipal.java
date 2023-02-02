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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {
	private JPanel window;
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
		window = new JPanel();
		window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(window);
		window.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		// Panel
		Panel contentPanel = new Panel();
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBounds(0, 0, 910, 537);
		window.add(contentPanel);
		contentPanel.setLayout(null);
		
		// Panel Body Logo - Image
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setBounds(-50, 0, 732, 501);
		backgroundImage.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/com/alurahotel/views/images/menu-img.png")));
		contentPanel.add(backgroundImage);
		
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
		contentPanel.add(header);
		
		// Panel - Header - Btn Exit/Close
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Quiere salir de la aplicación?", "Aviso", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					System.exit(0);
				}
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
		contentPanel.add(imageLogo);
		
		// Login
		JLabel labelLoginTitulo = new JLabel("LOGIN");
		labelLoginTitulo.setBounds(754, 265, 83, 24);
		labelLoginTitulo.setBackground(SystemColor.window);
		contentPanel.add(labelLoginTitulo);
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
		contentPanel.add(btnLogin);
		
		JLabel imageLogin = new JLabel("");
		imageLogin.setBounds(0, 0, 80, 70);
		btnLogin.add(imageLogin);
		imageLogin.setHorizontalAlignment(SwingConstants.CENTER);
		imageLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/com/alurahotel/views/images/login.png")));
		
		// Footer
		JPanel footer = new JPanel();
		footer.setBounds(0, 500, 910, 37);
		footer.setBackground(new Color(12, 138, 199));
		contentPanel.add(footer);
		footer.setLayout(null);
		
		JLabel labelCopyR = new JLabel("Desarrollado por Alan Montes de Oca Garcia © 2022");
		labelCopyR.setBounds(270, 11, 370, 19);
		labelCopyR.setForeground(new Color(240, 248, 255));
		labelCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
		footer.add(labelCopyR);
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
