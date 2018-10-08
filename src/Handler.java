/* https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Future.html
 * 
 * */


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Handler {
	public static void main(String[] args) throws IOException {
//       String config = args[0];

//		String config = "{\"one\":[{\"host\":\"182.12.47.150\","
//				+ "    \"port\":\"4545\",\"serverName\":\"CONSOLIDADA_DES\","
//				+ "    \"dbName\":\"CONSOLIDADA\",\"conector\":\"SYB\"" + "  },{\"query\":\"SELECT 1 * from table\"}],"
//				+ "\"two\":[{\"host\":\"srvdbslis9-test\"," + "    \"port\":\"7427\","
//				+ "    \"dbName\":\"DWM\",\"conector\":\"MSSQL\"" + "  },{\"query\":\"SELECT 2 * from table\"}]}";

		JsonParser parser = new JsonParser();

		JsonObject elem = parser.parse(new FileReader(
                "D:\\Users\\maxxb\\eclipse-workspace\\JsonHandler\\jsonFiles\\parametros.json")).getAsJsonObject();
		
		List<DBConnector> conectores = new ArrayList<>();
		for (Entry<String, JsonElement> obj : elem.entrySet()) {
//			System.out.println(obj.getKey());
			JsonObject dbconn = obj.getValue().getAsJsonArray().get(0).getAsJsonObject();

			conectores.add(new DBConnector(dbconn.get("host").getAsString()
											, dbconn.get("port").getAsString()
											, dbconn.get("conector").getAsString()));
		}
		//System.out.println(conectores.get(1).conector);
		
		ExecutorService execute = Executors.newCachedThreadPool();
		
		Future <?> future = execute.submit(conectores.get(0));
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println(e);
		}
//
//		@SuppressWarnings("unchecked")
//		Future <DBConnector> promesa = exec.submit() ;
	}
}