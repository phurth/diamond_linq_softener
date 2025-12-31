package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class I {
    static int a(RecyclerView.u uVar, x xVar, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        int i;
        if (iVar.e() == 0 || uVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar.l(view), iVar.l(view2));
        int max = Math.max(iVar.l(view), iVar.l(view2));
        if (z2) {
            i = Math.max(0, (uVar.a() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(xVar.a(view2) - xVar.d(view))) / ((float) (Math.abs(iVar.l(view) - iVar.l(view2)) + 1)))) + ((float) (xVar.f() - xVar.d(view))));
    }

    static int b(RecyclerView.u uVar, x xVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.e() == 0 || uVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return uVar.a();
        }
        return (int) ((((float) (xVar.a(view2) - xVar.d(view))) / ((float) (Math.abs(iVar.l(view) - iVar.l(view2)) + 1))) * ((float) uVar.a()));
    }

    static int a(RecyclerView.u uVar, x xVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.e() == 0 || uVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.l(view) - iVar.l(view2)) + 1;
        }
        return Math.min(xVar.g(), xVar.a(view2) - xVar.d(view));
    }
}
