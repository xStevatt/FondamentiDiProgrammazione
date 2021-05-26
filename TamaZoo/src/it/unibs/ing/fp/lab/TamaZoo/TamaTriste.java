package it.unibs.ing.fp.lab.TamaZoo;

public class TamaTriste extends Tamagotchi
{
	public TamaTriste(String nome, int grado_saziet�)
	{
		super(nome, grado_saziet�);
		this.soddisfazione_affettiva = MIN_AFFETTO; 
	}
	
	@Override
	public void riceviBiscotti(int biscotti)
	{
		super.riceviBiscotti(biscotti);
		soddisfazione_affettiva = 0; 
	}
	
	@Override
	public void riceviCarezze(int carezze)
	{
		super.riceviCarezze(carezze);
		soddisfazione_affettiva = 0; 
	}
	
	@Override
	public boolean sonoMorto()
	{
		return grado_saziet� == 0 || grado_saziet� > 90; 
	}
	
	@Override
	public boolean sonoTriste()
	{
		return true; 
	}
}
