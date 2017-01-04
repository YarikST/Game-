package ComponentGame;

import MyClass.MotionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by 2 on 09.05.2016.
 */
public class MatrixElement extends JComponent implements  MatrixElementInterfase{

    private int rowIndex,collumnIndex;
    private int vaule;
    private Lay lay;
    private MatrixElement matrixElement;

    public MatrixElement(int rowIndex, int collumnIndex, int vaule) {
        this.rowIndex = rowIndex;
        this.collumnIndex = collumnIndex;
        this.vaule = vaule;
        matrixElement = this;

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    try {
                        MatrixModel.matrixModel.motion(new Motion(getX(), getY(), e.getX(), e.getY(), matrixElement));
                    } catch (MotionException e1) {
                        System.out.println("Ex");
                    }
                }
            });


    }

    @Override
    protected void paintComponent(Graphics g) {


        if(vaule==0)
        {
            g.setColor(Color.blue);
            g.fillRect(0, 0, sizeElement()-10, sizeElement()-10);
            g.setColor(Color.black);
            g.drawString(String.valueOf(vaule),sizeElement()/2-5,sizeElement()/2-5);
            return;

        }
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, sizeElement()-10, sizeElement()-10);


        g.setColor(Color.black);
        g.drawString(String.valueOf(vaule),sizeElement()/2-5,sizeElement()/2-5);

    }

    @Override
    public int getIndexRow() {
        return rowIndex;
    }

    @Override
    public int getCollumnIndex() {
        return collumnIndex;
    }

    @Override
    public Lay getLay() {
        return lay;
    }

    @Override
    public int sizeElement() {
        return 50;
    }

    @Override
    public int getVaule() {
        return vaule;
    }

    @Override
    public void setVaule(int vaule) {
        this.vaule = vaule;
    }

    @Override
    public void setLay(Lay lay) {
        this.lay = lay;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(sizeElement(), sizeElement());
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

}
