package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.TerrainType;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ServerController {
    //static String restURI="http://localhost:5000/";
    static String restURI="http://ymacit-001-site1.ctempurl.com/cs319/";
    public static void main(String[] args) throws IOException, JSONException {
        //GetBoard();
        TransformTerrain(TerrainType.FOREST, 0, 4);
        //GetChanges(1);
        //TransformTerrain(TerrainType.FOREST, 3, 3);
        ConstructBuilding(StructureType.TRADINGHOUSE,  0,2);
        //GetChanges(1);
        GetBoard();
        // System.out.println(tmp_json);
    }
    static void GetBoard() throws IOException, JSONException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(restURI+"game/Board");
        HttpResponse response = client.execute(request);
        String tmp_json= IOUtils.toString(response.getEntity().getContent(),  StandardCharsets.UTF_8);
        JSONObject myObj = new JSONObject(tmp_json);
        JSONArray arr = myObj.getJSONArray("cells");

        for (int i = 0; i < arr.length(); i++)
        {
            System.out.println( "row " + i);
            JSONArray arr2 = arr.getJSONArray(i);
            for (int j = 0; j < arr2.length(); j++)
            {
                System.out.print( arr2.getJSONObject(j).getString("type"));
                System.out.println("- "+ arr2.getJSONObject(j).getString("structure"));

            }
        }
    }
    static void GetChanges(int lastSequence) throws IOException, JSONException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(restURI+"game/Changes/"+ lastSequence);
        HttpResponse response = client.execute(request);
        String tmp_json= IOUtils.toString(response.getEntity().getContent(),  StandardCharsets.UTF_8);
        JSONArray myArr = new JSONArray(tmp_json);
        System.out.println(tmp_json);
        for (int i = 0; i < myArr.length(); i++)
        {
            JSONObject myObj = myArr.getJSONObject(i);
            System.out.println( myObj.getInt("sequence"));
            System.out.println( myObj.getString("playerName"));
            System.out.println( myObj.getJSONObject("terrainPosition").getInt("x"));
            System.out.println( myObj.getJSONObject("terrainPosition").getInt("y"));
        }
    }
    static void TransformTerrain(TerrainType terrainType, int x,  int y)
    {
        //HttpClient httpClient = HttpClientBuilder.create().build();
        HttpClient client = new DefaultHttpClient();
        try {

            HttpPost request = new HttpPost(restURI+"game/TransformTerrain");

            StringEntity params =new StringEntity("{\n" +
                    "  \"sequence\": 0,\n" +
                    "  \"playerName\": \"testName\",\n" +
                    "  \"terrainPosition\": {\n" +
                    "  \"x\":" + x + ",\n" +
                    "  \"y\":" + y  + "\n" +
                    "  },\n" +
                    "  \"type\": \"" +  terrainType.toString() +  "\",\n" +
                    "  \"structure\": \"dwelling\"\n" +
                    "}",
                    "application/json",
                    "UTF-8");
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = client.execute(request);
            System.out.println("status: " + response.getStatusLine().getStatusCode());


            //handle response here...

        }catch (Exception ex) {
            System.out.println(ex.toString());
            //handle exception here

        } finally {
            //Deprecated
            //httpClient.getConnectionManager().shutdown();
        }

        /*
         HttpPost request = new HttpPost("http://yoururl");
        StringEntity params = new StringEntity(json.toString());
        request.addHeader("content-type", "application/json");
        request.setEntity(params);
        httpClient.execute(request);
         */
    }

    static void ConstructBuilding(StructureType inputStruct,int x , int y)
    {
        HttpClient client = new DefaultHttpClient();
        try {

            HttpPost request = new HttpPost(restURI+"game/ConstructBuilding");
            String tmp= inputStruct.toString();
            StringEntity params =new StringEntity("{\n" +
                    "  \"sequence\": 1,\n" +
                    "  \"playerName\": \"testName\",\n" +
                    "  \"terrainPosition\": {\n" +
                    "  \"x\":" + x + ",\n" +
                    "  \"y\":" + y  + "\n" +
                    "  },\n" +
                    "  \"type\": \"Forest\",\n" +
                    "  \"structure\": \"" + inputStruct.toString() + "\"\n" +
                    "}",
                    "application/json",
                    "UTF-8");
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = client.execute(request);
            System.out.println("status: " + response.getStatusLine().getStatusCode());
            System.out.println(params.toString());
            //handle response here...

        }catch (Exception ex) {
            System.out.println(ex.toString());
            //handle exception here

        } finally {
            //Deprecated
            //httpClient.getConnectionManager().shutdown();
        }

        /*
         HttpPost request = new HttpPost("http://yoururl");
        StringEntity params = new StringEntity(json.toString());
        request.addHeader("content-type", "application/json");
        request.setEntity(params);
        httpClient.execute(request);
         */
    }

}
