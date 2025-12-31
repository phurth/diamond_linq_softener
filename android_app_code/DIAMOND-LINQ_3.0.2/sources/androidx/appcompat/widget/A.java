package androidx.appcompat.widget;

import a.a.a;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class A extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    private final B f487a;

    public A(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.seekBarStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f487a.b();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f487a.c();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f487a.a(canvas);
    }

    public A(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f487a = new B(this);
        this.f487a.a(attributeSet, i);
    }
}
