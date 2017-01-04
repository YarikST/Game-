package ComponentGame;

/**
 * Created by 2 on 09.05.2016.
 */
public class Lay {
    private boolean up,dn,l, r;

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDn() {
        return dn;
    }

    public void setDn(boolean dn) {
        this.dn = dn;
    }

    public boolean isL() {
        return l;
    }

    public void setL(boolean l) {
        this.l = l;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }
}
