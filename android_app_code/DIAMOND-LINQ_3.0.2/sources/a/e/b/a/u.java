package a.e.b.a;

import a.e.b.c;
import java.util.ArrayList;

public class u extends h {
    protected ArrayList<h> ua = new ArrayList<>();

    public void E() {
        this.ua.clear();
        super.E();
    }

    public void J() {
        super.J();
        ArrayList<h> arrayList = this.ua;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.ua.get(i);
                hVar.b(h(), i());
                if (!(hVar instanceof i)) {
                    hVar.J();
                }
            }
        }
    }

    public ArrayList<h> L() {
        return this.ua;
    }

    public i M() {
        h l = l();
        i iVar = this instanceof i ? (i) this : null;
        while (l != null) {
            h l2 = l.l();
            if (l instanceof i) {
                iVar = (i) l;
            }
            l = l2;
        }
        return iVar;
    }

    public void N() {
        J();
        ArrayList<h> arrayList = this.ua;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.ua.get(i);
                if (hVar instanceof u) {
                    ((u) hVar).N();
                }
            }
        }
    }

    public void O() {
        this.ua.clear();
    }

    public void a(h hVar) {
        this.ua.add(hVar);
        if (hVar.l() != null) {
            ((u) hVar.l()).c(hVar);
        }
        hVar.b((h) this);
    }

    public void b(int i, int i2) {
        super.b(i, i2);
        int size = this.ua.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.ua.get(i3).b(p(), q());
        }
    }

    public void c(h hVar) {
        this.ua.remove(hVar);
        hVar.b((h) null);
    }

    public void a(c cVar) {
        super.a(cVar);
        int size = this.ua.size();
        for (int i = 0; i < size; i++) {
            this.ua.get(i).a(cVar);
        }
    }
}
