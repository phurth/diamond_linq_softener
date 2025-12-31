package com.chandlersystemsinc.signatureappcore.controllers;

import androidx.recyclerview.widget.GridLayoutManager;

class ta extends GridLayoutManager.c {
    final /* synthetic */ int e;
    final /* synthetic */ va f;

    ta(va vaVar, int i) {
        this.f = vaVar;
        this.e = i;
    }

    public int a(int i) {
        int i2 = ua.f1413a[this.f.da.e(i).ordinal()];
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 != 3) {
            return -1;
        }
        return this.e;
    }
}
