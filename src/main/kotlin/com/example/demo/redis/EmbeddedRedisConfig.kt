package com.example.demo.redis

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import redis.embedded.RedisServer
import java.net.Socket

@Configuration
class EmbeddedRedisConfig(
    @Value("\${spring.redis.port:6379}") val port: Int
) : InitializingBean, DisposableBean {
    private lateinit var redisServer: RedisServer

    override fun afterPropertiesSet() {
        if (isUnboundedPort(port)) {
            redisServer = RedisServer(port)
            redisServer.start()
        }
    }

    override fun destroy() {
        if (this::redisServer.isInitialized)
            redisServer.stop()
    }

    private fun isUnboundedPort(port: Int) =
        runCatching { Socket("localhost", port).also { it.close() } }.isFailure
}
