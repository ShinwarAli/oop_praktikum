package business.Buergeraemter;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import fabrikMethode.ConcreteCreatorTxt;
import fabrikMethode.ConcreteCsvCreator;
import fabrikMethode.Creator;
import fabrikMethode.Product;
import ownUtil.MyObservable;
import ownUtil.MyObserver;

public class BuergeraemterModel implements MyObservable{
 	
	LinkedList<MyObserver> liste = new LinkedList<MyObserver>();
	
	private ArrayList<Buergeramt> buergeraemterList = new ArrayList<Buergeramt>();
	
	public static BuergeraemterModel instanz=null;
	
	public static BuergeraemterModel getInstanz() {
		if(instanz == null) {
			instanz = new BuergeraemterModel();
		}
		return instanz;
	}
	
	
	public ArrayList<Buergeramt> getBuergeraemterList() {
		return buergeraemterList;
	}


	


	private BuergeraemterModel () {
		
	}
	
	private Buergeramt buergeramt;

	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	
	  public void addBuergeramt(Buergeramt buergeramt) {
	        buergeraemterList.add(buergeramt);
	        notifyObserver();
	    }
 		
	public void schreibeBuergeraemterInCsvDatei()
	    throws IOException{
		Creator creator =new ConcreteCsvCreator();
		Product writer = creator.factoryMethod();
		for (Buergeramt buergeramt : buergeraemterList) {
	        writer.fuegeInDateiHinzu(buergeramt);
	    }
	 
		
		
		writer.schliessDatei();

 	}
	public void schreibeBuergeraemterInTxtDatei()throws IOException{
		Creator creator =new ConcreteCreatorTxt();
		Product writer = creator.factoryMethod();
		for (Buergeramt buergeramt : buergeraemterList) {
	        writer.fuegeInDateiHinzu(buergeramt);
	    }
		
		writer.schliessDatei();
	}



	public void addObserver(MyObserver obs) {
		liste.add(obs);
		
	}



	public void removeObserver(MyObserver obs) {
		liste.remove(obs);
		
	}


	@Override
	public void notifyObserver() {
		for(MyObserver o:liste) {
			o.update();
		}
		
	}


	

}

