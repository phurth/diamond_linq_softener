package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.k;

public class A extends k implements SubMenu {
    private k B;
    private o C;

    public A(Context context, k kVar, o oVar) {
        super(context);
        this.B = kVar;
        this.C = oVar;
    }

    public void a(k.a aVar) {
        this.B.a(aVar);
    }

    public boolean b(o oVar) {
        return this.B.b(oVar);
    }

    public String d() {
        o oVar = this.C;
        int itemId = oVar != null ? oVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.d() + ":" + itemId;
    }

    public MenuItem getItem() {
        return this.C;
    }

    public k m() {
        return this.B.m();
    }

    public boolean o() {
        return this.B.o();
    }

    public boolean p() {
        return this.B.p();
    }

    public boolean q() {
        return this.B.q();
    }

    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public Menu t() {
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public boolean a(k kVar, MenuItem menuItem) {
        return super.a(kVar, menuItem) || this.B.a(kVar, menuItem);
    }

    public SubMenu setHeaderIcon(int i) {
        super.d(i);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.e(i);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.C.setIcon(i);
        return this;
    }

    public boolean a(o oVar) {
        return this.B.a(oVar);
    }
}
