package a.e.b.a;

import java.util.HashSet;
import java.util.Iterator;

public class s {

    /* renamed from: a  reason: collision with root package name */
    HashSet<s> f98a = new HashSet<>(2);

    /* renamed from: b  reason: collision with root package name */
    int f99b = 0;

    public void a(s sVar) {
        this.f98a.add(sVar);
    }

    public void b() {
        this.f99b = 0;
        Iterator<s> it = this.f98a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public boolean c() {
        return this.f99b == 1;
    }

    public void d() {
        this.f99b = 0;
        this.f98a.clear();
    }

    public void e() {
    }

    public void a() {
        this.f99b = 1;
        Iterator<s> it = this.f98a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }
}
