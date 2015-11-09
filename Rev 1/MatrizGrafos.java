/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 
 
	yasmin Valdez , 14079
	Alejandro del leon , 
 */



import java.util.Vector;

public class MatrizGrafos<V,E> implements InterfazGraph<V,E>{

    private Vector vertex = new Vector();
    private int[][] arcos= new int [25][25];
    
    /* Constructor */
    public MatrizGrafos(){
        
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    arcos[i][j]=0;
                }
                else{
                    arcos[i][j]=10000;
                }
            }
        }
    }
	
    @Override
    public void add(V label) {
        
        if(!vertex.contains(label)){
            vertex.add(label);
        }  
    }

    @Override
    public void addEdge(V vtx1, V vtx2, E label) {
        int i = vertex.indexOf(vtx1);
        int j = vertex.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        arcos[i][j]=peso;
    }

    @Override
    public void DespGraph(){
        for(int archivotxt=0;archivotxt<vertex.size();archivotxt++){
            for(int b=0;b<vertex.size();b++){
                System.out.print(""+arcos[archivotxt][b]+" ");
            }
            System.out.println("");
        }
    }
    
    @Override
    public int size(){
        return vertex.size();
    }

    @Override
    public int getEdge(V label1, V label2){
        return arcos[vertex.indexOf(label1)][vertex.indexOf(label2)];
    }
    
    @Override
    public V get(int label){
        
        return (V)vertex.get(label); 
    }
    
    @Override
    public int getIndex(V label){
        return vertex.indexOf(label);
    }

    public boolean contains(V label){
        return vertex.contains(label);
    }
}