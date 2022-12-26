package ru.vsu.cs.util;
import ru.vsu.cs.Game.GameParams;
import ru.vsu.cs.util.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ParamsDialog extends JDialog {
    private JPanel panelMain;
    private JSpinner spinnerSize;
    private JSlider sliderCellSize;
    private JButton buttonCancel;
    private JButton buttonOk;
    private JButton buttonNewGame;



    private GameParams params;
    private JTable gameFieldJTable;
    private ActionListener newGameAction;

    private int oldCellSize;


    public ParamsDialog(GameParams params, JTable gameFieldJTable, ActionListener newGameAction) {
        this.setTitle("Параметры");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();

        this.setResizable(false);

        this.params = params;
        this.gameFieldJTable = gameFieldJTable;
        this.newGameAction = newGameAction;

        this.oldCellSize = gameFieldJTable.getRowHeight();
        sliderCellSize.addChangeListener(e -> {
            int value = sliderCellSize.getValue();
            JTableUtils.resizeJTableCells(gameFieldJTable, value, value);
        });
        buttonCancel.addActionListener(e -> {
            JTableUtils.resizeJTableCells(gameFieldJTable, oldCellSize, oldCellSize);
            this.setVisible(false);
        });

        buttonNewGame.addActionListener(e -> {
            buttonOk.doClick();
            if (newGameAction != null) {
                newGameAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "newGame"));
            }
        });

        buttonOk.addActionListener(e -> {
            params.setSizeField((int) spinnerSize.getValue());
            oldCellSize = gameFieldJTable.getRowHeight();
            this.setVisible(false);
        });
    }

    public void updateView() {
        spinnerSize.setValue(GameParams.getSizeField());
        sliderCellSize.setValue(gameFieldJTable.getRowHeight());
    }


}
