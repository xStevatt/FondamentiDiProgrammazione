package it.unibs.ing.fp.lab.TamaZoo;

public class Tamagotchi 
{
	protected static final int MAX_SAZIETA = 100;
	protected static final int MIN_SAZIETA = 0;
	protected static final int MAX_AFFETTO = 100;
	protected static final int MIN_AFFETTO = 0;
	protected static final double PERCENTUALE_DECREMENTO_BISCOTTI = 0.5;
	protected static final double PERCENTUALE_INCREMENTO_CAREZZE = 1;
	protected static final double PERCENTUALE_DECREMENTO_AFFETTO = 0.25;
	protected static final double PERCENTUALE_INCREMENTO_BISCOTTI = 0.1;
	
	protected String nome; 
	protected double soddisfazione_affettiva; 
	protected double grado_saziet�; 
	
	public Tamagotchi(String nome, double soddisfazione_affettiva, double grado_saziet�) throws IllegalArgumentException
	{
		if(soddisfazione_affettiva < 0 || grado_saziet� < 0)
		{
			throw new IllegalArgumentException("ERRORE - Numero minore di zero inserito."); 
		}
		
		this.nome = nome; 
		this.soddisfazione_affettiva = soddisfazione_affettiva; 
		this.grado_saziet� = grado_saziet�; 	
	}
	
	public Tamagotchi(String nome, int grado_saziet�)
	{
		this.nome = nome; 
		this.grado_saziet� = grado_saziet�; 
	}
	
	public boolean sonoMorto()
	{
		return soddisfazione_affettiva == 0 || grado_saziet� == 0 || grado_saziet� > 90; 
	}
	
	public boolean sonoTriste()
	{
		return soddisfazione_affettiva < 30 || grado_saziet� < 30 || grado_saziet� > 90; 
	}
	
	public void riceviBiscotti(int biscotti)
	{
		double incremento_saziet� = PERCENTUALE_INCREMENTO_BISCOTTI * grado_saziet� * biscotti; 
		grado_saziet� += incremento_saziet�; 
		
		double decremento_affetto = PERCENTUALE_DECREMENTO_AFFETTO * biscotti; 
		soddisfazione_affettiva -= decremento_affetto; 
	}
	
	public void riceviCarezze(int carezze)
	{
		double incremento_affetto = PERCENTUALE_INCREMENTO_CAREZZE * carezze; 
		soddisfazione_affettiva += incremento_affetto; 
		
		double decremento_saziet� = PERCENTUALE_DECREMENTO_BISCOTTI * carezze; 
		grado_saziet� -= decremento_saziet�; 
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public double getSoddisfazione_affettiva() 
	{
		return soddisfazione_affettiva;
	}

	public void setSoddisfazione_affettiva(double soddisfazione_affettiva) 
	{
		this.soddisfazione_affettiva = Math.min(MAX_AFFETTO, soddisfazione_affettiva);
	}

	public double getGrado_saziet�() 
	{
		return grado_saziet�;
	}

	public void setGrado_saziet�(double grado_saziet�) 
	{
		this.grado_saziet� = Math.min(MAX_SAZIETA, grado_saziet�);
	}
}
