package a.e.b.a;

import a.e.b.a.f;
import java.util.ArrayList;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private int f100a;

    /* renamed from: b  reason: collision with root package name */
    private int f101b;
    private int c;
    private int d;
    private ArrayList<a> e = new ArrayList<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private f f102a;

        /* renamed from: b  reason: collision with root package name */
        private f f103b;
        private int c;
        private f.b d;
        private int e;

        public a(f fVar) {
            this.f102a = fVar;
            this.f103b = fVar.g();
            this.c = fVar.b();
            this.d = fVar.f();
            this.e = fVar.a();
        }

        public void a(h hVar) {
            hVar.a(this.f102a.h()).a(this.f103b, this.c, this.d, this.e);
        }

        public void b(h hVar) {
            this.f102a = hVar.a(this.f102a.h());
            f fVar = this.f102a;
            if (fVar != null) {
                this.f103b = fVar.g();
                this.c = this.f102a.b();
                this.d = this.f102a.f();
                this.e = this.f102a.a();
                return;
            }
            this.f103b = null;
            this.c = 0;
            this.d = f.b.STRONG;
            this.e = 0;
        }
    }

    public t(h hVar) {
        this.f100a = hVar.w();
        this.f101b = hVar.x();
        this.c = hVar.t();
        this.d = hVar.j();
        ArrayList<f> c2 = hVar.c();
        int size = c2.size();
        for (int i = 0; i < size; i++) {
            this.e.add(new a(c2.get(i)));
        }
    }

    public void a(h hVar) {
        hVar.t(this.f100a);
        hVar.u(this.f101b);
        hVar.q(this.c);
        hVar.i(this.d);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a(hVar);
        }
    }

    public void b(h hVar) {
        this.f100a = hVar.w();
        this.f101b = hVar.x();
        this.c = hVar.t();
        this.d = hVar.j();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).b(hVar);
        }
    }
}
