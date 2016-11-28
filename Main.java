import gui.IFrame;
import api.Model;
import gui.Frame;
import api.IModel;

public class Main {

	public static void main(String[] args){
		
		
		/* Create the Model*/
		IModel model = new Model();
		
		
		/*Create View of the model*/
		IFrame f = new Frame("Folio Tracker", model);
		
		
		/*
		 TO DO :
		
		 Implement Save
		 Implement Open
		 
		 Implement Delete button in the Footer container
		 Connect the GUI with the API
		 Add observer Model
		 Add refresh
		 */
	}
}
