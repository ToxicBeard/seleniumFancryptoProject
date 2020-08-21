package is.toxic.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import is.toxic.common.YamlProppertySourceFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Общая конфигурация проекта
 */
@EnableConfigurationProperties
@ComponentScan(basePackages = "is.toxic")
@PropertySource(value = "file:config\\properties.yml", factory = YamlProppertySourceFactory.class)
@CucumberContextConfiguration
public class ProjectConfig {
}
