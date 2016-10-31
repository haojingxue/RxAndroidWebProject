package com.mm.cme.rx_android_web_project.utils.base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * 
 *  项目名称：wl   
 *  类名称：AESUtils   
 *  类描述：加密工具   
 *  创建人：Curious 
 *  创建时间：2015-3-16 下午6:20:58
 */
public class AESUtils {

	
	/**
	 * 加密工具
	 */

	private static String ivParameter = "1234567890123456";  // 必须16位

	private static String WAYS = "AES";
	private static String MODE = "";
	private static boolean isPwd = false;
	private static String ModeCode = "PKCS5Padding";
//	private static int type = 0;
	
	private static int pwdLenght=16;
	private static  String val="0";

	public static String selectMod(int type) {
		// ECB("ECB", "0"), CBC("CBC", "1"), CFB("CFB", "2"), OFB("OFB", "3");
		switch (type) {
		case 0:
			isPwd = false;
			MODE = WAYS + "/" + AESTyp.ECB.key() + "/" + ModeCode;

			break;
		case 1:
			isPwd = true;
			MODE = WAYS + "/" + AESTyp.CBC.key() + "/" + ModeCode;
			break;
		case 2:
			isPwd = true;
			MODE = WAYS + "/" + AESTyp.CFB.key() + "/" + ModeCode;
			break;
		case 3:
			isPwd = true;
			MODE = WAYS + "/" + AESTyp.OFB.key() + "/" + ModeCode;
			break;

		}

		return MODE;

	}

	/*************************加密******************************/
	
	public static byte[] encrypt(String sSrc, String sKey, int type)
			throws Exception {
		sKey=toMakekey(sKey, pwdLenght, val);
		Cipher cipher = Cipher.getInstance(selectMod(type));
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, WAYS);

		IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
		if (isPwd == false) {
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		}
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
		return Base64.encode(encrypted);
	}


	public static String decrypt(String sSrc, String sKey, int type)
			throws Exception {
			sKey=toMakekey(sKey, pwdLenght, val);
		try {
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, WAYS);
			Cipher cipher = Cipher.getInstance(selectMod(type));
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
			if (isPwd == false) {
				cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			} else {
				cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			}
			byte[] encrypted1 = Base64.decode(sSrc.getBytes());
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	//key 
	public static String toMakekey(String str,int strLength,String val){
		
		int strLen=str.length();
		if (strLen<strLength) {
			while (strLen<strLength) {
				StringBuffer  buffer=new StringBuffer();
				buffer.append(str).append(val);
				str=buffer.toString();
				strLen=str.length();
			}
		}
		return str;
	}

	
/**********************************************************************************/
	
	
	public static byte[] newencrypt(String content, String password) {
        try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(128, new SecureRandom(password.getBytes()));
                SecretKey secretKey = kgen.generateKey();
                byte[] enCodeFormat = secretKey.getEncoded();
                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                byte[] byteContent = content.getBytes("UTF-8");
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] result = cipher.doFinal(byteContent);
                return result;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return null;
}

	
     public static byte[] newdecrypt(byte[] content, String password) {
             try {
                      KeyGenerator kgen = KeyGenerator.getInstance("AES");
                      kgen.init(128, new SecureRandom(password.getBytes()));
                      SecretKey secretKey = kgen.generateKey();
                      byte[] enCodeFormat = secretKey.getEncoded();
                      SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
                      Cipher cipher = Cipher.getInstance("AES");
                     cipher.init(Cipher.DECRYPT_MODE, key);
                     byte[] result = cipher.doFinal(content);
                     return result; 
             } catch (Exception e) {
                     e.printStackTrace();
             }
             return null;
     }
     
     /**
      * 将二进制转成16进制
      * @param buf
      * @return
      */
     public static String parseByte2HexStr(byte buf[]) {
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < buf.length; i++) {
                     String hex = Integer.toHexString(buf[i] & 0xFF);
                     if (hex.length() == 1) {
                             hex = '0' + hex;
                     }
                     sb.append(hex.toUpperCase());
             }
             return sb.toString();
     }
   
     
     /**
      * 将16进制转成2进制
      * @param hexStr
      * @return
      */
     public static byte[] parseHexStr2Byte(String hexStr) {
             if (hexStr.length() < 1)
                     return null;
             byte[] result = new byte[hexStr.length()/2];
             for (int i = 0;i< hexStr.length()/2; i++) {
                     int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
                     int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
                     result[i] = (byte) (high * 16 + low);
             }
             return result;
     }
	
     /**
 	 * 打乱加密后的字符
 	 * 
 	 * @param args
 	 */
 	public static String disorganizeString(String encrypt) {
 		encrypt = encrypt.replaceAll("2", "z");
 		encrypt = encrypt.replaceAll("3", "y");
 		encrypt = encrypt.replaceAll("5", "x");
 		encrypt = encrypt.replaceAll("6", "q");
 		encrypt = encrypt.replaceAll("8", "o");
 		encrypt = encrypt.replaceAll("a", "p");
 		encrypt = encrypt.replaceAll("b", "s");
 		encrypt = encrypt.replaceAll("c", "r");
 		encrypt = encrypt.replaceAll("d", "t");
 		encrypt = encrypt.replaceAll("e", "n");
 		encrypt = encrypt.replaceAll("f", "m");
 		return encrypt;
 	}

 	
 	
 	/**
 	 * 还原打乱后的字符
 	 * 
 	 * @param args
 	 */

 	public String revivificationString(String encrypt) {
 		String decrypt = encrypt;

 		decrypt = decrypt.replaceAll("z", "2");
 		decrypt = decrypt.replaceAll("y", "3");
 		decrypt = decrypt.replaceAll("x", "5");
 		decrypt = decrypt.replaceAll("q", "6");
 		decrypt = decrypt.replaceAll("o", "8");
 		decrypt = decrypt.replaceAll("p", "a");
 		decrypt = decrypt.replaceAll("s", "b");
 		decrypt = decrypt.replaceAll("r", "c");
 		decrypt = decrypt.replaceAll("t", "d");
 		decrypt = decrypt.replaceAll("n", "e");
 		decrypt = decrypt.replaceAll("m", "f");
 		return decrypt;
 	}

 	
 	
     
     /**
      * 加密
     * @throws Exception 
      */
     public static String Encrypt(String str) throws Exception{
    	 String sKey = "wuliupai40085656";
    	 byte[] encrypt = encrypt(str, sKey, 0);
    	 // 将二级制转成16进制
    	 str = parseByte2HexStr(encrypt);
    	 /**打乱加密的字符串*/
    	 str = disorganizeString(str);
    	 return str;
     }
     
     
     
     /**
      * 解密
     * @throws Exception 
      */
     
     public String Decrypt(String str) throws Exception{
    	 String sKey = "wuliupai40085656";
    	 /**还原打乱后的字符串*/
    	 str = revivificationString(str);
    	 //将16进制转成二进制
    	 str = new String(parseHexStr2Byte(str));
    	 str = decrypt(str, sKey, 0);
    	 return str;
     }
     
     
     public static void main(String[] args) throws Exception {
//		String mes = "15815593848";
//		/**加密*/
//		AESUtils en = new AESUtils();
//		String encrypt = en.Encrypt(mes);
//		
//		System.out.println(encrypt);
//		
//		String decrypt = en.Decrypt("qDzB70yzx94Aqzyq7q4DqExox94Dyq7y7zy4yoxo4oy9q97yx1q9x94Ayy4FqByxxA41qAqzy9qoy7y14zzF41yD");
//		System.out.println(decrypt);
		
	}
}

