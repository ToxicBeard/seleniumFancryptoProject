package is.toxic.config;

import io.vavr.control.Try;
import is.toxic.db.common.ExceptionTranslator;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
public class JooqConfig {

    @Autowired
    private ProjectProperties projectProperties;

    @Bean
    @Qualifier("dataSourceData")
    public DataSource dataSourceData() {
        return Try.of(PGSimpleDataSource::new)
                .andThen(dataSource ->
                        Try.of(() -> projectProperties.getDb().get("data"))
                                .andThen(data -> dataSource.setUrl(data.getUrl()))
                                .andThen(data -> dataSource.setUser(data.getUser()))
                                .andThen(data -> dataSource.setPassword(data.getPassword()))
                                .get())
                .get();
    }

    @Bean
    @Qualifier("dataSourceData")
    public TransactionAwareDataSourceProxy transactionAwareDataSourceData() {
        return new TransactionAwareDataSourceProxy(dataSourceData());
    }

    @Bean
    @Qualifier("dataSourceData")
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(transactionAwareDataSourceData());
    }

    @Bean
    @Qualifier("dataSourceData")
    public DefaultDSLContext dslData() {
        return new DefaultDSLContext(configurationData());
    }

    @Bean
    @Qualifier("dataSourceData")
    public DefaultConfiguration configurationData() {
        return Try.of(DefaultConfiguration::new)
                .andThen(jooqConfiguration -> jooqConfiguration.set(SQLDialect.POSTGRES))
                .andThen(jooqConfiguration -> jooqConfiguration.set(connectionProvider()))
                .andThen(jooqConfiguration -> jooqConfiguration.set(new DefaultExecuteListenerProvider(new ExceptionTranslator())))
                .get();
    }

    @Bean
    @Qualifier("dataSourceIdentity")
    public DataSource dataSourceIdentity() {
        return Try.of(PGSimpleDataSource::new)
                .andThen(dataSource ->
                        Try.of(() -> projectProperties.getDb().get("identity"))
                                .andThen(data -> dataSource.setUrl(data.getUrl()))
                                .andThen(data -> dataSource.setUser(data.getUser()))
                                .andThen(data -> dataSource.setPassword(data.getPassword()))
                                .get())
                .get();
    }

    @Bean
    @Qualifier("dataSourceIdentity")
    public DataSourceConnectionProvider connectionProviderIdentity() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSourceIdentity()));
    }

    @Bean
    @Qualifier("dataSourceIdentity")
    public DefaultDSLContext dslIdentity() {
        return new DefaultDSLContext(configurationIdentity());
    }

    @Bean
    @Qualifier("dataSourceIdentity")
    public DefaultConfiguration configurationIdentity() {
        return Try.of(DefaultConfiguration::new)
                .andThen(jooqConfiguration -> jooqConfiguration.set(SQLDialect.POSTGRES))
                .andThen(jooqConfiguration -> jooqConfiguration.set(connectionProviderIdentity()))
                .andThen(jooqConfiguration -> jooqConfiguration.set(new DefaultExecuteListenerProvider(new ExceptionTranslator())))
                .get();
    }
}
