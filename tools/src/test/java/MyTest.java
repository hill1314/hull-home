import com.hull.tools.HttpClientUtil;

/**
 * TODO 来点注释
 *
 * @author
 * @create 2018-04-06 下午11:45
 **/

public class MyTest {
    public static void main(String[] args) {
        String url = "http://97.64.82.90:8000/staff/queryStaff";
        String json = "{}";
        String result = HttpClientUtil.doPost(url,json);
        System.out.println(result);
    }

}
