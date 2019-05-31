package co.edu.udistrital.websocket;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import co.edu.udistrital.dominio.MedicalSignal;

public class SessionHandler implements StompSessionHandler {
	
	
	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
//		session.subscribe("/topic/medicalSignal", this);
//		final String mensajeInicio="";
//		session.send("/app/sendSignal", );
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		// Message msg = (Message) payload;
//		System.out.println("Recibido: ");
	}

	@Override
	public Type getPayloadType(StompHeaders arg0) {
		return MedicalSignal.class;
	}

	@Override
	public void handleException(StompSession arg0, StompCommand arg1, StompHeaders arg2, byte[] arg3, Throwable exception) {
		exception.printStackTrace();
	}

	@Override
	public void handleTransportError(StompSession arg0, Throwable exception) {
		exception.printStackTrace();
	}


}
