package androidx.appcompat.app;

import a.a.d.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Ma;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.a;
import androidx.core.app.h;
import androidx.core.app.j;
import androidx.fragment.app.C0134j;

public class m extends C0134j implements n, j.a, C0072b {
    private o p;
    private Resources q;

    public b a(b.a aVar) {
        return null;
    }

    public void a(b bVar) {
    }

    public void a(Toolbar toolbar) {
        v().a(toolbar);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        v().a(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        v().a(context);
    }

    /* access modifiers changed from: protected */
    public void b(int i) {
    }

    public void b(b bVar) {
    }

    public void b(j jVar) {
    }

    public boolean b(Intent intent) {
        return h.b((Activity) this, intent);
    }

    public void closeOptionsMenu() {
        C0071a w = w();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (w == null || !w.e()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        C0071a w = w();
        if (keyCode != 82 || w == null || !w.a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i) {
        return v().a(i);
    }

    public Intent g() {
        return h.a(this);
    }

    public MenuInflater getMenuInflater() {
        return v().c();
    }

    public Resources getResources() {
        if (this.q == null && Ma.b()) {
            this.q = new Ma(this, super.getResources());
        }
        Resources resources = this.q;
        return resources == null ? super.getResources() : resources;
    }

    public void invalidateOptionsMenu() {
        v().f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.q != null) {
            this.q.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        v().a(configuration);
    }

    public void onContentChanged() {
        x();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        o v = v();
        v.e();
        v.a(bundle);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        v().g();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0071a w = w();
        if (menuItem.getItemId() != 16908332 || w == null || (w.g() & 4) == 0) {
            return false;
        }
        return y();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        v().b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        v().h();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        v().c(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        v().i();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        v().j();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        v().a(charSequence);
    }

    public void openOptionsMenu() {
        C0071a w = w();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (w == null || !w.k()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i) {
        v().c(i);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        v().d(i);
    }

    public void u() {
        v().f();
    }

    public o v() {
        if (this.p == null) {
            this.p = o.a((Activity) this, (n) this);
        }
        return this.p;
    }

    public C0071a w() {
        return v().d();
    }

    @Deprecated
    public void x() {
    }

    public boolean y() {
        Intent g = g();
        if (g == null) {
            return false;
        }
        if (b(g)) {
            j a2 = j.a((Context) this);
            a(a2);
            b(a2);
            a2.a();
            try {
                a.a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            a(g);
            return true;
        }
    }

    public void a(j jVar) {
        jVar.a((Activity) this);
    }

    public void setContentView(View view) {
        v().a(view);
    }

    public void a(Intent intent) {
        h.a((Activity) this, intent);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        v().b(view, layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r2 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r2, android.view.KeyEvent r3) {
        /*
            r1 = this;
            int r2 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r2 >= r0) goto L_0x003e
            boolean r2 = r3.isCtrlPressed()
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getMetaState()
            boolean r2 = android.view.KeyEvent.metaStateHasNoModifiers(r2)
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getRepeatCount()
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getKeyCode()
            boolean r2 = android.view.KeyEvent.isModifierKey(r2)
            if (r2 != 0) goto L_0x003e
            android.view.Window r2 = r1.getWindow()
            if (r2 == 0) goto L_0x003e
            android.view.View r0 = r2.getDecorView()
            if (r0 == 0) goto L_0x003e
            android.view.View r2 = r2.getDecorView()
            boolean r2 = r2.dispatchKeyShortcutEvent(r3)
            if (r2 == 0) goto L_0x003e
            r2 = 1
            return r2
        L_0x003e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.m.a(int, android.view.KeyEvent):boolean");
    }
}
