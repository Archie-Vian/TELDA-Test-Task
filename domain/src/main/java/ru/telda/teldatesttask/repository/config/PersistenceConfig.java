package ru.telda.teldatesttask.repository.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Конфигурация взаимодействия MyBatis с базой данных.
 */
@Configuration
@MapperScan("ru.telda.teldatesttask.repository.mapper")
public class PersistenceConfig {

	/**
	 * Инициализация встроенной базы данных.
	 *
	 * @return Источник данных
	 */
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.setName("teldaTestTaskDB")
				.addScript("sql/regions.sql")
				.addScript("sql/regions_data.sql")
				.build();
	}

	/**
	 * Настройка взаимодействия ORM с базой данных.
	 *
	 * @return				Фабрика SQL запросов
	 * @throws Exception 	Возможные ошибки
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		return factoryBean.getObject();
	}
}
