package it.unibs.ing.fp.lab.TamaZoo;

/**
 * Tamagotchi
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
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
	
	/**
	 * Metodo che ritorna false se il tamagotchi � vivo, altrimenti ritorna true se
	 * � morto. Un tamagotchi si considera morto se il suo grado di soddisfazione o 
	 * il grado di saziet� diventano uguali a zero. Inoltre un tamagotchi muore se il grado 
	 * saziet� raggiunge un valore maggiore di 90. 
	 * 
	 * @return boolean - false se � il tamagotchi � morto, altrimenti true
	 */
	public boolean sonoMorto()
	{
		return soddisfazione_affettiva == 0 || grado_saziet� == 0 || grado_saziet� > 90; 
	}
	
	/**
	 * Metodo che ritorna se il tamagotchi � triste o felice. Il metodo ritorna true se il 
	 * tamagotchi � triste, altrimenti false se � felice. Un tamagotchi si considera triste 
	 * se il il grado di saziet� � minore di 30 e/o il grado di soddifsazione affettiva � 
	 * minore di 30 e/o il grado di saziet� supera 90. 
	 * 
	 * @return boolean - true se il tamagotchi � triste, altrimenti false
	 */
	public boolean sonoTriste()
	{
		return soddisfazione_affettiva < 30 || grado_saziet� < 30 || grado_saziet� > 90; 
	}
	
	/**
	 * Metodo che permette di interagire con il tamagotchi dandongli un certo numero di biscotti.
	 * Il numero di biscotti viene passato come paramentro. Per ogni biscotto il grado di saziet� 
	 * aumenta del 10 percento, mentre la soddisfazione affettiva diminuisce di un quarto del 
	 * numero dei biscotti. 
	 * 
	 * @param biscotti - il numero di biscotti viene passato come parametro del metodo
	 */
	public void riceviBiscotti(int biscotti)
	{
		double incremento_saziet� = PERCENTUALE_INCREMENTO_BISCOTTI * grado_saziet� * biscotti; 
		grado_saziet� += incremento_saziet�; 
		grado_saziet� = Math.min(100, grado_saziet�); 
		
		double decremento_affetto = PERCENTUALE_DECREMENTO_AFFETTO * biscotti; 
		soddisfazione_affettiva -= decremento_affetto; 
		soddisfazione_affettiva = Math.max(0, soddisfazione_affettiva); 
	}
	
	/**
	 * Metodo che permette di interagire con il tamagotchi dandogli un certo numero di carezze,
	 * che vengono passate come input. La soddisfazione affettiva aumenta del numero di carezze 
	 * che vengono passate. Il grado di saziet� diminuisce della met� del numero delle carezze 
	 * che vengono date al tamagotchi.
	 * 
	 * @param carezze - il numero di carezze viene passato come parametro del metodo
	 */
	public void riceviCarezze(int carezze)
	{
		double incremento_affetto = PERCENTUALE_INCREMENTO_CAREZZE * carezze; 
		soddisfazione_affettiva += incremento_affetto; 
		soddisfazione_affettiva = Math.min(100, soddisfazione_affettiva); 
		
		double decremento_saziet� = PERCENTUALE_DECREMENTO_BISCOTTI * carezze; 
		grado_saziet� -= decremento_saziet�; 
		grado_saziet� = Math.max(0, grado_saziet�);
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
