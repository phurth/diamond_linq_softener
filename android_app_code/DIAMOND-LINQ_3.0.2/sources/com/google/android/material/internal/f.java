package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.A;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.o;

public class f extends k {
    public f(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        o oVar = (o) a(i, i2, i3, charSequence);
        j jVar = new j(e(), this, oVar);
        oVar.a((A) jVar);
        return jVar;
    }
}
