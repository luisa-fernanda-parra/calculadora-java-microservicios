package com.app.calculadora.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "calculadora.operacion")
public class OperacionConfig {

    public static final String SUMA = "op1";
    public static final String RESTA = "op2";
    public static final String MULTIPLICACION = "op3";
    public static final String DIVISION = "op4";


    private Map<String,String> tipo;

    public String getOperacionSuma(final String operacionSuma){
        return tipo.get(operacionSuma);
    }

    public String getOperacionResta(final String operacionResta){
        return tipo.get(operacionResta);
    }

    public String getOperacionMultiplicacion(final String operacionMultiplicacion){
        return tipo.get(operacionMultiplicacion);
    }

    public String getOperacionDivision(final String operacionDivision){
        return tipo.get(operacionDivision);
    }

    public Map<String,String> getTipo(){
        return tipo;
    }

    public void setTipo(Map<String, String> tipo) {
        this.tipo = tipo;
    }
}
