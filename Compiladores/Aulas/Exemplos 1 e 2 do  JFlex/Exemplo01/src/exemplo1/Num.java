package exemplo1;

public class Num extends Token {
    public final double value;

    public Num(double v) {
        super(Tag.NUMBER);
        value = v;
    }

    @Override
    public String toString() {
        return "<" + this.tag + "," + this.value + ">";
    }
}
