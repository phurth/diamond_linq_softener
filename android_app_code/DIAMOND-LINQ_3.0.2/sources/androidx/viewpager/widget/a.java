package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f1038a = new DataSetObservable();

    /* renamed from: b  reason: collision with root package name */
    private DataSetObserver f1039b;

    public float a(int i) {
        return 1.0f;
    }

    public abstract int a();

    public int a(Object obj) {
        return -1;
    }

    public abstract Object a(ViewGroup viewGroup, int i);

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public void a(View view) {
    }

    @Deprecated
    public void a(View view, int i, Object obj) {
    }

    public void a(ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public abstract void a(ViewGroup viewGroup, int i, Object obj);

    public abstract boolean a(View view, Object obj);

    public Parcelable b() {
        return null;
    }

    @Deprecated
    public void b(View view) {
    }

    public void b(ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    /* access modifiers changed from: package-private */
    public void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f1039b = dataSetObserver;
        }
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        a((View) viewGroup, i, obj);
    }
}
