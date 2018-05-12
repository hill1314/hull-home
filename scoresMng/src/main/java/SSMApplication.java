import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 启动类
 *
 * @author
 * @create 2018-05-05 下午2:08
 **/
@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.hull"})
public class SSMApplication {

    public static void main(String[] args) {
        SpringApplication.run(SSMApplication.class);
    }

    @RequestMapping("/")
    public String index(){
        return "student-score-mng";
    }

}
