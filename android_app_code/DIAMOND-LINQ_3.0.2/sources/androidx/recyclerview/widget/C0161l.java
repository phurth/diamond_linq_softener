package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.l  reason: case insensitive filesystem */
public class C0161l extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f975a = {16843284};

    /* renamed from: b  reason: collision with root package name */
    private Drawable f976b;
    private int c;
    private final Rect d = new Rect();

    public C0161l(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f975a);
        this.f976b = obtainStyledAttributes.getDrawable(0);
        if (this.f976b == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        a(i);
    }

    private void c(Canvas canvas, RecyclerView recyclerView) {
        int i;
        int i2;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingTop();
            i = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), i);
        } else {
            i = recyclerView.getHeight();
            i2 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.getLayoutManager().b(childAt, this.d);
            int round = this.d.right + Math.round(childAt.getTranslationX());
            this.f976b.setBounds(round - this.f976b.getIntrinsicWidth(), i2, round, i);
            this.f976b.draw(canvas);
        }
        canvas.restore();
    }

    private void d(Canvas canvas, RecyclerView recyclerView) {
        int i;
        int i2;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingLeft();
            i = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i2, recyclerView.getPaddingTop(), i, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i = recyclerView.getWidth();
            i2 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.a(childAt, this.d);
            int round = this.d.bottom + Math.round(childAt.getTranslationY());
            this.f976b.setBounds(i2, round - this.f976b.getIntrinsicHeight(), i, round);
            this.f976b.draw(canvas);
        }
        canvas.restore();
    }

    public void a(int i) {
        if (i == 0 || i == 1) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.u uVar) {
        if (recyclerView.getLayoutManager() != null && this.f976b != null) {
            if (this.c == 1) {
                d(canvas, recyclerView);
            } else {
                c(canvas, recyclerView);
            }
        }
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.u uVar) {
        Drawable drawable = this.f976b;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }
}
