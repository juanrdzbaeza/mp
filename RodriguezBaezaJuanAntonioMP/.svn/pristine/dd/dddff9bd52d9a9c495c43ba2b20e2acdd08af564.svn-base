package org.mp.sesion03;

/**
 * Class to create objects taxi stops
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 20/03/2015
 */

public class ParadaTaxis{
	/**
	 * Attributes for the taxis stops
	 * 1)cola: array for objects Taxi
	 * 2)nombre: stop name
	 * 3)direccion: Stop address
	 */
	//private QueueArray cola = new QueueArray();
	private String nombre;
	private String direccion;
	
	private Taxi[] taxisArray;
	private int primeroDeLaCola;
	private int ultimoDeLaCola;
	private int longitudCola;
	private int longitudParada;
	
	/**
	 * constructor for class
	 * @param nombre stop name
	 * @param direccion Stop address
	 */
	public ParadaTaxis(String nombre,String direccion){
		this.nombre				= nombre;
		this.direccion			= direccion;	
		this.primeroDeLaCola	= 0;
		this.ultimoDeLaCola		= -1;
		this.longitudCola		= 0;
		this.longitudParada		= 10;
		this.taxisArray			= new Taxi[longitudParada];
	}
	
	/**
	 * returns the size of the queue of taxis
	 * @return int numbers of taxis
	 */
	public int numeroTaxis(){
		return longitudCola;//retorna el atamaño de de la cola de taxis
	}
	
	/**
	 * A taxi arrives in the queue and placed in the last position by
	 * calling the method addLast (t)
	 * @param t object taxi
	 */
	public void entradaTaxi(Taxi t){
		ensureCapacity();
		ultimoDeLaCola = increment(ultimoDeLaCola);
		taxisArray[ultimoDeLaCola] = t;//un taxi llega a la cola y se coloca en la ultima posicion.
		longitudCola++;
	}
	
	/**
	 * Increases the size of the queue
	 */
	private void ensureCapacity(){
		if(longitudCola == longitudParada){
			Taxi[] aux = new Taxi[longitudParada*2];
			for (int i = 0; i < taxisArray.length; i++, primeroDeLaCola = increment(primeroDeLaCola)) {
				aux[i]=taxisArray[primeroDeLaCola];
			}
			taxisArray		= aux;
			primeroDeLaCola	= 0;
			ultimoDeLaCola	= longitudCola-1;
			longitudParada	= taxisArray.length;
		}
	}
	
	/**
	 * Pointers controls
	 * @param x
	 * @return x
	 */
	private int increment(int x){
		if(++x == taxisArray.length)
			x = 0;
		return x;
	}

	/**
	 * The first taxi queue is going
	 * @return taxi 
	 * @throws EmptyQueueException if the queue is empty
	 */
	public Taxi salidaTaxi() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException ("Parada vacía");
		Taxi aux = taxisArray[primeroDeLaCola];
		taxisArray[primeroDeLaCola] = null;//el primer taxi de la cola se va
		primeroDeLaCola = increment(primeroDeLaCola);
		longitudCola--;
		return aux;
	}
	
	/**
	 * Checks if the queue is empty
	 * @return true or false
	 */
	public boolean isEmpty() {
		return (longitudCola == 0);
	}
	
	/**
	 * The first taxi queue is identified
	 * @return taxi
	 * @throws EmptyQueueException if the queue is empty
	 */
	public Taxi primerTaxi() throws  EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException ("Parada vacía");
		return taxisArray[primeroDeLaCola];//El primer taxi de la cola se identifica
	}
	
	/**
	 * Method to create a list of licensed taxis of the queue
	 * @return taxi
	 * @throws EmptyQueueException if the queue is empty
	 */
	public String listado()throws  EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException ("Parada vacía");
		
		String listado = "";//cadena para añadir las licencias de los taxis
		for (int i = 0; i < this.longitudCola; i++) {
			listado += taxisArray[i].getLicencia();//añadimos la licencia del taxi a la cadena
		}
		return listado;//devolvemos el listado
	}

	/**
	 * Method to return the first taxi adapted for disabled of the queue
	 * @return taxiAdaptado taxi adapted for disabled
	 * @throws EmptyQueueException if the queue is empty
	 */
	public Taxi minusvalidoTaxi() throws  EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException ("Parada vacía");
		int posicionDelPrimero	= primeroDeLaCola;	//guardamos la posicion que marca el primero de la cola
		Taxi taxiAdaptado		= null;				//este será el primer taxi adaptado para minusvalidos
		boolean taxiAdaptadoOK	= false;			//con este interruptor marcaremos que hemos encontrado un taxi adaptado
		for (int i = 0; i < longitudCola && !taxiAdaptadoOK; i++, primeroDeLaCola = increment(primeroDeLaCola)) {
			if(taxisArray[primeroDeLaCola].getMinusvalido()){
				longitudCola--;
				taxiAdaptadoOK = true;
				taxiAdaptado = taxisArray[primeroDeLaCola];
				taxisArray[primeroDeLaCola] = null;
			}
		}
		primeroDeLaCola = posicionDelPrimero;
		/*
		 * una vez haya salido el taxi adaptado tendremos que recolocar la cola
		 * respetando el orden de los taxis.
		 */
		Taxi[] colaAuxiliar = new Taxi[longitudCola];//creamos una cola auxiliar con el tamaño de nuestra cola de taxis
		for (int i = 0; i < longitudCola; i++, primeroDeLaCola = increment(primeroDeLaCola)) {
			if(taxisArray[primeroDeLaCola] == null && taxisArray[ultimoDeLaCola] != null){
				primeroDeLaCola = increment(primeroDeLaCola);
			}
			colaAuxiliar[i] = taxisArray[primeroDeLaCola];//colocamos los taxis en orden pero desde la posicion de inicio del array
		}
		taxisArray		= colaAuxiliar;
		primeroDeLaCola	= 0;
		ultimoDeLaCola	= longitudCola-2;
		return taxiAdaptado;
	}
	
}
