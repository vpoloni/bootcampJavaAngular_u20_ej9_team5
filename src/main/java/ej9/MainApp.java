package ej9;

import java.awt.EventQueue;

public class MainApp {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					// instanciamos la clase JuegoMemoria
					JuegoMemoria frame = new JuegoMemoria();
					// invocamos los métodos
					frame.setVisible(true);

					frame.poblarColores();

					frame.agregarAddListener();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
