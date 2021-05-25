package it.unibs.ing.fp.lab.TamaZoo;

public class TamaTriste extends Tamagotchi
{
	public TamaTriste(String nome, int grado_saziet�)
	{
		super(nome, grado_saziet�);
		this.soddisfazione_affettiva = MIN_AFFETTO; 
	}
	
	public boolean sonoMorto()
	{
		return grado_saziet� == 0 || grado_saziet� > 90; 
	}
	
	public boolean sonoTriste()
	{
		return true; 
	}
}
