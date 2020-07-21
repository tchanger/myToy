import com.yan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author:yan
 * @Todo
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
@SuppressWarnings("all")
public class SpringTest {
    @Test
    public void demo () throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService us = app.getBean("userService", UserService.class);
        us.save();
    }
}
