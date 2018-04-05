import com.alibaba.fastjson.JSON;
import com.hull.dto.LoginDto;
import com.hull.entity.StaffInfo;

/**
 * TODO 来点注释
 *
 * @author
 * @create 2018-04-05 下午2:32
 **/

public class MyTest {
    public static void main(String[] args) {

        createJson();

    }

    private static void createJson() {
//        LoginDto loginDto = new LoginDto();
//        loginDto.setName("test");
//        loginDto.setPassword("123");
//        System.out.println(JSON.toJSONString((loginDto)));

        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setName("test");
        staffInfo.setPassword("123");
        staffInfo.setEmail("test@qq.com");
        staffInfo.setRoleId(2);
        staffInfo.setTeamId(3);
        System.out.println(JSON.toJSONString(staffInfo));
    }
}
