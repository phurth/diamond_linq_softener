package androidx.appcompat.widget;

import a.g.i.t;
import a.g.i.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.C0082l;

public class E extends Spinner implements t {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f504a = {16843505};

    /* renamed from: b  reason: collision with root package name */
    private final C0105k f505b;
    private final Context c;
    private V d;
    private SpinnerAdapter e;
    private final boolean f;
    private e g;
    int h;
    final Rect i;

    class a implements e, DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        C0082l f506a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f507b;
        private CharSequence c;

        a() {
        }

        public int a() {
            return 0;
        }

        public void a(ListAdapter listAdapter) {
            this.f507b = listAdapter;
        }

        public CharSequence b() {
            return this.c;
        }

        public boolean c() {
            C0082l lVar = this.f506a;
            if (lVar != null) {
                return lVar.isShowing();
            }
            return false;
        }

        public void dismiss() {
            C0082l lVar = this.f506a;
            if (lVar != null) {
                lVar.dismiss();
                this.f506a = null;
            }
        }

        public Drawable e() {
            return null;
        }

        public int g() {
            return 0;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            E.this.setSelection(i);
            if (E.this.getOnItemClickListener() != null) {
                E.this.performItemClick((View) null, i, this.f507b.getItemId(i));
            }
            dismiss();
        }

        public void a(CharSequence charSequence) {
            this.c = charSequence;
        }

        public void b(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void a(int i, int i2) {
            if (this.f507b != null) {
                C0082l.a aVar = new C0082l.a(E.this.getPopupContext());
                CharSequence charSequence = this.c;
                if (charSequence != null) {
                    aVar.b(charSequence);
                }
                aVar.a(this.f507b, E.this.getSelectedItemPosition(), this);
                this.f506a = aVar.a();
                ListView b2 = this.f506a.b();
                if (Build.VERSION.SDK_INT >= 17) {
                    b2.setTextDirection(i);
                    b2.setTextAlignment(i2);
                }
                this.f506a.show();
            }
        }

        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void a(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }
    }

    private static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f508a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f509b;

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f508a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f509b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof va) {
                va vaVar = (va) spinnerAdapter;
                if (vaVar.getDropDownViewTheme() == null) {
                    vaVar.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f509b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f508a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f508a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f508a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f508a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f508a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f509b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f508a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f508a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class c extends Z implements e {
        private CharSequence K;
        ListAdapter L;
        private final Rect M = new Rect();

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            a((View) E.this);
            a(true);
            g(0);
            a((AdapterView.OnItemClickListener) new F(this, E.this));
        }

        public CharSequence b() {
            return this.K;
        }

        /* access modifiers changed from: package-private */
        public void m() {
            Drawable e = e();
            int i = 0;
            if (e != null) {
                e.getPadding(E.this.i);
                i = Na.a(E.this) ? E.this.i.right : -E.this.i.left;
            } else {
                Rect rect = E.this.i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = E.this.getPaddingLeft();
            int paddingRight = E.this.getPaddingRight();
            int width = E.this.getWidth();
            E e2 = E.this;
            int i2 = e2.h;
            if (i2 == -2) {
                int a2 = e2.a((SpinnerAdapter) this.L, e());
                int i3 = E.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = E.this.i;
                int i4 = (i3 - rect2.left) - rect2.right;
                if (a2 > i4) {
                    a2 = i4;
                }
                d(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i2 == -1) {
                d((width - paddingLeft) - paddingRight);
            } else {
                d(i2);
            }
            a(Na.a(E.this) ? i + ((width - paddingRight) - j()) : i + paddingLeft);
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.L = listAdapter;
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view) {
            return y.z(view) && view.getGlobalVisibleRect(this.M);
        }

        public void a(CharSequence charSequence) {
            this.K = charSequence;
        }

        public void a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean c = c();
            m();
            f(2);
            super.d();
            ListView f = f();
            f.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                f.setTextDirection(i);
                f.setTextAlignment(i2);
            }
            h(E.this.getSelectedItemPosition());
            if (!c && (viewTreeObserver = E.this.getViewTreeObserver()) != null) {
                G g = new G(this);
                viewTreeObserver.addOnGlobalLayoutListener(g);
                a((PopupWindow.OnDismissListener) new H(this, g));
            }
        }
    }

    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new I();

        /* renamed from: a  reason: collision with root package name */
        boolean f510a;

        d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f510a ? (byte) 1 : 0);
        }

        d(Parcel parcel) {
            super(parcel);
            this.f510a = parcel.readByte() != 0;
        }
    }

    interface e {
        int a();

        void a(int i);

        void a(int i, int i2);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        CharSequence b();

        void b(int i);

        boolean c();

        void dismiss();

        Drawable e();

        int g();
    }

    public E(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.a.spinnerStyle);
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.i);
        Rect rect = this.i;
        return i3 + rect.left + rect.right;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f505b;
        if (kVar != null) {
            kVar.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        e eVar = this.g;
        if (eVar != null) {
            return eVar.a();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        e eVar = this.g;
        if (eVar != null) {
            return eVar.g();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.g != null) {
            return this.h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final e getInternalPopup() {
        return this.g;
    }

    public Drawable getPopupBackground() {
        e eVar = this.g;
        if (eVar != null) {
            return eVar.e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.c;
    }

    public CharSequence getPrompt() {
        e eVar = this.g;
        return eVar != null ? eVar.b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f505b;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f505b;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e eVar = this.g;
        if (eVar != null && eVar.c()) {
            this.g.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.g != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        if (dVar.f510a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new D(this));
        }
    }

    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        e eVar = this.g;
        dVar.f510a = eVar != null && eVar.c();
        return dVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        V v = this.d;
        if (v == null || !v.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        e eVar = this.g;
        if (eVar == null) {
            return super.performClick();
        }
        if (eVar.c()) {
            return true;
        }
        a();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0105k kVar = this.f505b;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0105k kVar = this.f505b;
        if (kVar != null) {
            kVar.a(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.a(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    public void setDropDownVerticalOffset(int i2) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.b(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.g != null) {
            this.h = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(a.a.a.a.a.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f505b;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f505b;
        if (kVar != null) {
            kVar.a(mode);
        }
    }

    public E(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f) {
            this.e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.g != null) {
            Context context = this.c;
            if (context == null) {
                context = getContext();
            }
            this.g.a((ListAdapter) new b(spinnerAdapter, context.getTheme()));
        }
    }

    public E(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r11 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r11 != null) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.i = r0
            int[] r0 = a.a.j.Spinner
            r1 = 0
            androidx.appcompat.widget.za r0 = androidx.appcompat.widget.za.a(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.k r2 = new androidx.appcompat.widget.k
            r2.<init>(r6)
            r6.f505b = r2
            if (r11 == 0) goto L_0x0022
            a.a.d.d r2 = new a.a.d.d
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
            r6.c = r2
            goto L_0x0034
        L_0x0022:
            int r11 = a.a.j.Spinner_popupTheme
            int r11 = r0.g(r11, r1)
            if (r11 == 0) goto L_0x0032
            a.a.d.d r2 = new a.a.d.d
            r2.<init>((android.content.Context) r7, (int) r11)
            r6.c = r2
            goto L_0x0034
        L_0x0032:
            r6.c = r7
        L_0x0034:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x0066
            int[] r11 = f504a     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x004e }
            if (r3 == 0) goto L_0x0048
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x004e }
        L_0x0048:
            if (r11 == 0) goto L_0x0066
        L_0x004a:
            r11.recycle()
            goto L_0x0066
        L_0x004e:
            r3 = move-exception
            goto L_0x0055
        L_0x0050:
            r7 = move-exception
            r11 = r2
            goto L_0x0060
        L_0x0053:
            r3 = move-exception
            r11 = r2
        L_0x0055:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x005f }
            if (r11 == 0) goto L_0x0066
            goto L_0x004a
        L_0x005f:
            r7 = move-exception
        L_0x0060:
            if (r11 == 0) goto L_0x0065
            r11.recycle()
        L_0x0065:
            throw r7
        L_0x0066:
            r11 = 1
            if (r10 == 0) goto L_0x00a3
            if (r10 == r11) goto L_0x006c
            goto L_0x00b5
        L_0x006c:
            androidx.appcompat.widget.E$c r10 = new androidx.appcompat.widget.E$c
            android.content.Context r3 = r6.c
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.c
            int[] r4 = a.a.j.Spinner
            androidx.appcompat.widget.za r1 = androidx.appcompat.widget.za.a(r3, r8, r4, r9, r1)
            int r3 = a.a.j.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.f(r3, r4)
            r6.h = r3
            int r3 = a.a.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.b(r3)
            r10.a((android.graphics.drawable.Drawable) r3)
            int r3 = a.a.j.Spinner_android_prompt
            java.lang.String r3 = r0.d(r3)
            r10.a((java.lang.CharSequence) r3)
            r1.a()
            r6.g = r10
            androidx.appcompat.widget.C r1 = new androidx.appcompat.widget.C
            r1.<init>(r6, r6, r10)
            r6.d = r1
            goto L_0x00b5
        L_0x00a3:
            androidx.appcompat.widget.E$a r10 = new androidx.appcompat.widget.E$a
            r10.<init>()
            r6.g = r10
            androidx.appcompat.widget.E$e r10 = r6.g
            int r1 = a.a.j.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r10.a((java.lang.CharSequence) r1)
        L_0x00b5:
            int r10 = a.a.j.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.f(r10)
            if (r10 == 0) goto L_0x00cd
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = a.a.g.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00cd:
            r0.a()
            r6.f = r11
            android.widget.SpinnerAdapter r7 = r6.e
            if (r7 == 0) goto L_0x00db
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.e = r2
        L_0x00db:
            androidx.appcompat.widget.k r7 = r6.f505b
            r7.a(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.E.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.g.a(getTextDirection(), getTextAlignment());
        } else {
            this.g.a(-1, -1);
        }
    }
}
