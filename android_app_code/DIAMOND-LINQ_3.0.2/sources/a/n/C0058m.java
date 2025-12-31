package a.n;

import a.g.i.y;
import a.n.E;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* renamed from: a.n.m  reason: case insensitive filesystem */
public class C0058m extends E {
    private static final String[] K = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> L = new C0049d(PointF.class, "boundsOrigin");
    private static final Property<a, PointF> M = new C0050e(PointF.class, "topLeft");
    private static final Property<a, PointF> N = new C0051f(PointF.class, "bottomRight");
    private static final Property<View, PointF> O = new C0052g(PointF.class, "bottomRight");
    private static final Property<View, PointF> P = new C0053h(PointF.class, "topLeft");
    private static final Property<View, PointF> Q = new C0054i(PointF.class, "position");
    private static C0070z R = new C0070z();
    private int[] S = new int[2];
    private boolean T = false;
    private boolean U = false;

    private void d(M m) {
        View view = m.f286b;
        if (y.A(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            m.f285a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            m.f285a.put("android:changeBounds:parent", m.f286b.getParent());
            if (this.U) {
                m.f286b.getLocationInWindow(this.S);
                m.f285a.put("android:changeBounds:windowX", Integer.valueOf(this.S[0]));
                m.f285a.put("android:changeBounds:windowY", Integer.valueOf(this.S[1]));
            }
            if (this.T) {
                m.f285a.put("android:changeBounds:clip", y.g(view));
            }
        }
    }

    public void a(M m) {
        d(m);
    }

    public void c(M m) {
        d(m);
    }

    public String[] m() {
        return K;
    }

    private boolean a(View view, View view2) {
        if (!this.U) {
            return true;
        }
        M a2 = a(view, true);
        if (a2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == a2.f286b) {
            return true;
        }
        return false;
    }

    /* renamed from: a.n.m$a */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f319a;

        /* renamed from: b  reason: collision with root package name */
        private int f320b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        a(View view) {
            this.e = view;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(PointF pointF) {
            this.f319a = Math.round(pointF.x);
            this.f320b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                a();
            }
        }

        private void a() {
            ba.a(this.e, this.f319a, this.f320b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }
    }

    public Animator a(ViewGroup viewGroup, M m, M m2) {
        int i;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator2;
        M m3 = m;
        M m4 = m2;
        if (m3 == null || m4 == null) {
            return null;
        }
        Map<String, Object> map = m3.f285a;
        Map<String, Object> map2 = m4.f285a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = m4.f286b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) m3.f285a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) m4.f285a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            View view3 = view2;
            Rect rect4 = (Rect) m3.f285a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) m4.f285a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (!(i7 == i8 && i9 == i10)) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.T) {
                view = view3;
                ba.a(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        animator = C0065u.a(view, Q, f().a((float) i3, (float) i5, (float) i4, (float) i6));
                    } else {
                        a aVar = new a(view);
                        ObjectAnimator a2 = C0065u.a(aVar, M, f().a((float) i3, (float) i5, (float) i4, (float) i6));
                        ObjectAnimator a3 = C0065u.a(aVar, N, f().a((float) i7, (float) i9, (float) i8, (float) i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a2, a3});
                        animatorSet.addListener(new C0055j(this, aVar));
                        animator = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    animator = C0065u.a(view, O, f().a((float) i7, (float) i9, (float) i8, (float) i10));
                } else {
                    animator = C0065u.a(view, P, f().a((float) i3, (float) i5, (float) i4, (float) i6));
                }
            } else {
                view = view3;
                ba.a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                if (i3 == i4 && i5 == i6) {
                    objectAnimator = null;
                } else {
                    objectAnimator = C0065u.a(view, Q, f().a((float) i3, (float) i5, (float) i4, (float) i6));
                }
                if (rect7 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i2, i2, i13, i14) : rect6;
                if (!rect.equals(rect8)) {
                    y.a(view, rect);
                    C0070z zVar = R;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect8;
                    objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", zVar, objArr);
                    objectAnimator2.addListener(new C0056k(this, view, rect6, i4, i6, i8, i10));
                } else {
                    objectAnimator2 = null;
                }
                animator = L.a(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                S.a(viewGroup4, true);
                a((E.c) new C0057l(this, viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) m3.f285a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) m3.f285a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) m4.f285a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) m4.f285a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.S);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c = ba.c(view2);
        ba.a(view2, 0.0f);
        ba.b(viewGroup).a(bitmapDrawable);
        C0066v f = f();
        int[] iArr = this.S;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{C0068x.a(L, f.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        ofPropertyValuesHolder.addListener(new C0048c(this, viewGroup, bitmapDrawable, view2, c));
        return ofPropertyValuesHolder;
    }
}
