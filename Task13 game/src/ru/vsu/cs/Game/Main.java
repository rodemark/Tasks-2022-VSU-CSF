package ru.vsu.cs.Game;

import ru.vsu.cs.util.SwingUtils;

import java.util.Locale;

public class Main {
    public static void winMain() throws Exception { // запуск приложения
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("", 25);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainForm().setVisible(true));
        }

    public static void main(String[] args) throws Exception {
        winMain();
    }
}
