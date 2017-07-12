import com.hello.spring.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/****************************************
 *
 * Created by daipengfei on 2017/7/13.****
 *
 ***************************************/

@ContextConfiguration(classes = Application.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class BaseTest {
    @Test
    public void test(){
        System.out.println("hello");
    }
}
