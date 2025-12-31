package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f686a;

    /* renamed from: b  reason: collision with root package name */
    g f687b;
    int c = -1;
    int d = -1;
    private SparseArray<a> e = new SparseArray<>();
    private SparseArray<g> f = new SparseArray<>();
    private i g = null;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f688a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f689b = new ArrayList<>();
        int c = -1;
        g d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == m.State_android_id) {
                    this.f688a = obtainStyledAttributes.getResourceId(index, this.f688a);
                } else if (index == m.State_constraints) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        this.d = new g();
                        this.d.a(context, this.c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f689b.add(bVar);
        }

        public int a(float f, float f2) {
            for (int i = 0; i < this.f689b.size(); i++) {
                if (this.f689b.get(i).a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        float f690a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f691b = Float.NaN;
        float c = Float.NaN;
        float d = Float.NaN;
        int e = -1;
        g f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == m.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f = new g();
                        this.f.a(context, this.e);
                    }
                } else if (index == m.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == m.Variant_region_heightMoreThan) {
                    this.f691b = obtainStyledAttributes.getDimension(index, this.f691b);
                } else if (index == m.Variant_region_widthLessThan) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == m.Variant_region_widthMoreThan) {
                    this.f690a = obtainStyledAttributes.getDimension(index, this.f690a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f690a) && f2 < this.f690a) {
                return false;
            }
            if (!Float.isNaN(this.f691b) && f3 < this.f691b) {
                return false;
            }
            if (!Float.isNaN(this.c) && f2 > this.c) {
                return false;
            }
            if (Float.isNaN(this.d) || f3 <= this.d) {
                return true;
            }
            return false;
        }
    }

    f(Context context, ConstraintLayout constraintLayout, int i) {
        this.f686a = constraintLayout;
        a(context, i);
    }

    public void a(int i, float f2, float f3) {
        g gVar;
        int i2;
        a aVar;
        int a2;
        g gVar2;
        int i3;
        int i4 = this.c;
        if (i4 == i) {
            if (i == -1) {
                aVar = this.e.valueAt(0);
            } else {
                aVar = this.e.get(i4);
            }
            int i5 = this.d;
            if ((i5 == -1 || !aVar.f689b.get(i5).a(f2, f3)) && this.d != (a2 = aVar.a(f2, f3))) {
                if (a2 == -1) {
                    gVar2 = this.f687b;
                } else {
                    gVar2 = aVar.f689b.get(a2).f;
                }
                if (a2 == -1) {
                    i3 = aVar.c;
                } else {
                    i3 = aVar.f689b.get(a2).e;
                }
                if (gVar2 != null) {
                    this.d = a2;
                    i iVar = this.g;
                    if (iVar != null) {
                        iVar.b(-1, i3);
                    }
                    gVar2.a(this.f686a);
                    i iVar2 = this.g;
                    if (iVar2 != null) {
                        iVar2.a(-1, i3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.c = i;
        a aVar2 = this.e.get(this.c);
        int a3 = aVar2.a(f2, f3);
        if (a3 == -1) {
            gVar = aVar2.d;
        } else {
            gVar = aVar2.f689b.get(a3).f;
        }
        if (a3 == -1) {
            i2 = aVar2.c;
        } else {
            i2 = aVar2.f689b.get(a3).e;
        }
        if (gVar == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i + ", dim =" + f2 + ", " + f3);
            return;
        }
        this.d = a3;
        i iVar3 = this.g;
        if (iVar3 != null) {
            iVar3.b(i, i2);
        }
        gVar.a(this.f686a);
        i iVar4 = this.g;
        if (iVar4 != null) {
            iVar4.a(i, i2);
        }
    }

    public void a(i iVar) {
        this.g = iVar;
    }

    private void a(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (!(c2 == 0 || c2 == 1)) {
                        if (c2 == 2) {
                            aVar = new a(context, xml);
                            this.e.put(aVar.f688a, aVar);
                        } else if (c2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        } else if (c2 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            a(context, (XmlPullParser) xml);
                        }
                    }
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        int i;
        g gVar = new g();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if ("mId".equals(xmlPullParser.getAttributeName(i2))) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                if (attributeValue.contains("/")) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "mId", context.getPackageName());
                } else {
                    i = -1;
                }
                if (i == -1) {
                    if (attributeValue == null || attributeValue.length() <= 1) {
                        Log.e("ConstraintLayoutStates", "error in parsing mId");
                    } else {
                        i = Integer.parseInt(attributeValue.substring(1));
                    }
                }
                gVar.a(context, xmlPullParser);
                this.f.put(i, gVar);
                return;
            }
        }
    }
}
