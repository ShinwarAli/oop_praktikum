package fabrikMethode;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeraemter.Buergeramt;


public class ConcreteCsvProduct extends Product {
	
    BufferedWriter aus ;

    
	public ConcreteCsvProduct() throws IOException {
		aus	= new BufferedWriter(new FileWriter("Buergeraemter.csv", true));

	}

	public void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException {
		aus.write(buergeramt.gibBuergeramtZurueck(';'));

	}
	
	
	

	public void schliessDatei() throws IOException {
		aus.close();
	}

}

