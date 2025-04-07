package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class AdderModel
{
	DoubleProperty answer = new SimpleDoubleProperty();
	DoubleProperty num1 = new SimpleDoubleProperty();
	DoubleProperty num2 = new SimpleDoubleProperty();
	
	public AdderModel()
	{
		
	}
	
	public DoubleProperty getNum1()
	{
		return num1;
	 }
	 
	public DoubleProperty getNum2()
	 {
	   return num2;
	 }
	
	public DoubleProperty getAnswer()
	 {
	   return answer;
	 }
	
	public void add(DoubleProperty num1, DoubleProperty num2)
	 {
	   answer.set(num1.get()+ num2.get()); 
	 }

}
