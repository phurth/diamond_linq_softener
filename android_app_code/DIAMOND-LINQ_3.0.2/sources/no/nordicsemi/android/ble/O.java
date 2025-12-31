package no.nordicsemi.android.ble;

import java.util.LinkedList;
import java.util.Queue;
import no.nordicsemi.android.ble.N;

public class O extends P {
    private final Queue<N> o = new LinkedList();

    O() {
        super(N.a.SET);
    }

    /* access modifiers changed from: package-private */
    public N g() {
        try {
            return this.o.remove();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return !this.o.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public O a(C c) {
        super.a(c);
        return this;
    }
}
