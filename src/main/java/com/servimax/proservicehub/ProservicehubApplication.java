package com.servimax.proservicehub;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProservicehubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProservicehubApplication.class, args);
	}

	@Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((Connector connector) -> {
            connector.setProperty("maxHttpHeaderSize", "16384"); // Ajusta el tamaño según sea necesario
        });
        return factory;
    }

}
