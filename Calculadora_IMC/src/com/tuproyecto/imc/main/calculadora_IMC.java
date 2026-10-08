package com.tuproyecto.imc.main;

import com.tuproyecto.imc.controller.IMCController;
import com.tuproyecto.imc.model.CalculadoraIMC;
import com.tuproyecto.imc.view.Calculado_Vista;

/**
 *
 * @author Elias Pérez Arroyo
 */
public class calculadora_IMC {

    public static void main(String[] args) {
        //Se declaran objetos de las clases del MVC
        Calculado_Vista vista;
        CalculadoraIMC modelo;
        IMCController controlador;
        
        //Se instancian y se pasan por parámetro del constructor del controlador
        //Así se trabajaran con las mismas instancias en todo momento con la arquitectura MVC
        vista = new Calculado_Vista();
        modelo = new CalculadoraIMC();
        controlador = new IMCController(vista, modelo);
        
        //Se llama al método del controlador inicializar() para comenzar a trabajar con la vista
        controlador.inicializar();

    }

}
