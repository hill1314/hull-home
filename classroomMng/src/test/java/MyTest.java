import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hull.dto.LoginDto;
import com.hull.dto.RespDto;
import com.hull.entity.*;
//import com.hull.tools.HttpClientUtil;

import java.util.Date;
import java.util.List;


/**
 * 测试类
 *
 * @author
 * @create 2018-04-05 下午2:32
 **/

public class MyTest {
    public static void main(String[] args) {

//        createJson();
        analysisJson();

    }

    private static void analysisJson() {
//        String url = "http://97.64.82.90:8000/staff/queryStaff";
//        String json = "{}";
//        String result = HttpClientUtil.doPost(url,json);
//        System.out.println(result);
//
//        RespDto<List<StaffInfo>> respDto = JSON.parseObject(result,
//                new TypeReference<RespDto<List<StaffInfo>>>(){});
//        List<StaffInfo> staffInfos = respDto.getData();
    }


    private static void createJson() {
        LoginDto loginDto = new LoginDto();
        loginDto.setName("test");
        loginDto.setPassword("123");
        System.out.println(JSON.toJSONString((loginDto)));

        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setName("test");
        staffInfo.setPassword("123");
        staffInfo.setEmail("test@qq.com");
        staffInfo.setRoleId(2);
        staffInfo.setMobile("18899997777");
        staffInfo.setTeamId(3);
        String jsonStr = JSON.toJSONString(staffInfo);
        System.out.println(jsonStr);

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
        messageInfo.setReceiveTeamId(3);
        messageInfo.setSendTime(new Date());
        System.out.println(JSON.toJSONString(messageInfo));

        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setTeamCode("NB");
        teamInfo.setTeamName("牛掰队");
        System.out.println(JSON.toJSONString(teamInfo));
    }
}
