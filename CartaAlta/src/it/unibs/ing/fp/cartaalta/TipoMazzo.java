package it.unibs.ing.fp.cartaalta;

public enum TipoMazzo 
{
	ITALIANO("ITALIANO", new String[]{"SPADE", "BASTONI", "COPPE", "DENARI"}, ValoreCarteItaliane.values()),
	FRANCESE("FRANCESE", new String[]{"CUORI", "QUADRI", "PICCHE", "FIORI"}, ValoreCarteFrancesi.values()); 
	
	private String nome;
	private String[] semi; 
	private ValoreCarta[] valori;
	
	private TipoMazzo(String nome, String[] semi, ValoreCarta[] valori) 
	{
		this.nome = nome;
		this.semi = semi;
		this.valori = valori;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String[] getSemi() 
	{
		return semi;
	}
	
	public void setSemi(String[] semi) 
	{
		this.semi = semi;
	}
	
	public ValoreCarta[] getValori() 
	{
		return valori;
	}
	
	public void setValori(ValoreCarta[] valori) 
	{
		this.valori = valori;
	} 
}
