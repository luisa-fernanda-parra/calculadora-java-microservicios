package com.app.calculadora.services.impl;

import com.app.calculadora.config.OperacionConfig;
import com.app.calculadora.services.InterfazCalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements InterfazCalculadoraService {

    OperacionConfig config;

    public CalculadoraServiceImpl(OperacionConfig config){
        this.config = config;
    }

    @Override
    public String getSumaService(String num1, String num2){
        double resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
        String mensaje = "El resultado de sumar: " + num1 + " + " + num2 + " es " + resultado;
        String mensaje2 = "\nUtilizaste el servicio de " + config.getOperacion(OperacionConfig.SUMA);
        return mensaje+mensaje2;
    }
}
