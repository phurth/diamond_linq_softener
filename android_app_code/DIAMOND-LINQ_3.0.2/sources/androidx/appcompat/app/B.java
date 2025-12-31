package androidx.appcompat.app;

import a.a.a;
import a.a.d.b;
import a.g.i.C0040d;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

public class B extends Dialog implements n {

    /* renamed from: a  reason: collision with root package name */
    private o f380a;

    /* renamed from: b  reason: collision with root package name */
    private final C0040d.a f381b = new A(this);

    public B(Context context, int i) {
        super(context, a(context, i));
        o a2 = a();
        a2.d(a(context, i));
        a2.a((Bundle) null);
    }

    public b a(b.a aVar) {
        return null;
    }

    public void a(b bVar) {
    }

    public boolean a(int i) {
        return a().b(i);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    public void b(b bVar) {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0040d.a(this.f381b, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return a().a(i);
    }

    public void invalidateOptionsMenu() {
        a().f();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a().e();
        super.onCreate(bundle);
        a().a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a().j();
    }

    public void setContentView(int i) {
        a().c(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }

    public o a() {
        if (this.f380a == null) {
            this.f380a = o.a((Dialog) this, (n) this);
        }
        return this.f380a;
    }

    public void setContentView(View view) {
        a().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        a().a((CharSequence) getContext().getString(i));
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
