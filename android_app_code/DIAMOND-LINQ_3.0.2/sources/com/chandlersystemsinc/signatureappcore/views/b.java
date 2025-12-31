package com.chandlersystemsinc.signatureappcore.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.a.Ba;

public abstract class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected int f1424a = -1;

    /* renamed from: b  reason: collision with root package name */
    protected Button f1425b;
    protected Button c;

    public b(Context context) {
        super(context);
        b();
        c();
        a();
    }

    private void setTouchButtonDisabled(Button button) {
        button.setFocusable(false);
        button.setClickable(false);
        button.setAlpha(0.0f);
        button.setBackground((Drawable) null);
    }

    /* access modifiers changed from: protected */
    public void a() {
        int applyDimension = (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        setPadding(applyDimension, 0, applyDimension, 0);
    }

    public void b() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        this.f1425b = new Button(getContext());
        setTouchButtonDisabled(this.f1425b);
        this.c = new Button(getContext());
        setTouchButtonDisabled(this.c);
        linearLayout.addView(this.f1425b, layoutParams);
        linearLayout.addView(this.c, layoutParams);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public abstract void c();

    public TextView getTitleTextView() {
        return (TextView) findViewById(Ba.title);
    }

    /* access modifiers changed from: protected */
    public void setBottomTouchArea(View.OnClickListener onClickListener) {
        this.c.setFocusable(true);
        this.c.setClickable(true);
        this.c.setOnClickListener(onClickListener);
    }

    public void setGridCount(int i) {
        this.f1424a = i;
    }

    public void setTitle(String str) {
        ((TextView) findViewById(Ba.title)).setText(str);
    }

    public void setTitleLongPressCallback(View.OnLongClickListener onLongClickListener) {
        TextView textView = (TextView) findViewById(Ba.title);
        textView.setLongClickable(true);
        textView.setOnLongClickListener(onLongClickListener);
    }

    /* access modifiers changed from: protected */
    public void setTopTouchArea(View.OnClickListener onClickListener) {
        this.f1425b.setFocusable(true);
        this.f1425b.setClickable(true);
        this.f1425b.setOnClickListener(onClickListener);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
        c();
        a();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
        c();
        a();
    }
}
