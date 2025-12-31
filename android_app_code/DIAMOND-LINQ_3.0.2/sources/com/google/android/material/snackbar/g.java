package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Message;
import com.google.android.material.snackbar.h;

class g implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1541a;

    g(h hVar) {
        this.f1541a = hVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        this.f1541a.a((h.b) message.obj);
        return true;
    }
}
