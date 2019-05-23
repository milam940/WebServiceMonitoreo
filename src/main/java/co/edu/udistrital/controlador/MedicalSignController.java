package co.edu.udistrital.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udistrital.dominio.MedicalSignal;
import co.edu.udistrital.websocket.WsClient;

@RestController
@RequestMapping("/medical")
public class MedicalSignController {
	
//	public static WsClient clienteWebSocket;
	
	@PostMapping("/sendSignal")
	String capturarSenal(@RequestBody MedicalSignal senalMedica){
		WsClient.sendBroadcastMessage(senalMedica.getDato());
		final String mensajeRetorno = "Recieved signal: "+senalMedica.getDato();
		return mensajeRetorno;
	}
	
	@GetMapping("/hello")
    public Collection<String> sayHello() {
        return null;
    }
	
}
