package ru.vsu.cs.rmv;

import UtilsSolomatin.JTableUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable table;
    private JButton buttonLoadInputFromFile;
    private JButton buttonCheckWinner;
    private JTextField textFieldInputAnswer;
    private JButton ClearTable;
    private JButton buttonSaveInputInfoFile;
    private JButton buttonRandomInput;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Task08");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(table, 40, true, true, true, true);
        this.setTitle("Task08");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        table.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        JMenu menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        UtilsSolomatin.SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(table, Utils.array20by20());

        this.pack();

        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[][] arr = Utils.readFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(table, arr);
                    }
                } catch (Exception err) {
                    UtilsSolomatin.SwingUtils.showErrorMessageBox(err);
                }
            }
        });



        buttonCheckWinner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[][] arr = UtilsSolomatin.JTableUtils.readStringMatrixFromJTable(table);
                    textFieldInputAnswer.setText(Solution.getWinner(arr));
                }
                catch (Exception err){
                    JOptionPane.showMessageDialog(null, "Некорректные данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        ClearTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JTableUtils.writeArrayToJTable(table, Utils.array20by20());
                }
                catch (Exception err){
                    JOptionPane.showMessageDialog(null, "Некорректные данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonSaveInputInfoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[][] arr = UtilsSolomatin.JTableUtils.readStringMatrixFromJTable(table);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        UtilsSolomatin.ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception err) {
                    UtilsSolomatin.SwingUtils.showErrorMessageBox(err);
                }
            }
        });
        buttonRandomInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] matrix = UtilsSolomatin.ArrayUtils.createRandomIntMatrix(
                            table.getRowCount(), table.getColumnCount(), 2);
                    String[][] matrix2 = new String[20][20];
                    for (int i = 0; i < 20; i++){
                        for(int j = 0; j < 20; j++){
                            if (matrix[i][j] == 1){
                                matrix2[i][j] = "X";
                            }
                            else{
                                matrix2[i][j] = "0";
                            }
                        }
                    }
                    JTableUtils.writeArrayToJTable(table, matrix2);
                } catch (Exception err) {
                    UtilsSolomatin.SwingUtils.showErrorMessageBox(err);
                }
            }
        });
    }


}
