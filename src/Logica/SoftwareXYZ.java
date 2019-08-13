/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import com.ghgande.j2mod.modbus.Modbus;
import com.ghgande.j2mod.modbus.facade.ModbusSerialMaster;
import com.ghgande.j2mod.modbus.procimg.InputRegister;
import com.ghgande.j2mod.modbus.util.SerialParameters;
import gnu.io.SerialPort;

/**
 *
 * @author Ayneer Luis Gonzalez
 */
public class SoftwareXYZ {

    private boolean estado = false;

    public SoftwareXYZ() {
        estado = false;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int leerConsumoMedidorInteligente(int idMedidor, String puerto) {

        //Respesta del medidor
        String valor = "";
        int valorConsulta = 0;

        //Instanciar objeto maestro (Medidor Inteligente).
        ModbusSerialMaster medidorSmart = null;
        //Codigo que se le enviará al maestro para hacer la consulta.
        int codigo = 8192;
        //Donde se almacenará la respuesta del maestro. 2 porque el valor de la lectura puede ser muy grande.
        InputRegister[] respuestaMaestro = new InputRegister[2];

        //Configuración para conectarse con el maestro.
        SerialParameters parametros = new SerialParameters();
        parametros.setPortName(puerto);
        parametros.setBaudRate(9600);
        parametros.setDatabits(8);
        parametros.setParity(SerialPort.PARITY_NONE);
        parametros.setStopbits(SerialPort.STOPBITS_1);
        parametros.setEncoding(Modbus.SERIAL_ENCODING_RTU);
        parametros.setEcho(false);

        try {
            //Se abre una conexion con el esclavo.
            medidorSmart = new ModbusSerialMaster(parametros);
            medidorSmart.connect();

            //Se realiza la consulta al maestro.
            respuestaMaestro = medidorSmart.readInputRegisters(idMedidor, codigo, 2);

            //Se lee la respuesta del maestro.
            for (int i = 0; i < respuestaMaestro.length; i++) {
                valor += String.valueOf(respuestaMaestro[i]);
            }

            valorConsulta = Integer.parseInt(valor);

            //Se cierra la conexión.
            medidorSmart.disconnect();

        } catch (Exception exception) {
            System.out.print("\nError al intentar establecer comunicación con el maestro.");
          //  exception.printStackTrace();
        }

        return valorConsulta;
    }

    public int obtenerLecturaReal(int lectura) {
        int lecturaReal = 0;
        int tamanoLectura = String.valueOf(lectura).length();
        if (tamanoLectura > 2) {

            int[] digitos = new int[tamanoLectura];
            int i = digitos.length - 1;
            while (lectura > 0) {
                digitos[i] = lectura % 10;
                lectura = lectura / 10;
                i--;
            }
            String numeros = "";

            for (int j = 0; j < digitos.length - 2; j++) {
                numeros += digitos[j];
            }
            lecturaReal = Integer.parseInt(numeros);
        }
        return lecturaReal;

    }
}
