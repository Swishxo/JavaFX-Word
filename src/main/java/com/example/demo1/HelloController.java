package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import   javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class HelloController implements Initializable {

    TreeMap<Integer, String> getWord;

    @FXML
    private TableColumn<Word, Integer> countColumn;

    @FXML
    private TableView<Word> tableView;

    @FXML
    private TableColumn<Word, String> wordColumn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wordColumn.setCellValueFactory(new PropertyValueFactory<>("wordDoc"));
        countColumn.setCellValueFactory(new PropertyValueFactory<>("numberDoc"));
        try {
            tableView.setItems(ob());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public ObservableList<Word> ob() throws FileNotFoundException {
        ObservableList<Word> anotherOb = FXCollections.observableArrayList();
        GetWord get = new GetWord();
        getWord = get.send();


        for(int index = 0; index < getWord.size(); index++){
            for (Integer x: getWord.keySet()) {
                anotherOb.add(new Word(getWord.get(x), x));
            }
        }
        return anotherOb;
    }


}