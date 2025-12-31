package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.f  reason: case insensitive filesystem */
class C0095f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f595a;

    C0095f(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f595a = actionBarOverlayLayout;
    }

    public void run() {
        this.f595a.h();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f595a;
        actionBarOverlayLayout.x = actionBarOverlayLayout.e.animate().translationY((float) (-this.f595a.e.getHeight())).setListener(this.f595a.y);
    }
}
