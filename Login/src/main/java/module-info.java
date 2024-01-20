module org.jufeimswz.diarytoday.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jufeimswz.diarytoday.editor;

    opens org.jufeimswz.diarytoday.login to javafx.fxml;
    exports org.jufeimswz.diarytoday.login;
}