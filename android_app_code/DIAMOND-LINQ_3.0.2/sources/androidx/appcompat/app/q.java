package androidx.appcompat.app;

class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f425a;

    q(x xVar) {
        this.f425a = xVar;
    }

    public void run() {
        x xVar = this.f425a;
        if ((xVar.V & 1) != 0) {
            xVar.f(0);
        }
        x xVar2 = this.f425a;
        if ((xVar2.V & 4096) != 0) {
            xVar2.f(108);
        }
        x xVar3 = this.f425a;
        xVar3.U = false;
        xVar3.V = 0;
    }
}
