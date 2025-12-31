package androidx.constraintlayout.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConstraintLayout f685a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e(ConstraintLayout constraintLayout, Looper looper) {
        super(looper);
        this.f685a = constraintLayout;
    }

    public void handleMessage(Message message) {
        ConstraintLayout constraintLayout = this.f685a;
        constraintLayout.a(constraintLayout.m, message.arg1, message.arg2);
    }
}
