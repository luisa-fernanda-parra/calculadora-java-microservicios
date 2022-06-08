package com.app.calculadora.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping
public class CalculadoraController {

    @GetMapping("/sumar")
    public ResponseEntity getSuma(@PathParam("num1") String num1, @PathParam("num2") String num2){
        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);
        double resultado = numero1 + numero2;
        String mensaje = "El resultado de sumar: " + num1 + " + " + num2 + " es " + resultado;
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/restar")
    public ResponseEntity getResta(@PathParam("num1") String num1, @PathParam("num2") String num2) {
        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);
        double resultado = numero1 - numero2;
        String mensaje = "El resultado de restar: " + num1 + " - " + num2 + " es " + resultado;
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/multiplicar/{num1}/{num2}")
    public ResponseEntity getMuliplicacion(@PathVariable String num1, @PathVariable String num2){
        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);
        double resultado = numero1 * numero2;
        String mensaje = "El resultado de multiplicar: " + num1 + " * " + num2 + " es " + resultado;
        return ResponseEntity.ok(mensaje);
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
        return ResponseEntity.ok(mensaje);
    }

}
