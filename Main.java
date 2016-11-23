import gui.IFrame;
import api.Model;
import api.IModel;
import gui.Frame;

public class Main {

	public static void main(String[] args){
		
		
		IModel model = new Model();
		// UNCOMMENT EVERYWHERE IN THE CODE WHERE THIS IS PASSED :)
		
		@SuppressWarnings("unused")
		IFrame f = new Frame("Folio Tracker", model);
		
		
		/*
		 TO DO :
		 Probably have to look at the observer model (but might not need if we implement this right)
		
		 Implement Save
		 Implement Open
		 
		 Implement Delete button in the Footer container
		 Connect the GUI with the API
		 Add observer Model
		 Add refresh
		 */
	}
}
