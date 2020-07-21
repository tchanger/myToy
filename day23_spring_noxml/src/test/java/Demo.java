import com.yan.config.ApplicationConfig;
import com.yan.service.AccountService;
import com.yan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author:yan
 * @Todo
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@SuppressWarnings("all")
public class Demo {
    @Autowired
    UserService us;
    @Autowired
    AccountService as;
    @Test
    public void demo () throws Exception {
        System.out.println(us.findById(1));
    }
    @Test
    public void demo01 () throws Exception {
        us.save();
    }
    @Test
    public void demo02 () throws Exception {
        System.out.println(as.findByName("tom"));
    }
    @Test
    public void transferDemo () throws Exception {
        as.transfer("tom","jerry",1000F);
    }
}
