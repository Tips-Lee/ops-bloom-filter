import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @version 1.0
 * @date 2021/7/8 15:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:bootstrap.properties")
public class TestBloomFilterTest {
    @Autowired
    IBloomFilterService bloomFilterService;

    private static final String BOOLFILTER_KEY = "boolFilter:user";

    @Test
    public void add(){
        bloomFilterService.add(BOOLFILTER_KEY,"16987544");
        //查询
        Boolean f = bloomFilterService.exist(BOOLFILTER_KEY,"16987544");
        System.out.println("【获取bloomFilter】="+f);
    }

}
