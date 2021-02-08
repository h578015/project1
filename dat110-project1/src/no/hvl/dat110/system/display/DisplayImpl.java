package no.hvl.dat110.system.display;

import java.nio.ByteBuffer;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] request) {
		
		byte[] reply;
		byte rpcid;
		
		// TODO: 
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done int he SensorImpl for the read method
		rpcid = request[0];
		
		RPCUtils.unmarshallVoid(request);
		
		int t = ByteBuffer.wrap(request).getInt();
		
		
		reply = RPCUtils.marshallInteger(rpcid,t);
		
		String message = "DISPLAY:"+t;
		write(message);
		
		
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
		
		return reply;
	}
}
