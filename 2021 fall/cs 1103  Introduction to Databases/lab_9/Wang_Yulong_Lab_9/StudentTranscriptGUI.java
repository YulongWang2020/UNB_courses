import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class StudentTranscriptGUI extends Application {

	private TextField nameField;
	private Text response;

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Check Student Transcript");

		Label nameLabel = new Label("Id:");

		nameField = new TextField();
		nameField.setPrefWidth(150);
		nameField.setMaxWidth(300);

		Pattern pattern = Pattern.compile("\\d*|\\d+\\,\\d*");

		Button accept = new Button("Check");
		accept.setOnAction(this::processAcceptStudent);
		Button quit = new Button("Quit");
		quit.setOnAction(this::quitApp);

		response = new Text("");

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		// Row 1: Buttons
		grid.add(accept, 0, 0);
		grid.add(quit, 2, 0);
		//Row 2: name
		grid.add(nameLabel, 0, 1);
		grid.add(nameField, 1, 1);
		//Row 3: response
		grid.add(response, 0, 2, 2, 4);


		Scene scene = new Scene(grid, 300, 200);

		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public void processAcceptStudent(ActionEvent event) {

		StudentTranscript acceptStudent = new StudentTranscript();
		String[] args = {nameField.getText()};
		try{
			String res = acceptStudent.execute(args);
			response.setText(res);
			response.setFill(Color.GREEN);
		}catch (SQLException e){
			response.setText(e.getMessage());
			response.setFill(Color.RED);
		}
	}

	public void quitApp(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
}
