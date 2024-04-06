package view;
import model.*;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JTextArea textArea;
    private JButton openButton;
    private JButton saveButton;
    private JFileChooser fileChooser;

  public View() {
    frame = new JFrame("Text Editor");
    textArea = new JTextArea(30, 40);
   
    fileChooser = new JFileChooser();

    JPanel buttonPanel = new JPanel(); // Tạo một JPanel mới để chứa các nút
     openButton = new JButton("Open");
    saveButton = new JButton("Save");
    buttonPanel.add(openButton);
    buttonPanel.add(saveButton);

    frame.setLayout(new BorderLayout());
    frame.add(buttonPanel, BorderLayout.NORTH); // Thêm JPanel chứa các nút vào phía trên
    frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
    // Không cần phải thêm nút saveButton vào đây nữa vì nó đã được thêm vào buttonPanel

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
}


    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getOpenButton() {
        return openButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }
}
