package co.edu.udistrital.websocket;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class WsClient {
	
	private static WebSocketContainer container;
	private static Session session;
	public WsClient() {

	}

	public static void sendBroadcastMessage(final String mensaje) {
		
		try {
			if (container == null || session == null) {
				container = ContainerProvider.getWebSocketContainer();
				session = container.connectToServer(WsClient.class,
						URI.create("ws://localhost:8081/WebSocketServer/endpoint"));
			}
			session.getAsyncRemote().sendText(mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			if (session != null) {
//				try {
//					session.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
	
	@OnClose
	public void cerrarSesion(){
		if(session.isOpen()){
			try {
				session.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		session=null;
	}

}
