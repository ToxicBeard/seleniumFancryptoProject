package ru.toxic.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Конфигурация propperties проекта и их структура
 */
@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class ProjectProperties {
    private Map<String, String> project = new LinkedHashMap<>();
}
