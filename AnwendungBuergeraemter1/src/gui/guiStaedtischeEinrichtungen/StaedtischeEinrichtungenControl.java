package gui.guiStaedtischeEinrichtungen;

import java.io.IOException;

import business.Buergeraemter.BuergeraemterModel;
import business.Sporthalle.SporthallenModel;
import javafx.stage.Stage;
import ownUtil.MyObserver;

public class StaedtischeEinrichtungenControl implements MyObserver {
	
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	private BuergeraemterModel buergeraemterModel;
	private SporthallenModel sporthallenModel;
	

	public StaedtischeEinrichtungenControl(Stage primaryStage){
		this.buergeraemterModel = BuergeraemterModel.getInstanz();
		sporthallenModel=SporthallenModel.getInstance();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(this, primaryStage,buergeraemterModel, sporthallenModel);
		buergeraemterModel.addObserver(this);
	}

	
	public void leseSporthallenAusCsv()  {
		

		try {
			sporthallenModel.leseSporthallenAusCsvDatei();
		} catch (IOException e) {
			
			staedtischeEinrichtungenView.zeigeInformationsfensterAn("Fehler beim lesen aus der CSV Datei");		
			}
	}

	
	@Override
	public void update() {
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();
		
	}
}
	
	
