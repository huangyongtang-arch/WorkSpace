package com.example.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;
import java.util.UUID;

public class signUtils {
	public static String createNonce(){
		String timestamp = String.valueOf(System.currentTimeMillis());//当前时间戳
		Random ran = new Random();
		return DigestUtils.md5Hex(timestamp + ran.nextInt(1000));
	}
	
	public static String createTokenId(){
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString().replaceAll("-", "");
		String timestamp = String.valueOf(System.currentTimeMillis());//当前时间戳
		String token = DigestUtils.md5Hex(uuidStr + timestamp + new Random().nextInt(1000));
        return token;
	}
	
	public static String createMd5(String md5Before){
		return DigestUtils.md5Hex(md5Before);
	}
}
