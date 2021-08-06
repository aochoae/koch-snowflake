package dev.luisalberto.kochsnowflake;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Application extends JFrame {

    private static void setLookAndFeelAndShow() {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Application application = new Application();
        application.setTitle("Koch snowflake");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(new KochSnowflake());
        application.setSize(1200, 720);
        application.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            SwingUtilities.invokeAndWait(Application::setLookAndFeelAndShow);
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
