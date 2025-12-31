package b.b.a.a.e;

import b.b.a.a.d.j;
import java.text.DecimalFormat;

public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    protected DecimalFormat f1246a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1247b;

    public c(int i) {
        a(i);
    }

    public void a(int i) {
        this.f1247b = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f1246a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String a(float f, j jVar, int i, b.b.a.a.j.j jVar2) {
        return this.f1246a.format((double) f);
    }
}
