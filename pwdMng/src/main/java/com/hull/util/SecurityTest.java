package com.hull.util;

import java.security.Key;
import java.util.Base64;

import org.apache.tomcat.util.buf.HexUtils;
import org.junit.Assert;


public class SecurityTest {

    public static void main(String[] args)  throws Exception{
//        System.out.println("-----------<<< testDigest >>>------------------");
//        testDigest();
//        System.out.println();

        System.out.println("-----------<<< testAes >>>------------------");
        testAes();
        System.out.println();

//        System.out.println("-----------<<< testRsa >>>------------------");
//        testRsa();
//        System.out.println();
    }

    /**
     * 对称加密算法
     * @throws Exception
     */
    public static void testAes() throws Exception {
        String content = "I love U";
        System.out.println("要加密的内容："+content);
        String secretKeyStr = SecurityUtil.AesUtil.generaterKey();
        System.out.println("密钥："+secretKeyStr);
        String encryptStr = SecurityUtil.AesUtil.encrypt(content, secretKeyStr);
        System.out.println("加密后："+encryptStr);
        String decryptStr = SecurityUtil.AesUtil.decrypt(encryptStr, secretKeyStr);
        System.out.println("解密后："+decryptStr);
    }

    /**
     * 非对称加密算法
     * @throws Exception
     */
    public static void testRsa() throws Exception {

        String content = "I love U";
        System.out.println("要加密的内容："+content);
        // 生成秘钥对
        SecurityUtil.RsaUtil.RsaKeyPair mRsaKeyPair = SecurityUtil.RsaUtil.generaterKeyPair();
        String privateKeyStr = mRsaKeyPair.getPrivateKey();
        System.out.println("私钥："+privateKeyStr);
        String publicKeyStr = mRsaKeyPair.getPublicKey();
        System.out.println("公钥："+publicKeyStr);

        // test sign
        {
            String signStr = SecurityUtil.RsaUtil.sign(content, privateKeyStr,true);
            boolean isValid = SecurityUtil.RsaUtil.verify(content,signStr, publicKeyStr,true);
            System.out.println("-----------signStr------------------");
            System.out.println(signStr);
            System.out.println("-----------isValid------------------");
            System.out.println(isValid);
        }

        // test codec
        {
            Key privateKey = SecurityUtil.RsaUtil.getPrivateKey(privateKeyStr);
            Key publicKey = SecurityUtil.RsaUtil.getPublicKey(publicKeyStr);

            // 私钥加密、公钥解密
            System.out.println("私钥加密、公钥解密");
            String encryptStr = SecurityUtil.RsaUtil.encrypt(content, privateKey);
            System.out.println("加密后："+encryptStr);
            String decryptStr = SecurityUtil.RsaUtil.decrypt(encryptStr, publicKey);
            System.out.println("解密后："+decryptStr);

            // 公钥加密、私钥解密
            System.out.println("公钥加密、私钥解密");
            encryptStr = SecurityUtil.RsaUtil.encrypt(content, privateKey);
            System.out.println("加密后："+encryptStr);
            decryptStr = SecurityUtil.RsaUtil.decrypt(encryptStr, publicKey);
            System.out.println("解密后："+decryptStr);
        }

    }

    /**
     * 签名
     */
    public static void testDigest() throws Exception {
        String content = "I love U";
        System.out.println("需要加签名的内容:"+content);
        byte[] bytes = SecurityUtil.MessageDigestUtil.digest(content, true);
        String hexEncode = HexUtils.toHexString(bytes);
        System.out.println("签名后的内容:"+hexEncode);

        byte[] hexDecode = HexUtils.fromHexString(hexEncode);
        System.out.println(Base64.getEncoder().encodeToString(bytes));
        System.out.println(Base64.getEncoder().encodeToString(hexDecode));
    }

}
