package Chapter04;

import java.util.Objects;

public class Point {

    protected double x;
    protected double y;
    public class LabeledPoint {
        private double x;
        private double y;
        private String label;
        public LabeledPoint(String label, double x, double y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }
        
        public String getLabel() {
            return this.label;
        }
        
        public String ToString() {
            return "LabeledPoint : " + this.label + "(" + this.x + ", " + this.y + ")";
        }
        
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null) return false;
            if (this.getClass() != other.getClass()) return false;
            LabeledPoint o = (LabeledPoint) other;
            return o.label.equals(this.label) && o.x == this.x && o.y == this.y;
        }
        
        public int hashCode() {
            return Objects.hash(label, x, y);
        }
    }
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public String toString() {
        return "Point: (" + this.x + ", " + this.y + ")";
    }
    
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        Point p = (Point) other;
        return this.x == p.x && this.y == p.y;
    }
    
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
