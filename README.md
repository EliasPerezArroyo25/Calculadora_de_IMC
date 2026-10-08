# Calculadora de IMC

<img width="819" height="276" alt="image" src="https://github.com/user-attachments/assets/aab1cf35-45f5-4d20-879c-033a0a0b3ca3" />


Al introducir el peso,altura y pulsar "Calcular" se obtiene el valor numérico del Índice de Masa Corporal (IMC) con un color que referencia la clasificación de la OMS siguiendo sus reglas y que también se incluye: 

- < 18.5: "Bajo Peso"
- 18.5 – 24.9: "Peso Normal"
- 25.0 – 29.9: "Sobrepeso"
- ≥ 30.0: "Obesidad"

## Desarrollo

Para el desarrollo de la aplicación se va a seguir el patron de dearrollo de MVC y una estructura de paquetes y responsabilidades predefinida.

### Configuración

**Paquetes**:

- com.tuproyecto.imc.model
- com.tuproyecto.imc.controller
- com.tuproyecto.imc.main
- com.tuproyecto.imc.view

**Modelo (com.tuproyecto.imc.model)**
<br>Contiene la clase CalculadoraMC.java con estos métodos:
- Cálculo de IMC con fórmula.
- Selección de rango con el IMC recibido.

**Vista (com.tuproyecto.imc.view)**
<br>Contiene la interfaz que cuenta con:
- Campos de texto para introducir peso y altura.
- Un botón para realizar el cálculo.
- Dos displays para mostrar los resultados.

**Controlador (com.tuproyecto.imc.controller)**
<br>Contiene la clase IMCController.java que cumple las siguiente funciones:
- Declara las variables miembro para los componentes de la Vista.
- Instancia el modelo y vista.
- Implementa métodos que enlaza al botón, indica el color del resultado, controla los valores indicados y manda los resultados usando los campos introducidos. 








