import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;

import javafx.geometry.Insets;

public class noteTaker extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{
		//VBoxes created along with a scroll pane for inputs
		VBox display = new VBox(5);
		VBox outline = new VBox();
		
		ScrollPane scroll = new ScrollPane(display);
		scroll.prefHeightProperty().bind(stage.heightProperty());
		scroll.setMaxHeight(600);
		
		//padding is set
		display.setPadding(new Insets(10));
		outline.setPadding(new Insets(10));
		
		TextField input = new TextField();
		input.setPrefWidth(300);
		
		//after hitting enter, input is shown above
		input.setOnAction((ActionEvent e) ->
		{
			display.getChildren().add(new Text(input.getText()));
			input.clear();
		});
		
		//adds all nodes then displays
		outline.getChildren().addAll(scroll, input);
		
		Scene scene = new Scene(outline, 600, 300);
		stage.setScene(scene);
		stage.setTitle("Notes");
		
		stage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}