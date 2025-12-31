package com.google.android.material.internal;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.t;

class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1513a;

    h(i iVar) {
        this.f1513a = iVar;
    }

    public void onClick(View view) {
        boolean z = true;
        this.f1513a.b(true);
        o itemData = ((NavigationMenuItemView) view).getItemData();
        i iVar = this.f1513a;
        boolean a2 = iVar.d.a((MenuItem) itemData, (t) iVar, 0);
        if (itemData == null || !itemData.isCheckable() || !a2) {
            z = false;
        } else {
            this.f1513a.f.a(itemData);
        }
        this.f1513a.b(false);
        if (z) {
            this.f1513a.a(false);
        }
    }
}
