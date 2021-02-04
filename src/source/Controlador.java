package source;

public class Controlador extends Thread  {
	//private String nombre;

	//private long initialTime;

	// Constructor, getter & setter

	public Controlador() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 10000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}