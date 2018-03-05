package ListasDobles;

public class CircularDoubleList<T> {
    private Node<T> cabeza;
    private Node<T> cola;
    
    //Primeros metodos de la lista.
    public boolean estaVacia(){
        
        return (this.cabeza == null);
        
    }
    
    public int numeroDeNodos(){
        
        int nodos = 0;
        
        if(!this.estaVacia()){
            
            boolean recorrida = false;

            Nodo aux = this.cabeza;

            while((aux.getNodoAnterior() != this.cola) || (!recorrida)){

                recorrida = true;

                nodos++;

                aux = aux.getNodoSiguiente();

            }
        }
        
        return nodos;
        
    }
    
    
    //Metodos para insertar nodos.
    public void insertarPrimero(Nodo nodo){
        
        if(this.cabeza != null){
            
            nodo.setNodoSiguiente(this.cabeza);
            
            nodo.setNodoAnterior(this.cola);
            
            this.cabeza.setNodoAnterior(nodo);
            
            this.cola.setNodoSiguiente(nodo);
            
        }else{
            
            this.cola = nodo;
            
            nodo.setNodoAnterior(nodo);
            
            nodo.setNodoSiguiente(nodo);
            
        }
        
        this.cabeza = nodo;
        
    }
    
    
    public void insertarUltimo(Nodo nodo){
        
        if(this.cola != null){
            
            nodo.setNodoAnterior(this.cola);
            
            nodo.setNodoSiguiente(this.cabeza);
            
            this.cola.setNodoSiguiente(nodo);
            
            this.cabeza.setNodoAnterior(nodo);
            
        }else{
            
            this.cabeza = nodo;
            
        }
        
        this.cola = nodo;
        
    }
    
    //Metodos de eliminación.
    public Nodo eliminarPrimero(){
        
        Nodo aux = this.cabeza;
        
        if(cabeza != null){
            
            this.cabeza = this.cabeza.getNodoSiguiente();
            
            this.cabeza.setNodoAnterior(aux.getNodoAnterior());
            
            aux.getNodoAnterior().setNodoSiguiente(this.cabeza);
            
        }
        
         return aux;
        
    }
    
    public Nodo eliminarUltimo(){
        
        Nodo aux = this.cola;
        
        if(this.cabeza == this.cola){
            
            this.cabeza = null;
            
        }else{
            
                this.cola = this.cola.getNodoAnterior();
                
                this.cola.setNodoSiguiente(this.cabeza);
                
                this.cabeza.setNodoAnterior(this.cola);
                
                aux.setNodoAnterior(null);
                
        }
        
        return aux;
        
    }

    //Getters.
    public Nodo getCabeza() {
        return cabeza;
    }

    public Nodo getCola() {
        return cola;
    }
    
}
