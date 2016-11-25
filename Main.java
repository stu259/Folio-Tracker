import gui.IFrame;
import api.Model;
import api.IModel;
import gui.Frame;

public class Main {

	public static void main(String[] args){
		
		
		/* Create the Model*/
		Model model = new Model();
		
		
		/*Create View of the model*/
		Frame f = new Frame("Folio Tracker", model);
		
		
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
