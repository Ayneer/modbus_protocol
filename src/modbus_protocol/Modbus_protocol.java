/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modbus_protocol;

import Logica.ConsumoReal;
import Logica.SoftwareXYZ;
import Persistencia.ConexionServidor;
import Vista.MedidorModbus;
import com.ghgande.j2mod.modbus.ModbusException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;

/**
 *
 * @author Ayneer Luis Gonzalez
 */
public class Modbus_protocol {

    public static void main(String[] args) {
        // TODO code application logic here

        new MedidorModbus().setVisible(true);
        /*ConexionServidor con = new ConexionServidor();
        SoftwareXYZ xyz = new SoftwareXYZ();
        int contador = 120;
        String fecha2 = "";
        //Verificar la existencia de algun consumo no enviado.
        boolean esta = true;
        while (esta) {
            //Primero se verifica si hay que enviar algun consumo guardado.
            ArrayList<ConsumoReal> listaConsumo = new ArrayList<>();
            listaConsumo = xyz.leerConsumo();

            if (!listaConsumo.isEmpty()) {

                System.out.println("Existen consumos sin enviar, intentare enviarlos...");
                System.out.println("********* Lista de consumos sin enviar *************");
                for (int i = 0; i < listaConsumo.size(); i++) {
                    System.out.println("posicion: " + i);
                    System.out.println(listaConsumo.get(i).toString());
                }
                System.out.println("******************** FIN **************************");
                
                int contadorError = 0;
                int i = 0;
                for (i = 0; i < listaConsumo.size(); i++) {
                    
                    System.out.println("\nSe intentará enviar este:");
                    System.out.println(listaConsumo.get(i).toString());

                    try {
                        con.enviarConsumo(1, listaConsumo.get(i).getLecturaMedidor(), listaConsumo.get(i).getFecha());
                        System.out.println("Consumo enviado... Ahora lo elimino de la lista");
                        listaConsumo.remove(i);
                        xyz.guardarConsumo(listaConsumo);//actualizamos la lista
                    } catch (IOException ex) {
                        System.out.println("Error al volver intentar conectar con el servidor...");
                        contadorError++;
                    }
                    if (contadorError > 0) {
                        break;
                    }
                    i--;//reiniciamos el iterador.
                }
            }
            //actualizo la lista
            listaConsumo = xyz.leerConsumo();
            try {
                System.out.println("\n");
                fecha2 = xyz.obtenerFechaMedicion();
                System.out.println("Nuevo consumo: Fecha= " + fecha2 +" Consumo= "+contador+" Id_medidor= "+1);

                if (listaConsumo.isEmpty()) {
                    //Puede enviar al servidor el nuevo consumo.
                    con.enviarConsumo(1, contador, fecha2);
                } else {
                    //guardo en la lista de consumo, este nuevo consumo
                    System.out.println("Nuevo consumo real almacenado en la lista...Aun existen consumos almacenado!");
                    ConsumoReal consumo = new ConsumoReal(1, contador, fecha2);
                    listaConsumo.add(consumo);
                    xyz.guardarConsumo(listaConsumo);
                }

            } catch (IOException ex) {
                System.out.println("Error al intentar conectar con el servidor.");
                System.out.println("La lectura se almacenará de forma local...");
                ConsumoReal cReal = new ConsumoReal(1, contador, fecha2);
                listaConsumo.add(cReal);
                xyz.guardarConsumo(listaConsumo);
                System.out.println("Consumo guardado de forma local.");
            } catch (Exception ex) {
                System.out.println("Error al intentar conectar con el medidor. SI esta conectado!!");
            }

            try {
                Thread.sleep(300000); // Wait 5 minutos 300000.  60000 = 1min
            } catch (InterruptedException ex) {
                System.out.println("Error al dormir el hilo");
            }
            contador++;// Wait 5 minutos. es en milisegundos
            System.out.println("---------------------------------------------");
        }*/

        //Conocer el consumo = 8192
        //Conocer el id adress = 528
    }

}
