package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.e  reason: case insensitive filesystem */
class C0093e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f592a;

    C0093e(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f592a = actionBarOverlayLayout;
    }

    public void run() {
        this.f592a.h();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f592a;
        actionBarOverlayLayout.x = actionBarOverlayLayout.e.animate().translationY(0.0f).setListener(this.f592a.y);
    }
}
