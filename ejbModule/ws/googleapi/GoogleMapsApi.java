package ws.googleapi;

public interface GoogleMapsApi {
	
	public int calularDistancia(String origem, String destino) throws Exception;
	public String buscaLatLongDoEndereco(String endereco);
}
