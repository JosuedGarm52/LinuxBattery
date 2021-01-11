package source;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}
	String ruta = "/home/josue-user/Imágenes/battEsc.png";
	String bat="";
	String estado="";
	Bateria bateria = new Bateria();
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 47, 138, 190);
		lblNewLabel.setIcon(new ImageIcon(ruta));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(168, 77, 245, 114);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(12, 12, 52, 15);
		panel.add(lblStatus);
		
		
		
		/*JLabel lblPorcentaje = new JLabel("00%");
		lblPorcentaje.setFont(new Font("Dialog", Font.BOLD, 50));
		lblPorcentaje.setBounds(24, 54, 176, 48);
		panel.add(lblPorcentaje);*/
		
		
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(296, 203, 117, 25);
		frame.getContentPane().add(btnSalir);
		bateria = new Bateria();
		
		try
		{
			bat = bateria.getNivel()+"%";
			estado = bateria.getStatus();
		}catch(Exception excepcion)
        {
	         excepcion.printStackTrace();
        }
		JLabel lblEstado = new JLabel(estado);
		lblEstado.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEstado.setBounds(76, 12, 124, 15);
		panel.add(lblEstado);
		final String v = bateria.getComando;
		JLabel lblPorcentaje = new JLabel(bat);
		lblPorcentaje.setFont(new Font("Dialog", Font.BOLD, 50));
		lblPorcentaje.setBounds(24, 54, 176, 48);
		panel.add(lblPorcentaje);
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bateria= new Bateria();
				JOptionPane.showMessageDialog(null, "Resultado: "+bat+" de la terminal: "+v);
			}
		});
		btnActualizar.setBounds(167, 203, 117, 25);
		frame.getContentPane().add(btnActualizar);
	}
	
	ImageIcon imagen1 =new ImageIcon("imagenes"+File.separator+"open.png");
}
