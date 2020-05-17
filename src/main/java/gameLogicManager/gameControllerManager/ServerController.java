package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.StructureType;
import gameLogicManager.gameModel.gameBoard.Terrain;
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
import java.util.ArrayList;

public class ServerController {
    //static String restURI="http://localhost:5000/";
    private static String restURI="http://ymacit-001-site1.ctempurl.com/cs319/";
    public static void main(String[] args) throws IOException, JSONException {
        //GetBoard();
        TransformTerrain(TerrainType.Forest, 0);
        //GetChanges(1);
        //TransformTerrain(TerrainType.FOREST, 3, 3);
        ConstructBuilding(StructureType.TradingHouse, 0);
        //GetChanges(1);
        ArrayList<Terrain> ters1 = GetBoard();
        // These will give NULLPOINTEREXCEPTION if the structure on the terrain is empty
        for (int i = 0; i < ters1.size(); i++)
        {
            System.out.println(ters1.get(i).getType() + " " + ters1.get(i).getStructure());
        }
        GetPlayers();
        System.out.println(Login("Efe", "5"));
        /**TransformTerrain(TerrainType.Plains, 0, 4);
        for (int i = 0; i < ters1.size(); i++)
        {
            //System.out.println(ters1.get(i).getType() + " - " + ters1.get(i).getStructure().getStructureType());
        }*/
        // System.out.println(tmp_json);
    }
    public static ArrayList<Terrain> GetBoard(){
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(restURI+"game/Board");
            HttpResponse response = client.execute(request);
            String tmp_json= IOUtils.toString(response.getEntity().getContent(),  StandardCharsets.UTF_8);
            JSONObject myObj = new JSONObject(tmp_json);
            JSONArray arr = myObj.getJSONArray("cells");
            ArrayList<Terrain> terrainList = new ArrayList<Terrain>();
            for (int i = 0; i < arr.length(); i++)
            {
                    String terrainName = arr.getJSONObject(i).getString("type");
                    TerrainType terrainType = TerrainType.valueOf(terrainName);

                    String structureName = arr.getJSONObject(i).getString("structure");

                    StructureType structureType = StructureType.valueOf(structureName);

                    Terrain terrain = new Terrain(i, terrainType, structureType);
                    terrainList.add(terrain);
            }
            return terrainList;
            } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
            return null;
        }

    public static void GetChanges(int lastSequence) throws IOException, JSONException {
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
    public static void TransformTerrain(TerrainType terrainType, int x)
    {
        //HttpClient httpClient = HttpClientBuilder.create().build();
        HttpClient client = new DefaultHttpClient();
        try {

            HttpPost request = new HttpPost(restURI+"game/TransformTerrain");

            String tmp_params="{\n" +
                    "  \"sequence\": 1,\n" +
                    "  \"playerName\": \"testName\",\n" +
                    "  \"terrainPosition\": " + x +  ",\n" +
                    "  \"type\": \"" +  terrainType.toString() +  "\",\n" +
                    "  \"structure\": \"dwelling\"\n" +
                    "}";
            StringEntity params =new StringEntity(tmp_params,
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

    public static void ConstructBuilding(StructureType inputStruct,int x)
    {
        HttpClient client = new DefaultHttpClient();
        try {

            HttpPost request = new HttpPost(restURI+"game/ConstructBuilding");
            String tmp= inputStruct.toString();
            StringEntity params =new StringEntity("{\n" +
                    "  \"sequence\": 1,\n" +
                    "  \"playerName\": \"testName\",\n" +
                    "  \"terrainPosition\": " + x +  ",\n" +
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
    static void GetPlayers () throws IOException, JSONException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(restURI+"player/PlayerList");
        HttpResponse response = client.execute(request);
        String tmp_json= IOUtils.toString(response.getEntity().getContent(),  StandardCharsets.UTF_8);
        JSONArray myArr = new JSONArray(tmp_json);
        System.out.println(tmp_json);
        System.out.println( "***** Player List *****");
        for (int i = 0; i < myArr.length(); i++)
        {
            System.out.println( myArr.getString(i));
        }
    }
    static boolean Login( String playerName, String password)
    {
        boolean retval=false;

        HttpClient client = new DefaultHttpClient();
        try {

            HttpPost request = new HttpPost(restURI+"player/Login");

            StringEntity params =new StringEntity("{\n" +
                    "  \"name\": \"" + playerName + "\",\n" +
                    "  \"password\": \"" + password + "\"\n" +
                    "}",
                    "application/json",
                    "UTF-8");
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = client.execute(request);
            int tmp_statusCode=response.getStatusLine().getStatusCode();
            //
            System.out.println("status: " + response.getStatusLine().getStatusCode());
            //
            if(tmp_statusCode==200) {
                String tmp_json = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
                JSONObject myObj = new JSONObject(tmp_json);
                System.out.println("***** Login Result *****");
                retval=myObj.getBoolean("result");
            }

            //handle response here...

        }catch (Exception ex) {
            System.out.println(ex.toString());
            //handle exception here

        } finally {
            //Deprecated
            //httpClient.getConnectionManager().shutdown();
        }
        return retval;
    }

}
