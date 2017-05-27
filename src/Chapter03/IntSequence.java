package Chapter03;

public interface IntSequence {
    public boolean hasNext();
    public int next();
    public static IntSequence of(int... values) {
        return new IntSequence() {
            private int index = 0;
            public int next() {
                return values[index++];
            }
            public boolean hasNext() {
                return index < values.length;
            }
        };
    }
    
    public static IntSequence constant(int value) {
        return new IntSequence() {
            public boolean hasNext() {
                return true;
            }
            public int next() {
                return value;
            }
        };
    }
}
