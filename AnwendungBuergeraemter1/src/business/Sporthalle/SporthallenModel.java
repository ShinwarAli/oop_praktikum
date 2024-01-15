package business.Sporthalle;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import ownUtil.MyObservable;
import ownUtil.MyObserver;



public class SporthallenModel implements MyObservable{
	
	private static SporthallenModel instance;
	private ArrayList<Sporthalle> sporthallen = new ArrayList<Sporthalle>();
	private ArrayList <MyObserver> observers = new ArrayList<MyObserver>();
	BufferedWriter aus;
	
	public static SporthallenModel getInstance() {
		if(instance == null) {
			instance = new SporthallenModel();
		}
		return instance;
	}
	public void leseSporthallenAusCsvDatei()
			throws IOException{
			BufferedReader ein = new BufferedReader(
		 		new FileReader("Sporthallen.csv"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
		           ergebnis.add( 
					new Sporthalle(zeile[0], zeile[1], zeile[2]));
		           zeileStr = ein.readLine();
			}    
		 	ein.close();
		 	this.sporthallen = ergebnis;
		}
	
	
			


	
	private SporthallenModel() {
		super();
	}
	public ArrayList<Sporthalle> getSporthallen() {
		return sporthallen;
	}

	@Override
	public void addObserver(MyObserver obs) {
		// TODO Auto-generated method stub
		observers.add(obs);	

		
	}

	@Override
	public void removeObserver(MyObserver obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);

		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub

		for (MyObserver obs : observers) {
            obs.update();
		}

	}
	
}