package androidx.appcompat.view.menu;

import a.a.a;
import a.a.f;
import a.a.g;
import a.a.j;
import a.g.i.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.widget.za;

public class ListMenuItemView extends LinearLayout implements u.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    private o f446a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f447b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private Drawable j;
    private int k;
    private Context l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private int p;
    private LayoutInflater q;
    private boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.listMenuViewStyle);
    }

    private void b() {
        this.e = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, this, false);
        a(this.e);
    }

    private void c() {
        this.f447b = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, this, false);
        a((View) this.f447b, 0);
    }

    private void d() {
        this.c = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, this, false);
        a(this.c);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void a(o oVar, int i2) {
        this.f446a = oVar;
        this.p = i2;
        setVisibility(oVar.isVisible() ? 0 : 8);
        setTitle(oVar.a((u.a) this));
        setCheckable(oVar.isCheckable());
        a(oVar.m(), oVar.d());
        setIcon(oVar.getIcon());
        setEnabled(oVar.isEnabled());
        setSubMenuArrowVisible(oVar.hasSubMenu());
        setContentDescription(oVar.getContentDescription());
    }

    public boolean a() {
        return false;
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            rect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public o getItemData() {
        return this.f446a;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        y.a((View) this, this.j);
        this.d = (TextView) findViewById(f.title);
        int i2 = this.k;
        if (i2 != -1) {
            this.d.setTextAppearance(this.l, i2);
        }
        this.f = (TextView) findViewById(f.shortcut);
        this.g = (ImageView) findViewById(f.submenuarrow);
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.h = (ImageView) findViewById(f.group_divider);
        this.i = (LinearLayout) findViewById(f.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f447b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f447b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.c != null || this.e != null) {
            if (this.f446a.i()) {
                if (this.c == null) {
                    d();
                }
                compoundButton2 = this.c;
                compoundButton = this.e;
            } else {
                if (this.e == null) {
                    b();
                }
                compoundButton2 = this.e;
                compoundButton = this.c;
            }
            if (z) {
                compoundButton2.setChecked(this.f446a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f446a.i()) {
            if (this.c == null) {
                d();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                b();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f446a.l() || this.r;
        if (!z && !this.m) {
            return;
        }
        if (this.f447b != null || drawable != null || this.m) {
            if (this.f447b == null) {
                c();
            }
            if (drawable != null || this.m) {
                ImageView imageView = this.f447b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f447b.getVisibility() != 0) {
                    this.f447b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f447b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        za a2 = za.a(getContext(), attributeSet, j.MenuView, i2, 0);
        this.j = a2.b(j.MenuView_android_itemBackground);
        this.k = a2.g(j.MenuView_android_itemTextAppearance, -1);
        this.m = a2.a(j.MenuView_preserveIconSpacing, false);
        this.l = context;
        this.n = a2.b(j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, a.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        a2.a();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i2) {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void a(boolean z, char c2) {
        int i2 = (!z || !this.f446a.m()) ? 8 : 0;
        if (i2 == 0) {
            this.f.setText(this.f446a.e());
        }
        if (this.f.getVisibility() != i2) {
            this.f.setVisibility(i2);
        }
    }
}
