package androidx.appcompat.widget;

import a.a.a;
import a.a.j;
import a.g.i.E;
import a.g.i.F;
import a.g.i.y;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.appcompat.widget.a  reason: case insensitive filesystem */
abstract class C0085a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0020a f581a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f582b;
    protected ActionMenuView c;
    protected C0097g d;
    protected int e;
    protected E f;
    private boolean g;
    private boolean h;

    C0085a(Context context) {
        this(context, (AttributeSet) null);
    }

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.f581a.f584b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, j.ActionBar, a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        C0097g gVar = this.d;
        if (gVar != null) {
            gVar.a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            E e2 = this.f;
            if (e2 != null) {
                e2.a();
            }
            super.setVisibility(i);
        }
    }

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    protected class C0020a implements F {

        /* renamed from: a  reason: collision with root package name */
        private boolean f583a = false;

        /* renamed from: b  reason: collision with root package name */
        int f584b;

        protected C0020a() {
        }

        public C0020a a(E e, int i) {
            C0085a.this.f = e;
            this.f584b = i;
            return this;
        }

        public void b(View view) {
            if (!this.f583a) {
                C0085a aVar = C0085a.this;
                aVar.f = null;
                C0085a.super.setVisibility(this.f584b);
            }
        }

        public void c(View view) {
            C0085a.super.setVisibility(0);
            this.f583a = false;
        }

        public void a(View view) {
            this.f583a = true;
        }
    }

    C0085a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public E a(int i, long j) {
        E e2 = this.f;
        if (e2 != null) {
            e2.a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            E a2 = y.a(this);
            a2.a(1.0f);
            a2.a(j);
            C0020a aVar = this.f581a;
            aVar.a(a2, i);
            a2.a((F) aVar);
            return a2;
        }
        E a3 = y.a(this);
        a3.a(0.0f);
        a3.a(j);
        C0020a aVar2 = this.f581a;
        aVar2.a(a3, i);
        a3.a((F) aVar2);
        return a3;
    }

    C0085a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        this.f581a = new C0020a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(a.actionBarPopupTheme, typedValue, true) || (i2 = typedValue.resourceId) == 0) {
            this.f582b = context;
        } else {
            this.f582b = new ContextThemeWrapper(context, i2);
        }
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
