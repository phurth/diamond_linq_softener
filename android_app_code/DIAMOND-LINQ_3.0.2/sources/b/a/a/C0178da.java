package b.a.a;

/* renamed from: b.a.a.da  reason: case insensitive filesystem */
final class C0178da {

    /* renamed from: a  reason: collision with root package name */
    private final double f1127a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f1128b;

    C0178da(double d) {
        this.f1127a = d;
    }

    /* access modifiers changed from: package-private */
    public int a(int i) {
        Integer num = this.f1128b;
        if (num == null) {
            this.f1128b = Integer.valueOf(i);
            return i;
        }
        double intValue = (double) num.intValue();
        double d = this.f1127a;
        double intValue2 = (double) (i - this.f1128b.intValue());
        Double.isNaN(intValue2);
        Double.isNaN(intValue);
        int i2 = (int) (intValue + (d * intValue2));
        this.f1128b = Integer.valueOf(i2);
        return i2;
    }
}
