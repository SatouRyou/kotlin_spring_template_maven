package com.kotlinspringtemplatemaven.infrastructure.config

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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
@EnableJpaRepositories(entityManagerFactoryRef = "sampleDB2EntityManagerFactory",
        transactionManagerRef = "sampleDB2TransactionManager",
        basePackages = arrayOf("com.kotlinspringtemplatemaven.infrastructure.repository.sampleDB2"))
open class SampleDB2RepositoryConfigurer {

    private val ENTITY_PACKAGE : String = "com.springTemplateMaven.infrastructure.entity.sampleDB2"

    @Bean
    fun sampleDB2TransactionManager() : PlatformTransactionManager {
        return JpaTransactionManager( sampleDB2EntityManagerFactory().getObject() );
    }

    @Bean
    fun sampleDB2EntityManagerFactory() : LocalContainerEntityManagerFactoryBean {
        val factoryBean = LocalContainerEntityManagerFactoryBean()
        // 対象のDBの設定をセット
        factoryBean.setDataSource(this.sampleDB2DataSource())
        // 対象のJPAの設定をセット
        factoryBean.setJpaVendorAdapter(this.sampleDB2Adapter())
        // 対象のEntityを指定している
        factoryBean.setPackagesToScan(ENTITY_PACKAGE)
        return factoryBean
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource-SpringDB2")
    fun sampleDB2DataSource() : DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean
    fun sampleDB2Adapter() : HibernateJpaVendorAdapter {
        val hibernateJpaVendorAdapter = HibernateJpaVendorAdapter()
        // ログに発行されたSQLを表示
        hibernateJpaVendorAdapter.setShowSql(true)
        return hibernateJpaVendorAdapter
    }
}