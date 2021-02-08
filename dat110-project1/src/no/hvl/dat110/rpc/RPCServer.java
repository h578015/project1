package no.hvl.dat110.rpc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.Connection;
import no.hvl.dat110.messaging.Message;
import no.hvl.dat110.messaging.MessagingServer;

public class RPCServer {

	private MessagingServer msgserver;
	private Connection connection;
	
	// hashmap to register RPC methods which are required to implement RPCImpl
	
	private HashMap<Integer,RPCImpl> services;
	
	public RPCServer(int port) {
		
		this.msgserver = new MessagingServer(port);
		this.services = new HashMap<Integer,RPCImpl>();
		
		// the stop RPC methods is built into the server
		services.put((int)RPCCommon.RPIDSTOP,new RPCServerStopImpl());
	}
	
	public void run() throws IOException {
		
		System.out.println("RPC SERVER RUN - Services: " + services.size());
		
		connection = msgserver.accept(); 
		
		System.out.println("RPC SERVER ACCEPTED");
		
		boolean stop = false;
		
		while (!stop) {
	    
		   int rpcid;
		   
		   // TODO
		   // - receive message containing RPC request
		   // - find the identifier for the RPC methods to invoke
		   // - lookup the method to be invoked
		   // - invoke the method
		   // - send back message containing RPC reply
		   Message message = connection.receive();
		   
		   
		   byte[] bIn = new byte[4];
		   
		   rpcid = ByteBuffer.wrap(bIn).getInt(0);
		  
		   RPCImpl rpcImp = services.get(rpcid);

		   byte[] b2 = rpcImp.invoke(message.getData());
		   
		   connection.send(new Message(b2));
//		   if (true) {
//			   throw new UnsupportedOperationException(TODO.method());
//		   }
		   
		   if (rpcid == RPCCommon.RPIDSTOP) {
			   stop = true;
		   }
		}
	
	}
	
	public void register(int rpcid, RPCImpl impl) {
		services.put(rpcid, impl);
	}
	
	public void stop() {
		connection.close();
		msgserver.stop();
		
	}
}
