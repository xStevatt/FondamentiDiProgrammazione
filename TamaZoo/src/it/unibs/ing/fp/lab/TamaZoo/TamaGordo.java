package it.unibs.ing.fp.lab.TamaZoo;

public class TamaGordo extends Tamagotchi
{
	protected static final int DECREMENTO_TAMAGORDO = 2;

	public TamaGordo(String nome, int grado_saziet�)
	{
		super(nome, grado_saziet�); 
		soddisfazione_affettiva = MAX_AFFETTO; 
	}
	
	public boolean sonoMorto()
	{
		return grado_saziet� == 0; 
	}
	
	public boolean sonoTriste()
	{
		return grado_saziet� < 30; 
	}
	
	@Override
	public void riceviBiscotti(int biscotti)
	{
		double incremento_saziet� = PERCENTUALE_INCREMENTO_BISCOTTI * grado_saziet� * biscotti; 
		grado_saziet� += incremento_saziet�; 
	}
	
	@Override 
	public void riceviCarezze(int carezze)
	{
		double decremento_saziet� = PERCENTUALE_DECREMENTO_BISCOTTI * carezze * DECREMENTO_TAMAGORDO; 
		grado_saziet� -= decremento_saziet�; 
	}
}
