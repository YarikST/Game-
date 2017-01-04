package ComponentGame;

import Event_Listener.MotionEvent;
import Event_Listener.MotionListener;
import MyClass.MotionException;

/**
 * Created by 2 on 09.05.2016.
 */
public interface ModelData {

     MatrixElementInterfase vauleAt(int row, int collumn);

    void addListener(MotionListener listener);

    void removeListener(MotionListener listener);

    void signal();

    int size();

    int getRow();

    int getCollumn();

    void motion(Motion motion) throws MotionException;
}
