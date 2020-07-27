package com.kh.portfolio.common.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PropertiesEncryptor {

	public static void main(String[] args) {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		//암호키
		enc.setPassword("");
		
		//db암호화
		System.out.println(enc.encrypt("oracle.jdbc.driver.OracleDriver"));
		System.out.println(enc.encrypt("jdbc:oracle:thin:@127.0.0.1:1521:xe"));
		System.out.println(enc.encrypt("portfolio"));
		System.out.println(enc.encrypt(""));
		
		//mail암호화
		System.out.println(enc.encrypt("1404jsh@gmail.com"));
		System.out.println(enc.encrypt(""));
		
		//복호화
		System.out.println(enc.decrypt("eapAp5DOvmae03TNmXUKz0VFsIvCp5Rb"));
	}

}
