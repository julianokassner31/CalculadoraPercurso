package ws.enums;

import ws.exceptions.PagamentoException;

public enum EnumFormaPagamento {

	DINHEIRO(1, "DH"),
	CARTAO_DEBITO(2, "CB"),
	CARTAO_CREDITO(3,"CD");
	
	private int id;
	private String code;
	
	private EnumFormaPagamento(int id, String code) {
		this.id = id;
		this.code = code;
	}
	
	public static EnumFormaPagamento getById(int id) throws PagamentoException{
		for (EnumFormaPagamento f : EnumFormaPagamento.values()) {
			if(f.getId() == id){
				return f;
			}
		}
		
		throw new PagamentoException("Forma de pagamento escolhida não encontrada");
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
}
