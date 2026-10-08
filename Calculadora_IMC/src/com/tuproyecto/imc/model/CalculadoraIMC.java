package com.tuproyecto.imc.model;

/**
 *
 * @author Elias Pérez Arroyo
 */
public class CalculadoraIMC {
    //Método con fórmula de IMC que devuelve un número real directamente
    public double calcular(double peso,double altura){  
        
        return peso/(altura*altura);
    }
    //Método dónde se clasifica el rango empezando por el más común y devuelve el resultado usando solo un return para evitar confusiones
    public String clasificar (double imc){
        String clasificacion;
        if (imc >= 18.5 && imc < 24.9) {
            clasificacion = "Peso Normal";
        } else {
            if (imc >= 25) {
                if (imc <= 29.9) {
                    clasificacion = "Sobrepeso";
                } else {
                    clasificacion = "Obesidad";
                }
            } else {
                clasificacion = "Bajo Peso";
            }
        }
        return clasificacion;
    }
    
}
