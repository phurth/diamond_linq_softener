package androidx.recyclerview.widget;

import androidx.recyclerview.widget.q;
import java.util.Comparator;

class p implements Comparator<q.b> {
    p() {
    }

    /* renamed from: a */
    public int compare(q.b bVar, q.b bVar2) {
        if ((bVar.d == null) == (bVar2.d == null)) {
            boolean z = bVar.f988a;
            if (z == bVar2.f988a) {
                int i = bVar2.f989b - bVar.f989b;
                if (i != 0) {
                    return i;
                }
                int i2 = bVar.c - bVar2.c;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            } else if (z) {
                return -1;
            } else {
                return 1;
            }
        } else if (bVar.d == null) {
            return 1;
        } else {
            return -1;
        }
    }
}
