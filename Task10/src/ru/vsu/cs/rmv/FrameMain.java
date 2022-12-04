package ru.vsu.cs.rmv;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import UtilsSolomatin.JTableUtils;
import UtilsSolomatin.SwingUtils;

public class FrameMain extends JFrame{
    private JPanel panelMain;
    private JTable tableInput;
    private JTextField textFieldPointAverage;
    private JTextField textFieldMinAmountStudents;
    private JTable tableOutput;
    private JButton buttonGetResult;
    private JButton buttonOpenFromFile;
    private JPanel jPanelWithButton;
    private JPanel jPanelWithTextField;
    private JScrollPane jScrollPanelOutput;
    private JScrollPane jScrollPanelInput;

    public FrameMain() {
        this.setTitle("Task10");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        this.pack();


        JTableUtils.initJTableForArray(tableInput, 100, true, true, true, false);
        JTableUtils.initJTableForArray(tableOutput, 200, true, true, false, false);
        tableInput.getColumnModel().getColumn( 0 ).setWidth( 350 );
        this.pack();
        tableInput.setRowHeight(30);
        tableOutput.setRowHeight(30);

        JFileChooser fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        JMenu menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("View");
        menuBarMain.add(menuLookAndFeel);
        UtilsSolomatin.SwingUtils.initLookAndFeelMenu(menuLookAndFeel);
        JTableUtils.writeArrayToJTable(tableInput, new String[][]{
                {"Соломатин Дмитрий Ивановивич", "М", "1", "2.4"},
                {"Толкачев Аким Владимирович", "М", "2", "2.1"},
                {"Лобода Александр Васильевич", "М", "4", "2.2"},
                {"Каверина Валерия Константиновна", "Ж", "3", "4.0"},
                {"Вахитова Екатерина Васильевна", "Ж", "4", "4.5"}
        });



        buttonOpenFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[][] arr = JTableUtils.readStringMatrixFromJTable(tableInput);
                        int studentsAmount = arr.length;
                        ArrayList<ArrayList<String>> lists = Utils.readFromFile(fileChooserOpen.getSelectedFile().getPath(),studentsAmount );

                        arr = Utils.listToArray(lists);

                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception err) {
                    SwingUtils.showErrorMessageBox(err);
                }
            }
        });

        buttonGetResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[][] arr = JTableUtils.readStringMatrixFromJTable(tableInput);

                    assert arr != null;
                    ArrayList<ArrayList<String>> lists = Utils.arrayToList(arr);
                    double fieldPointAverage = 0;
                    int minAmountStudents = 0;

                    try{
                        fieldPointAverage = Double.parseDouble(textFieldPointAverage.getText());
                    }
                    catch (Exception err){
                        fieldPointAverage = 0;
                    }

                    try{
                        minAmountStudents = Integer.parseInt(textFieldMinAmountStudents.getText());
                    }
                    catch (Exception err){
                        minAmountStudents = 0;
                    }



                    String[][] arr2 = Utils.listToArray(Solution.getListsResult(lists, fieldPointAverage, minAmountStudents));

                    JTableUtils.writeArrayToJTable(tableOutput, arr2);
                } catch (Exception err) {
                    SwingUtils.showErrorMessageBox(err);
                }
            }
        });
    }
}
