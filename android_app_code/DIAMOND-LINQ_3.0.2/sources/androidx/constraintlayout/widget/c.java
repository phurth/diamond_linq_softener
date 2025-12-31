package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class c {

    /* renamed from: a  reason: collision with root package name */
    String f679a;

    /* renamed from: b  reason: collision with root package name */
    private a f680b;
    private int c;
    private float d;
    private String e;
    boolean f;
    private int g;

    public enum a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public c(String str, a aVar, Object obj) {
        this.f679a = str;
        this.f680b = aVar;
        a(obj);
    }

    public void a(Object obj) {
        switch (b.f678a[this.f680b.ordinal()]) {
            case 1:
            case 2:
                this.g = ((Integer) obj).intValue();
                return;
            case 3:
                this.c = ((Integer) obj).intValue();
                return;
            case 4:
                this.d = ((Float) obj).floatValue();
                return;
            case 5:
                this.e = (String) obj;
                return;
            case 6:
                this.f = ((Boolean) obj).booleanValue();
                return;
            case 7:
                this.d = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public c(c cVar, Object obj) {
        this.f679a = cVar.f679a;
        this.f680b = cVar.f680b;
        a(obj);
    }

    public static HashMap<String, c> a(HashMap<String, c> hashMap, View view) {
        HashMap<String, c> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            c cVar = hashMap.get(next);
            try {
                if (next.equals("BackgroundColor")) {
                    hashMap2.put(next, new c(cVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(next, new c(cVar, cls.getMethod("getMap" + next, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void a(View view, HashMap<String, c> hashMap) {
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            c cVar = hashMap.get(next);
            String str = "set" + next;
            try {
                switch (b.f678a[cVar.f680b.ordinal()]) {
                    case 1:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(cVar.g)});
                        break;
                    case 2:
                        Method method = cls.getMethod(str, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(cVar.g);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case 3:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(cVar.c)});
                        break;
                    case 4:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(cVar.d)});
                        break;
                    case 5:
                        cls.getMethod(str, new Class[]{CharSequence.class}).invoke(view, new Object[]{cVar.e});
                        break;
                    case 6:
                        cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(cVar.f)});
                        break;
                    case 7:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(cVar.d)});
                        break;
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, c> hashMap) {
        a aVar;
        Object string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        a aVar2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == m.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == m.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar2 = a.BOOLEAN_TYPE;
            } else {
                if (index == m.CustomAttribute_customColorValue) {
                    aVar = a.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == m.CustomAttribute_customColorDrawableValue) {
                    aVar = a.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == m.CustomAttribute_customDimension) {
                    aVar = a.DIMENSION_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == m.CustomAttribute_customFloatValue) {
                    aVar = a.FLOAT_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == m.CustomAttribute_customIntegerValue) {
                    aVar = a.INT_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == m.CustomAttribute_customStringValue) {
                    aVar = a.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                Object obj2 = string;
                aVar2 = aVar;
                obj = obj2;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new c(str, aVar2, obj));
        }
        obtainStyledAttributes.recycle();
    }
}
