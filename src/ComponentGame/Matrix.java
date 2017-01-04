package ComponentGame;

import Event_Listener.MotionEvent;
import Event_Listener.MotionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 2 on 09.05.2016.
 */
public class Matrix extends JPanel implements MotionListener{

    private ModelData modelData = new MatrixModel();

    public Matrix() {
        setLayout(new GridLayout(modelData.getRow(),modelData.getCollumn()));

        modelData.addListener(this);

        for (int i = 0; i < modelData.getRow(); i++) {
            for (int j = 0; j < modelData.getCollumn(); j++) {
                add((JComponent)modelData.vauleAt(i, j));
            }
        }

    }

    @Override
    public void action(MotionEvent event) {
        repaint();
    }
}
