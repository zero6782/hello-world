package com.javalec.security.seed;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Main {
	static String charset = "utf-8";
	
	public static byte pbUserKey[] = { (byte) 0x2c, (byte) 0x11, (byte) 0x19, (byte) 0x1d, (byte) 0x1f, (byte) 0x16, (byte) 0x12,
			(byte) 0x12, (byte) 0x11, (byte) 0x19, (byte) 0x1d, (byte) 0x1f, (byte) 0x10, (byte) 0x14, (byte) 0x1b,
			(byte) 0x16 };

	public static byte bszIV[] = { (byte) 0x27, (byte) 0x28, (byte) 0x27, (byte) 0x6d, (byte) 0x2d, (byte) 0xd5, (byte) 0x4e,
			(byte) 0x29, (byte) 0x2c, (byte) 0x56, (byte) 0xf4, (byte) 0x2a, (byte) 0x65, (byte) 0x2a, (byte) 0xae,
			(byte) 0x08 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] encryptData = encrypt("ktko");
		decrypt(encryptData);
	}

	public static byte[] encrypt(String str) {
		byte[] enc = null;

		try {
			//암호화 함수 호출
			enc = KISA_SEED_CBC.SEED_CBC_Encrypt(pbUserKey, bszIV, str.getBytes(charset), 0,
					str.getBytes(charset).length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Encoder encoder = Base64.getEncoder();
		byte[] encArray = encoder.encode(enc);
		try {
			System.out.println(new String(encArray, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encArray;
	}

	public static String decrypt(byte[] str) {

		Decoder decoder = Base64.getDecoder();
		byte[] enc = decoder.decode(str);

		String result = "";
		byte[] dec = null;

		try {
			//복호화 함수 호출
			dec = KISA_SEED_CBC.SEED_CBC_Decrypt(pbUserKey, bszIV, enc, 0, enc.length);
			result = new String(dec, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println("decrypt Result = " + result);
		return result;
	}

}
