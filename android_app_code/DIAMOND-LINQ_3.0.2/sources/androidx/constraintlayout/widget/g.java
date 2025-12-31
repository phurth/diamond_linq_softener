package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.h;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f692a = {0, 4, 8};

    /* renamed from: b  reason: collision with root package name */
    private static SparseIntArray f693b = new SparseIntArray();
    private HashMap<String, c> c = new HashMap<>();
    private boolean d = true;
    private HashMap<Integer, a> e = new HashMap<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f694a;

        /* renamed from: b  reason: collision with root package name */
        public final d f695b = new d();
        public final c c = new c();
        public final b d = new b();
        public final e e = new e();
        public HashMap<String, c> f = new HashMap<>();

        public a clone() {
            a aVar = new a();
            aVar.d.a(this.d);
            aVar.c.a(this.c);
            aVar.f695b.a(this.f695b);
            aVar.e.a(this.e);
            aVar.f694a = this.f694a;
            return aVar;
        }

        /* access modifiers changed from: private */
        public void a(d dVar, int i, h.a aVar) {
            a(i, aVar);
            if (dVar instanceof a) {
                b bVar = this.d;
                bVar.da = 1;
                a aVar2 = (a) dVar;
                bVar.ca = aVar2.getType();
                this.d.ea = aVar2.getReferencedIds();
            }
        }

        /* access modifiers changed from: private */
        public void a(int i, h.a aVar) {
            a(i, (ConstraintLayout.a) aVar);
            this.f695b.c = aVar.oa;
            e eVar = this.e;
            eVar.c = aVar.ra;
            eVar.d = aVar.sa;
            eVar.e = aVar.ta;
            eVar.f = aVar.ua;
            eVar.g = aVar.va;
            eVar.h = aVar.wa;
            eVar.i = aVar.xa;
            eVar.j = aVar.ya;
            eVar.k = aVar.za;
            eVar.l = aVar.Aa;
            eVar.n = aVar.qa;
            eVar.m = aVar.pa;
        }

        /* access modifiers changed from: private */
        public void a(int i, ConstraintLayout.a aVar) {
            this.f694a = i;
            b bVar = this.d;
            bVar.i = aVar.d;
            bVar.j = aVar.e;
            bVar.k = aVar.f;
            bVar.l = aVar.g;
            bVar.m = aVar.h;
            bVar.n = aVar.i;
            bVar.o = aVar.j;
            bVar.p = aVar.k;
            bVar.q = aVar.l;
            bVar.r = aVar.p;
            bVar.s = aVar.q;
            bVar.t = aVar.r;
            bVar.u = aVar.s;
            bVar.v = aVar.z;
            bVar.w = aVar.A;
            bVar.x = aVar.B;
            bVar.y = aVar.m;
            bVar.z = aVar.n;
            bVar.A = aVar.o;
            bVar.B = aVar.Q;
            bVar.C = aVar.R;
            bVar.D = aVar.S;
            bVar.h = aVar.c;
            bVar.f = aVar.f675a;
            bVar.g = aVar.f676b;
            bVar.d = aVar.width;
            this.d.e = aVar.height;
            b bVar2 = this.d;
            bVar2.E = aVar.leftMargin;
            bVar2.F = aVar.rightMargin;
            bVar2.G = aVar.topMargin;
            bVar2.H = aVar.bottomMargin;
            bVar2.Q = aVar.F;
            bVar2.R = aVar.E;
            bVar2.T = aVar.H;
            bVar2.S = aVar.G;
            boolean z = aVar.T;
            bVar2.ga = z;
            bVar2.ha = aVar.U;
            bVar2.U = aVar.I;
            bVar2.V = aVar.J;
            bVar2.ga = z;
            bVar2.W = aVar.M;
            bVar2.X = aVar.N;
            bVar2.Y = aVar.K;
            bVar2.Z = aVar.L;
            bVar2.aa = aVar.O;
            bVar2.ba = aVar.P;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar2.I = aVar.getMarginEnd();
                this.d.J = aVar.getMarginStart();
            }
        }

        public void a(ConstraintLayout.a aVar) {
            b bVar = this.d;
            aVar.d = bVar.i;
            aVar.e = bVar.j;
            aVar.f = bVar.k;
            aVar.g = bVar.l;
            aVar.h = bVar.m;
            aVar.i = bVar.n;
            aVar.j = bVar.o;
            aVar.k = bVar.p;
            aVar.l = bVar.q;
            aVar.p = bVar.r;
            aVar.q = bVar.s;
            aVar.r = bVar.t;
            aVar.s = bVar.u;
            aVar.leftMargin = bVar.E;
            aVar.rightMargin = bVar.F;
            aVar.topMargin = bVar.G;
            aVar.bottomMargin = bVar.H;
            aVar.x = bVar.P;
            aVar.y = bVar.O;
            aVar.z = bVar.v;
            aVar.A = bVar.w;
            aVar.m = bVar.y;
            aVar.n = bVar.z;
            aVar.o = bVar.A;
            aVar.B = bVar.x;
            aVar.Q = bVar.B;
            aVar.R = bVar.C;
            aVar.F = bVar.Q;
            aVar.E = bVar.R;
            aVar.H = bVar.T;
            aVar.G = bVar.S;
            aVar.T = bVar.ga;
            aVar.U = bVar.ha;
            aVar.I = bVar.U;
            aVar.J = bVar.V;
            aVar.M = bVar.W;
            aVar.N = bVar.X;
            aVar.K = bVar.Y;
            aVar.L = bVar.Z;
            aVar.O = bVar.aa;
            aVar.P = bVar.ba;
            aVar.S = bVar.D;
            aVar.c = bVar.h;
            aVar.f675a = bVar.f;
            aVar.f676b = bVar.g;
            aVar.width = bVar.d;
            aVar.height = bVar.e;
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(bVar.J);
                aVar.setMarginEnd(this.d.I);
            }
            aVar.a();
        }
    }

    static {
        f693b.append(m.Constraint_layout_constraintLeft_toLeftOf, 25);
        f693b.append(m.Constraint_layout_constraintLeft_toRightOf, 26);
        f693b.append(m.Constraint_layout_constraintRight_toLeftOf, 29);
        f693b.append(m.Constraint_layout_constraintRight_toRightOf, 30);
        f693b.append(m.Constraint_layout_constraintTop_toTopOf, 36);
        f693b.append(m.Constraint_layout_constraintTop_toBottomOf, 35);
        f693b.append(m.Constraint_layout_constraintBottom_toTopOf, 4);
        f693b.append(m.Constraint_layout_constraintBottom_toBottomOf, 3);
        f693b.append(m.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f693b.append(m.Constraint_layout_editor_absoluteX, 6);
        f693b.append(m.Constraint_layout_editor_absoluteY, 7);
        f693b.append(m.Constraint_layout_constraintGuide_begin, 17);
        f693b.append(m.Constraint_layout_constraintGuide_end, 18);
        f693b.append(m.Constraint_layout_constraintGuide_percent, 19);
        f693b.append(m.Constraint_android_orientation, 27);
        f693b.append(m.Constraint_layout_constraintStart_toEndOf, 32);
        f693b.append(m.Constraint_layout_constraintStart_toStartOf, 33);
        f693b.append(m.Constraint_layout_constraintEnd_toStartOf, 10);
        f693b.append(m.Constraint_layout_constraintEnd_toEndOf, 9);
        f693b.append(m.Constraint_layout_goneMarginLeft, 13);
        f693b.append(m.Constraint_layout_goneMarginTop, 16);
        f693b.append(m.Constraint_layout_goneMarginRight, 14);
        f693b.append(m.Constraint_layout_goneMarginBottom, 11);
        f693b.append(m.Constraint_layout_goneMarginStart, 15);
        f693b.append(m.Constraint_layout_goneMarginEnd, 12);
        f693b.append(m.Constraint_layout_constraintVertical_weight, 40);
        f693b.append(m.Constraint_layout_constraintHorizontal_weight, 39);
        f693b.append(m.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f693b.append(m.Constraint_layout_constraintVertical_chainStyle, 42);
        f693b.append(m.Constraint_layout_constraintHorizontal_bias, 20);
        f693b.append(m.Constraint_layout_constraintVertical_bias, 37);
        f693b.append(m.Constraint_layout_constraintDimensionRatio, 5);
        f693b.append(m.Constraint_layout_constraintLeft_creator, 76);
        f693b.append(m.Constraint_layout_constraintTop_creator, 76);
        f693b.append(m.Constraint_layout_constraintRight_creator, 76);
        f693b.append(m.Constraint_layout_constraintBottom_creator, 76);
        f693b.append(m.Constraint_layout_constraintBaseline_creator, 76);
        f693b.append(m.Constraint_android_layout_marginLeft, 24);
        f693b.append(m.Constraint_android_layout_marginRight, 28);
        f693b.append(m.Constraint_android_layout_marginStart, 31);
        f693b.append(m.Constraint_android_layout_marginEnd, 8);
        f693b.append(m.Constraint_android_layout_marginTop, 34);
        f693b.append(m.Constraint_android_layout_marginBottom, 2);
        f693b.append(m.Constraint_android_layout_width, 23);
        f693b.append(m.Constraint_android_layout_height, 21);
        f693b.append(m.Constraint_android_visibility, 22);
        f693b.append(m.Constraint_android_alpha, 43);
        f693b.append(m.Constraint_android_elevation, 44);
        f693b.append(m.Constraint_android_rotationX, 45);
        f693b.append(m.Constraint_android_rotationY, 46);
        f693b.append(m.Constraint_android_rotation, 60);
        f693b.append(m.Constraint_android_scaleX, 47);
        f693b.append(m.Constraint_android_scaleY, 48);
        f693b.append(m.Constraint_android_transformPivotX, 49);
        f693b.append(m.Constraint_android_transformPivotY, 50);
        f693b.append(m.Constraint_android_translationX, 51);
        f693b.append(m.Constraint_android_translationY, 52);
        f693b.append(m.Constraint_android_translationZ, 53);
        f693b.append(m.Constraint_layout_constraintWidth_default, 54);
        f693b.append(m.Constraint_layout_constraintHeight_default, 55);
        f693b.append(m.Constraint_layout_constraintWidth_max, 56);
        f693b.append(m.Constraint_layout_constraintHeight_max, 57);
        f693b.append(m.Constraint_layout_constraintWidth_min, 58);
        f693b.append(m.Constraint_layout_constraintHeight_min, 59);
        f693b.append(m.Constraint_layout_constraintCircle, 61);
        f693b.append(m.Constraint_layout_constraintCircleRadius, 62);
        f693b.append(m.Constraint_layout_constraintCircleAngle, 63);
        f693b.append(m.Constraint_animate_relativeTo, 64);
        f693b.append(m.Constraint_transitionEasing, 65);
        f693b.append(m.Constraint_drawPath, 66);
        f693b.append(m.Constraint_transitionPathRotate, 67);
        f693b.append(m.Constraint_android_id, 38);
        f693b.append(m.Constraint_progress, 68);
        f693b.append(m.Constraint_layout_constraintWidth_percent, 69);
        f693b.append(m.Constraint_layout_constraintHeight_percent, 70);
        f693b.append(m.Constraint_chainUseRtl, 71);
        f693b.append(m.Constraint_barrierDirection, 72);
        f693b.append(m.Constraint_constraint_referenced_ids, 73);
        f693b.append(m.Constraint_barrierAllowsGoneWidgets, 74);
        f693b.append(m.Constraint_pathMotionArc, 75);
    }

    public void b(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.e.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.d || id != -1) {
                if (!this.e.containsKey(Integer.valueOf(id))) {
                    this.e.put(Integer.valueOf(id), new a());
                }
                a aVar2 = this.e.get(Integer.valueOf(id));
                aVar2.f = c.a(this.c, childAt);
                aVar2.a(id, aVar);
                aVar2.f695b.f701b = childAt.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    aVar2.f695b.c = childAt.getAlpha();
                    aVar2.e.c = childAt.getRotation();
                    aVar2.e.d = childAt.getRotationX();
                    aVar2.e.e = childAt.getRotationY();
                    aVar2.e.f = childAt.getScaleX();
                    aVar2.e.g = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        e eVar = aVar2.e;
                        eVar.h = pivotX;
                        eVar.i = pivotY;
                    }
                    aVar2.e.j = childAt.getTranslationX();
                    aVar2.e.k = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar2.e.l = childAt.getTranslationZ();
                        e eVar2 = aVar2.e;
                        if (eVar2.m) {
                            eVar2.n = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof a) {
                    a aVar3 = (a) childAt;
                    aVar2.d.ia = aVar3.b();
                    aVar2.d.ea = aVar3.getReferencedIds();
                    aVar2.d.ca = aVar3.getType();
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void a(Context context, int i) {
        b((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f700a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f701b = 0;
        public float c = 1.0f;
        public float d = Float.NaN;

        public void a(d dVar) {
            this.f701b = dVar.f701b;
            this.c = dVar.c;
            this.d = dVar.d;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.PropertySet);
            this.f700a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == m.PropertySet_alpha) {
                    this.c = obtainStyledAttributes.getFloat(index, this.c);
                } else if (index == m.PropertySet_visibility) {
                    this.f701b = obtainStyledAttributes.getInt(index, this.f701b);
                } else if (index == m.PropertySet_progress) {
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(h hVar) {
        int childCount = hVar.getChildCount();
        this.e.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = hVar.getChildAt(i);
            h.a aVar = (h.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.d || id != -1) {
                if (!this.e.containsKey(Integer.valueOf(id))) {
                    this.e.put(Integer.valueOf(id), new a());
                }
                a aVar2 = this.e.get(Integer.valueOf(id));
                if (childAt instanceof d) {
                    aVar2.a((d) childAt, id, aVar);
                }
                aVar2.a(id, aVar);
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f698a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        public boolean f699b = false;
        public int c = -1;
        public String d = null;
        public int e = -1;
        public int f = 0;
        public float g = Float.NaN;

        static {
            f698a.append(m.Motion_transitionPathRotate, 1);
            f698a.append(m.Motion_pathMotionArc, 2);
            f698a.append(m.Motion_transitionEasing, 3);
            f698a.append(m.Motion_drawPath, 4);
            f698a.append(m.Motion_animate_relativeTo, 5);
        }

        public void a(c cVar) {
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.Motion);
            this.f699b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = f698a.get(index);
                if (i2 == 1) {
                    this.g = obtainStyledAttributes.getFloat(index, this.g);
                } else if (i2 == 2) {
                    this.e = obtainStyledAttributes.getInt(index, this.e);
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        this.f = obtainStyledAttributes.getInt(index, 0);
                    } else if (i2 == 5) {
                        this.c = g.b(obtainStyledAttributes, index, this.c);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.d = obtainStyledAttributes.getString(index);
                } else {
                    this.d = a.e.a.a.a.f74b[obtainStyledAttributes.getInteger(index, 0)];
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f702a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        public boolean f703b = false;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 0.0f;
        public float f = 1.0f;
        public float g = 1.0f;
        public float h = Float.NaN;
        public float i = Float.NaN;
        public float j = 0.0f;
        public float k = 0.0f;
        public float l = 0.0f;
        public boolean m = false;
        public float n = 0.0f;

        static {
            f702a.append(m.Transform_rotation, 1);
            f702a.append(m.Transform_rotationX, 2);
            f702a.append(m.Transform_rotationY, 3);
            f702a.append(m.Transform_scaleX, 4);
            f702a.append(m.Transform_scaleY, 5);
            f702a.append(m.Transform_transformPivotX, 6);
            f702a.append(m.Transform_transformPivotY, 7);
            f702a.append(m.Transform_translationX, 8);
            f702a.append(m.Transform_translationY, 9);
            f702a.append(m.Transform_translationZ, 10);
            f702a.append(m.Transform_elevation, 11);
        }

        public void a(e eVar) {
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.l = eVar.l;
            this.m = eVar.m;
            this.n = eVar.n;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.Transform);
            this.f703b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f702a.get(index)) {
                    case 1:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 2:
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 3:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 4:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 5:
                        this.g = obtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 6:
                        this.h = obtainStyledAttributes.getFloat(index, this.h);
                        break;
                    case 7:
                        this.i = obtainStyledAttributes.getFloat(index, this.i);
                        break;
                    case 8:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 9:
                        this.k = obtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 10:
                        this.l = obtainStyledAttributes.getDimension(index, this.l);
                        break;
                    case 11:
                        this.m = true;
                        this.n = obtainStyledAttributes.getDimension(index, this.n);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        a(constraintLayout, true);
        constraintLayout.setConstraintSet((g) null);
    }

    /* access modifiers changed from: package-private */
    public void a(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.e.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + a.e.a.b.a.a(childAt));
            } else if (this.d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (this.e.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    a aVar = this.e.get(Integer.valueOf(id));
                    if (childAt instanceof a) {
                        aVar.d.da = 1;
                    }
                    int i2 = aVar.d.da;
                    if (i2 != -1 && i2 == 1) {
                        a aVar2 = (a) childAt;
                        aVar2.setId(id);
                        aVar2.setType(aVar.d.ca);
                        aVar2.setAllowsGoneWidget(aVar.d.ia);
                        b bVar = aVar.d;
                        int[] iArr = bVar.ea;
                        if (iArr != null) {
                            aVar2.setReferencedIds(iArr);
                        } else {
                            String str = bVar.fa;
                            if (str != null) {
                                bVar.ea = a((View) aVar2, str);
                                aVar2.setReferencedIds(aVar.d.ea);
                            }
                        }
                    }
                    ConstraintLayout.a aVar3 = (ConstraintLayout.a) childAt.getLayoutParams();
                    aVar.a(aVar3);
                    if (z) {
                        c.a(childAt, aVar.f);
                    }
                    childAt.setLayoutParams(aVar3);
                    childAt.setVisibility(aVar.f695b.f701b);
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(aVar.f695b.c);
                        childAt.setRotation(aVar.e.c);
                        childAt.setRotationX(aVar.e.d);
                        childAt.setRotationY(aVar.e.e);
                        childAt.setScaleX(aVar.e.f);
                        childAt.setScaleY(aVar.e.g);
                        if (!Float.isNaN(aVar.e.h)) {
                            childAt.setPivotX(aVar.e.h);
                        }
                        if (!Float.isNaN(aVar.e.i)) {
                            childAt.setPivotY(aVar.e.i);
                        }
                        childAt.setTranslationX(aVar.e.j);
                        childAt.setTranslationY(aVar.e.k);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(aVar.e.l);
                            e eVar = aVar.e;
                            if (eVar.m) {
                                childAt.setElevation(eVar.n);
                            }
                        }
                    }
                } else {
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar4 = this.e.get(num);
            int i3 = aVar4.d.da;
            if (i3 != -1 && i3 == 1) {
                a aVar5 = new a(constraintLayout.getContext());
                aVar5.setId(num.intValue());
                b bVar2 = aVar4.d;
                int[] iArr2 = bVar2.ea;
                if (iArr2 != null) {
                    aVar5.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar2.fa;
                    if (str2 != null) {
                        bVar2.ea = a((View) aVar5, str2);
                        aVar5.setReferencedIds(aVar4.d.ea);
                    }
                }
                aVar5.setType(aVar4.d.ca);
                ConstraintLayout.a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                aVar5.a();
                aVar4.a(generateDefaultLayoutParams);
                constraintLayout.addView(aVar5, generateDefaultLayoutParams);
            }
            if (aVar4.d.f697b) {
                j jVar = new j(constraintLayout.getContext());
                jVar.setId(num.intValue());
                ConstraintLayout.a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar4.a(generateDefaultLayoutParams2);
                constraintLayout.addView(jVar, generateDefaultLayoutParams2);
            }
        }
    }

    public void b(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a a2 = a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.d.f697b = true;
                    }
                    this.e.put(Integer.valueOf(a2.f694a), a2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static int b(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f696a = new SparseIntArray();
        public float A = 0.0f;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public int P = -1;
        public float Q = 0.0f;
        public float R = 0.0f;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = 0;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public int Z = -1;
        public float aa = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        public boolean f697b = false;
        public float ba = 1.0f;
        public boolean c = false;
        public int ca = -1;
        public int d;
        public int da = -1;
        public int e;
        public int[] ea;
        public int f = -1;
        public String fa;
        public int g = -1;
        public boolean ga = false;
        public float h = -1.0f;
        public boolean ha = false;
        public int i = -1;
        public boolean ia = true;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public float v = 0.5f;
        public float w = 0.5f;
        public String x = null;
        public int y = -1;
        public int z = 0;

        static {
            f696a.append(m.Layout_layout_constraintLeft_toLeftOf, 24);
            f696a.append(m.Layout_layout_constraintLeft_toRightOf, 25);
            f696a.append(m.Layout_layout_constraintRight_toLeftOf, 28);
            f696a.append(m.Layout_layout_constraintRight_toRightOf, 29);
            f696a.append(m.Layout_layout_constraintTop_toTopOf, 35);
            f696a.append(m.Layout_layout_constraintTop_toBottomOf, 34);
            f696a.append(m.Layout_layout_constraintBottom_toTopOf, 4);
            f696a.append(m.Layout_layout_constraintBottom_toBottomOf, 3);
            f696a.append(m.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f696a.append(m.Layout_layout_editor_absoluteX, 6);
            f696a.append(m.Layout_layout_editor_absoluteY, 7);
            f696a.append(m.Layout_layout_constraintGuide_begin, 17);
            f696a.append(m.Layout_layout_constraintGuide_end, 18);
            f696a.append(m.Layout_layout_constraintGuide_percent, 19);
            f696a.append(m.Layout_orientation, 26);
            f696a.append(m.Layout_layout_constraintStart_toEndOf, 31);
            f696a.append(m.Layout_layout_constraintStart_toStartOf, 32);
            f696a.append(m.Layout_layout_constraintEnd_toStartOf, 10);
            f696a.append(m.Layout_layout_constraintEnd_toEndOf, 9);
            f696a.append(m.Layout_layout_goneMarginLeft, 13);
            f696a.append(m.Layout_layout_goneMarginTop, 16);
            f696a.append(m.Layout_layout_goneMarginRight, 14);
            f696a.append(m.Layout_layout_goneMarginBottom, 11);
            f696a.append(m.Layout_layout_goneMarginStart, 15);
            f696a.append(m.Layout_layout_goneMarginEnd, 12);
            f696a.append(m.Layout_layout_constraintVertical_weight, 38);
            f696a.append(m.Layout_layout_constraintHorizontal_weight, 37);
            f696a.append(m.Layout_layout_constraintHorizontal_chainStyle, 39);
            f696a.append(m.Layout_layout_constraintVertical_chainStyle, 40);
            f696a.append(m.Layout_layout_constraintHorizontal_bias, 20);
            f696a.append(m.Layout_layout_constraintVertical_bias, 36);
            f696a.append(m.Layout_layout_constraintDimensionRatio, 5);
            f696a.append(m.Layout_layout_constraintLeft_creator, 76);
            f696a.append(m.Layout_layout_constraintTop_creator, 76);
            f696a.append(m.Layout_layout_constraintRight_creator, 76);
            f696a.append(m.Layout_layout_constraintBottom_creator, 76);
            f696a.append(m.Layout_layout_constraintBaseline_creator, 76);
            f696a.append(m.Layout_layout_marginLeft, 23);
            f696a.append(m.Layout_layout_marginRight, 27);
            f696a.append(m.Layout_layout_marginStart, 30);
            f696a.append(m.Layout_layout_marginEnd, 8);
            f696a.append(m.Layout_layout_marginTop, 33);
            f696a.append(m.Layout_layout_marginBottom, 2);
            f696a.append(m.Layout_layout_width, 22);
            f696a.append(m.Layout_layout_height, 21);
            f696a.append(m.Layout_layout_constraintCircle, 61);
            f696a.append(m.Layout_layout_constraintCircleRadius, 62);
            f696a.append(m.Layout_layout_constraintCircleAngle, 63);
            f696a.append(m.Layout_layout_constraintWidth_percent, 69);
            f696a.append(m.Layout_layout_constraintHeight_percent, 70);
            f696a.append(m.Layout_chainUseRtl, 71);
            f696a.append(m.Layout_barrierDirection, 72);
            f696a.append(m.Layout_constraint_referenced_ids, 73);
            f696a.append(m.Layout_barrierAllowsGoneWidgets, 74);
        }

        public void a(b bVar) {
            this.f697b = bVar.f697b;
            this.d = bVar.d;
            this.c = bVar.c;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.t = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            this.w = bVar.w;
            this.x = bVar.x;
            this.y = bVar.y;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.aa = bVar.aa;
            this.ba = bVar.ba;
            this.ca = bVar.ca;
            this.da = bVar.da;
            int[] iArr = bVar.ea;
            if (iArr != null) {
                this.ea = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.ea = null;
            }
            this.fa = bVar.fa;
            this.ga = bVar.ga;
            this.ha = bVar.ha;
            this.ia = bVar.ia;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.Layout);
            this.c = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = f696a.get(index);
                if (i3 != 76) {
                    switch (i3) {
                        case 1:
                            this.q = g.b(obtainStyledAttributes, index, this.q);
                            break;
                        case 2:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            break;
                        case 3:
                            this.p = g.b(obtainStyledAttributes, index, this.p);
                            break;
                        case 4:
                            this.o = g.b(obtainStyledAttributes, index, this.o);
                            break;
                        case 5:
                            this.x = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            break;
                        case 7:
                            this.C = obtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                            break;
                        case 8:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            break;
                        case 9:
                            this.u = g.b(obtainStyledAttributes, index, this.u);
                            break;
                        case 10:
                            this.t = g.b(obtainStyledAttributes, index, this.t);
                            break;
                        case 11:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        case 12:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        case 13:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        case 14:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        case 15:
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        case 16:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        case 17:
                            this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                            break;
                        case 18:
                            this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                            break;
                        case 19:
                            this.h = obtainStyledAttributes.getFloat(index, this.h);
                            break;
                        case 20:
                            this.v = obtainStyledAttributes.getFloat(index, this.v);
                            break;
                        case 21:
                            this.e = obtainStyledAttributes.getLayoutDimension(index, this.e);
                            break;
                        case 22:
                            this.d = obtainStyledAttributes.getLayoutDimension(index, this.d);
                            break;
                        case 23:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            break;
                        case 24:
                            this.i = g.b(obtainStyledAttributes, index, this.i);
                            break;
                        case 25:
                            this.j = g.b(obtainStyledAttributes, index, this.j);
                            break;
                        case 26:
                            this.D = obtainStyledAttributes.getInt(index, this.D);
                            break;
                        case 27:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            break;
                        case 28:
                            this.k = g.b(obtainStyledAttributes, index, this.k);
                            break;
                        case 29:
                            this.l = g.b(obtainStyledAttributes, index, this.l);
                            break;
                        case 30:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        case 31:
                            this.r = g.b(obtainStyledAttributes, index, this.r);
                            break;
                        case 32:
                            this.s = g.b(obtainStyledAttributes, index, this.s);
                            break;
                        case 33:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            break;
                        case 34:
                            this.n = g.b(obtainStyledAttributes, index, this.n);
                            break;
                        case 35:
                            this.m = g.b(obtainStyledAttributes, index, this.m);
                            break;
                        case 36:
                            this.w = obtainStyledAttributes.getFloat(index, this.w);
                            break;
                        case 37:
                            this.R = obtainStyledAttributes.getFloat(index, this.R);
                            break;
                        case 38:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            break;
                        case 39:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            break;
                        case 40:
                            this.T = obtainStyledAttributes.getInt(index, this.T);
                            break;
                        default:
                            switch (i3) {
                                case 61:
                                    this.y = g.b(obtainStyledAttributes, index, this.y);
                                    break;
                                case 62:
                                    this.z = obtainStyledAttributes.getDimensionPixelSize(index, this.z);
                                    break;
                                case 63:
                                    this.A = obtainStyledAttributes.getFloat(index, this.A);
                                    break;
                                default:
                                    switch (i3) {
                                        case 69:
                                            this.aa = obtainStyledAttributes.getFloat(index, 1.0f);
                                            break;
                                        case 70:
                                            this.ba = obtainStyledAttributes.getFloat(index, 1.0f);
                                            break;
                                        case 71:
                                            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                            break;
                                        case 72:
                                            this.ca = obtainStyledAttributes.getInt(index, this.ca);
                                            break;
                                        case 73:
                                            this.fa = obtainStyledAttributes.getString(index);
                                            break;
                                        case 74:
                                            this.ia = obtainStyledAttributes.getBoolean(index, this.ia);
                                            break;
                                        default:
                                            Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f696a.get(index));
                                            break;
                                    }
                            }
                    }
                } else {
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f696a.get(index));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0160, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x016f
            if (r0 == 0) goto L_0x015d
            java.lang.String r4 = "Constraint"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x0036
            if (r0 == r5) goto L_0x0015
            goto L_0x0160
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.String r3 = "ConstraintSet"
            boolean r3 = r3.equals(r0)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r3 == 0) goto L_0x0022
            return
        L_0x0022:
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r0 == 0) goto L_0x0160
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.g$a> r0 = r9.e     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            int r3 = r2.f694a     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r2 = r1
            goto L_0x0160
        L_0x0036:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r7 = -1
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            switch(r8) {
                case -2025855158: goto L_0x007d;
                case -1984451626: goto L_0x0073;
                case -1269513683: goto L_0x0069;
                case -1238332596: goto L_0x005f;
                case -71750448: goto L_0x0055;
                case 1791837707: goto L_0x004b;
                case 1803088381: goto L_0x0043;
                default: goto L_0x0042;
            }     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
        L_0x0042:
            goto L_0x0087
        L_0x0043:
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r0 == 0) goto L_0x0087
            r0 = 0
            goto L_0x0088
        L_0x004b:
            java.lang.String r4 = "CustomAttribute"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r0 == 0) goto L_0x0087
            r0 = 6
            goto L_0x0088
        L_0x0055:
            java.lang.String r4 = "Guideline"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r0 == 0) goto L_0x0087
            r0 = 1
            goto L_0x0088
        L_0x005f:
            java.lang.String r4 = "Transform"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r0 == 0) goto L_0x0087
            r0 = 3
            goto L_0x0088
        L_0x0069:
            java.lang.String r4 = "PropertySet"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r0 == 0) goto L_0x0087
            r0 = 2
            goto L_0x0088
        L_0x0073:
            java.lang.String r4 = "Motion"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r0 == 0) goto L_0x0087
            r0 = 5
            goto L_0x0088
        L_0x007d:
            java.lang.String r4 = "Layout"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            if (r0 == 0) goto L_0x0087
            r0 = 4
            goto L_0x0088
        L_0x0087:
            r0 = -1
        L_0x0088:
            java.lang.String r4 = "XML parser error must be within a Constraint "
            switch(r0) {
                case 0: goto L_0x0154;
                case 1: goto L_0x0147;
                case 2: goto L_0x0122;
                case 3: goto L_0x00fd;
                case 4: goto L_0x00d7;
                case 5: goto L_0x00b1;
                case 6: goto L_0x008f;
                default: goto L_0x008d;
            }
        L_0x008d:
            goto L_0x0160
        L_0x008f:
            if (r2 == 0) goto L_0x0098
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.c> r0 = r2.f     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            androidx.constraintlayout.widget.c.a(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            goto L_0x0160
        L_0x0098:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            throw r10     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
        L_0x00b1:
            if (r2 == 0) goto L_0x00be
            androidx.constraintlayout.widget.g$c r0 = r2.c     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            goto L_0x0160
        L_0x00be:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            throw r10     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
        L_0x00d7:
            if (r2 == 0) goto L_0x00e4
            androidx.constraintlayout.widget.g$b r0 = r2.d     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            goto L_0x0160
        L_0x00e4:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            throw r10     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
        L_0x00fd:
            if (r2 == 0) goto L_0x0109
            androidx.constraintlayout.widget.g$e r0 = r2.e     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            goto L_0x0160
        L_0x0109:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            throw r10     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
        L_0x0122:
            if (r2 == 0) goto L_0x012e
            androidx.constraintlayout.widget.g$d r0 = r2.f695b     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            goto L_0x0160
        L_0x012e:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r4)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.append(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            java.lang.String r11 = r0.toString()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            throw r10     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
        L_0x0147:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            androidx.constraintlayout.widget.g$a r2 = r9.a((android.content.Context) r10, (android.util.AttributeSet) r0)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            androidx.constraintlayout.widget.g$b r0 = r2.d     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            r0.f697b = r3     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            goto L_0x0160
        L_0x0154:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            androidx.constraintlayout.widget.g$a r2 = r9.a((android.content.Context) r10, (android.util.AttributeSet) r0)     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            goto L_0x0160
        L_0x015d:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
        L_0x0160:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x016b, IOException -> 0x0166 }
            goto L_0x0006
        L_0x0166:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x016f
        L_0x016b:
            r10 = move-exception
            r10.printStackTrace()
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.g.a(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    private a a(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.Constraint);
        a(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private void a(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index != m.Constraint_android_id) {
                aVar.c.f699b = true;
                aVar.d.c = true;
                aVar.f695b.f700a = true;
                aVar.e.f703b = true;
            }
            int i2 = f693b.get(index);
            switch (i2) {
                case 1:
                    b bVar = aVar.d;
                    bVar.q = b(typedArray, index, bVar.q);
                    break;
                case 2:
                    b bVar2 = aVar.d;
                    bVar2.H = typedArray.getDimensionPixelSize(index, bVar2.H);
                    break;
                case 3:
                    b bVar3 = aVar.d;
                    bVar3.p = b(typedArray, index, bVar3.p);
                    break;
                case 4:
                    b bVar4 = aVar.d;
                    bVar4.o = b(typedArray, index, bVar4.o);
                    break;
                case 5:
                    aVar.d.x = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.d;
                    bVar5.B = typedArray.getDimensionPixelOffset(index, bVar5.B);
                    break;
                case 7:
                    b bVar6 = aVar.d;
                    bVar6.C = typedArray.getDimensionPixelOffset(index, bVar6.C);
                    break;
                case 8:
                    b bVar7 = aVar.d;
                    bVar7.I = typedArray.getDimensionPixelSize(index, bVar7.I);
                    break;
                case 9:
                    b bVar8 = aVar.d;
                    bVar8.u = b(typedArray, index, bVar8.u);
                    break;
                case 10:
                    b bVar9 = aVar.d;
                    bVar9.t = b(typedArray, index, bVar9.t);
                    break;
                case 11:
                    b bVar10 = aVar.d;
                    bVar10.N = typedArray.getDimensionPixelSize(index, bVar10.N);
                    break;
                case 12:
                    b bVar11 = aVar.d;
                    bVar11.O = typedArray.getDimensionPixelSize(index, bVar11.O);
                    break;
                case 13:
                    b bVar12 = aVar.d;
                    bVar12.K = typedArray.getDimensionPixelSize(index, bVar12.K);
                    break;
                case 14:
                    b bVar13 = aVar.d;
                    bVar13.M = typedArray.getDimensionPixelSize(index, bVar13.M);
                    break;
                case 15:
                    b bVar14 = aVar.d;
                    bVar14.P = typedArray.getDimensionPixelSize(index, bVar14.P);
                    break;
                case 16:
                    b bVar15 = aVar.d;
                    bVar15.L = typedArray.getDimensionPixelSize(index, bVar15.L);
                    break;
                case 17:
                    b bVar16 = aVar.d;
                    bVar16.f = typedArray.getDimensionPixelOffset(index, bVar16.f);
                    break;
                case 18:
                    b bVar17 = aVar.d;
                    bVar17.g = typedArray.getDimensionPixelOffset(index, bVar17.g);
                    break;
                case 19:
                    b bVar18 = aVar.d;
                    bVar18.h = typedArray.getFloat(index, bVar18.h);
                    break;
                case 20:
                    b bVar19 = aVar.d;
                    bVar19.v = typedArray.getFloat(index, bVar19.v);
                    break;
                case 21:
                    b bVar20 = aVar.d;
                    bVar20.e = typedArray.getLayoutDimension(index, bVar20.e);
                    break;
                case 22:
                    d dVar = aVar.f695b;
                    dVar.f701b = typedArray.getInt(index, dVar.f701b);
                    d dVar2 = aVar.f695b;
                    dVar2.f701b = f692a[dVar2.f701b];
                    break;
                case 23:
                    b bVar21 = aVar.d;
                    bVar21.d = typedArray.getLayoutDimension(index, bVar21.d);
                    break;
                case 24:
                    b bVar22 = aVar.d;
                    bVar22.E = typedArray.getDimensionPixelSize(index, bVar22.E);
                    break;
                case 25:
                    b bVar23 = aVar.d;
                    bVar23.i = b(typedArray, index, bVar23.i);
                    break;
                case 26:
                    b bVar24 = aVar.d;
                    bVar24.j = b(typedArray, index, bVar24.j);
                    break;
                case 27:
                    b bVar25 = aVar.d;
                    bVar25.D = typedArray.getInt(index, bVar25.D);
                    break;
                case 28:
                    b bVar26 = aVar.d;
                    bVar26.F = typedArray.getDimensionPixelSize(index, bVar26.F);
                    break;
                case 29:
                    b bVar27 = aVar.d;
                    bVar27.k = b(typedArray, index, bVar27.k);
                    break;
                case 30:
                    b bVar28 = aVar.d;
                    bVar28.l = b(typedArray, index, bVar28.l);
                    break;
                case 31:
                    b bVar29 = aVar.d;
                    bVar29.J = typedArray.getDimensionPixelSize(index, bVar29.J);
                    break;
                case 32:
                    b bVar30 = aVar.d;
                    bVar30.r = b(typedArray, index, bVar30.r);
                    break;
                case 33:
                    b bVar31 = aVar.d;
                    bVar31.s = b(typedArray, index, bVar31.s);
                    break;
                case 34:
                    b bVar32 = aVar.d;
                    bVar32.G = typedArray.getDimensionPixelSize(index, bVar32.G);
                    break;
                case 35:
                    b bVar33 = aVar.d;
                    bVar33.n = b(typedArray, index, bVar33.n);
                    break;
                case 36:
                    b bVar34 = aVar.d;
                    bVar34.m = b(typedArray, index, bVar34.m);
                    break;
                case 37:
                    b bVar35 = aVar.d;
                    bVar35.w = typedArray.getFloat(index, bVar35.w);
                    break;
                case 38:
                    aVar.f694a = typedArray.getResourceId(index, aVar.f694a);
                    break;
                case 39:
                    b bVar36 = aVar.d;
                    bVar36.R = typedArray.getFloat(index, bVar36.R);
                    break;
                case 40:
                    b bVar37 = aVar.d;
                    bVar37.Q = typedArray.getFloat(index, bVar37.Q);
                    break;
                case 41:
                    b bVar38 = aVar.d;
                    bVar38.S = typedArray.getInt(index, bVar38.S);
                    break;
                case 42:
                    b bVar39 = aVar.d;
                    bVar39.T = typedArray.getInt(index, bVar39.T);
                    break;
                case 43:
                    d dVar3 = aVar.f695b;
                    dVar3.c = typedArray.getFloat(index, dVar3.c);
                    break;
                case 44:
                    e eVar = aVar.e;
                    eVar.m = true;
                    eVar.n = typedArray.getDimension(index, eVar.n);
                    break;
                case 45:
                    e eVar2 = aVar.e;
                    eVar2.d = typedArray.getFloat(index, eVar2.d);
                    break;
                case 46:
                    e eVar3 = aVar.e;
                    eVar3.e = typedArray.getFloat(index, eVar3.e);
                    break;
                case 47:
                    e eVar4 = aVar.e;
                    eVar4.f = typedArray.getFloat(index, eVar4.f);
                    break;
                case 48:
                    e eVar5 = aVar.e;
                    eVar5.g = typedArray.getFloat(index, eVar5.g);
                    break;
                case 49:
                    e eVar6 = aVar.e;
                    eVar6.h = typedArray.getFloat(index, eVar6.h);
                    break;
                case 50:
                    e eVar7 = aVar.e;
                    eVar7.i = typedArray.getFloat(index, eVar7.i);
                    break;
                case 51:
                    e eVar8 = aVar.e;
                    eVar8.j = typedArray.getDimension(index, eVar8.j);
                    break;
                case 52:
                    e eVar9 = aVar.e;
                    eVar9.k = typedArray.getDimension(index, eVar9.k);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        e eVar10 = aVar.e;
                        eVar10.l = typedArray.getDimension(index, eVar10.l);
                        break;
                    }
                default:
                    switch (i2) {
                        case 60:
                            e eVar11 = aVar.e;
                            eVar11.c = typedArray.getFloat(index, eVar11.c);
                            break;
                        case 61:
                            b bVar40 = aVar.d;
                            bVar40.y = b(typedArray, index, bVar40.y);
                            break;
                        case 62:
                            b bVar41 = aVar.d;
                            bVar41.z = typedArray.getDimensionPixelSize(index, bVar41.z);
                            break;
                        case 63:
                            b bVar42 = aVar.d;
                            bVar42.A = typedArray.getFloat(index, bVar42.A);
                            break;
                        case 64:
                            c cVar = aVar.c;
                            cVar.c = b(typedArray, index, cVar.c);
                            break;
                        case 65:
                            if (typedArray.peekValue(index).type != 3) {
                                aVar.c.d = a.e.a.a.a.f74b[typedArray.getInteger(index, 0)];
                                break;
                            } else {
                                aVar.c.d = typedArray.getString(index);
                                break;
                            }
                        case 66:
                            aVar.c.f = typedArray.getInt(index, 0);
                            break;
                        case 67:
                            c cVar2 = aVar.c;
                            cVar2.g = typedArray.getFloat(index, cVar2.g);
                            break;
                        case 68:
                            d dVar4 = aVar.f695b;
                            dVar4.d = typedArray.getFloat(index, dVar4.d);
                            break;
                        case 69:
                            aVar.d.aa = typedArray.getFloat(index, 1.0f);
                            break;
                        case 70:
                            aVar.d.ba = typedArray.getFloat(index, 1.0f);
                            break;
                        case 71:
                            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                            break;
                        case 72:
                            b bVar43 = aVar.d;
                            bVar43.ca = typedArray.getInt(index, bVar43.ca);
                            break;
                        case 73:
                            aVar.d.fa = typedArray.getString(index);
                            break;
                        case 74:
                            b bVar44 = aVar.d;
                            bVar44.ia = typedArray.getBoolean(index, bVar44.ia);
                            break;
                        case 75:
                            c cVar3 = aVar.c;
                            cVar3.e = typedArray.getInt(index, cVar3.e);
                            break;
                        case 76:
                            Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f693b.get(index));
                            break;
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f693b.get(index));
                            break;
                    }
            }
        }
    }

    private int[] a(View view, String str) {
        int i;
        Object a2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = l.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) view.getParent()).a(0, (Object) trim)) != null && (a2 instanceof Integer)) {
                i = ((Integer) a2).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }
}
