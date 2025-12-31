package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import b.c.a.a.m.e;
import b.c.a.a.m.g;
import java.lang.ref.WeakReference;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f1529a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final g f1530b = new q(this);
    private float c;
    /* access modifiers changed from: private */
    public boolean d = true;
    /* access modifiers changed from: private */
    public WeakReference<a> e = new WeakReference<>((Object) null);
    private e f;

    public interface a {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public TextPaint b() {
        return this.f1529a;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public float a(String str) {
        if (!this.d) {
            return this.c;
        }
        this.c = a((CharSequence) str);
        this.d = false;
        return this.c;
    }

    private float a(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f1529a.measureText(charSequence, 0, charSequence.length());
    }

    public e a() {
        return this.f;
    }

    public void a(e eVar, Context context) {
        if (this.f != eVar) {
            this.f = eVar;
            if (eVar != null) {
                eVar.c(context, this.f1529a, this.f1530b);
                a aVar = (a) this.e.get();
                if (aVar != null) {
                    this.f1529a.drawableState = aVar.getState();
                }
                eVar.b(context, this.f1529a, this.f1530b);
                this.d = true;
            }
            a aVar2 = (a) this.e.get();
            if (aVar2 != null) {
                aVar2.a();
                aVar2.onStateChange(aVar2.getState());
            }
        }
    }

    public void a(Context context) {
        this.f.b(context, this.f1529a, this.f1530b);
    }
}
