package androidx.fragment.app;

import a.g.h.g;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.E;

/* renamed from: androidx.fragment.app.l  reason: case insensitive filesystem */
public class C0136l {

    /* renamed from: a  reason: collision with root package name */
    private final C0138n<?> f808a;

    private C0136l(C0138n<?> nVar) {
        this.f808a = nVar;
    }

    public static C0136l a(C0138n<?> nVar) {
        g.a(nVar, "callbacks == null");
        return new C0136l(nVar);
    }

    public void b() {
        this.f808a.e.g();
    }

    public void c() {
        this.f808a.e.h();
    }

    public void d() {
        this.f808a.e.j();
    }

    public void e() {
        this.f808a.e.k();
    }

    public void f() {
        this.f808a.e.l();
    }

    public void g() {
        this.f808a.e.m();
    }

    public void h() {
        this.f808a.e.n();
    }

    public boolean i() {
        return this.f808a.e.p();
    }

    public C0139o j() {
        return this.f808a.e;
    }

    public void k() {
        this.f808a.e.t();
    }

    public Parcelable l() {
        return this.f808a.e.v();
    }

    public C0132h a(String str) {
        return this.f808a.e.b(str);
    }

    public void b(boolean z) {
        this.f808a.e.b(z);
    }

    public void a(C0132h hVar) {
        C0138n<?> nVar = this.f808a;
        nVar.e.a((C0138n) nVar, (C0135k) nVar, hVar);
    }

    public boolean b(Menu menu) {
        return this.f808a.e.b(menu);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f808a.e.onCreateView(view, str, context, attributeSet);
    }

    public boolean b(MenuItem menuItem) {
        return this.f808a.e.b(menuItem);
    }

    public void a(Parcelable parcelable) {
        C0138n<?> nVar = this.f808a;
        if (nVar instanceof E) {
            nVar.e.a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public void a() {
        this.f808a.e.f();
    }

    public void a(boolean z) {
        this.f808a.e.a(z);
    }

    public void a(Configuration configuration) {
        this.f808a.e.a(configuration);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f808a.e.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f808a.e.a(menuItem);
    }

    public void a(Menu menu) {
        this.f808a.e.a(menu);
    }
}
