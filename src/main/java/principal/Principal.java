package principal;


import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;


import dao.DemandaDao;
import dao.EnderecoDao;
import entidades.Demanda;
import entidades.Endereco;
import entidades.HibernateUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Principal extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {


		Pane p = new Pane();
		
		p.setPrefSize(700.0, 400.0);
		
		Label lblDoc = new Label("Documento");
		TextField tfDoc = new TextField("Memorando 10/20");
		Button btn = new Button("Salvar");
		
		
		lblDoc.setPrefSize(80.0, 30.0);
		lblDoc.setLayoutX(90.0);
		lblDoc.setLayoutY(52.0);
		
			tfDoc.setPrefSize(300.0, 30.0);
			tfDoc.setLayoutX(180.0);
			tfDoc.setLayoutY(52.0);
		
				btn.setPrefSize(100.0, 30.0);
				btn.setLayoutX(490.0);
				btn.setLayoutY(52.0);
				
				
				btn.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	
				    	
				    	HibernateUtil.setUserPass("somde078_adasaMy", "12345");
				    	
				    	Demanda dem = new Demanda(tfDoc.getText());
				    
				    	//List<Demanda> list = new ArrayList<Demanda>();
				    	
				    	//list.add(dem);
				    	
				     	Endereco end = new Endereco ("Rua dos Brejos");
				    	
					    	Point point = new GeometryFactory().createPoint(new Coordinate(26, 62));
						    	point.setSRID(4674);
					     
						    	end.setEndPoint(point);
				        	
				    	//end.setDemandas(list);
				    	
				    	dem.setDemEnderecoFK(end);
				    	
				    	//EnderecoDao endDao = new EnderecoDao ();
				    	
				    	//endDao.salvarEndereco(end);
				    	
				    	
				    	DemandaDao demDao =  new DemandaDao();
				    	
				    	demDao.salvarDemanda(dem);
				    	
				    	Alert alert;
				    	alert = new Alert(AlertType.INFORMATION);
				    		alert.setTitle("Informação");
				    			alert.setHeaderText("Endereço salvo");
				    				alert.setContentText("Parabéns");

				    	alert.showAndWait();
				    	
				    }
				});
		
		p.getChildren().addAll(lblDoc, tfDoc, btn);
		
		//Creating a scene object 
	      Scene scene = new Scene(p);  
	      
	      //Setting title to the Stage 
	      primaryStage.setTitle("Adasa conexao MySQL"); 
	         
	      //Adding scene to the stage 
	      primaryStage.setScene(scene); 
	          
	      //Displaying the contents of the stage 
	      primaryStage.show(); 
		
	}

}
