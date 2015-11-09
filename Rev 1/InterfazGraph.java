/*
 *  Universidad del Valle de Guatemala
 *  Algoritmos y estructura de datos 
 
	yasmin Valdez , 14079
	Alejandro del leon , 
 */
 
public interface InterfazGraph<V,E> {

    /* Agrega  un nodo al grafo */
    public void add(V label);

    /* Agregar conexion entre nodos */
    public void addEdge(V vtx1, V vtx2, E label);
    
    /* Despliega el Ngraph */
    public void DespGraph();
    
    /* Obtiene la posicion de un nodo */
    public int getIndex(V label);
    
    /* En la posicion label obtiene el nodo */
    public V get(int label);
    
    /* Obtiene el peso de la conexion entre dos nodos */
    public int getEdge(V label1, V label2);
    
    /* Verifica si el nodo indicado existe en el Ngraph */
    public boolean contains(V label);
    
    /* Indica la cantidad de nodos en el Ngraph */
    public int size();
    
}