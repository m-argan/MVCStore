package view;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

//import org.assertj.core.api.Assertions;
import javafx.application.Application;

import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.AdderModel;
import view.MainController;

@ExtendWith(ApplicationExtension.class)
public class TestAdder
{

	@Start  //Before
	  private void start(Stage stage)
	  {
	    
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(main.MVCMain.class.getResource("../view/MainView.fxml"));
	    try {
	      Scene s = new Scene(loader.load());
	      MainController cont = loader.getController();
		  cont.setModel(new AdderModel());
	      
	     
	      stage.setScene(s);
	      stage.show();
	    
	      
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
	
	private void enterAmt(FxRobot robot, String amt1, String amt2)
	  {
	    robot.clickOn("#Num1TextField");
	    robot.write(amt1);
	    robot.clickOn("#Num2TextField");
	    robot.write(amt2);
	    robot.clickOn("#AddButton");
	  }
	  
	  private void checkBalance(FxRobot robot,String bal)
	  {
	    Assertions.assertThat(robot.lookup("#answerLabel")
	        .queryAs(Label.class)).hasText(bal);    
	  }
	  
	  private void checkAdder(FxRobot robot, String num1, String num2, String ans)
	  {
	    enterAmt(robot,num1,num2);
	    //robot.clickOn("#AddButton");
	    checkBalance(robot,ans);
	  }

	  @Test
	  public void testAdds(FxRobot robot)
	  {
		
	    checkAdder(robot,"1","2","3");
	    checkAdder(robot,"10","2","12");
	    checkAdder(robot, "two", "one", "0");
	    
	    
	  }

}