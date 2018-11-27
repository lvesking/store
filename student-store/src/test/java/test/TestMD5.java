package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMD5 {

	@Test
	public void testString(){
		
		String x="1103456";
		String y="123456";
		String md5x=DigestUtils.md5Hex(x);
		String md5y=DigestUtils.md5Hex(y);
		System.out.println(md5x);
		System.out.println(md5y);
	}
	
	@Test
	public void testFile() throws  Exception{
		String ms5Str1=DigestUtils.md5Hex(new FileInputStream("pom.xml"));
		String ms5Str2=DigestUtils.md5Hex(new FileInputStream("pom.xml"));
		System.out.println(ms5Str1);
		System.out.println(ms5Str2);
		
	}
}
