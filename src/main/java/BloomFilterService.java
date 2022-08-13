import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 布鲁过滤器实现类
 *
 * @author Administrator
 * @date    2021-07-07 17:16
 * @since   1.0.0
 */

@Service
public class BloomFilterService implements IBloomFilterService {
    /**
     * 容量
     */

    protected Long expectedInsertions = 1000000L;
    /**
     * 误差
     */

    protected Double falseProbability = 0.001;

    @Autowired
    private Redisson redisson;

    @Override
    public void add(String key , String data) {
        RBloomFilter bloomFilter = redisson.getBloomFilter(key);
        bloomFilter.tryInit(expectedInsertions, falseProbability);
        bloomFilter.add(data);
    }

    @Override
    public Boolean exist(String key , String data) {
        RBloomFilter bloomFilter = redisson.getBloomFilter(key);
        bloomFilter.tryInit(expectedInsertions , falseProbability);
        boolean isExist = bloomFilter.contains(data);
        return isExist;
    }

}

