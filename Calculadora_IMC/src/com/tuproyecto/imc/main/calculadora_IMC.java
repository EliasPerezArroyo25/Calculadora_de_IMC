package com.tuproyecto.imc.main;

import com.tuproyecto.imc.controller.IMCController;
import com.tuproyecto.imc.model.CalculadoraIMC;
import com.tuproyecto.imc.view.Calculado_Vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Elias Pérez Arroyo
 */
public class calculadora_IMC {

    public static void main(String[] args) {
        Calculado_Vista vista;
        CalculadoraIMC modelo;
        IMCController controlador;
        
        vista=new Calculado_Vista();
        modelo=new CalculadoraIMC();
        controlador=new IMCController(vista,modelo);
        
        controlador.inicializar();
        
    }
    
}
