package com.example.demo;
import java.util.Scanner;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dos.EjercicioTrenesFunciones;



@SpringBootApplication
public class EjercicioTrenesApplication {
    
	public static void main(String[] args) {
		
		EjercicioTrenesFunciones objetoFunciones = new EjercicioTrenesFunciones();	
		Scanner entrada = new Scanner(System.in);
		
		int op=0;
		
		do {	
			
			System.out.println("\n\t Salidas :");
	        objetoFunciones.onv("C", "C", 3);
	        objetoFunciones.contadorViaje=1;
	        objetoFunciones.onve("A", "C", 4);
	        objetoFunciones.ormc("C","A",0);
	        System.out.println("Salida #8 : " + objetoFunciones.mejorCosto2);
	        objetoFunciones.ormc("B","B",0);
	        System.out.println("Salida #9 : " + objetoFunciones.mejorCosto2);
	        objetoFunciones.onrdm("C", "C", 0);
	        System.out.println("Salida #10 : " + objetoFunciones.contadorViaje2);
	        objetoFunciones.contadorViaje2=0;
	        
	        System.out.println("\n\n\tOpciones disponibles:\n");
			System.out.println("1. Obtener distancia de una ruta (Salida #1, #2, #3, #4, #5)");
			System.out.println("0. Salir");
			op = entrada.nextInt();
			entrada.nextLine();
			switch(op) {
				
				case 1:
					System.out.println("\nIngrese la ruta:");
					String ruta = entrada.nextLine();
					boolean valida=true;
					
					for (int x=0;x<ruta.length();x++){
						if(ruta.charAt(x)!='A'&& ruta.charAt(x)!='B'&& ruta.charAt(x)!='C'&& ruta.charAt(x)!='D'&& ruta.charAt(x)!='E') {
							valida=false;
							break;						
						}
					}
					
					if(valida) {
						int distancia = 0;
				        distancia = objetoFunciones.getDistancia(ruta);
				        if (distancia > 0)
				        	System.out.println("La distancia de la ruta '" +ruta +"' es : " + distancia);
				        else
				            System.out.println("No existe tal ruta");
				        
				       	
					}else
						System.out.println("\nLa ruta '" +ruta+"' no es válida.");
					
					
				break;
				
					
				default:
			
				break;
			}
			
			entrada.nextLine();
		}while(op != 0);
		
	}
}
