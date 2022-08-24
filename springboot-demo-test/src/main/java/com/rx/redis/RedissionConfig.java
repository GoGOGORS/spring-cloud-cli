package com.rx.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import javax.annotation.Resource;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-18 17:17}
 * {{@code @Description} @Description: }
 */

@Slf4j
@Configuration
public class RedissionConfig {


    @Resource
    private RedisConnectionFactory redisConnectionFactory;

/*     @Bean(destroyMethod = "shutdown")
    public RedissonClient getRedissonClient() {

        List<String> clusterNodes = RedisConfig.getCluster().getNodeAddresses();
        log.info("【Redisson 配置】：{}", redisConnectionFactory.getConnection().info());

        Config config = new Config();
        //对象编码选择纯字符串编码
        config.setCodec(StringCodec.INSTANCE);
        ClusterServersConfig clusterServersConfig = config.useClusterServers()
                .addNodeAddress(clusterNodes.toArray(new String[clusterNodes.size()]));
        //设置密码
        clusterServersConfig.setPassword(redisConfigProperties.getPassword());
        //redis连接心跳检测，防止一段时间过后，与redis的连接断开
        clusterServersConfig.setPingConnectionInterval(32000);
        return Redisson.create(config);
    } */

}
