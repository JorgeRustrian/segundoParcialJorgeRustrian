public class linkedList {
    nodo head; // Este es el primer nodo de la lista enlazada
    public linkedList(){
     this.head=null;   //Inicializamos la lista pero sin ningun nodo.
    }
//Este metodo agrega un valor al final de la lista enlazada
    public void agregarDatos(int data){
        nodo nuevoNodo = new nodo(data); // El valor recibido como parametro lo usamos para crear un nuevo nodo. 
             if(head==null){
                head=nuevoNodo;    // Si la cabeza esta vacia sabemos que este es el rpimer nodo
             }
             else{          // En caso contrarioa lo anterior significa que necesitamos recorrer toda la lista para llegar al elemento final
                nodo actual=head;    //Creamos un nodo provisional que se usara para guardar el nodo cabeza
                while(actual.next!=null){   // Sabemos que si un nodo tiene null es porque es el ultimo
                    actual=actual.next; // asignamos el valor hasta llegar al ultimo
                }
                actual.next=nuevoNodo;    // Agregamos el nuevo nodo al final de la lista.
             }

    }
//Este metodo agrega un valor al inicio de la lista
  public void agregarPrimero(int data){
    nodo nuevoNodo=new  nodo(data); // Creamos un nuevo nodo con lo que recibimos de parametro.
    nuevoNodo.next=head;  // asignamos que el siguiente nodo sea la cabeza actual
    head=nuevoNodo;     // la nueva ccabeza es nuestro nuevo nodo.

  }
  // Este metodo agrega un elemnto a la lista en una posicion elegida arbitrariamente.
  public void agregarPosicion(int data, int posicion){   // Notese que a diferencia de los metodos anteriores que recibian solamente el dato a guardar, este tambien recibe la posicion en la que queremos guardarlo
          nodo nuevoNodo= new nodo(data);        // Creamos un nuevo nodo
          if(head==null || posicion <=0){       // Comprobamos que la posicion sea valida. Y que la lista no este vacia. Si esta vacia simplemente llamamos al metodo agregarPrimero
           agregarPrimero(data);
            return;
          }
          nodo actual = head;        // Usamos un nodo provisional para guardar la cabeza
          int contador =0;        // Iniciamos un contador que nos ayudara a encontrar la posicion requerida

          while(actual != null && contador <posicion -1){     // El while se encarga de que nuestro nodo no sea el ultimo y que se pare justo 1 posicion antes de la posicion requerida
                 actual=actual.next;  
                 contador++;   // Entonces asignamos a nuestro nodo provisional el valor de la posicion contigua
          }
          if(actual != null){ // para evcitar errores verificamos que no sea null
            nuevoNodo.next=actual.next;   // Corre el nodo de la posicion requerida
            actual.next=nuevoNodo;             // El nodo de la posicion requerida es cambiado por nuevo nodo
          }
  }

  public void eliminar(int data){
    if(head==null){     // Si la lista esta vacia. no hace nada
        return;
    }
    if(head.data==data){
        head=head.next;        // Si el elemento a eliminar es la cabeza solo se corre. 
        return;
    }     
    // Caso contrario creamos un nodo temporal. Que sera la cabeza
    nodo actual=head;
    while(actual.next.data !=data && actual.next !=null){ // Recorremos la lista hasta que haya coincidencia
             actual=actual.next;       //El nodo temporal cambia de valor por el que le sigue
    }
    if(actual.next!= null){    
        actual.next=actual.next.next; // Lo que hace es saltar la referencia del siguiente. por eso el doble next
    }
  }

  public void imprimirLista(){
    nodo actual=head; // El nodo temporal empieza desde la cabeza
    while(actual !=null){  
        //el while nos sirve para recorrer la lista, vamos recorriendo cada nodo.
        System.out.println(actual.data+" -> ");
        actual=actual.next;
    }
    System.out.println("null");
  }
// Revierte el orden d ela lista
  public void reverse(){
        nodo previo = null; // apunta al nodo anterior
        nodo actual= head;   // Empieza por la cabeza
        nodo siguiente=null;  // apunta al siguiente nodo
        while(actual!=null){      // Mientras no lleguemos a la ultima posicion

           siguiente=actual.next; // El nodo siguiente guarda la posicion del siguiente a donde estamos parados
           actual.next=previo;    // El nodo actual ahora apunta al anterior
           previo=actual;      // previo toma la posicion del nodo actual
           actual=siguiente;      // Mueve el nodo actual al siguiente 
 

        }
        head=previo;     // sal final previo es el ultimo nodo entonces head sera este. 
  }
  // Recorre la lista y devuelve verdadero si el valor esta en la lista de lo contrario devuelve falso
  public boolean contiene(int valor){
           nodo actual =head;        // recorremos la lista como lo hemos hecho anteriormente empezando desde la cabeza y un while
           while(actual!=null){
              if(actual.data==valor){        // En el momento en el que el valor de un nodo es igual al valor recibido como parametro devuelve true.
                return true;
              }
              actual=actual.next;    // Pasa al siguiente nodo para su revision

           }
           return false;       // Si no encontro coincidencias devuelve false


  }

}
