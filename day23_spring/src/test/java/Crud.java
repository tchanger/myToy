import com.yan.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
@ContextConfiguration("classpath:ApplicationContext.xml")
@SuppressWarnings("all")
public class Crud {

    @Autowired
    QueryRunner queryRunner;

    @Test
    public void demo () throws Exception {
        User query = queryRunner.query("select * from user where id = 41", new BeanHandler<User>(User.class));
        System.out.println(query);
    }

    @Test
    public void demo1 () throws Exception {
        System.out.println(Math.ceil(Math.random()*1000));
    }
}
