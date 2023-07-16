package io.github.xxyopen.novel;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisConnectionTest {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testRedisConnection() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("testKey", "testValue");
        String value = ops.get("testKey");
        System.out.println("Retrieved value from Redis: " + value);
    }

    @Test
    public void testCacheManager() {
        // 进行与缓存管理器相关的测试操作
        // ...
    }
}
