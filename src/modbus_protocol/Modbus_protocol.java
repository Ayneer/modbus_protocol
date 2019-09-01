/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modbus_protocol;

import Persistencia.ConexionServidor;
import Vista.MedidorModbus;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayneer Luis Gonzalez
 */
public class Modbus_protocol {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        //new MedidorModbus().setVisible(true);
        ConexionServidor con = new ConexionServidor();
        int contador = 39;
        while (true) {
            try {
                LocalDate fechaActual = LocalDate.now();
                String fecha = String.valueOf(fechaActual.format(DateTimeFormatter.ofPattern("M/d/yyyy")));

                LocalTime hora = LocalTime.now();
                String horaA = hora.getHour() + ":" + hora.getMinute() + ":" + hora.getSecond();
                System.out.println(horaA);
                String formato = "";

                if (hora.getHour() >= 12) {
                    if (hora.getHour() == 24) {
                        //son las 12 AM
                        formato = "AM";
                    } else {
                        formato = "PM";
                    }

                    if (hora.getHour() > 12) {
                        horaA = (hora.getHour() - 12) + ":" + hora.getMinute() + ":" + hora.getSecond();
                    }
                } else {
                    if (hora.getHour() == 0) {
                        //son las 12 AM
                        horaA = 12 + ":" + hora.getMinute() + ":" + hora.getSecond();
                    }
                    formato = "AM";
                }
                String fecha2 = fecha + ", " + horaA + " " + formato;

                System.out.println("Hora como javascript: " + fecha2);

                con.enviarConsumo(1, contador, fecha2);
                
                Thread.sleep(300000); // Wait 5 minutos. es en milisegundos
                contador++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Modbus_protocol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Conocer el consumo = 8192
        //Conocer el id adress = 528
    }

}
