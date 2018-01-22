package ws.enums;

import ws.exceptions.MoedaException;

public enum EnumMoeda {

	BRL(1, "BRL"),
	USD(2, "USD"),
	EUR(3, "EUR");
	
	private int id;
	private String code;
	
	private EnumMoeda(int id, String code) {
		this.id = id;
		this.code = code;
	}
	
	public static EnumMoeda getById(int id) throws MoedaException{
		for (EnumMoeda f : EnumMoeda.values()) {
			if(f.getId() == id){
				return f;
			}
		}
		
		throw new MoedaException("Moeda escolhida não encontrada");
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
}
