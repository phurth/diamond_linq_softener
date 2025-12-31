package androidx.appcompat.app;

import a.g.i.F;
import a.g.i.G;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.x;

class y extends G {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x.b f442a;

    y(x.b bVar) {
        this.f442a = bVar;
    }

    public void b(View view) {
        x.this.r.setVisibility(8);
        x xVar = x.this;
        PopupWindow popupWindow = xVar.s;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (xVar.r.getParent() instanceof View) {
            a.g.i.y.F((View) x.this.r.getParent());
        }
        x.this.r.removeAllViews();
        x.this.u.a((F) null);
        x.this.u = null;
    }
}
