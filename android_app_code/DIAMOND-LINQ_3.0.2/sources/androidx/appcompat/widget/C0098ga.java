package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.C0071a;
import androidx.appcompat.widget.W;

/* renamed from: androidx.appcompat.widget.ga  reason: case insensitive filesystem */
public class C0098ga extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f603a = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    Runnable f604b;
    private b c;
    W d;
    private Spinner e;
    private boolean f;
    int g;
    int h;
    private int i;
    private int j;

    /* renamed from: androidx.appcompat.widget.ga$a */
    private class a extends BaseAdapter {
        a() {
        }

        public int getCount() {
            return C0098ga.this.d.getChildCount();
        }

        public Object getItem(int i) {
            return ((c) C0098ga.this.d.getChildAt(i)).a();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return C0098ga.this.a((C0071a.c) getItem(i), true);
            }
            ((c) view).a((C0071a.c) getItem(i));
            return view;
        }
    }

    /* renamed from: androidx.appcompat.widget.ga$b */
    private class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ((c) view).a().e();
            int childCount = C0098ga.this.d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = C0098ga.this.d.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private Spinner a() {
        E e2 = new E(getContext(), (AttributeSet) null, a.a.a.actionDropDownStyle);
        e2.setLayoutParams(new W.a(-2, -1));
        e2.setOnItemSelectedListener(this);
        return e2;
    }

    private boolean b() {
        Spinner spinner = this.e;
        return spinner != null && spinner.getParent() == this;
    }

    private void c() {
        if (!b()) {
            if (this.e == null) {
                this.e = a();
            }
            removeView(this.d);
            addView(this.e, new ViewGroup.LayoutParams(-2, -1));
            if (this.e.getAdapter() == null) {
                this.e.setAdapter(new a());
            }
            Runnable runnable = this.f604b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f604b = null;
            }
            this.e.setSelection(this.j);
        }
    }

    private boolean d() {
        if (!b()) {
            return false;
        }
        removeView(this.e);
        addView(this.d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.e.getSelectedItemPosition());
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f604b;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a.a.d.a a2 = a.a.d.a.a(getContext());
        setContentHeight(a2.e());
        this.h = a2.d();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f604b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((c) view).a().e();
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.g = -1;
        } else {
            if (childCount > 2) {
                this.g = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.g = View.MeasureSpec.getSize(i2) / 2;
            }
            this.g = Math.min(this.g, this.h);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        if (z2 || !this.f) {
            z = false;
        }
        if (z) {
            this.d.measure(0, makeMeasureSpec);
            if (this.d.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                c();
            } else {
                d();
            }
        } else {
            d();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f = z;
    }

    public void setContentHeight(int i2) {
        this.i = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.j = i2;
        int childCount = this.d.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.d.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.e;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }

    /* renamed from: androidx.appcompat.widget.ga$c */
    private class c extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f607a = {16842964};

        /* renamed from: b  reason: collision with root package name */
        private C0071a.c f608b;
        private TextView c;
        private ImageView d;
        private View e;

        public c(Context context, C0071a.c cVar, boolean z) {
            super(context, (AttributeSet) null, a.a.a.actionBarTabStyle);
            this.f608b = cVar;
            za a2 = za.a(context, (AttributeSet) null, this.f607a, a.a.a.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.b(0));
            }
            a2.a();
            if (z) {
                setGravity(8388627);
            }
            b();
        }

        public void a(C0071a.c cVar) {
            this.f608b = cVar;
            b();
        }

        public void b() {
            C0071a.c cVar = this.f608b;
            View b2 = cVar.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.e = b2;
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.d.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.e;
            if (view != null) {
                removeView(view);
                this.e = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.d == null) {
                    C0119u uVar = new C0119u(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    uVar.setLayoutParams(layoutParams);
                    addView(uVar, 0);
                    this.d = uVar;
                }
                this.d.setImageDrawable(c2);
                this.d.setVisibility(0);
            } else {
                ImageView imageView2 = this.d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.d.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.c == null) {
                    M m = new M(getContext(), (AttributeSet) null, a.a.a.actionBarTabTextStyle);
                    m.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    m.setLayoutParams(layoutParams2);
                    addView(m);
                    this.c = m;
                }
                this.c.setText(d2);
                this.c.setVisibility(0);
            } else {
                TextView textView2 = this.c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            if (!z) {
                charSequence = cVar.a();
            }
            Ha.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i, int i2) {
            int i3;
            super.onMeasure(i, i2);
            if (C0098ga.this.g > 0 && getMeasuredWidth() > (i3 = C0098ga.this.g)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public C0071a.c a() {
            return this.f608b;
        }
    }

    public void a(int i2) {
        View childAt = this.d.getChildAt(i2);
        Runnable runnable = this.f604b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f604b = new C0096fa(this, childAt);
        post(this.f604b);
    }

    /* access modifiers changed from: package-private */
    public c a(C0071a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable((Drawable) null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
        } else {
            cVar2.setFocusable(true);
            if (this.c == null) {
                this.c = new b();
            }
            cVar2.setOnClickListener(this.c);
        }
        return cVar2;
    }
}
