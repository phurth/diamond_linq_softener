package b.a.a;

/* renamed from: b.a.a.ea  reason: case insensitive filesystem */
public final class C0180ea {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f1142a;

    /* renamed from: b  reason: collision with root package name */
    private int f1143b;
    private int c;
    private long d;

    public C0180ea(int i) {
        this.f1142a = new long[((i < 0 || i > 1000) ? 50 : i)];
        this.c = 0;
        this.d = 0;
    }

    public int a(long j) {
        int i = this.f1143b;
        if (i < this.f1142a.length) {
            this.f1143b = i + 1;
        }
        long j2 = this.d;
        long[] jArr = this.f1142a;
        int i2 = this.c;
        this.d = j2 - jArr[i2];
        this.d += j;
        jArr[i2] = j;
        this.c = (i2 + 1) % jArr.length;
        return (int) (this.d / ((long) this.f1143b));
    }
}
