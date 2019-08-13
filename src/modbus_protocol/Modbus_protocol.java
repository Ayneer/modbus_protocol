/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package modbus_protocol;

import Persistencia.ConexionServidor;
import Vista.MedidorModbus;
import com.ghgande.j2mod.modbus.*;
import com.ghgande.j2mod.modbus.facade.ModbusSerialMaster;
import com.ghgande.j2mod.modbus.net.*;
import com.ghgande.j2mod.modbus.procimg.InputRegister;
import com.ghgande.j2mod.modbus.procimg.Register;
import com.ghgande.j2mod.modbus.procimg.SimpleInputRegister;
import com.ghgande.j2mod.modbus.procimg.SimpleRegister;
import com.ghgande.j2mod.modbus.util.*;
import gnu.io.SerialPort;
import java.io.IOException;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayneer Luis Gonzalez
 */
public class Modbus_protocol {    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        new MedidorModbus().setVisible(true);
        
        //Conocer el consumo = 8192
        //Conocer el id adress = 528
           
    }
    
}
