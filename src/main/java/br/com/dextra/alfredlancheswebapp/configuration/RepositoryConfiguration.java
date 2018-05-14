package br.com.dextra.alfredlancheswebapp.configuration;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"br.com.dextra.alfredlancheswebapp.models"})
@EnableJpaRepositories(basePackages = {"br.com.dextra.alfredlancheswebapp.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
