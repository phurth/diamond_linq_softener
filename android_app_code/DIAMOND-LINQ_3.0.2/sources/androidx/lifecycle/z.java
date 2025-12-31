package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.h;

public class z extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private a f883a;

    interface a {
        void a();

        void b();

        void onCreate();
    }

    static z a(Activity activity) {
        return (z) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new z(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f883a);
        a(h.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        a(h.a.ON_DESTROY);
        this.f883a = null;
    }

    public void onPause() {
        super.onPause();
        a(h.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        c(this.f883a);
        a(h.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        d(this.f883a);
        a(h.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        a(h.a.ON_STOP);
    }

    private void a(h.a aVar) {
        Activity activity = getActivity();
        if (activity instanceof o) {
            ((o) activity).a().b(aVar);
        } else if (activity instanceof l) {
            h a2 = ((l) activity).a();
            if (a2 instanceof n) {
                ((n) a2).b(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.onCreate();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f883a = aVar;
    }
}
