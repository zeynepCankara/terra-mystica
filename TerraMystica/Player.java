package TerraMystica;
import java.util.*;

public class Player {
	//Variables
	private String faction;
	private HashMap<Structure,Integer> availableStructures;
	private HashMap<Structure,Integer> structesBuilt;
	private ArrayList<Terrain> ownedTerrains;
	private int score;
	private int coins;
	private int numOfPriests;
	private int numOfWorkers;
	private HashMap<Integer,Integer> powerBowlDistribution;
	private ArrayList<Terrain> adjacencyList;
	private int shipping;
	private int spadeRate;
	private int numOfTownKeys;
	public boolean transformTerrain(int Terrain)
	{
		return true;
	}
	public boolean build(int Terrain)
	{
		return true;
	}
	public boolean improveShipping()
	{
		return true;
	}
	public boolean improveTerraforming()
	{
		return true;
	}
	public boolean upgradeStructure(int Structure)
	{
		return true;
	}
	public boolean sendPriestToCult(int cultID)
	{
		return true;
	}
	public boolean usePowerAction(int powerActionID)
	{
		return true;
	}
	public boolean powerBowlConvert()
	{
		return true;
	}
	public boolean useSpecialAction(int specialActionID)
	{
		return true;
	}
	public void pass()
	{
		
	}
	public void getResources()
	{
		
	}

}	
