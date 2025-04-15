package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AdderModel;
import view.MainController;
//import models.AdderModel;

public class MVCMain extends Application
{

	public MVCMain()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		AdderModel model = new AdderModel();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MVCMain.class.getResource("../view/MainView.fxml"));
		BorderPane view = loader.load();
		
		MainController cont = loader.getController();
		cont.setModel(model);
		
		
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
		
		//AdderModel model = new AdderModel();

	}
	
	public static void main(String [] args)
	{
		launch(args);
	}

}
