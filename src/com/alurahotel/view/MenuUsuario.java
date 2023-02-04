package com.alurahotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuUsuario extends JFrame {
	private JPanel window;
	int xMouse, yMouse;
	private JLabel labelExit;
	
	// Show View
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create frame
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/com/alurahotel/view/images/aH-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		window = new JPanel();
		window.setBackground(Color.WHITE);
		window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(window);
		window.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		// Window Header
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
		
		// Btn Exit / Close Window
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
				btnExit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		
		btnExit.setLayout(null);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(891, 0, 53, 36);
		header.add(btnExit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnExit.add(labelExit);
		
		// Window Menu
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		window.add(panelMenu);
		panelMenu.setLayout(null);
		
		// Menu Logo
		JLabel imageLogo = new JLabel("");
		imageLogo.setBounds(50, 58, 150, 150);
		panelMenu.add(imageLogo);
		imageLogo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/com/alurahotel/view/images/aH-150px.png")));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		window.add(header);
		
		// Btn Registrar Reservas
		JPanel btnRegistro = new JPanel();
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Reservas reservas = new Reservas();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegistro);
		btnRegistro.setLayout(null);
		
		JLabel labelRegistro = new JLabel("Registro de reservas");
		labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/com/alurahotel/view/images/reservado.png")));
		labelRegistro.setForeground(SystemColor.text);
		labelRegistro.setBounds(25, 11, 205, 34);
		labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(labelRegistro);
		
		// Btn Busqueda de Reservas
		JPanel btnBusqueda = new JPanel();
		btnBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		btnBusqueda.setBounds(0, 312, 257, 56);
		btnBusqueda.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnBusqueda);
		btnBusqueda.setLayout(null);
		
		JLabel lblBusquedaDeReservas = new JLabel("Búsqueda");
		lblBusquedaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/com/alurahotel/view/images/pessoas.png")));
		lblBusquedaDeReservas.setBounds(27, 11, 200, 34);
		lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBusquedaDeReservas.setForeground(Color.WHITE);
		lblBusquedaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBusqueda.add(lblBusquedaDeReservas);
		
		// Window Panel Fecha
		JPanel panelFecha = new JPanel();
	    panelFecha.setBackground(new Color(118, 187, 223));
	    panelFecha.setBounds(256, 84, 688, 121);
	    panelFecha.setLayout(null);
	    window.add(panelFecha);
	    
	    // Panel Fecha Titulo
		JLabel labelPanelFechaTitulo = new JLabel("Sistema de reservas Hotel Alura");
		labelPanelFechaTitulo.setBounds(180, 11, 356, 42);
	    labelPanelFechaTitulo.setForeground(Color.WHITE);
	    labelPanelFechaTitulo.setFont(new Font("Roboto", Font.PLAIN, 24));
	    panelFecha.add(labelPanelFechaTitulo);
	   
	    // Fecha/Hora actual
	    Date fechaActual = new Date();
	    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual);
	    
	    // Panel Fecha Mostrar Fecha
	    JLabel labelPanelFecha_Fecha = new JLabel("New label");
	    labelPanelFecha_Fecha.setBounds(35, 64, 294, 36);
	    labelPanelFecha_Fecha.setForeground(Color.WHITE);
	    labelPanelFecha_Fecha.setFont(new Font("Roboto", Font.PLAIN, 33));
	    labelPanelFecha_Fecha.setText("Hoy es " + fecha);
	    panelFecha.add(labelPanelFecha_Fecha);
	    
	    // Titulo de Contenido
	    JLabel labelTituloContenido = new JLabel("Bienvenido");
	    labelTituloContenido.setFont(new Font("Roboto", Font.BOLD, 24));
	    labelTituloContenido.setBounds(302, 234, 147, 46);
	    window.add(labelTituloContenido);
	    
	    // Descripcion Parrafo 1
	    String textoDescripcionP1 = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel   </body></html>";
	    JLabel labelDescripcionP1 = new JLabel(textoDescripcionP1);
	    labelDescripcionP1.setFont(new Font("Roboto", Font.PLAIN, 17));
	    labelDescripcionP1.setBounds(312, 291, 598, 66);
	    window.add(labelDescripcionP1);
	    
	    // Descripcion Parrafo 2
	    String textoDescripcionP2 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
	    JLabel labelDescripcionP2 = new JLabel(textoDescripcionP2);
	    labelDescripcionP2.setFont(new Font("Roboto", Font.PLAIN, 17));
	    labelDescripcionP2.setBounds(311, 345, 569, 88);
	    window.add(labelDescripcionP2);
	    
	    // Lista de Funciones
	    JLabel labelFuncion1 = new JLabel("- Registro de Reservas y Huéspedes");
	    labelFuncion1.setFont(new Font("Roboto", Font.PLAIN, 17));
	    labelFuncion1.setBounds(312, 444, 295, 27);
	    window.add(labelFuncion1);
	    
	    JLabel labelFuncion2 = new JLabel("- Edición de Reservas y Huéspedes existentes");
	    labelFuncion2.setFont(new Font("Roboto", Font.PLAIN, 17));
	    labelFuncion2.setBounds(312, 482, 355, 27);
	    window.add(labelFuncion2);
	    
	    JLabel labelFuncion3 = new JLabel("- Eliminar todo tipo de registros");
	    labelFuncion3.setFont(new Font("Roboto", Font.PLAIN, 17));
	    labelFuncion3.setBounds(312, 520, 295, 27);
	    window.add(labelFuncion3);
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
