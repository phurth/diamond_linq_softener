package a.g.f;

import a.g.h.g;
import android.util.Base64;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f145a;

    /* renamed from: b  reason: collision with root package name */
    private final String f146b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e = 0;
    private final String f = (this.f145a + "-" + this.f146b + "-" + this.c);

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        g.a(str);
        this.f145a = str;
        g.a(str2);
        this.f146b = str2;
        g.a(str3);
        this.c = str3;
        g.a(list);
        this.d = list;
    }

    public List<List<byte[]>> a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.f145a;
    }

    public String e() {
        return this.f146b;
    }

    public String f() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f145a + ", mProviderPackage: " + this.f146b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
