package ej9;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;

public class JuegoMemoria extends JFrame {

	private static final long serialVersionUID = 1L;

	// toggleButtons
	private JToggleButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	private JToggleButton btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16;
	
	// array de toggleButtons
	ArrayList<JToggleButton> arrayBotones = new ArrayList<JToggleButton>();
		
	// array de colores disponibles (16)
	public Color[] coloresDisponibles = { Color.WHITE, Color.BLACK, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN,
			Color.ORANGE, Color.RED, Color.WHITE, Color.BLACK, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN, Color.ORANGE, Color.RED };
	
	// arrayList de colores poblados
	ArrayList<Color> misColores = new ArrayList<Color>();
	
	// variables para guardar colores de botones clickados
	Color color1, color2;

	// variables para guardar índices de botones clickados
	int indexBtn1, indexBtn2;

	// variables para guardar el estado de botones clickados (si son iguales o no)
	boolean coloresIguales, volverAlEstadoInicial;
	
	public JuegoMemoria() {
		
		setTitle("Juego de memoria");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn1 = new JToggleButton("");
		btn1.setBounds(61, 10, 57, 53);
		// color no se muestra cuando el toggleButton está seleccionado
		btn1.setSelected(true);
		arrayBotones.add(btn1);
		contentPane.add(btn1);

		btn2 = new JToggleButton("");
		btn2.setBounds(61, 73, 57, 58);
		btn2.setSelected(true);
		arrayBotones.add(btn2);
		contentPane.add(btn2);

		btn3 = new JToggleButton("");
		btn3.setBounds(61, 137, 57, 53);
		btn3.setSelected(true);
		arrayBotones.add(btn3);
		contentPane.add(btn3);

		btn4 = new JToggleButton("");
		btn4.setBounds(61, 200, 57, 53);
		btn4.setSelected(true);
		arrayBotones.add(btn4);
		contentPane.add(btn4);

		btn5 = new JToggleButton("");
		btn5.setBounds(147, 10, 57, 53);
		btn5.setSelected(true);
		arrayBotones.add(btn5);
		contentPane.add(btn5);

		btn6 = new JToggleButton("");
		btn6.setBounds(147, 78, 57, 53);
		btn6.setSelected(true);
		arrayBotones.add(btn6);
		contentPane.add(btn6);

		btn7 = new JToggleButton("");
		btn7.setBounds(147, 137, 57, 53);
		btn7.setSelected(true);
		arrayBotones.add(btn7);
		contentPane.add(btn7);

		btn8 = new JToggleButton("");
		btn8.setBounds(147, 200, 57, 53);
		btn8.setSelected(true);
		arrayBotones.add(btn8);
		contentPane.add(btn8);

		btn9 = new JToggleButton("");
		btn9.setBounds(233, 10, 57, 53);
		btn9.setSelected(true);
		arrayBotones.add(btn9);
		contentPane.add(btn9);

		btn10 = new JToggleButton("");
		btn10.setBounds(233, 76, 57, 53);
		btn10.setSelected(true);
		arrayBotones.add(btn10);
		contentPane.add(btn10);

		btn11 = new JToggleButton("");
		btn11.setBounds(233, 139, 57, 51);
		btn11.setSelected(true);
		arrayBotones.add(btn11);
		contentPane.add(btn11);

		btn12 = new JToggleButton("");
		btn12.setBounds(233, 198, 57, 56);
		btn12.setSelected(true);
		arrayBotones.add(btn12);
		contentPane.add(btn12);

		btn13 = new JToggleButton("");
		btn13.setBounds(325, 10, 57, 53);
		btn13.setSelected(true);
		arrayBotones.add(btn13);
		contentPane.add(btn13);

		btn14 = new JToggleButton("");
		btn14.setBounds(325, 73, 57, 55);
		btn14.setSelected(true);
		arrayBotones.add(btn14);
		contentPane.add(btn14);

		btn15 = new JToggleButton("");
		btn15.setBounds(325, 137, 57, 53);
		btn15.setSelected(true);
		arrayBotones.add(btn15);
		contentPane.add(btn15);

		btn16 = new JToggleButton("");
		btn16.setBounds(325, 200, 57, 53);
		btn16.setSelected(true);
		arrayBotones.add(btn16);
		contentPane.add(btn16);

	}
	// añadimos listeners a cada posición del array de botones
	public void agregarAddListener() {

		for (int i = 0; i < arrayBotones.size(); i++) {
			final int indBtn = i;
			arrayBotones.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// llamamos a la función que setea el color a cada índice del array de botones
					arrayBotones.get(indBtn).setBackground(devolverColor(indBtn));
				}

			});
		}
	}

	public void poblarColores() {
		
		// poblamos el array de colores con colores disponibles
		for (int i = 0; i < coloresDisponibles.length; i++) {
			misColores.add(coloresDisponibles[i]);
		}
	}

	public Color devolverColor(int i) {
		
		// llamamos a la función para comprobar el estado de botones clickados
		cambiarEstadoBotones();

		// si variable color1 es null
		if (color1 == null) {
			// asignamos el color obtenido del ArrayList cogiendo el mismo índice que tiene el botón clickado
			color1 = misColores.get(i); 
			// asignamos el indice del botón clickado a la variable indexBtn;
			indexBtn1 = i; 
		} else {
			color2 = misColores.get(i);
			indexBtn2 = i;

			// si los colores son iguales
			if (color1.equals(color2)) {
				// reseteamos valores de colores
				color1 = null;
				color2 = null;
				// guardamos el estado de dos botones clickados (son iguales)
				coloresIguales = true;
			} else {

				color1 = null;
				color2 = null;
				// guardamos el estado de dos botones clickados (no son iguales)
				volverAlEstadoInicial = true;
			}
		}

		return misColores.get(i);
	}

	// función que mira si se cumplen las condiciones para cambiar el estado de los botones clickados
	public void cambiarEstadoBotones() {
		
		if (coloresIguales) {
			// si son iguales - serán invisibles
			arrayBotones.get(indexBtn1).setVisible(false);
			arrayBotones.get(indexBtn2).setVisible(false);
			// cuando clickamos el tercer botón, la condición no se cumple
			coloresIguales = false;
		}

		if (volverAlEstadoInicial) {
			// si no son iguales  - dejaran de mostrar su color
			arrayBotones.get(indexBtn1).setSelected(true);
			arrayBotones.get(indexBtn2).setSelected(true);

			volverAlEstadoInicial = false;
		}
	}

}
