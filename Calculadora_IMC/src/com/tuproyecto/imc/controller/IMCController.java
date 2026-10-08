package com.tuproyecto.imc.controller;

import com.tuproyecto.imc.model.CalculadoraIMC;
import com.tuproyecto.imc.view.Calculado_Vista;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Elias Pérez Arroyo
 */
public class IMCController implements ActionListener {
    //Se declaran las instancias del modelo y vista como constantes ya que no cambian 
    private final Calculado_Vista vista;
    private final CalculadoraIMC calculadora;
    //Se declaran las variables peso y altura en la clase en caso de uso en otro método futuro
    private String peso;
    private String altura;

    //Se define el constructor del contralador para que reciba la vista y modelo por parámetro 
    //Asigna el objeto recibido con los declarados en la propia clase
    public IMCController(Calculado_Vista v, CalculadoraIMC m) {
        this.vista = v;
        this.calculadora = m;
    }
    
    //Metodo que vincula el controlador para que reaccione ante la interacción del botón Calcular
    //Se ha incluido en inicializar el addActionListener() aqui para que sea independiente del constructor
    //El método hace que la vista sea visible por el usuario
    
    public void inicializar() {
        vista.getBtnCalcular().addActionListener(this);
        vista.setVisible(true);
    }
    
    //Metodo predefinido por la interfaz ActionListener que se sobreescribe para que al pulsar Calcular active el método siguiente
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnCalcular()) {
            procesarCalculo();
        }
    }
    
    /*Metodo en el que se declara una variable resultado para poder manejar el IMC de manera más limpia.
      Se guarda la altura y el peso  introducido en la variable y se reemplaza la coma de los decimales a un punto
        para que Java haga los cálculos con el formato correcto.
      Se verifica que no este vacío ninguno y en caso contrario se manda un mensaje de error a la vista a través de un método.
      A continuación se rodea el siguiente bloque con un try-catch para recoger el error que se produciria si no se han introducido número
        causado por el parseo, en ese caso se enviaría otro mensaje al mismo método de antes.
      Una vez comprobado, se calcula el IMC llamando al método del modelo y se guarda el resultado en la variable 
        que se usará para calcular la clasificación llamando de nuevo al otro método del modelo.
      Se pasa el resultado como texto con formato de dos decimales para que lo muestre la vista que
        además se le seleccionará el color con el que se mostrará según el rango en la tabla de IMC seleccionado aquí 
        para mantener esta lógica en el controlador.
    
    */
    private void procesarCalculo() {

        double resultado;
        peso = vista.getPeso().replace(',', '.');
        altura = vista.getAltura();
        if (!peso.isEmpty() && !altura.isEmpty()) {
            try {

                resultado = calculadora.calcular(Double.parseDouble(peso), Double.parseDouble(altura) / 100);
                vista.setCalculo(String.format("%.2f", resultado));
                vista.setClasiResultado(calculadora.clasificar(resultado));
                
                if (resultado >= 18.5 && resultado < 24.9) {
                    vista.getLblCalculo().setForeground(Color.green);
                } else {
                    if (resultado >= 25) {
                        if (resultado <= 29.9) {
                            vista.getLblCalculo().setForeground(Color.orange);
                        } else {
                            vista.getLblCalculo().setForeground(Color.red);
                        }
                    } else {
                        vista.getLblCalculo().setForeground(Color.blue);
                    }
                }

            } catch (NumberFormatException ex) {

                vista.mostrarErrorDatos("Dato erróneo introducido");
                //Mostrar mensaje de Mete datos erroneos en algún campo
            }
        } else {
            vista.mostrarErrorDatos("Introduzca todos los datos necesarios");
        }
    }

}
