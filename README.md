# TpHilos
primer tp

1- Puede variar ya que cada consumidor puede consumir una cantidad diferente de bebidas antes de que entre todos se acaben el stock. Además, puede variar de acuerdo a cuantos productores haya, y en la medida que va recargando a la beerHouse (si es que carga de a más de a un artículo).

2- No es lo mismo un bloque synchronized que un método synchronized. (No han explicado dicha diferencia). Aunqué en sí, lo que hacen ambos es limitar el acceso a dicho método o bloque, a un solo hilo al mismo tiempo, para evitar diferencias de escritura/lectura entre ellos.

3- El recurso compartido es la clase BeerHouse, es compartida por ambas clases (productor y consumidor). Al recurso compartido se lo llama Monitor, y el mismo encapsula sus atributos y define a sus métodos como synchronized, para que los hilos lleguen de a uno.

4- 

  A- Extender Thread y llamar al método start.
  
  B- Implementar Runnable, crear un objeto de tipo Thread y llamar al método run(Runnable "r") dónde "r" es el objeto que         
     implemente Runnable.
     
  C- crear un objeto de tipo Thread y mandar por parámetro una clase anónima que implemente Runnable (definiendo allí el cuerpo del  método run() ). Lo mismo de arriba pero pedorro.
