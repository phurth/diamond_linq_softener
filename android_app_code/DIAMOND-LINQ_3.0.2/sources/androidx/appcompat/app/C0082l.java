package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.l  reason: case insensitive filesystem */
public class C0082l extends B implements DialogInterface {
    final AlertController c = new AlertController(getContext(), this, getWindow());

    /* renamed from: androidx.appcompat.app.l$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.a f421a;

        /* renamed from: b  reason: collision with root package name */
        private final int f422b;

        public a(Context context) {
            this(context, C0082l.a(context, 0));
        }

        public a a(View view) {
            this.f421a.g = view;
            return this;
        }

        public Context b() {
            return this.f421a.f375a;
        }

        public C0082l c() {
            C0082l a2 = a();
            a2.show();
            return a2;
        }

        public a(Context context, int i) {
            this.f421a = new AlertController.a(new ContextThemeWrapper(context, C0082l.a(context, i)));
            this.f422b = i;
        }

        public a a(CharSequence charSequence) {
            this.f421a.h = charSequence;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f421a.f = charSequence;
            return this;
        }

        public a a(Drawable drawable) {
            this.f421a.d = drawable;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f421a;
            aVar.i = aVar.f375a.getText(i);
            this.f421a.k = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.f421a.t = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f421a.u = onKeyListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f421a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public a a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f421a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            aVar.I = i;
            aVar.H = true;
            return this;
        }

        public C0082l a() {
            C0082l lVar = new C0082l(this.f421a.f375a, this.f422b);
            this.f421a.a(lVar.c);
            lVar.setCancelable(this.f421a.r);
            if (this.f421a.r) {
                lVar.setCanceledOnTouchOutside(true);
            }
            lVar.setOnCancelListener(this.f421a.s);
            lVar.setOnDismissListener(this.f421a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f421a.u;
            if (onKeyListener != null) {
                lVar.setOnKeyListener(onKeyListener);
            }
            return lVar;
        }
    }

    protected C0082l(Context context, int i) {
        super(context, a(context, i));
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView b() {
        return this.c.a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c.b();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.c.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.c.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.c.b(charSequence);
    }
}
