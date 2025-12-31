package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

class K implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f781a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f782b;
    final /* synthetic */ N c;

    K(N n, View view, ArrayList arrayList) {
        this.c = n;
        this.f781a = view;
        this.f782b = arrayList;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f781a.setVisibility(8);
        int size = this.f782b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f782b.get(i)).setVisibility(0);
        }
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
