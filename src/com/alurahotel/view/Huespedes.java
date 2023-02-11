package com.alurahotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Huespedes extends JFrame {
	private JPanel window;
	int xMouse, yMouse;
	private JLabel labelAtras;
	private JLabel labelExit;
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNumReserva;
	private JDateChooser txtFechaN;
	private JComboBox<Format> txtNacionalidad;
	
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
		
		// Window Header
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
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		window.add(header);
		
		// Btn Atras
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Desea cancelar la operacion
				Reservas reservas = new Reservas();
				reservas.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(new Color(12, 138, 199));
			     labelAtras.setForeground(Color.white);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		// Btn Exit/Close
		/*JPanel btnExit = new JPanel();
		btnExit.setBounds(857, 0, 53, 36);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Desea cancelar la operacion
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
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
		btnExit.setBackground(Color.white);
		window.add(btnExit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnExit.add(labelExit);*/
		
		// Panel Izquierdo
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 489, 634);
		contentPanel.setBackground(new Color(12, 138, 199));
		contentPanel.setLayout(null);
		window.add(contentPanel);
		
		// Panel Izquierdo - Imagen
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		imagenFondo.setIcon(new ImageIcon(Huespedes.class.getResource("/com/alurahotel/view/images/registro.png")));
		contentPanel.add(imagenFondo);
		
		// Logo
		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		logo.setIcon(new ImageIcon(Huespedes.class.getResource("/com/alurahotel/view/images/Ha-100px.png")));
		contentPanel.add(logo);
		
		// Form
		// Title
		JLabel labelTitulo = new JLabel("REGISTRO HUÉSPED");
		labelTitulo.setBounds(585, 55, 237, 42);
		labelTitulo.setForeground(new Color(12, 138, 199));
		labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		window.add(labelTitulo);
		
		// Nombre
		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setBounds(555, 119, 253, 14);
		labelNombre.setForeground(SystemColor.textInactiveText);
		labelNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		window.add(labelNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(555, 135, 290, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		window.add(txtNombre);
		
		JSeparator separatorNombre = new JSeparator();
		separatorNombre.setBounds(555, 170, 290, 2);
		separatorNombre.setForeground(new Color(12, 138, 199));
		separatorNombre.setBackground(new Color(12, 138, 199));
		window.add(separatorNombre);
		
		// Apellido
		JLabel labelApellido = new JLabel("APELLIDO");
		labelApellido.setBounds(555, 189, 255, 14);
		labelApellido.setForeground(SystemColor.textInactiveText);
		labelApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		window.add(labelApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(555, 204, 290, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		window.add(txtApellido);
		
		JSeparator separatorApellido = new JSeparator();
		separatorApellido.setBounds(555, 240, 290, 2);
		separatorApellido.setForeground(new Color(12, 138, 199));
		separatorApellido.setBackground(new Color(12, 138, 199));
		window.add(separatorApellido);
		
		// Fecha Nacimiento
		JLabel labelFechaN = new JLabel("FECHA DE NACIMIENTO");
		labelFechaN.setBounds(555, 256, 255, 14);
		labelFechaN.setForeground(SystemColor.textInactiveText);
		labelFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		window.add(labelFechaN);
		
		txtFechaN = new JDateChooser();
		txtFechaN.setBounds(555, 278, 290, 36);
		txtFechaN.getCalendarButton().setIcon(new ImageIcon(Huespedes.class.getResource("/com/alurahotel/view/images/icon-reservas.png")));
		txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		window.add(txtFechaN);
		
		JSeparator separatorFechaN = new JSeparator();
		separatorFechaN.setBounds(555, 314, 290, 2);
		separatorFechaN.setForeground(new Color(12, 138, 199));
		separatorFechaN.setBackground(new Color(12, 138, 199));
		window.add(separatorFechaN);
		
		// Nacionalidad
		JLabel labelNacionalidad = new JLabel("NACIONALIDAD");
		labelNacionalidad.setBounds(555, 326, 255, 14);
		labelNacionalidad.setForeground(SystemColor.textInactiveText);
		labelNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		window.add(labelNacionalidad);
		
		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(555, 350, 290, 36);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] { "Elige una opción", "afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita" }));
		window.add(txtNacionalidad);
		
		JSeparator separatorNacionalidad = new JSeparator();
		separatorNacionalidad.setBounds(555, 386, 290, 2);
		separatorNacionalidad.setForeground(new Color(12, 138, 199));
		separatorNacionalidad.setBackground(new Color(12, 138, 199));
		window.add(separatorNacionalidad);
		
		// Telefono
		JLabel labelTelefono = new JLabel("TELÉFONO");
		labelTelefono.setBounds(555, 406, 253, 14);
		labelTelefono.setForeground(SystemColor.textInactiveText);
		labelTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		window.add(labelTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(555, 424, 290, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		window.add(txtTelefono);
		
		JSeparator separatorTelefono = new JSeparator();
		separatorTelefono.setBounds(555, 457, 290, 2);
		separatorTelefono.setForeground(new Color(12, 138, 199));
		separatorTelefono.setBackground(new Color(12, 138, 199));
		window.add(separatorTelefono);
		
		// Numero de Reserva
		JLabel labelNumReserva = new JLabel("NÚMERO DE RESERVA");
		labelNumReserva .setBounds(555, 474, 253, 14);
		labelNumReserva .setForeground(SystemColor.textInactiveText);
		labelNumReserva .setFont(new Font("Roboto Black", Font.PLAIN, 18));
		window.add(labelNumReserva );
		
		txtNumReserva = new JTextField(String.valueOf(reservaId));
		txtNumReserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNumReserva.setBounds(555, 495, 290, 33);
		txtNumReserva.setColumns(10);
		txtNumReserva.setBackground(Color.WHITE);
		txtNumReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtNumReserva.setEditable(false);
		window.add(txtNumReserva);
		
		JSeparator separatorNumReserva = new JSeparator();
		separatorNumReserva.setBounds(555, 529, 290, 2);
		separatorNumReserva.setForeground(new Color(12, 138, 199));
		separatorNumReserva.setBackground(new Color(12, 138, 199));
		window.add(separatorNumReserva);
		
		// Btn Guardar
		JPanel btnGuardar = new JPanel();
		btnGuardar.setBounds(723, 560, 122, 35);
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO Guardar Huesped
			}
		});
		btnGuardar.setLayout(null);
		btnGuardar.setBackground(new Color(12, 138, 199));
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		window.add(btnGuardar);
		
		JLabel labelGuardar = new JLabel("GUARDAR");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnGuardar.add(labelGuardar);
	}
	
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
