package androidx.fragment.app;

import a.g.h.b;
import android.util.Log;
import androidx.fragment.app.C0132h;
import androidx.fragment.app.C0139o;
import androidx.fragment.app.w;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a  reason: case insensitive filesystem */
final class C0125a extends D implements C0139o.a, w.h {

    /* renamed from: a  reason: collision with root package name */
    final w f794a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<C0025a> f795b = new ArrayList<>();
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j = true;
    String k;
    boolean l;
    int m = -1;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    boolean t = false;
    ArrayList<Runnable> u;

    /* renamed from: androidx.fragment.app.a$a  reason: collision with other inner class name */
    static final class C0025a {

        /* renamed from: a  reason: collision with root package name */
        int f796a;

        /* renamed from: b  reason: collision with root package name */
        C0132h f797b;
        int c;
        int d;
        int e;
        int f;

        C0025a() {
        }

        C0025a(int i, C0132h hVar) {
            this.f796a = i;
            this.f797b = hVar;
        }
    }

    public C0125a(w wVar) {
        this.f794a = wVar;
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public int b() {
        return a(true);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int size = this.f795b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0025a aVar = this.f795b.get(i2);
            C0132h hVar = aVar.f797b;
            if (hVar != null) {
                hVar.a(this.g, this.h);
            }
            switch (aVar.f796a) {
                case 1:
                    hVar.c(aVar.c);
                    this.f794a.a(hVar, false);
                    break;
                case 3:
                    hVar.c(aVar.d);
                    this.f794a.n(hVar);
                    break;
                case 4:
                    hVar.c(aVar.d);
                    this.f794a.h(hVar);
                    break;
                case 5:
                    hVar.c(aVar.c);
                    this.f794a.s(hVar);
                    break;
                case 6:
                    hVar.c(aVar.d);
                    this.f794a.d(hVar);
                    break;
                case 7:
                    hVar.c(aVar.c);
                    this.f794a.b(hVar);
                    break;
                case 8:
                    this.f794a.r(hVar);
                    break;
                case 9:
                    this.f794a.r((C0132h) null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f796a);
            }
            if (!(this.t || aVar.f796a == 1 || hVar == null)) {
                this.f794a.k(hVar);
            }
        }
        if (!this.t) {
            w wVar = this.f794a;
            wVar.a(wVar.r, true);
        }
    }

    public String d() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        for (int i2 = 0; i2 < this.f795b.size(); i2++) {
            if (b(this.f795b.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        ArrayList<Runnable> arrayList = this.u;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.u.get(i2).run();
            }
            this.u = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.c == 0 && this.d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (!(this.e == 0 && this.f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (!(this.n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (!(this.p == 0 && this.q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (!this.f795b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f795b.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0025a aVar = this.f795b.get(i2);
                switch (aVar.f796a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f796a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f797b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        int size = this.f795b.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0132h hVar = this.f795b.get(i3).f797b;
            int i4 = hVar != null ? hVar.w : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.f795b.size() - 1; size >= 0; size--) {
            C0025a aVar = this.f795b.get(size);
            C0132h hVar = aVar.f797b;
            if (hVar != null) {
                hVar.a(w.d(this.g), this.h);
            }
            switch (aVar.f796a) {
                case 1:
                    hVar.c(aVar.f);
                    this.f794a.n(hVar);
                    break;
                case 3:
                    hVar.c(aVar.e);
                    this.f794a.a(hVar, false);
                    break;
                case 4:
                    hVar.c(aVar.e);
                    this.f794a.s(hVar);
                    break;
                case 5:
                    hVar.c(aVar.f);
                    this.f794a.h(hVar);
                    break;
                case 6:
                    hVar.c(aVar.e);
                    this.f794a.b(hVar);
                    break;
                case 7:
                    hVar.c(aVar.f);
                    this.f794a.d(hVar);
                    break;
                case 8:
                    this.f794a.r((C0132h) null);
                    break;
                case 9:
                    this.f794a.r(hVar);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f796a);
            }
            if (!(this.t || aVar.f796a == 3 || hVar == null)) {
                this.f794a.k(hVar);
            }
        }
        if (!this.t && z) {
            w wVar = this.f794a;
            wVar.a(wVar.r, true);
        }
    }

    /* access modifiers changed from: package-private */
    public C0132h b(ArrayList<C0132h> arrayList, C0132h hVar) {
        for (int size = this.f795b.size() - 1; size >= 0; size--) {
            C0025a aVar = this.f795b.get(size);
            int i2 = aVar.f796a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            hVar = null;
                            break;
                        case 9:
                            hVar = aVar.f797b;
                            break;
                    }
                }
                arrayList.add(aVar.f797b);
            }
            arrayList.remove(aVar.f797b);
        }
        return hVar;
    }

    private static boolean b(C0025a aVar) {
        C0132h hVar = aVar.f797b;
        return hVar != null && hVar.k && hVar.G != null && !hVar.z && !hVar.y && hVar.I();
    }

    /* access modifiers changed from: package-private */
    public void a(C0025a aVar) {
        this.f795b.add(aVar);
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
    }

    public D a(C0132h hVar, String str) {
        a(0, hVar, str, 1);
        return this;
    }

    private void a(int i2, C0132h hVar, String str, int i3) {
        Class<?> cls = hVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        hVar.r = this.f794a;
        if (str != null) {
            String str2 = hVar.x;
            if (str2 == null || str.equals(str2)) {
                hVar.x = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + hVar + ": was " + hVar.x + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = hVar.v;
                if (i4 == 0 || i4 == i2) {
                    hVar.v = i2;
                    hVar.w = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + hVar + ": was " + hVar.v + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + hVar + " with tag " + str + " to container view with no id");
            }
        }
        a(new C0025a(i3, hVar));
    }

    public D a(int i2, C0132h hVar) {
        a(i2, hVar, (String) null);
        return this;
    }

    public D a(int i2, C0132h hVar, String str) {
        if (i2 != 0) {
            a(i2, hVar, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public D a(C0132h hVar) {
        w wVar = hVar.r;
        if (wVar == null || wVar == this.f794a) {
            a(new C0025a(3, hVar));
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + hVar.toString() + " is already attached to a FragmentManager.");
    }

    public D a(String str) {
        if (this.j) {
            this.i = true;
            this.k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.i) {
            if (w.c) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f795b.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0025a aVar = this.f795b.get(i3);
                C0132h hVar = aVar.f797b;
                if (hVar != null) {
                    hVar.q += i2;
                    if (w.c) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f797b + " to " + aVar.f797b.q);
                    }
                }
            }
        }
    }

    public int a() {
        return a(false);
    }

    /* access modifiers changed from: package-private */
    public int a(boolean z) {
        if (!this.l) {
            if (w.c) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new b("FragmentManager"));
                a("  ", printWriter);
                printWriter.close();
            }
            this.l = true;
            if (this.i) {
                this.m = this.f794a.b(this);
            } else {
                this.m = -1;
            }
            this.f794a.a((w.h) this, z);
            return this.m;
        }
        throw new IllegalStateException("commit already called");
    }

    public boolean a(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2) {
        if (w.c) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.i) {
            return true;
        }
        this.f794a.a(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<C0125a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f795b.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            C0132h hVar = this.f795b.get(i5).f797b;
            int i6 = hVar != null ? hVar.w : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    C0125a aVar = arrayList.get(i7);
                    int size2 = aVar.f795b.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        C0132h hVar2 = aVar.f795b.get(i8).f797b;
                        if ((hVar2 != null ? hVar2.w : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public C0132h a(ArrayList<C0132h> arrayList, C0132h hVar) {
        ArrayList<C0132h> arrayList2 = arrayList;
        C0132h hVar2 = hVar;
        int i2 = 0;
        while (i2 < this.f795b.size()) {
            C0025a aVar = this.f795b.get(i2);
            int i3 = aVar.f796a;
            if (i3 != 1) {
                if (i3 == 2) {
                    C0132h hVar3 = aVar.f797b;
                    int i4 = hVar3.w;
                    C0132h hVar4 = hVar2;
                    int i5 = i2;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        C0132h hVar5 = arrayList2.get(size);
                        if (hVar5.w == i4) {
                            if (hVar5 == hVar3) {
                                z = true;
                            } else {
                                if (hVar5 == hVar4) {
                                    this.f795b.add(i5, new C0025a(9, hVar5));
                                    i5++;
                                    hVar4 = null;
                                }
                                C0025a aVar2 = new C0025a(3, hVar5);
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.f795b.add(i5, aVar2);
                                arrayList2.remove(hVar5);
                                i5++;
                            }
                        }
                    }
                    if (z) {
                        this.f795b.remove(i5);
                        i5--;
                    } else {
                        aVar.f796a = 1;
                        arrayList2.add(hVar3);
                    }
                    i2 = i5;
                    hVar2 = hVar4;
                } else if (i3 == 3 || i3 == 6) {
                    arrayList2.remove(aVar.f797b);
                    C0132h hVar6 = aVar.f797b;
                    if (hVar6 == hVar2) {
                        this.f795b.add(i2, new C0025a(9, hVar6));
                        i2++;
                        hVar2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f795b.add(i2, new C0025a(9, hVar2));
                        i2++;
                        hVar2 = aVar.f797b;
                    }
                }
                i2++;
            }
            arrayList2.add(aVar.f797b);
            i2++;
        }
        return hVar2;
    }

    /* access modifiers changed from: package-private */
    public void a(C0132h.c cVar) {
        for (int i2 = 0; i2 < this.f795b.size(); i2++) {
            C0025a aVar = this.f795b.get(i2);
            if (b(aVar)) {
                aVar.f797b.a(cVar);
            }
        }
    }
}
