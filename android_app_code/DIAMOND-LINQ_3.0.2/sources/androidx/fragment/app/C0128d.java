package androidx.fragment.app;

import android.app.Dialog;

/* renamed from: androidx.fragment.app.d  reason: case insensitive filesystem */
class C0128d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0129e f800a;

    C0128d(C0129e eVar) {
        this.f800a = eVar;
    }

    public void run() {
        C0129e eVar = this.f800a;
        Dialog dialog = eVar.ca;
        if (dialog != null) {
            eVar.onDismiss(dialog);
        }
    }
}
