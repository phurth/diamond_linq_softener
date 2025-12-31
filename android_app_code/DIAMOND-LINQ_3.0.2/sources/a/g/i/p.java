package a.g.i;

import android.view.View;
import android.view.ViewGroup;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private int f228a;

    /* renamed from: b  reason: collision with root package name */
    private int f229b;

    public p(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f229b = i;
        } else {
            this.f228a = i;
        }
    }

    public int a() {
        return this.f228a | this.f229b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i) {
        if (i == 1) {
            this.f229b = 0;
        } else {
            this.f228a = 0;
        }
    }
}
