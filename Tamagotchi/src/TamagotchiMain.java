import java.util.Random; 

public class TamagotchiMain 
{
	private static final String INSERISCI_IL_NOME_DEL_TAMAGOTCHI = "Inserisci il nome del tamagotchi: ";
	private static final String TAMAGOTCHI_MORTE = "Tamagotchi � morto. RIP Tama.";
	private static final String TAMAGOTCHI_�_INFELICE = "Tamagotchi � infelice";
	private static final String GRADO_SAZIET� = "Grado Saziet�: ";
	private static final String SODDISFAZIONE_AFFETTIVA = "Soddisfazione affettiva: ";
	private static final String TAMAGOTCHI_�_FELICE = "Tamagotchi � felice";
	private static final String INSERIRE_IL_GRADO_DI_SAZIET�_INIZIALE = "Inserire il grado di saziet� iniziale: ";
	private static final String INSERIRE_IL_GRADO_DI_SODDISFAZIONE_AFFETTIVA_INIZIALE = "Inserire il grado di soddisfazione affettiva iniziale: ";
	private static String MESSAGGIO_INIZIALE = "Benvenuto nell'applicazione Tamagotchi. Qui puoi gestire il tuo tamagotchi."; 
	private static String MESSAGGIO_MENU = "0. Esci dal programma\n"
										 + "1. Dai biscotti\n"	
										 + "2. Dai carezze\n"
										 + "La tua scelta: "; 
	
	private static final int GRADO_SAZIETA_MASSIMO_INIZIALE = 100;
	private static final int GRADO_SAZIETA_MINIMO_INIZIALE = 0;
	private static final int SODDISFAZIONE_AFFETTIVA_MASSIMA_INIZIALE = 100;
	private static final int SODDISFAZIONE_AFFETTIVA_MINIMA_INIZIALE = 0;
	
	private static final int MIN_BISCOTTI = 1;
	private static final int MIN_CAREZZE = 1;
	private static final int MAX_CAREZZE = 20;
	private static final int MAX_BISCOTTI = 20;
	
	private static final int CHIUDI_PROGRAMMA = 0; 
	private static final int DAI_BISCOTTI = 1; 
	private static final int DAI_CAREZZE = 2;
	

	public static void main(String[] args) 
	{
		mostraMenu();
	}
	
	public static void mostraMenu()
	{
		int scelta; 
		Tamagotchi tamagotchi = creaTamagotchi(); 
		Random random = new Random(); 
		
		do
		{
			scelta = InputDati.inputInteger(MESSAGGIO_MENU, 0, 2); // 0 -> scelta minima possibile | 2 -> scelta massima possibile
			
			switch(scelta)
			{
				case DAI_BISCOTTI: 
					tamagotchi.daiBiscotto(random.nextInt(MAX_BISCOTTI) + MIN_BISCOTTI);
					break; 
				case DAI_CAREZZE: 
					tamagotchi.daiCarezze(random.nextInt(MAX_CAREZZE) + MIN_CAREZZE);
					break;
				case CHIUDI_PROGRAMMA: 
					System.out.println("Mancherai al tuo tamagotchi!");
			}
			
			if(tamagotchi.isAlive() && scelta != 0)
			{
				if(tamagotchi.isFelice())
				{
					System.out.println(TAMAGOTCHI_�_FELICE);
					System.out.println(SODDISFAZIONE_AFFETTIVA + tamagotchi.getSodd_affettiva());
					System.out.println(GRADO_SAZIET� + tamagotchi.getGrado_sazieta());
				}
				else
				{
					System.out.println(TAMAGOTCHI_�_INFELICE);
					System.out.println(SODDISFAZIONE_AFFETTIVA + tamagotchi.getSodd_affettiva());
					System.out.println(GRADO_SAZIET� + tamagotchi.getGrado_sazieta());
				}
			}
			if(!tamagotchi.isAlive() && scelta != 0)
			{
				System.out.println(TAMAGOTCHI_MORTE);
			}
		}
		while(scelta != 0 && tamagotchi.isAlive()); 
	}
	
	public static Tamagotchi creaTamagotchi()
	{
		String nome = InputDati.inputString(INSERISCI_IL_NOME_DEL_TAMAGOTCHI); 
		int sodd_aff_ini = InputDati.inputInteger(INSERIRE_IL_GRADO_DI_SODDISFAZIONE_AFFETTIVA_INIZIALE, SODDISFAZIONE_AFFETTIVA_MINIMA_INIZIALE, SODDISFAZIONE_AFFETTIVA_MASSIMA_INIZIALE); 
		int grad_saz_ini = InputDati.inputInteger(INSERIRE_IL_GRADO_DI_SAZIET�_INIZIALE, GRADO_SAZIETA_MINIMO_INIZIALE, GRADO_SAZIETA_MASSIMO_INIZIALE); 
		
		Tamagotchi tamagotchi = new Tamagotchi(sodd_aff_ini, grad_saz_ini, nome); 

		return tamagotchi; 
	}
}
