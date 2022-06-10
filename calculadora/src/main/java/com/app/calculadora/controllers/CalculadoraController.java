package com.app.calculadora.controllers;

import com.app.calculadora.config.OperacionConfig;
import com.app.calculadora.services.InterfazCalculadoraService;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
@RequestMapping
public class CalculadoraController {

    OperacionConfig config;
    InterfazCalculadoraService calculadoraService;

    public CalculadoraController(OperacionConfig config, InterfazCalculadoraService calculadoraService){
        this.config = config;
        this.calculadoraService = calculadoraService;
    }



    @Value("${calculadora.saludoManana}")
    private String saludoManana;

    @Value("${calculadora.saludoTarde}")
    private String saludoTarde;

    @Value("${calculadora.saludoNoche}")
    private String saludoNoche;


    //Utilizando inyección de dependencias
    @GetMapping("/sumar")
    public ResponseEntity getSuma(@PathParam("num1") String num1, @PathParam("num2") String num2){
        return ResponseEntity.ok(calculadoraService.getSumaService(num1,num2));
    }

    @GetMapping("/restar")
    public ResponseEntity getResta(@PathParam("num1") String num1, @PathParam("num2") String num2) {
        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);
        double resultado = numero1 - numero2;
        String mensaje = "El resultado de restar: " + num1 + " - " + num2 + " es " + resultado;
        //String mensaje2 = "\nUtilizaste el servicio de " + config.getTipo().get("op2");
        String mensaje2 = "\nUtilizaste el servicio de " + config.getOperacion(OperacionConfig.RESTA);
        return ResponseEntity.ok(mensaje+mensaje2);
    }

    @GetMapping("/multiplicar/{num1}/{num2}")
    public ResponseEntity getMuliplicacion(@PathVariable String num1, @PathVariable String num2){
        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);
        double resultado = numero1 * numero2;
        String mensaje = "El resultado de multiplicar: " + num1 + " * " + num2 + " es " + resultado;
        //String mensaje2 = "\nUtilizaste el servicio de " + config.getTipo().get("op3");
        String mensaje2 = "\nUtilizaste el servicio de " + config.getOperacion(OperacionConfig.MULTIPLICACION);
        return ResponseEntity.ok(mensaje+mensaje2);
    }

    @GetMapping("/dividir/{num1}/{num2}")
    public ResponseEntity getDivision(@PathVariable String num1, @PathVariable String num2){
        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);
        String mensaje;
        if(numero2 == 0){
            mensaje = "Error! División entre cero";
        }else{
            double resultado = numero1 / numero2;
            mensaje = "El resultado de dividir: " + num1 + " / " + num2 + " es " + resultado;
        }
        //String mensaje2 = "\nUtilizaste el servicio de " + config.getTipo().get("op4");
        String mensaje2 = "\nUtilizaste el servicio de " + config.getOperacion(OperacionConfig.DIVISION);
        return ResponseEntity.ok(mensaje+mensaje2);
    }

    @GetMapping("/menu")
    public ResponseEntity getOperaciones(){
        /*
        ArrayList<String> lista = new ArrayList<>(config.getTipo().values());
        String mensaje = "Operaciones:";
        for(String i:lista){
            mensaje += "\n" + i;
        }
        return ResponseEntity.ok(mensaje);
        */
        String mensaje = "Operaciones:" +
                "\n" + config.getOperacion(OperacionConfig.SUMA) +
                "\n" + config.getOperacion(OperacionConfig.RESTA) +
                "\n" + config.getOperacion(OperacionConfig.MULTIPLICACION) +
                "\n" + config.getOperacion(OperacionConfig.DIVISION);

        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/saludo/{nombre}/{hora}")
    public ResponseEntity getSaludo(@PathVariable String nombre, @PathVariable String hora){
        int horaNum = Integer.parseInt(hora);
        String mensaje;

        if( horaNum >= 6 && horaNum < 12){
            mensaje = saludoManana;
        } else if(horaNum >= 12 && horaNum < 18){
            mensaje = saludoTarde;
        }else{
            mensaje = saludoNoche;
        }
        return ResponseEntity.ok(mensaje + " " + nombre);
    }

}
