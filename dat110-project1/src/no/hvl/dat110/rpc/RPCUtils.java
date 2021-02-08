package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;
		
		byte[] strBytes = str.getBytes();
		encoded= new byte[strBytes.length+1];
		encoded[0]=rpcid;
		for(int i = 0; i<encoded.length-1;i++) {
			encoded[i+1]=strBytes[i];
		}
		// TODO: marshall RPC identifier and string into byte array
	
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		
		byte[] s = new byte[data.length-1];
		for(int i = 0; i<s.length;i++) {
			s[i]=data[i+1];
		}
		// TODO: unmarshall String contained in data into decoded
		String decoded = new String(s,StandardCharsets.UTF_8);
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		// TODO: marshall RPC identifier in case of void type
		encoded[0]=rpcid;
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];

		// TODO: marshall RPC identifier and string into byte array
		encoded[0]=rpcid;
		byte[] data = ByteBuffer.allocate(4).putInt(x).array();
		for(int i = 0;i<4;i++) {
			encoded[i+1]=data[i];
		}
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		byte[] d = new byte[4];
		for(int i = 0;i<4;i++) {
			d[i]=data[i+1];
		}
		
		int decoded = ByteBuffer.wrap(d).getInt();
		
		// TODO: unmarshall integer contained in data
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return decoded;

	}
}
