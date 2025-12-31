package b.a.a.b;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.Da;
import b.a.a.K;
import b.a.a.L;
import b.a.a.d.d;
import java.util.List;

public final class b extends RecyclerView.a<L> {
    private final d c;
    private final List<K> d;

    public b(List<K> list, d dVar) {
        this.d = list;
        this.c = dVar;
    }

    /* renamed from: a */
    public void b(L l, int i) {
        K k = this.d.get(i);
        l.a(k.b());
        l.a(k.a());
    }

    public L b(ViewGroup viewGroup, int i) {
        return new L(LayoutInflater.from(viewGroup.getContext()).inflate(Da.device_option, viewGroup, false), this.c);
    }

    public int a() {
        return this.d.size();
    }
}
