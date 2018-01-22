package ws.googleapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import org.json.JSONArray;
import org.json.JSONObject;

@Stateless(mappedName="ejb/GoogleMapsApiImpl")
public class GoogleMapsApiImpl implements GoogleMapsApiRemote, GoogleMapsApiLocal{

	private static final String URL = "https://maps.googleapis.com/maps/api/";
	private static String DIRECTIONS_SERVICE = "directions/json?origin=%s&destination=%s&key=AIzaSyA6HXqk8Q0lCKUYKXwFyQyWpH-FPNbLYmo";
	private static String GEOCODE_SERVICE = "geocode/json?address=%s&key=AIzaSyB2VjFQcx9rycNZ4uYtUVbaniFyVNNQRYE";
	private final static String USER_AGENT = "Mozilla/5.0";
	
	private Map<String, Map<String, String>> originsDestinations = new HashMap<String, Map<String, String>>();
	
	@Override
	public int calularDistancia(String origin, String destino) throws Exception {
		
		String response = getDistancia(origin, destino);
		
		JSONObject jsonObject = new JSONObject(response);
		JSONArray routes = jsonObject.getJSONArray("routes");
		JSONObject objRoute = routes.getJSONObject(0);
		JSONArray legs = objRoute.getJSONArray("legs");
		JSONObject objLegs = legs.getJSONObject(0);
		JSONObject distance = objLegs.getJSONObject("distance");
		System.out.println();
		return distance.getInt("value") / 1000;
	}
	
	@Override
	public String buscaLatLongDoEndereco(String endereco) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getDistancia(String origin, String destino) throws Exception{
		String url = String.format(URL.concat(DIRECTIONS_SERVICE), origin, destino).replaceAll(",", "").replaceAll(" ", "+").replace("\\s","");
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("GET");
		
//		con.setRequestProperty("User-Agent", USER_AGENT);
		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String inputLine;
		
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		in.close();
		
		return response.toString();
	}

}
