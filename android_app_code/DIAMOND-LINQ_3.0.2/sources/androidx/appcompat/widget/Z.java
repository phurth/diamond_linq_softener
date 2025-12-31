package androidx.appcompat.widget;

import a.a.j;
import a.g.i.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.w;
import androidx.core.widget.i;
import java.lang.reflect.Method;

public class Z implements w {

    /* renamed from: a  reason: collision with root package name */
    private static Method f574a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f575b;
    private static Method c;
    final e A;
    private final d B;
    private final c C;
    private final a D;
    private Runnable E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;
    private Context d;
    private ListAdapter e;
    T f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    int s;
    private View t;
    private int u;
    private DataSetObserver v;
    private View w;
    private Drawable x;
    private AdapterView.OnItemClickListener y;
    private AdapterView.OnItemSelectedListener z;

    private class a implements Runnable {
        a() {
        }

        public void run() {
            Z.this.h();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            if (Z.this.c()) {
                Z.this.d();
            }
        }

        public void onInvalidated() {
            Z.this.dismiss();
        }
    }

    private class c implements AbsListView.OnScrollListener {
        c() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !Z.this.k() && Z.this.J.getContentView() != null) {
                Z z = Z.this;
                z.F.removeCallbacks(z.A);
                Z.this.A.run();
            }
        }
    }

    private class d implements View.OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = Z.this.J) != null && popupWindow.isShowing() && x >= 0 && x < Z.this.J.getWidth() && y >= 0 && y < Z.this.J.getHeight()) {
                Z z = Z.this;
                z.F.postDelayed(z.A, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                Z z2 = Z.this;
                z2.F.removeCallbacks(z2.A);
                return false;
            }
        }
    }

    private class e implements Runnable {
        e() {
        }

        public void run() {
            T t = Z.this.f;
            if (t != null && y.z(t) && Z.this.f.getCount() > Z.this.f.getChildCount()) {
                int childCount = Z.this.f.getChildCount();
                Z z = Z.this;
                if (childCount <= z.s) {
                    z.J.setInputMethodMode(2);
                    Z.this.d();
                }
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            f574a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f575b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public Z(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: androidx.appcompat.widget.T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: androidx.appcompat.widget.T} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m() {
        /*
            r12 = this;
            androidx.appcompat.widget.T r0 = r12.f
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00c1
            android.content.Context r0 = r12.d
            androidx.appcompat.widget.X r5 = new androidx.appcompat.widget.X
            r5.<init>(r12)
            r12.E = r5
            boolean r5 = r12.I
            r5 = r5 ^ r3
            androidx.appcompat.widget.T r5 = r12.a(r0, r5)
            r12.f = r5
            android.graphics.drawable.Drawable r5 = r12.x
            if (r5 == 0) goto L_0x0024
            androidx.appcompat.widget.T r6 = r12.f
            r6.setSelector(r5)
        L_0x0024:
            androidx.appcompat.widget.T r5 = r12.f
            android.widget.ListAdapter r6 = r12.e
            r5.setAdapter(r6)
            androidx.appcompat.widget.T r5 = r12.f
            android.widget.AdapterView$OnItemClickListener r6 = r12.y
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.T r5 = r12.f
            r5.setFocusable(r3)
            androidx.appcompat.widget.T r5 = r12.f
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.T r5 = r12.f
            androidx.appcompat.widget.Y r6 = new androidx.appcompat.widget.Y
            r6.<init>(r12)
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.T r5 = r12.f
            androidx.appcompat.widget.Z$c r6 = r12.C
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.z
            if (r5 == 0) goto L_0x0056
            androidx.appcompat.widget.T r6 = r12.f
            r6.setOnItemSelectedListener(r5)
        L_0x0056:
            androidx.appcompat.widget.T r5 = r12.f
            android.view.View r6 = r12.t
            if (r6 == 0) goto L_0x00ba
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.u
            if (r8 == 0) goto L_0x0091
            if (r8 == r3) goto L_0x008a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.u
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0097
        L_0x008a:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0097
        L_0x0091:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0097:
            int r0 = r12.h
            if (r0 < 0) goto L_0x009e
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x00a0
        L_0x009e:
            r0 = 0
            r5 = 0
        L_0x00a0:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00bb
        L_0x00ba:
            r0 = 0
        L_0x00bb:
            android.widget.PopupWindow r6 = r12.J
            r6.setContentView(r5)
            goto L_0x00df
        L_0x00c1:
            android.widget.PopupWindow r0 = r12.J
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.t
            if (r0 == 0) goto L_0x00de
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00df
        L_0x00de:
            r0 = 0
        L_0x00df:
            android.widget.PopupWindow r5 = r12.J
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00fb
            android.graphics.Rect r6 = r12.G
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.G
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.l
            if (r7 != 0) goto L_0x0101
            int r6 = -r6
            r12.j = r6
            goto L_0x0101
        L_0x00fb:
            android.graphics.Rect r5 = r12.G
            r5.setEmpty()
            r5 = 0
        L_0x0101:
            android.widget.PopupWindow r6 = r12.J
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x010b
            goto L_0x010c
        L_0x010b:
            r3 = 0
        L_0x010c:
            android.view.View r4 = r12.i()
            int r6 = r12.j
            int r3 = r12.a(r4, r6, r3)
            boolean r4 = r12.q
            if (r4 != 0) goto L_0x017e
            int r4 = r12.g
            if (r4 != r2) goto L_0x011f
            goto L_0x017e
        L_0x011f:
            int r4 = r12.h
            r6 = -2
            if (r4 == r6) goto L_0x0147
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012e
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
        L_0x012c:
            r7 = r1
            goto L_0x0160
        L_0x012e:
            android.content.Context r2 = r12.d
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.G
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x012c
        L_0x0147:
            android.content.Context r2 = r12.d
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.G
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x012c
        L_0x0160:
            androidx.appcompat.widget.T r6 = r12.f
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.a(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x017c
            androidx.appcompat.widget.T r2 = r12.f
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.T r3 = r12.f
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x017c:
            int r1 = r1 + r0
            return r1
        L_0x017e:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Z.m():int");
    }

    private void n() {
        View view = this.t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.v;
        if (dataSetObserver == null) {
            this.v = new b();
        } else {
            ListAdapter listAdapter2 = this.e;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.e = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.v);
        }
        T t2 = this.f;
        if (t2 != null) {
            t2.setAdapter(this.e);
        }
    }

    public void b(int i2) {
        this.j = i2;
        this.l = true;
    }

    public void c(int i2) {
        this.J.setAnimationStyle(i2);
    }

    public void d(int i2) {
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            this.h = rect.left + rect.right + i2;
            return;
        }
        i(i2);
    }

    public void dismiss() {
        this.J.dismiss();
        n();
        this.J.setContentView((View) null);
        this.f = null;
        this.F.removeCallbacks(this.A);
    }

    public Drawable e() {
        return this.J.getBackground();
    }

    public void f(int i2) {
        this.J.setInputMethodMode(i2);
    }

    public void g(int i2) {
        this.u = i2;
    }

    public void h(int i2) {
        T t2 = this.f;
        if (c() && t2 != null) {
            t2.setListSelectionHidden(false);
            t2.setSelection(i2);
            if (t2.getChoiceMode() != 0) {
                t2.setItemChecked(i2, true);
            }
        }
    }

    public View i() {
        return this.w;
    }

    public int j() {
        return this.h;
    }

    public boolean k() {
        return this.J.getInputMethodMode() == 2;
    }

    public boolean l() {
        return this.I;
    }

    public Z(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.g = -2;
        this.h = -2;
        this.k = 1002;
        this.m = true;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = Integer.MAX_VALUE;
        this.u = 0;
        this.A = new e();
        this.B = new d();
        this.C = new c();
        this.D = new a();
        this.G = new Rect();
        this.d = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i2, i3);
        this.i = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.j = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.j != 0) {
            this.l = true;
        }
        obtainStyledAttributes.recycle();
        this.J = new C0121w(context, attributeSet, i2, i3);
        this.J.setInputMethodMode(1);
    }

    public boolean c() {
        return this.J.isShowing();
    }

    public void e(int i2) {
        this.p = i2;
    }

    public ListView f() {
        return this.f;
    }

    public int g() {
        if (!this.l) {
            return 0;
        }
        return this.j;
    }

    public void i(int i2) {
        this.h = i2;
    }

    private void c(boolean z2) {
        Method method = f574a;
        if (method != null) {
            try {
                method.invoke(this.J, new Object[]{Boolean.valueOf(z2)});
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void b(boolean z2) {
        this.o = true;
        this.n = z2;
    }

    public void d() {
        int m2 = m();
        boolean k2 = k();
        i.a(this.J, this.k);
        boolean z2 = true;
        if (!this.J.isShowing()) {
            int i2 = this.h;
            if (i2 == -1) {
                i2 = -1;
            } else if (i2 == -2) {
                i2 = i().getWidth();
            }
            int i3 = this.g;
            if (i3 == -1) {
                m2 = -1;
            } else if (i3 != -2) {
                m2 = i3;
            }
            this.J.setWidth(i2);
            this.J.setHeight(m2);
            c(true);
            this.J.setOutsideTouchable(!this.r && !this.q);
            this.J.setTouchInterceptor(this.B);
            if (this.o) {
                i.a(this.J, this.n);
            }
            Method method = c;
            if (method != null) {
                try {
                    method.invoke(this.J, new Object[]{this.H});
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
            i.a(this.J, i(), this.i, this.j, this.p);
            this.f.setSelection(-1);
            if (!this.I || this.f.isInTouchMode()) {
                h();
            }
            if (!this.I) {
                this.F.post(this.D);
            }
        } else if (y.z(i())) {
            int i4 = this.h;
            if (i4 == -1) {
                i4 = -1;
            } else if (i4 == -2) {
                i4 = i().getWidth();
            }
            int i5 = this.g;
            if (i5 == -1) {
                if (!k2) {
                    m2 = -1;
                }
                if (k2) {
                    this.J.setWidth(this.h == -1 ? -1 : 0);
                    this.J.setHeight(0);
                } else {
                    this.J.setWidth(this.h == -1 ? -1 : 0);
                    this.J.setHeight(-1);
                }
            } else if (i5 != -2) {
                m2 = i5;
            }
            PopupWindow popupWindow = this.J;
            if (this.r || this.q) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.J.update(i(), this.i, this.j, i4 < 0 ? -1 : i4, m2 < 0 ? -1 : m2);
        }
    }

    public void h() {
        T t2 = this.f;
        if (t2 != null) {
            t2.setListSelectionHidden(true);
            t2.requestLayout();
        }
    }

    public void a(boolean z2) {
        this.I = z2;
        this.J.setFocusable(z2);
    }

    public void a(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    public void a(View view) {
        this.w = view;
    }

    public int a() {
        return this.i;
    }

    public void a(int i2) {
        this.i = i2;
    }

    public void a(Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.y = onItemClickListener;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    /* access modifiers changed from: package-private */
    public T a(Context context, boolean z2) {
        return new T(context, z2);
    }

    private int a(View view, int i2, boolean z2) {
        Method method = f575b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.J, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.J.getMaxAvailableHeight(view, i2);
    }
}
