package com.ingweb.cun.infrastructure.entrypoint.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import org.springframework.stereotype.Controller;

@Controller
@WebService
public class HelloWorldSoapController {

    public String helloWorld() {
        return "Hello World";
    }

    @WebMethod(operationName = "saludarUsuario")
    public String sayHello(@WebParam(name = "nombre_usuario") @XmlElement(required = true) String name) {
        return "Hello " + name;
    }
}
