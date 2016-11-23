package api;

import java.util.HashMap;
import java.util.Map;

public class Model implements IModel{
	Map<String,IFolio> folios;
	
	public Model(){
		folios = new HashMap<String,IFolio>();
		
	}
	
	
}
