package b.a.a.c;

import b.a.a.ia;
import no.nordicsemi.android.log.BuildConfig;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private final v f1113a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1114b;
    private final byte[] c;

    public t(v vVar, int i, byte[] bArr) {
        this.f1113a = vVar;
        this.f1114b = i;
        this.c = bArr;
    }

    public int a() {
        return this.f1114b;
    }

    public byte[] b() {
        return this.c;
    }

    public v c() {
        return this.f1113a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nType: ");
        sb.append(this.f1113a);
        sb.append("\nLength: ");
        sb.append(this.f1114b);
        sb.append("\nPayload: ");
        byte[] bArr = this.c;
        sb.append((bArr == null || this.f1114b == 0) ? BuildConfig.FLAVOR : ia.a((String) null, bArr, bArr.length));
        return sb.toString();
    }
}
