
package com.tuproyecto.imc.controller;

import com.tuproyecto.imc.model.CalculadoraIMC;
import com.tuproyecto.imc.view.Calculado_Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Elias Pérez Arroyo
 */
public class IMCController implements ActionListener{
    
    private final Calculado_Vista vista;
    private final CalculadoraIMC calculadora;
    private String peso;
    private String altura;
    
    
    
    public IMCController(Calculado_Vista v,CalculadoraIMC m) {
        this.vista=v;
        this.calculadora=m;
    }
    public void inicializar(){
        vista.getBtnCalcular().addActionListener(this);
        vista.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getBtnCalcular()){
            procesarCalculo();
        }
    }
    
    private void procesarCalculo(){
        
        double resultado;
        peso=vista.getPeso();
        altura=vista.getAltura();
        if (peso.isEmpty() && altura.isEmpty()){
            if(peso.matches("^(?:\\d{2,3})(?:[.,]\\d{1,2})?$") && altura.matches("^\\d{2,3}$")){
                resultado=calculadora.calcular(Double.valueOf(peso),Double.valueOf(altura));
                vista.setCalculo(String.valueOf(resultado));
                vista.setClasiDePeso(calculadora.clasificar(resultado));
            }else{
               //Mostrar mensaje de Mete datos erroneos en algún campo
            }            
        }else{
            //Mostrar mensaje de No mete datos en algún campo
        }
    }
    
    
    
    
    
    
    
}
