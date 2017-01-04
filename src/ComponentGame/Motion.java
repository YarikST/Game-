package ComponentGame;

/**
 * Created by 2 on 09.05.2016.
 */
public class Motion {

    private  int x1,y1,x2, y2;
    private MatrixElement matrixElement;

    public Motion(int x1, int y1, int x2, int y2, MatrixElement matrixElement) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.matrixElement = matrixElement;
    }

    public Lay getLay() {

        Lay lay = new Lay();

        if ((x2 - x1) < (y2 - y1)) {
            lay.setDn(true);
            return lay;
        } else if ((x2 - x1) > (y2 - y1)) {
            lay.setL(true);
            return lay;
        } else if ((x1 - x2) < (y1 - y2)) {
            lay.setUp(true);
            return lay;
        }else {
            lay.setR(true);
            return lay;
        }

    }

    public boolean isLay() {
        Lay lay1 = matrixElement.getLay();
        Lay lay2 = getLay();
        boolean b = false;

        b = lay1.isDn() && lay2.isDn();
        if (b) return b;
        b = lay1.isUp() && lay2.isUp();
        if (b) return b;
        b = lay1.isL() && lay2.isL();
        if (b) return b;
        b = lay1.isR() && lay2.isR();
        return b;

            }

    public MatrixElementInterfase getElement() {
        return matrixElement;
    }
}
