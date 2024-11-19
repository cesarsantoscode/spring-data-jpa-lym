package pe.edu.cibertec.spring_data_jpa_lym.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatJndiConfig {

    @Bean
    public HikariDataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/sakila");
        config.setUsername("root");
        config.setPassword("123456");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // configuracionde HikaryCP
        config.setMaximumPoolSize(20); // numero máximo de conexiones del pool
        config.setMinimumIdle(5); // número mínimo de conexiones que deben mantenerse inactivas
        config.setIdleTimeout(300000); // 5 minutos, tiempo en milisegundos después del cual una conexión inactiva puede ser eliminada
        config.setConnectionTimeout(30000); // 30 segundos, tiempo en milisegundos que el pool espera para obtener una conexión antes de lanzar un excepción

        return new HikariDataSource(config);
    }



}
