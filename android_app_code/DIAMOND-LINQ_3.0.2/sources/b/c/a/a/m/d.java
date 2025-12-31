package b.c.a.a.m;

import android.graphics.Typeface;
import android.text.TextPaint;

class d extends g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextPaint f1311a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f1312b;
    final /* synthetic */ e c;

    d(e eVar, TextPaint textPaint, g gVar) {
        this.c = eVar;
        this.f1311a = textPaint;
        this.f1312b = gVar;
    }

    public void a(Typeface typeface, boolean z) {
        this.c.a(this.f1311a, typeface);
        this.f1312b.a(typeface, z);
    }

    public void a(int i) {
        this.f1312b.a(i);
    }
}
