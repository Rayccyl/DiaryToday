package org.jufeimswz.diarytoday.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.jufeimswz.diarytoday.editor.EditorApp;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("Welcome to Login Application!");
        new EditorApp().start(new Stage());
    }
}