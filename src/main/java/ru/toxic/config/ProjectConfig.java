package ru.toxic.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.toxic.common.YamlProppertySourceFactory;

/**
 * Общая конфигурация проекта
 */
@EnableConfigurationProperties
@ComponentScan(basePackages = "ru.toxic")
@PropertySource(value = "file:config\\properties.yml", factory = YamlProppertySourceFactory.class)
@CucumberContextConfiguration
public class ProjectConfig {
}
