package com.google.android.material.navigation;

import a.a.d.g;
import a.g.i.I;
import a.g.i.y;
import a.i.a.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.widget.za;
import b.c.a.a.j;
import com.google.android.material.internal.f;
import com.google.android.material.internal.i;
import com.google.android.material.internal.n;
import com.google.android.material.internal.s;

public class NavigationView extends n {
    private static final int[] d = {16842912};
    private static final int[] e = {-16842910};
    private final f f;
    private final i g;
    a h;
    private final int i;
    private MenuInflater j;

    public interface a {
        boolean a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    private ColorStateList d(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = a.a.a.a.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(a.a.a.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        return new ColorStateList(new int[][]{e, d, FrameLayout.EMPTY_STATE_SET}, new int[]{a2.getColorForState(e, defaultColor), i3, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.j == null) {
            this.j = new g(getContext());
        }
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void a(I i2) {
        this.g.a(i2);
    }

    public View b(int i2) {
        return this.g.b(i2);
    }

    public void c(int i2) {
        this.g.b(true);
        getMenuInflater().inflate(i2, this.f);
        this.g.b(false);
        this.g.a(false);
    }

    public MenuItem getCheckedItem() {
        return this.g.c();
    }

    public int getHeaderCount() {
        return this.g.d();
    }

    public Drawable getItemBackground() {
        return this.g.e();
    }

    public int getItemHorizontalPadding() {
        return this.g.f();
    }

    public int getItemIconPadding() {
        return this.g.g();
    }

    public ColorStateList getItemIconTintList() {
        return this.g.i();
    }

    public ColorStateList getItemTextColor() {
        return this.g.h();
    }

    public Menu getMenu() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.i), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.a());
        this.f.b(bVar.f1534a);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f1534a = new Bundle();
        this.f.d(bVar.f1534a);
        return bVar;
    }

    public void setCheckedItem(int i2) {
        MenuItem findItem = this.f.findItem(i2);
        if (findItem != null) {
            this.g.a((o) findItem);
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.g.a(drawable);
    }

    public void setItemBackgroundResource(int i2) {
        setItemBackground(a.g.a.a.c(getContext(), i2));
    }

    public void setItemHorizontalPadding(int i2) {
        this.g.d(i2);
    }

    public void setItemHorizontalPaddingResource(int i2) {
        this.g.d(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(int i2) {
        this.g.e(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.g.e(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(int i2) {
        this.g.f(i2);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.g.a(colorStateList);
    }

    public void setItemTextAppearance(int i2) {
        this.g.g(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.g.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.h = aVar;
    }

    public static class b extends c {
        public static final Parcelable.Creator<b> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public Bundle f1534a;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1534a = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f1534a);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.c.a.a.b.navigationViewStyle);
    }

    public View a(int i2) {
        return this.g.a(i2);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ColorStateList colorStateList;
        int i3;
        boolean z;
        this.g = new i();
        this.f = new f(context);
        za b2 = s.b(context, attributeSet, j.NavigationView, i2, b.c.a.a.i.Widget_Design_NavigationView, new int[0]);
        y.a((View) this, b2.b(j.NavigationView_android_background));
        if (b2.g(j.NavigationView_elevation)) {
            y.a((View) this, (float) b2.c(j.NavigationView_elevation, 0));
        }
        y.a((View) this, b2.a(j.NavigationView_android_fitsSystemWindows, false));
        this.i = b2.c(j.NavigationView_android_maxWidth, 0);
        if (b2.g(j.NavigationView_itemIconTint)) {
            colorStateList = b2.a(j.NavigationView_itemIconTint);
        } else {
            colorStateList = d(16842808);
        }
        if (b2.g(j.NavigationView_itemTextAppearance)) {
            i3 = b2.g(j.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            z = false;
            i3 = 0;
        }
        if (b2.g(j.NavigationView_itemIconSize)) {
            setItemIconSize(b2.c(j.NavigationView_itemIconSize, 0));
        }
        ColorStateList a2 = b2.g(j.NavigationView_itemTextColor) ? b2.a(j.NavigationView_itemTextColor) : null;
        if (!z && a2 == null) {
            a2 = d(16842806);
        }
        Drawable b3 = b2.b(j.NavigationView_itemBackground);
        if (b2.g(j.NavigationView_itemHorizontalPadding)) {
            this.g.d(b2.c(j.NavigationView_itemHorizontalPadding, 0));
        }
        int c = b2.c(j.NavigationView_itemIconPadding, 0);
        this.f.a((k.a) new a(this));
        this.g.c(1);
        this.g.a(context, (k) this.f);
        this.g.a(colorStateList);
        if (z) {
            this.g.g(i3);
        }
        this.g.b(a2);
        this.g.a(b3);
        this.g.e(c);
        this.f.a((t) this.g);
        addView((View) this.g.a((ViewGroup) this));
        if (b2.g(j.NavigationView_menu)) {
            c(b2.g(j.NavigationView_menu, 0));
        }
        if (b2.g(j.NavigationView_headerLayout)) {
            b(b2.g(j.NavigationView_headerLayout, 0));
        }
        b2.a();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.g.a((o) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
