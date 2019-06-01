/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package modbus_protocol;

import com.ghgande.j2mod.modbus.*;
import com.ghgande.j2mod.modbus.facade.ModbusSerialMaster;
import com.ghgande.j2mod.modbus.net.*;
import com.ghgande.j2mod.modbus.procimg.InputRegister;
import com.ghgande.j2mod.modbus.procimg.Register;
import com.ghgande.j2mod.modbus.util.*;
import gnu.io.SerialPort;

/**
 *
 * @author Ayneer Luis Gonzalez
 */
public class Modbus_protocol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /* The important instances of the classes mentioned before */
	ModbusSerialMaster serialMaster = null; // the connection
	
	/* Variables for storying the parameters */
	String portname = "COM3"; // the name of the serial port to be used
	int unitID = 1; // the unit identifier we will be talking to
	int startingRegister = 8192; // the reference, where to start reading from
	int registerCount = 2; // the count of the input registers to read
	InputRegister[] slaveResponse = new InputRegister[registerCount];
        
        try {
		/* Setup the serial parameters */
		SerialParameters parameters = new SerialParameters();
		parameters.setPortName(portname);
		parameters.setBaudRate(9600);
		parameters.setDatabits(8);
		parameters.setParity(SerialPort.PARITY_NONE);
		parameters.setStopbits(SerialPort.STOPBITS_1);
		parameters.setEncoding(Modbus.SERIAL_ENCODING_RTU);
		parameters.setEcho(false);

		/* Open the connection */
		serialMaster = new ModbusSerialMaster(parameters);
		serialMaster.connect();

	} catch (Exception exception) {
                System.out.print("error to build SerialParameters");
		exception.printStackTrace();
                
	}
        
        /* Read the first four holding registers */
	try {
		slaveResponse = serialMaster.readInputRegisters(unitID, startingRegister, registerCount);
		for (int i = 0; i < slaveResponse.length; i++) {
			System.out.println("reg" + i + " = " + slaveResponse[i]);
		}
	} catch (ModbusException e) {
                System.out.print("Error to comunicated");
		e.printStackTrace();
	}
	/* Close the connection */
	serialMaster.disconnect();
    }
    
}
