package ws.cotacaomoeda.service.impl;

import javax.ejb.Stateless;

import ws.cotacaomoeda.service.Currency;
import ws.cotacaomoeda.service.CurrencyConvertor;
import ws.cotacaomoeda.service.CurrencyConvertorSoap;

@Stateless(mappedName="ejb/CotarMoedaServiceImpl")
public class CotarMoedaServiceImpl implements CotarMoedaServiceRemote, CotarMoedaServiceLocal{

	@Override
	public double cotar(Currency moeda) {
		CurrencyConvertor service = new CurrencyConvertor();
		CurrencyConvertorSoap convertor = service.getCurrencyConvertorSoap();
		return convertor.conversionRate(Currency.BRL, Currency.USD);

	}
	
	public static void main(String[] args) {
		CurrencyConvertor service = new CurrencyConvertor();
		CurrencyConvertorSoap convertor = service.getCurrencyConvertorSoap();
		System.out.println(convertor.conversionRate(Currency.BRL, Currency.BRL));
	}
	
}
