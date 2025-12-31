package b.c.a.a.p;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import b.c.a.a.j;
import java.util.LinkedHashSet;
import java.util.Set;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private a f1326a;

    /* renamed from: b  reason: collision with root package name */
    private a f1327b;
    private a c;
    private a d;
    private c e;
    private c f;
    private c g;
    private c h;
    private final Set<a> i;

    public interface a {
        void b();
    }

    public h() {
        this.i = new LinkedHashSet();
        c(f.a());
        d(f.a());
        b(f.a());
        a(f.a());
        b(f.b());
        d(f.b());
        c(f.b());
        a(f.b());
        j();
    }

    private boolean b(float f2) {
        a aVar = this.d;
        if (aVar.f1320a == f2) {
            return false;
        }
        aVar.f1320a = f2;
        return true;
    }

    private boolean c(float f2) {
        a aVar = this.c;
        if (aVar.f1320a == f2) {
            return false;
        }
        aVar.f1320a = f2;
        return true;
    }

    private boolean d(float f2) {
        a aVar = this.f1326a;
        if (aVar.f1320a == f2) {
            return false;
        }
        aVar.f1320a = f2;
        return true;
    }

    private boolean e(float f2) {
        a aVar = this.f1327b;
        if (aVar.f1320a == f2) {
            return false;
        }
        aVar.f1320a = f2;
        return true;
    }

    private void j() {
        for (a next : this.i) {
            if (next != null) {
                next.b();
            }
        }
    }

    public void a(float f2) {
        a(f2, f2, f2, f2);
    }

    public c f() {
        return this.e;
    }

    public a g() {
        return this.f1326a;
    }

    public a h() {
        return this.f1327b;
    }

    public boolean i() {
        boolean z = this.h.getClass().equals(c.class) && this.f.getClass().equals(c.class) && this.e.getClass().equals(c.class) && this.g.getClass().equals(c.class);
        float a2 = this.f1326a.a();
        boolean z2 = this.f1327b.a() == a2 && this.d.a() == a2 && this.c.a() == a2;
        boolean z3 = (this.f1327b instanceof g) && (this.f1326a instanceof g) && (this.c instanceof g) && (this.d instanceof g);
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }

    public void a(float f2, float f3, float f4, float f5) {
        if ((d(f2) | e(f3) | c(f4)) || b(f5)) {
            j();
        }
    }

    private boolean b(a aVar) {
        if (this.c == aVar) {
            return false;
        }
        this.c = aVar;
        return true;
    }

    private boolean c(a aVar) {
        if (this.f1326a == aVar) {
            return false;
        }
        this.f1326a = aVar;
        return true;
    }

    private boolean d(a aVar) {
        if (this.f1327b == aVar) {
            return false;
        }
        this.f1327b = aVar;
        return true;
    }

    public c e() {
        return this.f;
    }

    public a b() {
        return this.d;
    }

    public a c() {
        return this.c;
    }

    public c d() {
        return this.h;
    }

    private boolean b(c cVar) {
        if (this.h == cVar) {
            return false;
        }
        this.h = cVar;
        return true;
    }

    private boolean c(c cVar) {
        if (this.f == cVar) {
            return false;
        }
        this.f = cVar;
        return true;
    }

    private boolean d(c cVar) {
        if (this.e == cVar) {
            return false;
        }
        this.e = cVar;
        return true;
    }

    private boolean a(a aVar) {
        if (this.d == aVar) {
            return false;
        }
        this.d = aVar;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.i.remove(aVar);
    }

    private boolean a(c cVar) {
        if (this.g == cVar) {
            return false;
        }
        this.g = cVar;
        return true;
    }

    public c a() {
        return this.g;
    }

    public h(h hVar) {
        this.i = new LinkedHashSet();
        c(hVar.g().clone());
        d(hVar.h().clone());
        b(hVar.c().clone());
        a(hVar.b().clone());
        b(hVar.d().clone());
        d(hVar.f().clone());
        c(hVar.e().clone());
        a(hVar.a().clone());
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.i.add(aVar);
    }

    public h(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i2, int i3, int i4) {
        this.i = new LinkedHashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(j.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(j.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        if (resourceId2 != 0) {
            context = new ContextThemeWrapper(context, resourceId);
            resourceId = resourceId2;
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, j.ShapeAppearance);
        int i5 = obtainStyledAttributes2.getInt(j.ShapeAppearance_cornerFamily, 0);
        int i6 = obtainStyledAttributes2.getInt(j.ShapeAppearance_cornerFamilyTopLeft, i5);
        int i7 = obtainStyledAttributes2.getInt(j.ShapeAppearance_cornerFamilyTopRight, i5);
        int i8 = obtainStyledAttributes2.getInt(j.ShapeAppearance_cornerFamilyBottomRight, i5);
        int i9 = obtainStyledAttributes2.getInt(j.ShapeAppearance_cornerFamilyBottomLeft, i5);
        int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(j.ShapeAppearance_cornerSize, i4);
        int dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(j.ShapeAppearance_cornerSizeTopLeft, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(j.ShapeAppearance_cornerSizeTopRight, dimensionPixelSize);
        int dimensionPixelSize4 = obtainStyledAttributes2.getDimensionPixelSize(j.ShapeAppearance_cornerSizeBottomRight, dimensionPixelSize);
        int dimensionPixelSize5 = obtainStyledAttributes2.getDimensionPixelSize(j.ShapeAppearance_cornerSizeBottomLeft, dimensionPixelSize);
        c(f.a(i6, dimensionPixelSize2));
        d(f.a(i7, dimensionPixelSize3));
        b(f.a(i8, dimensionPixelSize4));
        a(f.a(i9, dimensionPixelSize5));
        d(f.b());
        c(f.b());
        a(f.b());
        b(f.b());
        obtainStyledAttributes2.recycle();
    }
}
