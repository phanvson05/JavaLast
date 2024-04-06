package control;
import model.*;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import view.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;

public class Controller {
    private Model model;
    private View view;
    

    

    private void onSave(ActionEvent e) {
    int option = view.getFileChooser().showSaveDialog(view.getFrame());
    if (option == JFileChooser.APPROVE_OPTION) {
        Path selectedFile = view.getFileChooser().getSelectedFile().toPath();
        String textToSave = view.getTextArea().getText();
        
        try {
            model.setText(textToSave);
            model.saveToFile(selectedFile);
            view.showSaveSuccessMessage(selectedFile);
        } catch (IOException ex) {
            view.showSaveErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
    }
}

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        
      
        
        
        
        view.getSaveButton().addActionListener(this::onSave);
       view.getOpenButton().addActionListener(this::onOpen);
    }
private void onOpen(ActionEvent e) {
    int option = view.getFileChooser().showOpenDialog(view.getFrame());
    if (option == JFileChooser.APPROVE_OPTION) {
        try {
            model.loadFromFile(view.getFileChooser().getSelectedFile().toPath());
            view.getTextArea().setText(model.getText());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

    
}
