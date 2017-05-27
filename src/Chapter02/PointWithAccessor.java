/**
 * An <code>Point</code> class with accessor methods
 * 
 * @author wzr
 * @version 1.0
 */

package Chapter02;

public class PointWithAccessor {

    private double X;
    private double Y;
    
    public PointWithAccessor() {
        this.X = 0;
        this.Y = 0;
    }
    
    public PointWithAccessor(double x, double y) {
        this.X = x;
        this.Y = y;
    }
    
    public PointWithAccessor translate(double dx, double dy) {
        return new PointWithAccessor(this.X + dx, this.Y + dy);
    }
    
    public PointWithAccessor scale(double scale) {
        return new PointWithAccessor(this.X * scale, this.Y * scale);
    }
    
    public String toString() {
        return "Point (" + this.X + ", " + this.Y + ")";
    }

}
