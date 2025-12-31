package com.chandlersystemsinc.signatureappcore.controllers;

import androidx.recyclerview.widget.GridLayoutManager;

class ca extends GridLayoutManager.c {
    final /* synthetic */ int e;
    final /* synthetic */ ea f;

    ca(ea eaVar, int i) {
        this.f = eaVar;
        this.e = i;
    }

    public int a(int i) {
        int i2 = da.f1379a[this.f.ca.e(i).ordinal()];
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 != 3) {
            return -1;
        }
        return this.e;
    }
}
