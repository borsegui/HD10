/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 
 
	yasmin Valdez , 14079
	Alejandro del leon , 
 */
 
import java.io.*;

public class LectorText{
    
    File archivo;
    FileReader Lector1;
    BufferedReader brReader;
    FileWriter L1;
    PrintWriter L2;
    InterfazGraph Ngraph = new MatrizGrafos();

    /* Obtiene el archivo  de texto */
    public void obtenerArchivo(String direccion) throws FileNotFoundException{
       archivo=new File(direccion); 
    }  
    
    /* Obtiene los nombres de las ciudades o nodos  para el Ngraph */
    public InterfazGraph Ciudades() throws IOException{
        Lector1 = new FileReader (archivo);
        brReader = new BufferedReader(Lector1);
        String CityLine;
        while((CityLine=brReader.readLine())!=null){
            String[] tmp;
            tmp=CityLine.split(" ");
            Ngraph.add(tmp[0]);
            Ngraph.add(tmp[1]);
        }
        return Ngraph;
    }
    
    /* Escribe en el archivo para realizar los cambios por el user  */
    public void WTRsave(String cadena) throws IOException{
        L1 = new FileWriter(archivo);
        L2 = new PrintWriter(L1);
        L2.println(cadena);
    }
    
    /* Obtiene los pesos o distancia de los arcos entre nodos del grafo con las ciudades  */
    public InterfazGraph MatDist() throws IOException{
        Lector1 = new FileReader (archivo);
        brReader = new BufferedReader(Lector1);
        String CityLine;

        while((CityLine=brReader.readLine())!=null){
            String[] tmp;
            tmp=CityLine.split(" ");
            Ngraph.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return Ngraph;
    }
}