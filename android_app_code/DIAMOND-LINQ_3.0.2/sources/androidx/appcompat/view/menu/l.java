package androidx.appcompat.view.menu;

import a.a.g;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.C0082l;
import androidx.appcompat.view.menu.t;

class l implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, t.a {

    /* renamed from: a  reason: collision with root package name */
    private k f470a;

    /* renamed from: b  reason: collision with root package name */
    private C0082l f471b;
    i c;
    private t.a d;

    public l(k kVar) {
        this.f470a = kVar;
    }

    public void a(IBinder iBinder) {
        k kVar = this.f470a;
        C0082l.a aVar = new C0082l.a(kVar.e());
        this.c = new i(aVar.b(), g.abc_list_menu_item_layout);
        this.c.a((t.a) this);
        this.f470a.a((t) this.c);
        aVar.a(this.c.c(), (DialogInterface.OnClickListener) this);
        View i = kVar.i();
        if (i != null) {
            aVar.a(i);
        } else {
            aVar.a(kVar.g());
            aVar.b(kVar.h());
        }
        aVar.a((DialogInterface.OnKeyListener) this);
        this.f471b = aVar.a();
        this.f471b.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f471b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f471b.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f470a.a((MenuItem) (o) this.c.c().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.c.a(this.f470a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f471b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f471b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f470a.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f470a.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        C0082l lVar = this.f471b;
        if (lVar != null) {
            lVar.dismiss();
        }
    }

    public void a(k kVar, boolean z) {
        if (z || kVar == this.f470a) {
            a();
        }
        t.a aVar = this.d;
        if (aVar != null) {
            aVar.a(kVar, z);
        }
    }

    public boolean a(k kVar) {
        t.a aVar = this.d;
        if (aVar != null) {
            return aVar.a(kVar);
        }
        return false;
    }
}
