/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 
 
	yasmin Valdez , 14079
	Alejandro del leon , 
 */
 
import java.io.IOException;

public class FloydGraph {
    
    LectorText archivotxt= new LectorText();
    InterfazGraph Interface1;
    int[][] control;
    int[] maximo;
    int centro;
    int minimo=10000;
 
    public FloydGraph(){
        
        try {
            archivotxt.obtenerArchivo("src/datos.txt");
            archivotxt.Ciudades(); 	/* Nombre de los nodos o ciudades  */
            Interface1 = archivotxt.MatDist(); 	/* Peso / distancia de los arcos entre nodos */
            control = new int[25][25]; 	/* Matriz de nodos intermedios */
            maximo = new int[25];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<archivotxt.Ngraph.size();n++){
            for(int m=0;m<archivotxt.Ngraph.size();m++){
                control[n][m]=10000;
            }
        }
    }
    
    /* Algoritmo de FloydGraph para encontrar el camino mas corto entre todos los nodos es decir la distancia mas corta  */
    public void ShortWay(){
        for(int k=0;k<Interface1.size();k++){
            for(int i=0;i<Interface1.size();i++){
                for(int j=0;j<Interface1.size();j++){
                    if(Interface1.getEdge(Interface1.get(i),Interface1.get(j))>(Interface1.getEdge(Interface1.get(i), Interface1.get(k))+Interface1.getEdge(Interface1.get(k), Interface1.get(j)))){
                        Interface1.addEdge(Interface1.get(i), Interface1.get(j), (Interface1.getEdge(Interface1.get(i), Interface1.get(k))+Interface1.getEdge(Interface1.get(k), Interface1.get(j))));
                        control[i][j]=k;
                    }
                }
            }
        }
        
    }
    
    /* Encontrar el centro del grafo o la ciudad central  */
    public void GraphCenter(){
        ShortWay();
        int n=0;       
        /* Encuentra los valores máximos de la matríz en cada columna */
        for(int i=0;i<Interface1.size();i++){
            for(int j=0;j<Interface1.size()-1;j++){
                int num1=Interface1.getEdge(Interface1.get(j), Interface1.get(i));
                n=j;
                n++;
                int num2=Interface1.getEdge(Interface1.get(n), Interface1.get(i));
                if(num1>num2){
                    maximo[i]=num1;
                }
                else{
                    maximo[i]=num2;
                }
            }
            n++;
        }
        /* Encuentra los valores minimos de los maximos de todas las columnas  de la matriz de adyacencia */
        for(int i=0;i<Interface1.size();i++){
            int num1=maximo[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        System.out.println("\nEl centro del grafo es: "+Interface1.get(centro)+"\n");
        
    }
    
    /* Desplegar los nodos intermedios  del grafo */
    public void MintGraph(int num1, int num2){
        if(control[num1][num2]!=10000){
            MintGraph(num1,control[num1][num2]);
            System.out.print(", "+Interface1.get(control[num1][num2]));
            MintGraph(control[num1][num2],num2);
            return;
        }
        else return;
           
    }
}