package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.k;
import com.google.android.material.navigation.NavigationView;

class a implements k.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NavigationView f1535a;

    a(NavigationView navigationView) {
        this.f1535a = navigationView;
    }

    public void a(k kVar) {
    }

    public boolean a(k kVar, MenuItem menuItem) {
        NavigationView.a aVar = this.f1535a.h;
        return aVar != null && aVar.a(menuItem);
    }
}
