/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 
 
	yasmin Valdez , 14079
	Alejandro del leon , 
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args){
        
        FloydGraph MatCity = new FloydGraph(); 			/* Crea la matriz de adyacencia */
        MatCity.ShortWay(); 					/* Encuentra el camino más corto entre los nodos / menor distancia entre las ciudades  */
        int opcion1; 							
        int opcion2; 							
        Scanner Scanner1 = new Scanner(System.in);
        System.out.println("1. Encontrar la ruta más corta para los dos destinos ");
        System.out.println("2. ciudad que se encuentra en el centro del grafo");
        System.out.println("3. Modificar Ngraph");
        System.out.println("4. Salir");
        opcion1 = Scanner1.nextInt(); 
        
       
        while(opcion1!=4){
            /* Se muestra la matriz de adyacencia  */
            System.out.println("\nMatriz de adyacencia");
            MatCity.Interface1.DespGraph();
            
            /* Pregunta los destinos y desplegar los resultados  */
            if(opcion1==1){
                MatCity.ShortWay(); 			/* Camino mas corto entre las ciudades */
                System.out.println("Ingrese el nombre de la ciudad de salida");
                String ciudad1 = Scanner1.next(); 
                System.out.println("Ingrese el nombre de la ciudad de destino");
                String ciudad2 = Scanner1.next();
                /* Desplegar la distancia minima y la ruta completa, Si las ciudades existen*/
                if(MatCity.Interface1.contains(ciudad1)&&MatCity.Interface1.contains(ciudad2)){
                    System.out.println("\nLa distancia minima es: "+MatCity.Interface1.getEdge(ciudad1, ciudad2)+".");
                    if(MatCity.Interface1.getEdge(ciudad1, ciudad2)!=10000){
                        System.out.print("La ruta es: "+ciudad1);
                        MatCity.MintGraph(MatCity.Interface1.getIndex(ciudad1), MatCity.Interface1.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            /* Desplegar el centro del Ngraph (opción 2) */
            else if(opcion1==2){
                MatCity.GraphCenter();
            }
            
            /* Preguntar cual es el cambio archivotxt realizar y ejecutarlo  */
            else if(opcion1==3){
                System.out.println("1. Hay interrupcion de trafico entre un par de ciudades");
                System.out.println("2. Establecer nueva conexion");
                opcion2 = Scanner1.nextInt();
                // Si la respuesta es 1, preguntar por el nombre de las ciudades y colocar un numero muy grande de esta forma se
				// quita la conexion en la matriz
               
                if(opcion2==1){
                    System.out.println("Ingrese el nombre de la ciudad de salida");
                    String ciudad1 = Scanner1.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = Scanner1.next();
                    if(MatCity.Interface1.contains(ciudad1)&&MatCity.Interface1.contains(ciudad2)){
                        MatCity.Interface1.addEdge(ciudad1, ciudad2, 10000);
                        // se modifica y guarda el archivo 
                        try {
                            MatCity.archivotxt.WTRsave(ciudad1+" "+ciudad2+" 10000");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                /* se pregunta  por el nombre de las ciudades y agregar distancia */
                else if(opcion2==2){
                    System.out.println("Ingrese el nombre de la ciudad de salida");
                    String ciudad1 = Scanner1.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = Scanner1.next();
                    System.out.println("Ingrese la distancia entre las ciudades");
                    int distancia = Scanner1.nextInt();
                    // Si las ciudades ya existe solo se modifica el valor 
                    if(MatCity.Interface1.contains(ciudad1)&&MatCity.Interface1.contains(ciudad2)){
                        MatCity.Interface1.addEdge(ciudad1, ciudad2, distancia);
                    }
                    /* Agregar archivotxt la MatCity las ciudades que no existen */
                    else{
                        MatCity.Interface1.add(ciudad1);
                        MatCity.Interface1.add(ciudad2);
                        MatCity.Interface1.addEdge(ciudad1, ciudad2, distancia);
                    }
                    /* En el archivo guardar los cambios */
                    try {
                        MatCity.archivotxt.WTRsave(ciudad1+" "+ciudad2+" "+distancia);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                /* Definir las distancias para las rutas mas cortas */
                MatCity.ShortWay();
            }
       
            System.out.println("1. Encontrar la ruta más corta para los dos destinos ");
            System.out.println("2. Nombre de la ciudad en el centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Salir");
            opcion1 = Scanner1.nextInt();
        }
        
    }
}