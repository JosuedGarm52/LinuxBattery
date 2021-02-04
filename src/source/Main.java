package source;

import java.awt.EventQueue;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
import java.awt.Toolkit;

public class Main {

	private JFrame frmBatterLinux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmBatterLinux.setVisible(true);
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
	//String ruta = "BatteryLinx/src/Draw/battEsc.png";
	//String relativeWebPath = "/src/Draw/battEsc.png";
	//String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
	String bat="";
	String estado="";
	Bateria bateria = new Bateria();
	JLabel lblNewLabel;
	JLabel lblEstado; 
	JLabel lblPorcentaje;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBatterLinux = new JFrame();
		frmBatterLinux.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/josue-user/Repos/ProyectoJava/BatteryLinux/src/Draw/batt4.png"));
		frmBatterLinux.setTitle("Battery Linux");
		frmBatterLinux.setBounds(100, 100, 450, 300);
		frmBatterLinux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBatterLinux.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 47, 138, 190);
		lblNewLabel.setIcon(new ImageIcon("/home/josue-user/Repos/ProyectoJava/BatteryLinux/src/Draw/battEsc.png"));
		frmBatterLinux.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(168, 77, 245, 114);
		frmBatterLinux.getContentPane().add(panel);
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
		frmBatterLinux.getContentPane().add(btnSalir);
		bateria = new Bateria();
		
		try
		{
			bat = bateria.getNivel()+"%";
			estado = bateria.getStatus();
		}catch(Exception excepcion)
        {
	         excepcion.printStackTrace();
        }
		lblEstado = new JLabel(estado);
		lblEstado.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEstado.setBounds(76, 12, 124, 15);
		panel.add(lblEstado);
		final String v = bateria.getComando;
		lblPorcentaje = new JLabel(bat);
		lblPorcentaje.setFont(new Font("Dialog", Font.BOLD, 50));
		lblPorcentaje.setBounds(24, 54, 176, 48);
		panel.add(lblPorcentaje);
		JButton btnActualizar = new JButton("Estado");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ff = bateria.getNivel()+"%";
				String fff = bateria.getComando;
				lblPorcentaje.setText(ff);
				JOptionPane.showMessageDialog(null, "Resultado: "+ff+" de la terminal: "+ fff);
			}
		});
		btnActualizar.setBounds(167, 203, 117, 25);
		frmBatterLinux.getContentPane().add(btnActualizar);
		control c = new control();
		ScheduledExecutorService sche = Executors.newScheduledThreadPool(1);
		sche.scheduleAtFixedRate(c, 0, 30, TimeUnit.SECONDS);
		
	}
	private void Cambiar()
	{
		bateria= new Bateria();
		int vv = bateria.getNivelBateria();
		switch(vv)
		{
			case 0:
				lblNewLabel.setIcon(new ImageIcon("/home/josue-user/Repos/ProyectoJava/BatteryLinux/src/Draw/battEsc.png"));
			break;
			case 1:
				lblNewLabel.setIcon(new ImageIcon("/home/josue-user/Repos/ProyectoJava/BatteryLinux/src/Draw//batt1.png"));
			break;
			case 2:
				lblNewLabel.setIcon(new ImageIcon("/home/josue-user/Repos/ProyectoJava/BatteryLinux/src/Draw//batt2.png"));
			break;
			case 3:
				lblNewLabel.setIcon(new ImageIcon("/home/josue-user/Repos/ProyectoJava/BatteryLinux/src/Draw//batt3.png"));
			break;
			case 4:
				lblNewLabel.setIcon(new ImageIcon("/home/josue-user/Repos/ProyectoJava/BatteryLinux/src/Draw//batt4.png"));
			break;
			default:
				JOptionPane.showMessageDialog(null, "Error");
			break;
		}
		String f= bateria.getStatus();
		lblEstado.setText(f);
		String ff = bateria.getNivel()+"%";
		lblPorcentaje.setText(ff);
	}
	ImageIcon imagen1 =new ImageIcon("imagenes"+File.separator+"open.png");
	private class control implements Runnable
	{
		public control()  {
			// TODO Auto-generated constructor stub
		}

		public void run() {
			
			Cambiar();
			//JOptionPane.showMessageDialog(null,"1");
			
			//JOptionPane.showMessageDialog(null,"Se esta ejecutando correctamente");
		}
		
		
	}
}
