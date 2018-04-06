import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hull.dto.LoginDto;
import com.hull.entity.*;

import java.util.Date;
import java.util.List;

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
        staffInfo.setMobile("18899997777");
        staffInfo.setTeamId(3);
        String jsonStr = JSON.toJSONString(staffInfo);
        System.out.println(jsonStr);

//        List<StaffInfo> staffInfos = JSON.parseObject(jsonStr,
//                new TypeReference<List<StaffInfo>>(){});


        ClassOrderInfo orderInfo = new ClassOrderInfo();
        orderInfo.setClassId(1);
        orderInfo.setMeetingTimeId(1);
        orderInfo.setTeamId(1);
        orderInfo.setMeetingTopic("早会");
        orderInfo.setStatus("0");
        orderInfo.setOrderStaffId(2);
        System.out.println(JSON.toJSONString(orderInfo));


        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassNo("M002");
        classInfo.setClassName("中会议室002");
        classInfo.setType("02");
        classInfo.setStatus("1");
        classInfo.setAllowTime("1111");
        System.out.println(JSON.toJSONString(classInfo));

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setContent("hello hello");
        messageInfo.setStatus("0");
        messageInfo.setSendMan(2);
        messageInfo.setReceiveMan(3);
        messageInfo.setSendTime(new Date());
        System.out.println(JSON.toJSONString(messageInfo));

        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setTeamCode("NB");
        teamInfo.setTeamName("牛掰队");
        System.out.println(JSON.toJSONString(teamInfo));
    }
}
