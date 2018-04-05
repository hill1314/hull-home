import com.alibaba.fastjson.JSON;
import com.hull.dto.LoginDto;
import com.hull.entity.ClassOrderInfo;
import com.hull.entity.StaffInfo;

import java.util.Date;

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

//        StaffInfo staffInfo = new StaffInfo();
//        staffInfo.setName("test");
//        staffInfo.setPassword("123");
//        staffInfo.setEmail("test@qq.com");
//        staffInfo.setRoleId(2);
//        staffInfo.setTeamId(3);
//        System.out.println(JSON.toJSONString(staffInfo));

        ClassOrderInfo orderInfo = new ClassOrderInfo();
        orderInfo.setClassId(1);
        orderInfo.setMeetingTimeId(1);
        orderInfo.setTeamId(1);
        orderInfo.setMeetingTopic("早会");
        orderInfo.setStatus("0");
        orderInfo.setOrderStaffId(2);
        System.out.println(JSON.toJSONString(orderInfo));
    }
}
