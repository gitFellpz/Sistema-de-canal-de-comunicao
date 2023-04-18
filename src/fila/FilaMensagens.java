package fila;

import java.util.Arrays;
import entidades.Mensagem;

public class FilaMensagens {
	
	public final int N = 3;
	Mensagem filaMensagens[] = new Mensagem[N];
	int ini, fim, cont;
	
	public void init() {
		ini = fim = cont = 0;
	}
	
	public boolean isEmpty() {
		if(cont == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(cont == N)
			return true;
		else
			return false;
	}
	
	public void enqueue(Mensagem mensagem) {
		if(isFull())
			System.out.println("\nFila cheia!");
		else {
			filaMensagens[fim] = mensagem;
			fim = (fim+1) % N;
			cont++;
		}		
	}
	
	public Mensagem dequeue() {
		Mensagem elem = filaMensagens[ini];
		ini = (ini+1) % N;
		cont--;
		return elem;
	}

	@Override
	public String toString() {
		return "FilaMensagens [N=" + N + ", filaMensagens=" + Arrays.toString(filaMensagens) + ", ini=" + ini + ", fim="
				+ fim + ", cont=" + cont + "]";
	}

	

}
