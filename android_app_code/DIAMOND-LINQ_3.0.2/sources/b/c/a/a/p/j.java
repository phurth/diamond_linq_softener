package b.c.a.a.p;

import android.graphics.Canvas;
import android.graphics.Matrix;
import b.c.a.a.o.a;
import b.c.a.a.p.k;
import java.util.List;

class j extends k.f {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f1332b;
    final /* synthetic */ Matrix c;
    final /* synthetic */ k d;

    j(k kVar, List list, Matrix matrix) {
        this.d = kVar;
        this.f1332b = list;
        this.c = matrix;
    }

    public void a(Matrix matrix, a aVar, int i, Canvas canvas) {
        for (k.f a2 : this.f1332b) {
            a2.a(this.c, aVar, i, canvas);
        }
    }
}
