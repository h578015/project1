package no.hvl.dat110.system.controller;

import java.nio.ByteBuffer;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		byte[] request = RPCUtils.marshallVoid(RPCID);
		byte[] response = rpcclient.call(request);
		temp = ByteBuffer.wrap(response).getInt();
		RPCUtils.unmarshallVoid(response);
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
//		
		return temp;
	}
	
}