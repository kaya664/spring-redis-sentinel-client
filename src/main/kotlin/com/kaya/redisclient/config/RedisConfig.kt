package com.kaya.redisclient.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisSentinelConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate





@Configuration
class RedisConfig {

    @Bean
    fun lettuceConnectionFactory(): RedisConnectionFactory? {
        val sentinelConfig = RedisSentinelConfiguration()
            .master("redis-sentinel-master")
            .sentinel("redis-sentinel", 26379)
        sentinelConfig.sentinelPassword = RedisPassword.of("myRedisPassword")
        sentinelConfig.password = RedisPassword.of("myRedisPassword")

        return LettuceConnectionFactory(sentinelConfig)
    }

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<String, Any>? {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(redisConnectionFactory!!)
        return template
    }

}