package ru.vsu.cs.Game;

import ru.vsu.cs.util.DrawUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;

import static ru.vsu.cs.Game.Game.*;
import static ru.vsu.cs.Game.GameParams.getSizeField;
import static ru.vsu.cs.util.JTableUtils.DEFAULT_GAP;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JTable tableGameField;
    private JPanel panelScore;
    private JLabel labelScore;
    private JButton buttonNewGame;
    private JLabel labelStatus;

    private static final int DEFAULT_CELL_SIZE = 90;
    private static final int DEFAULT_FIELD_SIZE = 4;

    private GameParams params = new GameParams(DEFAULT_FIELD_SIZE);
    private Game game = new Game();

    private ParamsDialog dialogParams;


    public MainForm() {
        this.setTitle("2048");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        //setJMenuBar(createMenuBar());

        this.pack();

        tableGameField.setRowHeight(DEFAULT_CELL_SIZE);
        JTableUtils.initJTableForArray(tableGameField, DEFAULT_CELL_SIZE, false, false, false, false);
        tableGameField.setIntercellSpacing(new Dimension(0, 0));
        tableGameField.setEnabled(false);


        tableGameField.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            final class DrawComponent extends Component {
                private int row = 0, column = 0;

                @Override
                public void paint(Graphics gr) {
                    Graphics2D g2d = (Graphics2D) gr;
                    int width = getWidth() - 2;
                    int height = getHeight() - 2;
                    paintCell(row, column, g2d, width, height);
                }
            }

            DrawComponent comp = new DrawComponent();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                comp.row = row;
                comp.column = column;
                return comp;
            }
        });


        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.newGame();
                JTableUtils.writeArrayToJTable(tableGameField, gameField);
                labelScore.setText(String.valueOf(0));
            }
        });

        dialogParams = new ParamsDialog(params, tableGameField, e -> newGame());

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                        Game.moveRight();
                        JTableUtils.writeArrayToJTable(tableGameField, gameField);
                        updateView();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_LEFT){
                        Game.moveLeft();
                        JTableUtils.writeArrayToJTable(tableGameField, gameField);
                        updateView();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_UP){
                        Game.moveUp();
                        JTableUtils.writeArrayToJTable(tableGameField, gameField);
                        updateView();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_DOWN){
                        Game.moveDown();
                        JTableUtils.writeArrayToJTable(tableGameField, gameField);
                        updateView();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_SPACE){
                        newGame();
                        JTableUtils.writeArrayToJTable(tableGameField, gameField);
                        updateView();
                    }
                    labelScore.setText(String.valueOf(score));
                    updateView();
                }
                win();
                gameOver();
                return false;
            }
        });

        labelScore.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }

//    private JMenuItem createMenuItem(String text, String shortcut, Character mnemonic, ActionListener listener) {
//        JMenuItem menuItem = new JMenuItem(text);
//        menuItem.addActionListener(listener);
//        if (shortcut != null) {
//            menuItem.setAccelerator(KeyStroke.getKeyStroke(shortcut.replace('+', ' ')));
//        }
//        if (mnemonic != null) {
//            menuItem.setMnemonic(mnemonic);
//        }
//        return menuItem;
//    }
//
//    private JMenuBar createMenuBar() {
//        JMenuBar menuBarMain = new JMenuBar();
//
//        JMenu menuGame = new JMenu("Игра");
//        menuBarMain.add(menuGame);
//
//        menuGame.add(createMenuItem("Параметры", "ctrl+P", null, e -> {
//            dialogParams.updateView();
//            dialogParams.setVisible(true);
//        }));
//        menuGame.addSeparator();
//        menuGame.add(createMenuItem("Выход", "ctrl+X", null, e -> {
//            System.exit(0);
//        }));
//
//        JMenu menuView = new JMenu("Вид");
//        menuBarMain.add(menuView);
//        menuView.add(createMenuItem("Подогнать размер окна", null, null, e -> {
//            updateWindowSize();
//        }));
//        menuView.addSeparator();
//        SwingUtils.initLookAndFeelMenu(menuView);
//
//        JMenu menuHelp = new JMenu("Справка");
//        menuBarMain.add(menuHelp);
//        menuHelp.add(createMenuItem("Правила", "ctrl+R", null, e -> {
//            SwingUtils.showInfoMessageBox("Здесь должно быть краткое описание правил ...", "Правила");
//        }));
//        menuHelp.add(createMenuItem("О программе", "ctrl+A", null, e -> {
//            SwingUtils.showInfoMessageBox(
//                    "Шаблон для создания игры" +
//                            "\n\nАвтор: Соломатин Д.И." +
//                            "\nE-mail: solomatin.cs.vsu.ru@gmail.com",
//                    "О программе"
//            );
//        }));
//        return menuBarMain;
//    }

    private void newGame() {
        JTableUtils.resizeJTable(tableGameField, getSizeField(), getSizeField(), 0, 0);
        updateView();
    }

    private void updateWindowSize() {
        int menuSize = this.getJMenuBar() != null ? this.getJMenuBar().getHeight() : 0;
        SwingUtils.setFixedSize(
                this,
                tableGameField.getWidth() + 2 * DEFAULT_GAP + 60,
                tableGameField.getHeight() + panelMain.getY() + labelStatus.getHeight() +
                        menuSize + 1 * DEFAULT_GAP + 2 * DEFAULT_GAP + 60
        );
        this.setMaximumSize(null);
        this.setMinimumSize(null);
    }
    private Font font = null;

    private Font getFont(int size) {
        if (font == null || font.getSize() != size) {
            font = new Font("Comic Sans MS", Font.BOLD, 25);
        }
        return font;
    }
    private void paintCell(int row, int column, Graphics2D g2d, int cellWidth, int cellHeight) {
        int cellValue = gameField[row][column];

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (cellValue <= 0) {
            return;
        }
        Color color = Color.lightGray;

        int size = Math.min(cellWidth, cellHeight);
        int bound = (int) Math.round(size * 0.05);

        if(cellValue == 2){
            g2d.setColor(Colors.getC2());
        }
        if(cellValue == 4){
            g2d.setColor(Colors.getC4());
        }
        if(cellValue == 8){
            g2d.setColor(Colors.getC8());
        }
        if(cellValue == 16){
            g2d.setColor(Colors.getC16());
        }
        if(cellValue == 32){
            g2d.setColor(Colors.getC32());
        }
        if(cellValue == 64){
            g2d.setColor(Colors.getC64());
        }
        if(cellValue == 128){
            g2d.setColor(Colors.getC128());
        }
        if(cellValue == 256){
            g2d.setColor(Colors.getC256());
        }
        if(cellValue == 512){
            g2d.setColor(Colors.getC512());
        }
        if(cellValue == 1024){
            g2d.setColor(Colors.getC1024());
        }
        if(cellValue == 2048){
            g2d.setColor(Colors.getC2048());
        }


        g2d.fillRoundRect(bound, bound, size - 2 * bound, size - 2 * bound, bound * 3, bound * 3);
        g2d.setColor(color);

        g2d.drawRoundRect(bound, bound, size - 2 * bound, size - 2 * bound, bound * 3, bound * 3);
        g2d.setFont(getFont(size - 2 * bound));

        g2d.setColor(DrawUtils.getContrastColor(color));
        DrawUtils.drawStringInCenter(g2d, font, "" + cellValue, 0, 0, cellWidth, (int) Math.round(cellHeight * 0.95));

    }

    private void updateView() {
        tableGameField.repaint();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}