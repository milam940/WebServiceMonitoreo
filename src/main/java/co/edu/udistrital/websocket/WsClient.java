package co.edu.udistrital.websocket;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class WsClient {
//	private static Object waitLock = new Object();
	// Session userSession = null;
	
	private static WebSocketContainer container;
	private static Session session;
	public WsClient() {

	}

	// @PostConstruct
	// public void Init(){
	// WebSocketContainer container = null;//
	// Session session = null;
	// try {
	// container = ContainerProvider.getWebSocketContainer();
	// session = container.connectToServer(WsClient.class,
	// URI.create("ws://localhost:8081/WebSocketServer/endpoint?push=TIME"));
	// wait4TerminateSignal();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if (session != null) {
	// try {
	// session.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }

//	@OnMessage
//	public void onMessage(String message) {
//		// the new USD rate arrives from the websocket server side.
//		System.out.println("Received msg: " + message);
//	}

//	private static void wait4TerminateSignal() {
//		synchronized (waitLock) {
//			try {
//				waitLock.wait();
//			} catch (InterruptedException e) {
//			}
//		}
//	}

	public static void sendBroadcastMessage(final String mensaje) {
		
		try {
			if (container == null || session == null) {
				container = ContainerProvider.getWebSocketContainer();
				session = container.connectToServer(WsClient.class,
						URI.create("ws://localhost:8081/WebSocketServer/endpoint"));
			}
			session.getAsyncRemote().sendText("Valor de la señal enviada: " + mensaje);
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

}
