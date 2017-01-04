package ComponentGame;

import Event_Listener.MotionEvent;
import Event_Listener.MotionListener;
import MyClass.MotionException;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Created by 2 on 09.05.2016.
 */
public class MatrixModel implements  ModelData {
    private LinkedHashSet<MotionListener> setListener = new LinkedHashSet<>();
    private MatrixElementInterfase mas[][];

    public static MatrixModel matrixModel;

    public MatrixModel() {
        matrixModel = this;
        mas = new MatrixElementInterfase[getRow()][getCollumn()];

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        Random random = new Random();

        while (set.size() != size()) {
            set.add(random.nextInt(size()));
        }

        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getCollumn(); j++) {
                mas[i][j] = new MatrixElement(i, j, iterator.next());
            }
        }

        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getCollumn(); j++) {
                mas[i][j].setLay(newLay(i, j));
            }
        }

    }


    protected Lay newLay(int row, int collumn) {

        Lay lay = new Lay();

        int rowI = 0;
        int collumnI = 0;
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getCollumn(); j++) {
                if (mas[i][j].getVaule() == 0) {
                    rowI = i;
                    collumnI = j;
                }
            }
        }

        if (((rowI) != 0)) {
            lay.setR(true);
        } if (((rowI) != getRow()-1)) {
            lay.setL(true);
        }
        if (((collumn) != getCollumn()-1)) {
            lay.setUp(true);
        }

        if (((collumn) != 0)) {
            lay.setDn(true);
        }



        return lay;
    }

    @Override
    public MatrixElementInterfase vauleAt(int row, int collumn) {
        return mas[row][collumn];
    }

    @Override
    public void addListener(MotionListener listener) {

        setListener.add(listener);
    }

    @Override
    public void removeListener(MotionListener listener) {
        setListener.remove(listener);
    }

    @Override
    public void signal() {

        for (MotionListener listener:setListener
             ) {
            listener.action(new MotionEvent());

        }

        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getCollumn(); j++) {
           mas[i][j].setLay( newLay(i, j));
            }
        }
    }

    @Override
    public int size() {
        return 9;
    }

    @Override
    public int getRow() {
        return 3;
    }

    @Override
    public int getCollumn() {
        return 3;
    }

    @Override
    public void motion(Motion motion) throws MotionException {
        int row = motion.getElement().getIndexRow();
        int collumn = motion.getElement().getCollumnIndex();

        System.out.println("A"+row + " " + collumn);
        Lay lay = motion.getLay();

        if (lay.isL()) {
            if (row <= getRow()-2) {

                int vaule = mas[row + 1][collumn].getVaule();
                mas[row + 1][collumn].setVaule(mas[row][collumn].getVaule());
                mas[row][collumn].setVaule(vaule);
                signal();
                return;
            }else throw new MotionException();
        }

        if (lay.isR()) {
            if (row >= 1) {

                int vaule = mas[row - 1][collumn].getVaule();
                mas[row - 1][collumn].setVaule(mas[row][collumn].getVaule());
                mas[row][collumn].setVaule(vaule);
                signal();
                return;
            }else throw new MotionException();
        }


        if (lay.isUp()) {
            if (collumn >= 1) {
                int vaule = mas[row][collumn - 1].getVaule();
                mas[row][collumn - 1].setVaule(mas[row][collumn].getVaule());
                mas[row][collumn].setVaule(vaule);
                signal();
                return;
            }else throw new MotionException();}


            if (lay.isDn()) {
                if (collumn <= getCollumn()-2) {
                    int vaule = mas[row][collumn + 1].getVaule();
                    mas[row][collumn + 1].setVaule(mas[row][collumn].getVaule());
                    mas[row][collumn].setVaule(vaule);
                    signal();
                    return;
                } else throw new MotionException();}


        }
}
