package no.hvl.dat110.rpc;

import java.io.IOException;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() {
		
		// TODO: connect using the underlying messaging layer connection
		try {
			connection = msgclient.connect();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    //throw new UnsupportedOperationException(TODO.method());
			
	}
	
	public void disconnect() {
		
		// TODO: disconnect/close the underlying messaging connection
		connection.close();
		//throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public byte[] call(byte[] rpcrequest) {
		
		byte[] rpcreply;
		
		/* TODO: 
		
		Make a remote call on the RPC server by sending the RPC request message
		and receive an RPC reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpctreply is the rpcreply to be unmarshalled by the client-stub
		
		*/
		
		connection.send(new Message(rpcrequest));
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
		Message reply = connection.receive();
		rpcreply=reply.getData();
		return rpcreply;
		
	}

}
