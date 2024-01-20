module org.jufeimswz.diarytoday.editor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens org.jufeimswz.diarytoday.editor to javafx.fxml;
    exports org.jufeimswz.diarytoday.editor;
}