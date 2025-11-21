package Esame.Agenda;

import Tutorato.App;

/**
 * Rappresenta un agenda, contenente al suo interno un array di Appuntamenti. Gli appuntamenti vengono memorizzati in
 * ordine crescente
 * @see  Esame.Agenda.Appuntamento#Appuntamento
 */
public class Agenda {
	private Appuntamento[] appointments;
	private int currentAppointments;

	public Agenda(int n){
		if(n < 0) throw new RuntimeException("Il numero di appuntamenti non è valido");
		this.appointments = new Appuntamento[n];
		this.currentAppointments = 0;
	}

	public int numeroAppuntamenti() {
		return this.currentAppointments;
	}

	/**
	 * Aggiunge un appunmento all'agenda. Il metodo non effettua nessun inserimento se l'agenda risulta piena, se
	 * l'appuntamento è null o se è già presente un altro appuntamento nell'ora e nel giorno indicati. L'agenda mantiene
	 * l'ordine cronologico dopo che l'appuntamento è stato aggiunto.
	 * @param a appuntamento da aggiungere
	 * @return true se l'appuntamento viene aggiunto con successo, false altrimenti
	 */
	public boolean aggiungi(Appuntamento a){
		if(
			a == null ||
			this.numeroAppuntamenti() == this.getMaxAppointment() ||
			this.isOccupied(a.getGiorno(), a.getOra())
		){
			return false;
		}
		this.appointments[this.currentAppointments++] = a;
		this.orderAgenda();
		return true;
	}

	/**
	 * Rimuove un appuntamento dall'agenda, se i è un indice valido. L'agenda mantiene l'ordine cronologico dopo
	 * la rimozione
	 * @param i indice da rimuovere
	 * @return true se l'appuntamento è stato rimosso, false altrimenti
	 */
	public boolean disdetta(int i){
		if(i < 0 || i >= this.currentAppointments) return false;

		for(int j = i; j < this.currentAppointments - 1; j++){
			this.appointments[j] = this.appointments[j + 1];
		}
		return true;
	}

	public Appuntamento appuntamento(int i){
		return i > 0 && i < this.numeroAppuntamenti() ? this.appointments[i] : null;
	}

	/**
	 * Ordina gli appuntamenti dell'agenda seguendo l'ordine cronologico
	 */
	private void orderAgenda() {
		//ordiniamo utilizzando l'insertion sort
		Appuntamento[] sorted = new Appuntamento[this.getMaxAppointment()];
		for(int i = 0; i < sorted.length; i++){
			int j = this.findIndex(sorted, this.appointments[i], i);
			this.insertInIndex(sorted, this.appointments[i], i);
		}
		this.appointments = sorted;
	}

	private int findIndex(Appuntamento[] sorted, Appuntamento appointment, int i) {
		for(int j = 0; j < i; j++){
			if(sorted[i].isNext(appointment)) return j;
		}
		return i;
	}

	private void insertInIndex(Appuntamento[] sorted, Appuntamento appointment, int i) {
		for(int j = 0; j < sorted.length; j++){
			Appuntamento tmp = sorted[j];
			sorted[j] = appointment;
			appointment = tmp;
		}
	}

	/**
	 * Controlla se esiste un appuntamento nel giorno e nell'ora passati come parametro
	 * @param giorno giorno da controllare
	 * @param ora ora da controllare
	 * @return true se esiste un appuntamento che soddisfa i requisiti, false altrimenti
	 */
	private boolean isOccupied(int giorno, int ora) {
		Appuntamento toSearch = new Appuntamento("search", giorno, ora);
		for(int i = 0; i < this.numeroAppuntamenti(); i++){
			/*
			essendo appointments ordinato in maniera crescente, sono sicuro che se sto controllando un appuntamento
			con giorno maggiore o con stesso ora e giorno maggiore, allora non esiste un appuntamento che soddisfa
			la richiesta
			 */
			if(this.appointments[i].getGiorno() == giorno && this.appointments[i].getOra() == ora) return true;
			if(this.appointments[i].isNext(toSearch)) return false;
		}
		//se esco dal ciclo vuol dire che non ho trovato nessun appuntamento che soddisfa la richiesta
		return false;
	}

	private int getMaxAppointment() {
		return this.appointments.length;
	}
}
