import com.alibaba.fastjson.JSON;
import com.hull.entity.PwdInfo;
import com.hull.entity.UserInfo;
import com.hull.util.SecurityUtil;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *  测试类
 *
 * @author
 * @create 2018-05-05 下午9:20
 **/

public class SimpleTest {

    public static void main(String[] args) {
//        createUser();
//        createPWD();
//        encrypt();
//        decrypt();
        testKey();

    }

    private static void testKey() {
        KeyGenerator keygen = null;
        try {
            keygen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keygen.init(128); // 16 字节 == 128 bit

        //zNgW6Qz3lI5A6cMmD6ixCg==
        String str = Base64.getEncoder().encodeToString(keygen.generateKey().getEncoded());
        System.out.println(str);
    }

    private static void decrypt() {
        String decryptStr = "KL3nme2GDV53StNduUlGKg==";
        try {
            String secretKeyStr = SecurityUtil.AesUtil.generaterKey("123456");
            decryptStr = SecurityUtil.AesUtil.decrypt(decryptStr, secretKeyStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(decryptStr);
    }

    private static void encrypt() {
        String encryptStr = "123123";
        try {
            String secretKeyStr = SecurityUtil.AesUtil.generaterKey("123456");
            encryptStr = SecurityUtil.AesUtil.encrypt(encryptStr, secretKeyStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(encryptStr);
    }

    private static void createPWD() {
        PwdInfo pwdInfo = new PwdInfo();
        pwdInfo.setLoginCode("weixin");
        pwdInfo.setLoginPwd("321321");
        pwdInfo.setType("微信");
        pwdInfo.setUserId(1);
        String json = JSON.toJSONString(pwdInfo);
        System.out.println(json);
    }

    private static void createUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setPassword("123123");
        userInfo.setVerifyCode("123456");
        String json = JSON.toJSONString(userInfo);
        System.out.println(json);
    }
}
