package ws.validacao.cartaocredito.service.impl;

import ws.validacao.cartaocredito.service.CCChecker;
import ws.validacao.cartaocredito.service.CCCheckerSoap;

public class ValidarCartaoCreditoServiceImpl {

	public static void main(String[] args) {
		CCChecker service = new CCChecker();
		CCCheckerSoap ccchecker = service.getCCCheckerSoap();
		String validateCardNumber = ccchecker.validateCardNumber("VISA","4485347124918");
		System.out.println(validateCardNumber);

	}

}
