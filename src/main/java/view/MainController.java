package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    
    @FXML
    private Button AddButton;
    
	public void setModel(AdderModel newModel)
	{
		model = newModel;
		
		
		StringConverter<Number> fmt = new CurrencyStringConverter();
	    
		//Integer fmt;
	    Bindings.bindBidirectional(answerLabel.textProperty(),
	       model.getAnswer(),fmt);
	     
	}
	
	public double getAmt()
	{
		String value1 = Num1TextField.textProperty().get();
		String value2 = Num2TextField.textProperty().get();
		double val1 = 0.0;
		double val2 = 0.0;
		
		try
		{
		val1 = Double.parseDouble(value1);
		val2 = Double.parseDouble(value2);
		}
		catch(NumberFormatException e)
		{
			Num1TextField.textProperty().set("");
			Num2TextField.textProperty().set("");
			return 0.0;
		}
		double amt = Double.sum(val1, val2);
		return amt;
		
	}

    @FXML
    void onAddButton(ActionEvent event) 
    {
    	double value = 0.0;
    	System.out.println("onAddButton");
    	//try {
    	value = getAmt();
    	/*
    	} catch(NumberFormatException e)
    	{
    		Num1TextField.textProperty().set("");
			Num2TextField.textProperty().set("");
    	}*/
    	model.add(value);
    	Num1TextField.textProperty().set("");
		Num2TextField.textProperty().set("");
    }

}
