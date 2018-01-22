package ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ws.cotacaomoeda.service.Currency;
import ws.cotacaomoeda.service.impl.CotarMoedaServiceLocal;
import ws.enums.EnumMoeda;
import ws.googleapi.GoogleMapsApiLocal;

@WebService
@Stateless(mappedName="ejb/CalculadoraPercursoImpl")
public class CalculadoraPercursoImpl implements CalculadoraPercursoRemote, CalculadoraPercursoLocal{

//	private static final Logger logger = LogManager.getLogger(CalculadoraPercursoImpl.class);
	
	@EJB
	GoogleMapsApiLocal googleApiLocal;
	@EJB
	CotarMoedaServiceLocal cotarMoedaServiceLocal;
	
	@WebMethod(operationName="calculaValorTotalDoPercurso")
	public double CalculaValorTotalDoPercurso(String origem, String destino, int idMoeda) throws Exception{
		
		double litroCombustivel = 3.59;//valor em BRL
		double valorMoedaBase = 0.0;
		
//		logger.info("Iniciando calculo da distancia na API do GOOGLE");
		
		int distancia = googleApiLocal.calularDistancia(origem, destino);
		
//		logger.info("Finalizado calculo da distancia distancia total = "+distancia);
		
		EnumMoeda moeda = EnumMoeda.getById(idMoeda);
		
//		logger.info("Moeda escolhida para cotação é "+moeda.getCode());
		if(!moeda.getCode().equals(EnumMoeda.BRL.getCode())){
//			logger.info("Iniciando cotação da moeda...");
			valorMoedaBase = cotarMoedaServiceLocal.cotar(Currency.fromValue(moeda.getCode()));
			return (distancia * litroCombustivel) / valorMoedaBase;
		}
		 
		return distancia * litroCombustivel;
	}

}
