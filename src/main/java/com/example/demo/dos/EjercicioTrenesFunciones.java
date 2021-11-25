package com.example.demo.dos;

public class EjercicioTrenesFunciones {
	
	public int[][] matriz = {
	        //    A   B   C   D   E
	    /*A*/   {-1,  5, -1,  5,  7},
	    /*B*/   {-1, -1,  4, -1, -1},
	    /*C*/   {-1, -1, -1,  8,  2},
	    /*D*/   {-1, -1,  8, -1,  6},
	    /*E*/   {-1,  3, -1, -1, -1},
	    };
	

	
	public int getDistancia(String cadena)
    {
        int distancia = 0;
        for (int i=0; i<cadena.length()-1; i++) {
            int indicenodo = cadena.charAt(i) - 'A';
            int nodosiguiente = cadena.charAt(i+1) - 'A';
            if (matriz[indicenodo][nodosiguiente] == -1) {
                return -1;
            } else {
                distancia += matriz[indicenodo][nodosiguiente];
            }
        }
        return distancia;
    }
	
	
	public int contadorViaje = 1;
	
	public void onv(String inicio, String fin, int longitudMax)
    {
        
        if (fin.length() - 1 > longitudMax) return;

        if ( fin.length() > 1 && fin.endsWith(inicio) ) {
        	if(contadorViaje > 1) {
        		System.out.println("Salida #6 : " + contadorViaje);
        	}
            contadorViaje ++;
        }

        char anteriorcaracter = fin.charAt(fin.length()-1);
        int indicenodoanterior = anteriorcaracter - 'A';
        for ( int i=0; i<matriz[indicenodoanterior].length; i++ )
        {
            char newChar = (char)(i + 'A');
            if ( matriz[indicenodoanterior][i] > 0) {
                onv(inicio, fin + newChar, longitudMax);
            }
        }
    }
	
	
	public void onve(String inicio, String fin, int paradas) {
        String ultimaRuta = inicio;
        for (int salto = 0; salto < paradas; salto++) {
            String ruta = "";
            for (int i = 0; i < ultimaRuta.length(); i++) {
                char c = ultimaRuta.charAt(i);
                int id = c - 'A';
                for (int j = 0; j < matriz[id].length; j++) {
                    if (matriz[id][j] > 0)
                        ruta = ruta + (char) (j + 'A');
                }
            }
            ultimaRuta = ruta;
        }
        System.out.println("Salida #7 : "+ (ultimaRuta.split(fin).length - 1));
      
    }
	
	
	public String mejorCamino2 = "";
    public int mejorCosto2 = Integer.MAX_VALUE;
    
    public void ormc(String inicio, String fin, int cost) {
        if (fin.endsWith(inicio) && cost < mejorCosto2 && cost > 0) {
            mejorCamino2 = fin;
            mejorCosto2 = cost;
            return;
        }
        char anteriorcaracter = fin.charAt(fin.length() - 1);
        int indicenodoanterior = anteriorcaracter - 'A';

        for (int i = 0; i < matriz[indicenodoanterior].length; i++) {
            char nuevocaracter = (char) (i + 'A');
            int nuevocosto = matriz[indicenodoanterior][i];
            if (nuevocosto > 0) {
                if (fin.indexOf(nuevocaracter) > 0)
                    continue;
                ormc(inicio, fin + nuevocaracter, cost + nuevocosto);
            }
        }
    }
	

    
    public int contadorViaje2 = 0;
    public void onrdm(String inicio, String fin, int menores) {
        if (menores >= 30)
            return;
        if (menores > 0 && fin.endsWith(inicio)) {
        	contadorViaje2++;
        }
        char anteriorcaracter = fin.charAt(fin.length() - 1);
        int indicenodoanterior = anteriorcaracter - 'A';
        for (int i = 0; i < matriz[indicenodoanterior].length; i++) {
            char nuevocaracter = (char) (i + 'A');
            int nuevomenor = matriz[indicenodoanterior][i];
            if (nuevomenor > 0) {
            	onrdm(inicio, fin + nuevocaracter, menores + nuevomenor);
            }
        }
    }
    
	
	
}
