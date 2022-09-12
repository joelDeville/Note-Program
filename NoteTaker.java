import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NoteTaker extends Application {
    // main runner method for GUI and user interaction
    @Override
    public void start(Stage stage) {
        // note display pane and entire window pane created
        VBox display = new VBox(5);
        VBox outline = new VBox();

        // ScrollPane created to accomodate more notes in the display
        // binds height of scroll to match window's current height
        // but also restricts so text entry is available at the bottom
        ScrollPane scroll = new ScrollPane(display);
        scroll.prefHeightProperty().bind(stage.heightProperty());
        scroll.setMaxHeight(600);

        // adding padding of elements within the screen
        display.setPadding(new Insets(10));
        outline.setPadding(new Insets(10));

        TextField input = new TextField();
        input.setPrefWidth(300);

        // controller for user hitting enter or return
        // adds user's input into display VBox and clears for next entry
        input.setOnAction((ActionEvent e) -> {
            display.getChildren().add(new Text(input.getText()));
            input.clear();
        });

        // adds scrollpane of notes and input field into general screen
        outline.getChildren().addAll(scroll, input);

        // sets initial size of screen and displays the application
        Scene scene = new Scene(outline, 600, 300);
        stage.setScene(scene);
        stage.setTitle("Notes");

        stage.show();
    }
}
