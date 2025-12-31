package a.a.d;

import a.a.j;
import a.g.i.C0038b;
import a.g.i.C0043g;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.S;
import androidx.appcompat.widget.za;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?>[] f26a = {Context.class};

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f27b = f26a;
    final Object[] c;
    final Object[] d = this.c;
    Context e;
    private Object f;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f28a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f29b;
        private Method c;

        public a(Object obj, String str) {
            this.f29b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, f28a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.f29b, new Object[]{menuItem})).booleanValue();
                }
                this.c.invoke(this.f29b, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.d();
                        } else if (name2.equals("item")) {
                            if (!bVar.c()) {
                                C0038b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.a(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.b(attributeSet);
                    } else if (name3.equals("menu")) {
                        a(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                i = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof a.g.c.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.e.getResources().getLayout(i);
            a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private class b {
        C0038b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f30a;

        /* renamed from: b  reason: collision with root package name */
        private int f31b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.f30a = menu;
            d();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.e.obtainStyledAttributes(attributeSet, j.MenuGroup);
            this.f31b = obtainStyledAttributes.getResourceId(j.MenuGroup_android_id, 0);
            this.c = obtainStyledAttributes.getInt(j.MenuGroup_android_menuCategory, 0);
            this.d = obtainStyledAttributes.getInt(j.MenuGroup_android_orderInCategory, 0);
            this.e = obtainStyledAttributes.getInt(j.MenuGroup_android_checkableBehavior, 0);
            this.f = obtainStyledAttributes.getBoolean(j.MenuGroup_android_visible, true);
            this.g = obtainStyledAttributes.getBoolean(j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            za a2 = za.a(g.this.e, attributeSet, j.MenuItem);
            this.i = a2.g(j.MenuItem_android_id, 0);
            this.j = (a2.d(j.MenuItem_android_menuCategory, this.c) & -65536) | (a2.d(j.MenuItem_android_orderInCategory, this.d) & 65535);
            this.k = a2.e(j.MenuItem_android_title);
            this.l = a2.e(j.MenuItem_android_titleCondensed);
            this.m = a2.g(j.MenuItem_android_icon, 0);
            this.n = a(a2.d(j.MenuItem_android_alphabeticShortcut));
            this.o = a2.d(j.MenuItem_alphabeticModifiers, 4096);
            this.p = a(a2.d(j.MenuItem_android_numericShortcut));
            this.q = a2.d(j.MenuItem_numericModifiers, 4096);
            if (a2.g(j.MenuItem_android_checkable)) {
                this.r = a2.a(j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = a2.a(j.MenuItem_android_checked, false);
            this.t = a2.a(j.MenuItem_android_visible, this.f);
            this.u = a2.a(j.MenuItem_android_enabled, this.g);
            this.v = a2.d(j.MenuItem_showAsAction, -1);
            this.z = a2.d(j.MenuItem_android_onClick);
            this.w = a2.g(j.MenuItem_actionLayout, 0);
            this.x = a2.d(j.MenuItem_actionViewClass);
            this.y = a2.d(j.MenuItem_actionProviderClass);
            boolean z2 = this.y != null;
            if (z2 && this.w == 0 && this.x == null) {
                this.A = (C0038b) a(this.y, g.f27b, g.this.d);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = a2.e(j.MenuItem_contentDescription);
            this.C = a2.e(j.MenuItem_tooltipText);
            if (a2.g(j.MenuItem_iconTintMode)) {
                this.E = S.a(a2.d(j.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (a2.g(j.MenuItem_iconTint)) {
                this.D = a2.a(j.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            a2.a();
            this.h = false;
        }

        public boolean c() {
            return this.h;
        }

        public void d() {
            this.f31b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        private char a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z3 = menuItem instanceof o;
            if (z3) {
                o oVar = (o) menuItem;
            }
            if (this.r >= 2) {
                if (z3) {
                    ((o) menuItem).c(true);
                } else if (menuItem instanceof p) {
                    ((p) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f26a, g.this.c));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            C0038b bVar = this.A;
            if (bVar != null) {
                C0043g.a(menuItem, bVar);
            }
            C0043g.a(menuItem, this.B);
            C0043g.b(menuItem, this.C);
            C0043g.a(menuItem, this.n, this.o);
            C0043g.b(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                C0043g.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                C0043g.a(menuItem, colorStateList);
            }
        }

        public SubMenu b() {
            this.h = true;
            SubMenu addSubMenu = this.f30a.addSubMenu(this.f31b, this.i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public void a() {
            this.h = true;
            a(this.f30a.add(this.f31b, this.i, this.j, this.k));
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = g.this.e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object a() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
