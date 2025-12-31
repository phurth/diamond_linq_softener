package b.c.a.a.p;

public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected float f1320a;

    public a() {
        this.f1320a = 0.0f;
    }

    public float a() {
        return this.f1320a;
    }

    public void a(float f, float f2, k kVar) {
    }

    public void a(float f) {
        this.f1320a = f;
    }

    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    protected a(float f) {
        this.f1320a = f;
    }
}
