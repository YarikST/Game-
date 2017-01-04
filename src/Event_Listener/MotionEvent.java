package Event_Listener;

/**
 * Created by 2 on 09.05.2016.
 */
public class MotionEvent {
    private int row1, collumn1,row2,getCollumn2;
    private  int size;

    public MotionEvent(int row1, int collumn1, int row2, int getCollumn2,int size) {
        this.row1 = row1;
        this.collumn1 = collumn1;
        this.row2 = row2;
        this.getCollumn2 = getCollumn2;
        this.size = size;
    }

    public MotionEvent() {
    }

    public int getX() {
        return row1 * size;
    }

    public int getY() {
        return collumn1 * size;
    }

    public int width() {
        return getX() + size;
    }

    public int heigth() {
        return getY() + size;
    }
}
