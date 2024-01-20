package org.jufeimswz.diarytoday.editor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class EditorController {
    @FXML public HTMLEditor editor;
    @FXML public Tab tab;
    @FXML public Button insertMedia;

    @FXML
    protected void imageInsert(){
        tab.setText("2024-01-18");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        String imagePath = selectedFile.toURI().toString();
        System.out.println(imagePath);
        int endIndex=editor.getHtmlText().lastIndexOf("</body></html>");
        StringBuilder modifiedHtml = new StringBuilder(editor.getHtmlText().substring(0, endIndex));
        modifiedHtml.append("<p><img src=\"" + imagePath + "\"   style=\"max-width:95%;\"></p>");
        modifiedHtml.append("</body></html>");
        editor.setHtmlText(modifiedHtml.toString());
    }
    @FXML
    protected void audioInsert() {
        tab.setText("2024-01-18");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Audio File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.mp3", "*.wav", "*.ogg")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            String audioPath = selectedFile.toURI().toString();
            System.out.println(audioPath);

            int endIndex = editor.getHtmlText().lastIndexOf("</body></html>");
            StringBuilder modifiedHtml = new StringBuilder(editor.getHtmlText().substring(0, endIndex));

            // 插入音频
            modifiedHtml.append("<p><audio controls=\"controls\"><source src=\"" + audioPath + "\" type=\"audio/mpeg\"></audio></p>");
            modifiedHtml.append("<p>音频"+selectedFile.toString()+"</p>");
            modifiedHtml.append("</body></html>");
            editor.setHtmlText(modifiedHtml.toString());
        }
    }
    @FXML
    public void codePrint(){
        System.out.println(editor.getHtmlText());
    }

    @FXML
    public void mediaInsert() {
        tab.setText("2024-01-18");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Video File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi", "*.mkv")
        );
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            String videoPath = selectedFile.toURI().toString();
            System.out.println(videoPath);

            int endIndex = editor.getHtmlText().lastIndexOf("</body></html>");
            StringBuilder modifiedHtml = new StringBuilder(editor.getHtmlText().substring(0, endIndex));
            modifiedHtml.append("<div style=\"text-align: center;\">");
            modifiedHtml.append("<p><video style=\"max-width:95%;\" controls>");
            modifiedHtml.append("<source src=\"" + videoPath + "\" type=\"video/mp4\">");
            modifiedHtml.append("</video></p>");
            modifiedHtml.append("<p>视频" + selectedFile.toString() + "</p></div>");
            modifiedHtml.append("</body></html>");

            editor.setHtmlText(modifiedHtml.toString());
        }
    }
}