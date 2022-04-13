package com.example.demo.environmentimport org.springframework.beans.factory.annotation.Autowiredimport org.springframework.beans.factory.annotation.Valueimport org.springframework.boot.ApplicationArgumentsimport org.springframework.boot.ApplicationRunnerimport org.springframework.context.ApplicationContextimport org.springframework.stereotype.Component@Componentclass EnvironmentAppRunner : ApplicationRunner {    @Autowired    lateinit var ctx : ApplicationContext    @Autowired    lateinit var envBookRepository: EnvBookRepository    @Value("\${app.about}")    lateinit var appName: String    override fun run(args: ApplicationArguments?) {        val environment = ctx.environment        println(environment.activeProfiles.contentToString())        println(environment.defaultProfiles.contentToString())        println(envBookRepository)        println(environment.getProperty("app.name"))        println(environment.getProperty("app.about"))        println(appName)    }}