package Signup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    @FXML
    TextField firstName;
    @FXML TextField lastName;
    @FXML TextField email;

    @FXML
    public void submit(ActionEvent event) {
        File file;
        FileWriter fileWriter;
        BufferedWriter bufferWriter;
        String line = String.format("%s,%s,%s\n", firstName.getText(), lastName.getText(), email.getText());
        try {
            file = new File("signups.csv");
            if(!file.exists())
                file.createNewFile();
            fileWriter = new FileWriter(file.getName(), true);
            bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(line);
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
