import API.*;
import gui.*;

public class Main {

	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		IFrame f = new Frame("Folio Tracker");
		
		@SuppressWarnings("unused")
		IQuote quote = new Quote(true);
		/*
		 TO DO :
		 Probably have to look at the observer model (but might not need if we implement this right)
		 Fix table double click (remove double click on cell to be actually double click on rows that goes to editRow)
		 Implement Save
		 Implement Open
		 Fix AddTableRow
		 Implement TEMP (dont know what this is) button in the Header container
		 Implement Delete button in the Footer container
		 Connect the GUI with the API
		 */
	}
}
