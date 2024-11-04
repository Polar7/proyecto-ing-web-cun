package com.ingweb.cun.infrastructure.config;

import com.ingweb.cun.infrastructure.entrypoint.soap.BrandCarSoapController;
import com.ingweb.cun.infrastructure.entrypoint.soap.HelloWorldSoapController;
import jakarta.xml.ws.Endpoint;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que configura los endpoint de tipo SOAP
 */
@Configuration
@RequiredArgsConstructor
public class WebServiceSoapConfig {

    /**
     * Bean de HelloWorldSoapController
     */
    private final HelloWorldSoapController helloWorldSoapController;

    /**
     * Bean de BrandCarSoapController
     */
    private final BrandCarSoapController brandCarSoapController;

    /**
     * Configura un servlet u orquestador para todas las peticiones SOAP usando la libreria de ApacheCXF
     * @return Bean de ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/wssoap/*");
    }

    /**
     * Configura un bus de integracion de ApacheCXF
     * @return Bean de SpringBus
     */
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpointHelloWorldSoap() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), helloWorldSoapController);
        endpoint.publish("/helloWorldController");
        return endpoint;
    }

    @Bean
    public Endpoint endpointBrandCarSoapController() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), brandCarSoapController);
        endpoint.publish("/brandCarSoapController");
        return endpoint;
    }

}
