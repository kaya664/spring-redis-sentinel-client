package com.kaya.redisclient.controller

import com.kaya.redisclient.service.CacheService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CacheController(private val cacheService: CacheService) {

    @GetMapping("/get")
    @ResponseBody
    fun getDataFromCache(@RequestParam(name = "cacheName") cacheName: String): String? {
        return cacheService.getCachedDataWithKey(cacheName)
    }

    @PostMapping("/set")
    fun setDataToCache(@RequestBody cacheData: CacheData): ResponseEntity<CacheData> {
        cacheService.setCacheDataWithKey(cacheData)
        return ResponseEntity.ok(cacheData);
    }

}

data class CacheData(
    val key: String,
    val value: String
)