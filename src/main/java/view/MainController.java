package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.AdderModel;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import javafx.util.converter.CurrencyStringConverter;

public class MainController
{

	AdderModel model;

    @FXML
    private Label answerLabel;
    
    @FXML
    private TextField Num1TextField;
    
    @FXML
    private TextField Num2TextField;
    
	public void setModel(AdderModel newModel)
	{
		model = newModel;
		
		StringConverter<Number> fmt = new CurrencyStringConverter();
	    
	    
	    Bindings.bindBidirectional(answerLabel.textProperty(),
	       model.getAnswer(),fmt);
	}
	
	public double getAmt()
	{
		String value1 = Num1TextField.textProperty().get();
		String value2 = Num2TextField.textProperty().get();
		
		double val1 = Double.parseDouble(value1);
		double val2 = Double.parseDouble(value2);
		
		double amt = Double.sum(val1, val2);
		return amt;
	}

    @FXML
    void onAddButton(ActionEvent event) 
    {
    	System.out.println("onAddButton");
    	double value = getAmt();
    	model.add(value);
    }

}
