package com.kaya.redisclient.service

import com.kaya.redisclient.controller.CacheData
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class CacheService(private val redisTemplate: RedisTemplate<String, Any>) {

    fun getCachedDataWithKey(key: String): String? {
        return redisTemplate.opsForValue().get(key) as String?
    }

    fun setCacheDataWithKey(cacheData: CacheData) {
        redisTemplate.opsForValue().set(cacheData.key, cacheData.value)
    }

}