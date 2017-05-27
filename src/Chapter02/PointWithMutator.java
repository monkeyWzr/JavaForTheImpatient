/**
 * An <code>Point</code> class with mutator methods
 * 
 * @author wzr
 * @version 1.0
 */

package Chapter02;

public class PointWithMutator {
    
    private double X;
    private double Y;
    
    public PointWithMutator() {
        this.X = 0.0;
        this.Y = 0.0;
    }
        
    public PointWithMutator(double x, double y) {
        this.X = x;
        this.Y = y;
    }
    
    public double getX() {
        return this.X;
    }
    
    public double getY() {
        return this.Y;
    }
    
    public PointWithMutator translate(double dx, double dy) {
        this.X += dx;
        this.Y += dy;
        return this;
    }
    
    public PointWithMutator scale (double scale) {
        this.X *= scale;
        this.Y *= scale;
        return this;
    }
    
    public String toString() {
        return "Point (" + this.X + ", " + this.Y + ")";
    }

}
