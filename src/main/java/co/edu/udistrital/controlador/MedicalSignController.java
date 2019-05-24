package co.edu.udistrital.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.edu.udistrital.dominio.MedicalSignal;
import co.edu.udistrital.websocket.WsClient;

@RestController
@RequestMapping("/medical")
public class MedicalSignController {
	
//	public static WsClient clienteWebSocket;
	
	@PostMapping("/sendSignal")
	String capturarSenal(@RequestBody MedicalSignal senalMedica){
		final Gson gson = new Gson();
		final String senalMedicaJson = gson.toJson(senalMedica);
		WsClient.sendBroadcastMessage(senalMedicaJson);
		final String mensajeRetorno = "Recieved signal: "+senalMedica.getDato();
		return mensajeRetorno;
	}
	
}
