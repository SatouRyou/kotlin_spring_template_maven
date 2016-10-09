package com.kotlinspringtemplatemaven.infrastructure.config

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

/**
 * Created by teradashoutarou on 2016/10/09.
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "sampleDBEntityManagerFactory",
        transactionManagerRef = "sampleDBTransactionManager",
        basePackages = arrayOf("com.kotlinspringtemplatemaven.infrastructure.repository.sampleDB"))
open class SampleDBRepositoryConfigurer {

    private val ENTITY_PACKAGE : String = "com.springTemplateMaven.infrastructure.entity.sampleDB"

    @Primary
    @Bean
    fun sampleDBTransactionManager() : PlatformTransactionManager {
        return JpaTransactionManager( sampleDBEntityManagerFactory().getObject() );
    }

    @Primary
    @Bean
    fun sampleDBEntityManagerFactory() : LocalContainerEntityManagerFactoryBean {
        val factoryBean = LocalContainerEntityManagerFactoryBean()
        // 対象のDBの設定をセット
        factoryBean.setDataSource(this.sampleDBDataSource())
        // 対象のJPAの設定をセット
        factoryBean.setJpaVendorAdapter(this.sampleDBAdapter())
        // 対象のEntityを指定している
        factoryBean.setPackagesToScan(ENTITY_PACKAGE)
        return factoryBean
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "datasource-SpringDB")
    fun sampleDBDataSource() : DataSource {
        return DataSourceBuilder.create().build()
    }

    @Primary
    @Bean
    fun sampleDBAdapter() : HibernateJpaVendorAdapter {
        val hibernateJpaVendorAdapter = HibernateJpaVendorAdapter()
        // ログに発行されたSQLを表示
        hibernateJpaVendorAdapter.setShowSql(true)
        return hibernateJpaVendorAdapter
    }
}