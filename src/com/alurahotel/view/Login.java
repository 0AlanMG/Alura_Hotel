package com.alurahotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.alurahotel.controller.UsuarioController;

public class Login extends JFrame {
	private JPanel window;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	
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
		
		// Content Panel - Header
		JPanel header = new JPanel();
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
		header.setBackground(SystemColor.window);
		header.setBounds(0, 0, 784, 36);
		contentPanel.add(header);
		header.setLayout(null);
		
		// Btn Exit
		JPanel btnExit = new JPanel();
		btnExit.setBounds(251, 0, 53, 36);
		imagePanel.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
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
		btnExit.setBackground(new Color(12, 138, 199));
		btnExit.setLayout(null);
		btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.add(labelExit);
		
		// Image Hotel
		JLabel imageHotel = new JLabel("");
		imageHotel.setBounds(0, 0, 304, 538);
		imageHotel.setIcon(new ImageIcon(Login.class.getResource("/com/alurahotel/view/images/img-hotel-login-.png")));
		imagePanel.add(imageHotel);
		
		// Image Logo
		JLabel imageLogo = new JLabel("");
		imageLogo.setHorizontalAlignment(SwingConstants.CENTER);
		imageLogo.setIcon(new ImageIcon(Login.class.getResource("/com/alurahotel/view/images/lOGO-50PX.png")));
		imageLogo.setBounds(65, 65, 48, 59);
		contentPanel.add(imageLogo);
		
		// Form Title
		JLabel labelFormTitulo = new JLabel("INICIAR SESIÓN");
		labelFormTitulo.setForeground(SystemColor.textHighlight);
		labelFormTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		labelFormTitulo.setBounds(65, 149, 202, 26);
		contentPanel.add(labelFormTitulo);
		
		// Form Data User
		JLabel labelUser = new JLabel("USUARIO");
		labelUser.setForeground(SystemColor.textInactiveText);
		labelUser.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		labelUser.setBounds(65, 219, 107, 26);
		contentPanel.add(labelUser);
		
		txtUser = new JTextField();
		txtUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (txtUser.getText().equals("Ingrese su nombre de usuario")) {
					 txtUser.setText("");
					 txtUser.setForeground(Color.black);
			        }
			        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
			        	txtPassword.setText("********");
			        	txtPassword.setForeground(Color.gray);
			        }
			}
		});
		txtUser.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUser.setText("Ingrese su nombre de usuario");
		txtUser.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUser.setForeground(SystemColor.activeCaptionBorder);
		txtUser.setBounds(65, 256, 324, 32);
		txtUser.setColumns(10);
		contentPanel.add(txtUser);
		
		JSeparator separatorUser = new JSeparator();
		separatorUser.setBackground(new Color(0, 120, 215));
		separatorUser.setBounds(65, 292, 324, 2);
		contentPanel.add(separatorUser);
		
		// Form Data Password
		JLabel labelPassword = new JLabel("CONTRASEÑA");
		labelPassword.setForeground(SystemColor.textInactiveText);
		labelPassword.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		labelPassword.setBounds(65, 316, 140, 26);
		contentPanel.add(labelPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("********");
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtPassword.getPassword()).equals("********")) {
					txtPassword.setText("");
					txtPassword.setForeground(Color.black);
		        }
		        if (txtUser.getText().isEmpty()) {
		        	txtUser.setText("Ingrese su nombre de usuario");
		        	txtUser.setForeground(Color.gray);
		        }
			}
		});
		txtPassword.setForeground(SystemColor.activeCaptionBorder);
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtPassword.setBounds(65, 353, 324, 32);
		contentPanel.add(txtPassword);
		
		JSeparator separatorPassword = new JSeparator();
		separatorPassword.setBackground(SystemColor.textHighlight);
		separatorPassword.setBounds(65, 393, 324, 2);
		contentPanel.add(separatorPassword);
		
		// Btn Login
		JPanel btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				UsuarioController usuarioController = new UsuarioController();
				if(usuarioController.autentificar(txtUser.getText(), new String (txtPassword.getPassword()))) {
					MenuUsuario menu = new MenuUsuario();
		            menu.setVisible(true);
		            dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña no válidos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(65, 431, 122, 44);
		contentPanel.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelLogin = new JLabel("ENTRAR");
		labelLogin.setBounds(0, 0, 122, 44);
		labelLogin.setForeground(SystemColor.controlLtHighlight);
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogin.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnLogin.add(labelLogin);
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
