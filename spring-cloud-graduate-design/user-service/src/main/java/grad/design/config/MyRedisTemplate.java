package grad.design.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;

/**
 * @author 王远辉
 */
@Configuration
public class MyRedisTemplate {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        template.setKeySerializer(redisSerializer);
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
