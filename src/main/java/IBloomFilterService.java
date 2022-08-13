/**
 * 布鲁过滤器Service接口类
 *
 * @date    2021-07-07 17:14
 * @since   1.0.0
 */
public interface IBloomFilterService<T> {
    /**
     * 添加数据
     *
     * @param key
     * @param data
     */
    void add(String key , String data);

    /**
     * 判断是否存在
     *
     * @param key
     * @param data
     * @return
     */
    Boolean exist(String key , String data);
}
