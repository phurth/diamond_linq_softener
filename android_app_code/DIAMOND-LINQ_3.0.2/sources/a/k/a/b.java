package a.k.a;

import a.d.j;
import a.k.b.a;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.A;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.l;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class b extends a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f256a = false;

    /* renamed from: b  reason: collision with root package name */
    private final l f257b;
    private final c c;

    /* renamed from: a.k.a.b$b  reason: collision with other inner class name */
    static class C0013b<D> implements t<D> {
    }

    static class c extends A {
        private static final B.b c = new c();
        private j<a> d = new j<>();
        private boolean e = false;

        c() {
        }

        static c a(D d2) {
            return (c) new B(d2, c).a(c.class);
        }

        /* access modifiers changed from: protected */
        public void b() {
            super.b();
            if (this.d.b() <= 0) {
                this.d.a();
            } else {
                this.d.e(0).a(true);
                throw null;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            int b2 = this.d.b();
            for (int i = 0; i < b2; i++) {
                this.d.e(i).c();
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.d.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.d.b() > 0) {
                    a e2 = this.d.e(0);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.d.c(0));
                    printWriter.print(": ");
                    printWriter.println(e2.toString());
                    e2.a(str2, fileDescriptor, printWriter, strArr);
                    throw null;
                }
            }
        }
    }

    b(l lVar, D d) {
        this.f257b = lVar;
        this.c = c.a(d);
    }

    public void a() {
        this.c.c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a.g.h.a.a(this.f257b, sb);
        sb.append("}}");
        return sb.toString();
    }

    public static class a<D> extends s<D> implements a.C0014a<D> {
        private final int k;
        private final Bundle l;
        private final a.k.b.a<D> m;
        private l n;
        private C0013b<D> o;
        private a.k.b.a<D> p;

        /* access modifiers changed from: protected */
        public void a() {
            if (b.f256a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.c();
            throw null;
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (b.f256a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.d();
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            l lVar = this.n;
            C0013b<D> bVar = this.o;
            if (lVar != null && bVar != null) {
                super.a(bVar);
                a(lVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            a.g.h.a.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(t<? super D> tVar) {
            super.a(tVar);
            this.n = null;
            this.o = null;
        }

        /* access modifiers changed from: package-private */
        public a.k.b.a<D> a(boolean z) {
            if (b.f256a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.a();
            throw null;
        }

        public void a(D d) {
            super.a(d);
            a.k.b.a<D> aVar = this.p;
            if (aVar != null) {
                aVar.b();
                throw null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.k);
            printWriter.print(" mArgs=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            a.k.b.a<D> aVar = this.m;
            aVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            throw null;
        }
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }
}
