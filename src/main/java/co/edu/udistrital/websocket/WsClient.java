package co.edu.udistrital.websocket;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.ClientEndpoint;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import com.google.gson.Gson;

import co.edu.udistrital.dominio.MedicalSignal;

@ClientEndpoint
public class WsClient {

	// private static WebSocketClient clienteWebSocket;
	// private static WebSocketStompClient stompClient;
	// private static Session session;

	private static StompSession sesion;

	public WsClient() {

	}

	public static void sendBroadcastMessage(final MedicalSignal senalMedica) {

		try {
			if (sesion == null || !sesion.isConnected()) {
				WebSocketClient clienteWebSocket = new StandardWebSocketClient();
				List<Transport> transports = new ArrayList<>(1);
				transports.add(new WebSocketTransport(clienteWebSocket));
				SockJsClient sockJsClient = new SockJsClient(transports);
				WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
				stompClient.setMessageConverter(new MappingJackson2MessageConverter());
				//String url = "ws://localhost:9001/medical-devices-websocket"; //http://localhost:9001/medical-devices-websocket
				String url = "ws://websocketspring.azurewebsites.net/medical-devices-websocket";
				StompSessionHandler sessionHandler = new SessionHandler();
				sesion = stompClient.connect(url, sessionHandler).get();
				sesion.subscribe("/topic/medicalSignal", sessionHandler);

			}
			final Gson gson = new Gson();
			final String senalMedicaJson = gson.toJson(senalMedica);
			sesion.send("/app/sendSignal", senalMedicaJson);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// if (session != null) {
			// try {
			// session.close();
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			// }
		}
	}
}
