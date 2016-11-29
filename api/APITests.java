package api;

import static org.junit.Assert.*;

import javax.annotation.processing.SupportedAnnotationTypes;

import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidNumberOfSharesException;
import exceptions.InvalidStockException;
import gui.Frame;
import gui.IFrame;

public class APITests {
	private IModel model;
	public IFolio f;
	@Before
	public void setUp() {
		/* Create the Model*/
		model = new Model();
		f = new Folio(model);
		
		
	}
	
	
	// Below tests Model class directly
	
	@Test
	public void testModelCreateFolio() {
		model.createFolio("GGEztyyw");
		assertEquals(true, model.getLastFolio().equals("GGEztyyw"));  
	} 
	     
	@Test  
	public void testModelBuySharesTrue() {
		model.createFolio("xyz");  
		model.buyShares("xyz", "lloy.l", 5); 
		 
		assertEquals(5, model.getFolio("xyz").getShareAt("lloy.l").getNumShares());
		   
	}
	
	@Test
	public void testModelBuySharesFalse() {
		model.createFolio("xyz");  
		model.buyShares("xyz", "lloy.l", 5); 
		  
		assertNotEquals(model.getFolio("xyz").getShareAt("lloy.l").getNumShares(), 4 );
		   
	}
	  
	@Test
	public void testModelSellSharesTrue() {
		model.createFolio("xyz");
		model.buyShares("xyz", "lloy.l", 5);
		model.sellShares("xyz", "lloy.l", 4);
		assertEquals(1, model.getFolio("xyz").getShareAt("lloy.l").getNumShares());
	}  
	
	@Test  
	public void testModelSellSharesNotEnoughShares() throws InvalidNumberOfSharesException{
		model.createFolio("xyz");
		model.buyShares("xyz", "lloy.l", 5);
		model.sellShares("xyz", "lloy.l", 6);
	}
	 
	@Test  
	public void testModelSellSharesInvalidStock() throws InvalidStockException{
		model.createFolio("xyz");
		model.buyShares("xyz", "lloy.l", 5);
		model.sellShares("xyz", "fdafdasfd", 5);
	}
  
	@Test
	public void testGetLastFolio() {
		model.createFolio("GG"); 
		model.createFolio("ezpzy");    
		System.out.println(model.getLastFolio());
	}
	
	@Test
	public void testAddFolio() {
		IFolio f = new Folio(model);
		model.addFolio(f, "Aaron");
		assertEquals(f, model.getFolio("Aaron"));
	}

	@Test
	public void testRefresh() {
		model.createFolio("xyz");
		model.buyShares("xyz", "fb", 5);   
		Double oldShare = model.getFolio("xyz").getShareAt("fb").getPricePerShare();
		model.refresh("xyz");
		assertTrue(model.getFolio("xyz").getShareAt("fb").getPricePerShare() != oldShare);
	} 
	  
	@Test
	public void testGetFolioNames() {
		model.createFolio("xyz"); 
		model.createFolio("xyzz");
		assertTrue(model.getFolioNames().contains("xyz") && model.getFolioNames().contains("xyzz"));
	}
	
	@Test
	public void testDeleteFolio() {
		model.createFolio("xyz");
		model.deleteFolio("xyz");
		assertFalse(model.getFolioNames().contains("xyz"));
	}
	
	@Test
	public void testUpdateShare() {
		model.createFolio("xyz");
		model.buyShares("xyz", "fb", 5);   
		Double oldShare = model.getFolio("xyz").getShareAt("fb").getPricePerShare();
		model.updateShare("xyz", "fb", "fb");
		assertTrue(model.getFolio("xyz").getShareAt("fb").getPricePerShare() != oldShare);
	} 
	@Test
	public void testSetGetMessage() {
		model.setMessage("Aaron");
		assertTrue(model.getMessage().equals("Aaron"));
	}
	
	@Test
	public void testSetGetStatus() {
		model.setStatus("aaron");
		assertTrue(model.getStatus().equals("aaron"));
	}
	
	// Below tests Folio class directly
	@Test
	public void testAddGetShare() {
		f.addShare("fb", "facebook", 5);
		assertTrue(f.getShareAt("fb").getTickerSymbol().equals("fb"));
	}
	
	@Test
	public void testAddShareAlreadyContains() {
		f.addShare("fb", "facebook", 5);
		f.addShare("fb", "facebook", 5);
		assertEquals(10, f.getShareAt("fb").getNumShares());
	}
	@Test
	public void testAddShareInvalidTicker() {
		f.addShare("ffdjfjhdjfjfd", "aaron", 5);
		assertTrue(model.getStatus().equals("Error"));
	}
	
	@Test
	public void testRemoveShare() throws NullPointerException, InvalidNumberOfSharesException, InvalidStockException{
		f.addShare("fb", "fad", 5);
		f.removeShare("fb", 5);
		f.getShareAt("fb");
		
	} 
	
} 
