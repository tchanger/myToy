import com.yan.service.UserService;
import com.yan.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class SpringTest {


    @Test
    public void demo1 () throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean("UserService", UserService.class);
        userService.save();
    }

}
