package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonTrianguloListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		TareaOpengl ventana = new TareaOpengl();
		ventana.crearVentanaRenderizado();
		ventana.dibujarTriangulo();
	}
	
}
