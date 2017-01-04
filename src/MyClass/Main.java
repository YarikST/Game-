package MyClass;

import ComponentGame.Matrix;
import ComponentGame.MatrixElement;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 2 on 09.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add ( new Matrix());
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(200, 200, 0, 0);
        jFrame.pack();
        jFrame.setVisible(true);

    }
}
