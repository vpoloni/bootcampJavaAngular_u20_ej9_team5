package ej9;

public class App {

	public static void main(String[] args) {

		try {
			JuegoMemoria frame = new JuegoMemoria();

			frame.setVisible(true);

			frame.poblarColores();

			frame.agregarAddListener();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
