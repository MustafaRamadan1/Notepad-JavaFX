

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Dialog;


import java.awt.*;
import java.io.File;


public class Main extends Application {

        public void start (Stage s1) {
            // Menu bar
            MenuBar bar = new MenuBar();
            // Menus of our program
            Menu file = new Menu("File");
            Menu edit = new Menu("Edit");
            Menu help = new Menu("Help");
            // Menu1 items
            MenuItem n = new MenuItem("New");
            MenuItem open = new MenuItem("Open");
            MenuItem save = new MenuItem("Save");
            MenuItem exit = new MenuItem("Exit");
            SeparatorMenuItem sep1 = new SeparatorMenuItem();
            n.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));

            // Menu2 items
            MenuItem undo = new MenuItem("Undo");
            MenuItem cut = new MenuItem("Cut");
            MenuItem copy = new MenuItem("Copy");
            MenuItem paste = new MenuItem("Paste");
            MenuItem delete = new MenuItem("Delete");
            MenuItem selectAll = new MenuItem("Select All");
            SeparatorMenuItem sep2 = new SeparatorMenuItem();

            selectAll.setAccelerator(KeyCombination.keyCombination("Ctrl+a"));
            //  Menu3 items
            MenuItem about = new MenuItem("About Notepad");
            //putting items on menus
            file.getItems().addAll(n, open, save, exit);
            file.getItems().add(3, sep1);
            edit.getItems().addAll(undo, cut, copy, paste, selectAll);
            edit.getItems().add(4, sep2);

            help.getItems().addAll(about);
            // add menus on bar
            bar.getMenus().addAll(file, edit, help);
            // our text in the bottom for test
            TextArea Area = new TextArea();

            // we declare borderpane to put our node in someplace of the program
           // newfile eventhandling
            EventHandler<ActionEvent> newFile = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Area.setText("");
                }
            };
            n.setOnAction(newFile);
            // open file event handling
            EventHandler<ActionEvent> openFile = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser file = new FileChooser();
                    file.setTitle("Open File");
                    file.showOpenDialog(s1);
                }
            };
            open.setOnAction(openFile);
            EventHandler<ActionEvent> saveFile = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser file = new FileChooser();
                    file.setTitle("Save File ");
                    File file1 = file.showSaveDialog(s1);
                    System.out.println(file1);

                }
            };
            save.setOnAction(saveFile);

            EventHandler<ActionEvent> exitFile = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Platform.exit();

                }
            };
            exit.setOnAction(exitFile);
            EventHandler<ActionEvent> aboutPart = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Dialog<String> d1 = new Dialog<String>();
                    d1.setTitle("About Mustafa's Notepad");
                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    d1.setContentText("This is my Notepad you're welcome to use it ");
                    d1.getDialogPane().getButtonTypes().add(type);
                    d1.show();



                }
            };
            about.setOnAction(aboutPart);
            BorderPane pane1 = new BorderPane();
            // bar will be on top
            pane1.setTop(bar);
            // text will be on the bottom
            pane1.setCenter(Area);

            Scene s = new Scene(pane1, 500, 600);
            s1.setScene(s);
            s1.setTitle("NotePad");
            s1.show();
        }

    public static void main(String[] args) {
        Application.launch(args);
    }
}