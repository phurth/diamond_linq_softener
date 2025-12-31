package androidx.core.app;

import a.d.i;
import a.g.i.C0040d;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;

public class g extends Activity implements C0040d.a {

    /* renamed from: a  reason: collision with root package name */
    private i<Class<? extends Object>, Object> f729a = new i<>();

    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0040d.a(decorView, keyEvent)) {
            return C0040d.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0040d.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }
}
