import com.alibaba.fastjson.JSON;
import com.hull.entity.PwdInfo;
import com.hull.entity.UserInfo;
import com.hull.util.SecurityUtil;

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
        encrypt();
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
        userInfo.setMobile("13111112222");
        String json = JSON.toJSONString(userInfo);
        System.out.println(json);
    }
}
