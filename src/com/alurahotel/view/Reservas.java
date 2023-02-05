package com.alurahotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.Format;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class Reservas extends JFrame {
	private JPanel window;
	int xMouse, yMouse;
	private JLabel labelAtras;
	private JLabel labelExit;
	
	public static JDateChooser txtCheckIn;
	public static JDateChooser txtCheckOut;
	public static JTextField txtValor;
	private JLabel labelValorSimbolo;
	public static JComboBox<Format> txtFormaPago;
	
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		
		// Formulario
		// Titulo
		JLabel labelTitulo = new JLabel("SISTEMA DE RESERVAS");
		labelTitulo.setBounds(93, 60, 235, 42);
		labelTitulo.setForeground(new Color(12, 138, 199));
		labelTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		contentPanel.add(labelTitulo);
		
		// Check In
		JLabel labelCheckIn = new JLabel("FECHA DE CHECK IN");
		labelCheckIn.setForeground(SystemColor.textInactiveText);
		labelCheckIn.setBounds(47, 136, 180, 14);
		labelCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPanel.add(labelCheckIn);
		
		txtCheckIn = new JDateChooser();
		txtCheckIn.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtCheckIn.getCalendarButton().setIcon(new ImageIcon(Reservas.class.getResource("/com/alurahotel/view/images/icon-reservas.png")));
		txtCheckIn.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtCheckIn.setBounds(47, 161, 330, 35);
		txtCheckIn.getCalendarButton().setBounds(268, 0, 21, 33);
		txtCheckIn.setBackground(Color.WHITE);
		txtCheckIn.setBorder(new LineBorder(SystemColor.window));
		txtCheckIn.setDateFormatString("yyyy-MM-dd");
		txtCheckIn.setFont(new Font("Roboto", Font.PLAIN, 18));
		contentPanel.add(txtCheckIn);
		
		JSeparator separatorCheckIn = new JSeparator();
		separatorCheckIn.setForeground(SystemColor.textHighlight);
		separatorCheckIn.setBounds(47, 196, 330, 2);
		separatorCheckIn.setBackground(SystemColor.textHighlight);
		contentPanel.add(separatorCheckIn);
		
		// Check Out
		JLabel labelCheckOut = new JLabel("FECHA DE CHECK OUT");
		labelCheckOut.setForeground(SystemColor.textInactiveText);
		labelCheckOut.setBounds(47, 221, 202, 14);
		labelCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPanel.add(labelCheckOut);
		
		txtCheckOut = new JDateChooser();
		txtCheckOut.getCalendarButton().setIcon(new ImageIcon(Reservas.class.getResource("/com/alurahotel/view/images/icon-reservas.png")));
		txtCheckOut.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtCheckOut.setBounds(47, 246, 330, 35);
		txtCheckOut.getCalendarButton().setBounds(267, 1, 21, 31);
		txtCheckOut.setBackground(Color.WHITE);
		txtCheckOut.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtCheckOut.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO
				// Activa el evento, después del usuario seleccionar las fechas se debe calcular el valor de la reserva
			}
		});
		txtCheckOut.setDateFormatString("yyyy-MM-dd");
		txtCheckOut.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtCheckOut.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		contentPanel.add(txtCheckOut);
		
		JSeparator separatorCheckOut = new JSeparator();
		separatorCheckOut.setForeground(SystemColor.textHighlight);
		separatorCheckOut.setBounds(47, 281, 330, 2);
		separatorCheckOut.setBackground(SystemColor.textHighlight);
		contentPanel.add(separatorCheckOut);
		
		// Valor de La Reserva
		JLabel labelValor = new JLabel("VALOR DE LA RESERVA");
		labelValor.setForeground(SystemColor.textInactiveText);
		labelValor.setBounds(47, 303, 204, 14);
		labelValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPanel.add(labelValor);
		
		labelValorSimbolo = new JLabel("$");
		labelValorSimbolo.setVisible(false);
		labelValorSimbolo.setBounds(121, 332, 17, 25);
		labelValorSimbolo.setForeground(SystemColor.textHighlight);
		labelValorSimbolo.setFont(new Font("Roboto", Font.BOLD, 17));
		contentPanel.add(labelValorSimbolo);
		
		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(47, 328, 330, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtValor.setColumns(10);
		contentPanel.add(txtValor);
		
		JSeparator separatorValor = new JSeparator();
		separatorValor.setForeground(SystemColor.textHighlight);
		separatorValor.setBounds(47, 362, 330, 2);
		separatorValor.setBackground(SystemColor.textHighlight);
		contentPanel.add(separatorValor);
		
		// Forma de Pago
		JLabel labelFormaPago = new JLabel("FORMA DE PAGO");
		labelFormaPago.setForeground(SystemColor.textInactiveText);
		labelFormaPago.setBounds(47, 382, 187, 24);
		labelFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPanel.add(labelFormaPago);
		
		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(47, 417, 330, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {
				"Tarjeta de Crédito", 
				"Tarjeta de Débito", 
				"Dinero en Efectivo"}));
		contentPanel.add(txtFormaPago);
		
		JSeparator separatorFormaPago = new JSeparator();
		separatorFormaPago.setForeground(SystemColor.textHighlight);
		separatorFormaPago.setBackground(SystemColor.textHighlight);
		separatorFormaPago.setBounds(47, 455, 330, 2);
		contentPanel.add(separatorFormaPago);
		
		// Btn Siguiente
		JPanel btnSiguiente = new JPanel();
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Verificar Validaciones
				if (Reservas.txtCheckIn.getDate() != null && Reservas.txtCheckOut.getDate() != null) {		
					// TODO Registrar Huesped
					/*RegistroHuesped registro = new RegistroHuesped();
					registro.setVisible(true);*/
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}						
		});
		btnSiguiente.setLayout(null);
		btnSiguiente.setBackground(SystemColor.textHighlight);
		btnSiguiente.setBounds(238, 493, 122, 35);
		btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPanel.add(btnSiguiente);
		
		JLabel labelSiguiente = new JLabel("SIGUIENTE");
		labelSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		labelSiguiente.setForeground(Color.WHITE);
		labelSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelSiguiente.setBounds(0, 0, 122, 35);
		btnSiguiente.add(labelSiguiente);
		
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
		
		// Btn Atras
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		contentPanelHeader.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		btnAtras.add(labelAtras);
		
		// Btn Exit Close windows
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Quiere cerrar sesión?", "Aviso", JOptionPane.YES_NO_OPTION) == 0) {
					Login login = new Login();
					login.setVisible(true);
					dispose();
				}
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
