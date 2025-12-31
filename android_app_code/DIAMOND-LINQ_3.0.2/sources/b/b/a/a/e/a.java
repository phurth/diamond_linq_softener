package b.b.a.a.e;

import java.text.DecimalFormat;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected DecimalFormat f1244a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1245b = 0;

    public a(int i) {
        this.f1245b = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f1244a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String a(float f, b.b.a.a.c.a aVar) {
        return this.f1244a.format((double) f);
    }

    public int a() {
        return this.f1245b;
    }
}
