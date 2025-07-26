package com.server.uthonserver2025_1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = ["com.server.uthonserver2025_1.domain.user.domain.repository"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
