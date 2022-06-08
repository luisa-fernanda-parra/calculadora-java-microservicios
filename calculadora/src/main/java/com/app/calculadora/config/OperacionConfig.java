package com.app.calculadora.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "calculadora.operacion")
public class OperacionConfig {

    private Map<String,String> tipo;

    public Map<String,String> getTipo(){
        return tipo;
    }

    public void setTipo(Map<String, String> tipo) {
        this.tipo = tipo;
    }
}
