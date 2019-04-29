import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 来点注释
 *
 * @author
 * @create 2019-04-26 20:48
 **/

public class Test {

    public static void main(String[] args) {
//        System.out.println(StringUtils.trimAllWhitespace("sfsdff sdfs ss"));
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(1,3);
        System.out.println(list.toString());
    }
}
