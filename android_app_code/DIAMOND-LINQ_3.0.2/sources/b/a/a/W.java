package b.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.fragment.app.C0132h;
import androidx.fragment.app.C0139o;
import androidx.fragment.app.D;
import no.nordicsemi.android.log.BuildConfig;

public final class W {
    public static void a(Context context, C0139o oVar, String str) {
        String str2;
        boolean z = context.getResources().getBoolean(ya.show_short_url_in_contact_dialog);
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str2 = "1.0";
        }
        String string = context.getString(Fa.ci_title);
        int i = Fa.ci_message;
        Object[] objArr = new Object[7];
        objArr[0] = context.getString(Fa.company_name);
        objArr[1] = context.getString(Fa.company_phone);
        objArr[2] = context.getString(Fa.company_support_email);
        objArr[3] = context.getString(z ? Fa.company_website_short : Fa.company_website);
        objArr[4] = context.getString(Fa.company_privacy_policy);
        objArr[5] = str2;
        objArr[6] = Z.a(context);
        String string2 = context.getString(i, objArr);
        if (!context.getResources().getBoolean(ya.show_privacy_policy)) {
            int i2 = Fa.ci_message_no_policy;
            Object[] objArr2 = new Object[6];
            objArr2[0] = context.getString(Fa.company_name);
            objArr2[1] = context.getString(Fa.company_phone);
            objArr2[2] = context.getString(Fa.company_support_email);
            objArr2[3] = context.getString(z ? Fa.company_website_short : Fa.company_website);
            objArr2[4] = str2;
            objArr2[5] = Z.a(context);
            string2 = context.getString(i2, objArr2);
        }
        N n = (N) oVar.a("com.ChandlerSystemsInc.SignatureAppCore.dialog_contact");
        if (n == null) {
            n = new N();
        } else {
            D a2 = oVar.a();
            a2.a((C0132h) n);
            a2.a();
        }
        n.b(str, string, string2);
        D a3 = oVar.a();
        a3.a((C0132h) n, "com.ChandlerSystemsInc.SignatureAppCore.dialog_contact");
        a3.a();
    }

    public static void b(C0139o oVar, String str, String str2, String str3, String str4) {
        d(oVar, str, str2, str3, str4);
    }

    private static void c(C0139o oVar, String str, String str2, String str3, String str4) {
        O o = (O) oVar.a("com.ChandlerSystemsInc.SignatureAppCore.dialog_information");
        if (o == null) {
            o = new O();
        } else {
            D a2 = oVar.a();
            a2.a((C0132h) o);
            a2.a();
        }
        o.a(str, str2, str3, str4);
        D a3 = oVar.a();
        a3.a((C0132h) o, "com.ChandlerSystemsInc.SignatureAppCore.dialog_information");
        a3.a();
    }

    private static void d(C0139o oVar, String str, String str2, String str3, String str4) {
        U u = (U) oVar.a("com.ChandlerSystemsInc.SignatureAppCore.dialog_share");
        if (u == null) {
            u = new U();
        } else {
            D a2 = oVar.a();
            a2.a((C0132h) u);
            a2.a();
        }
        u.a(str, str2, str3, str4);
        D a3 = oVar.a();
        a3.a((C0132h) u, "com.ChandlerSystemsInc.SignatureAppCore.dialog_share");
        a3.a();
    }

    public static void b(C0139o oVar, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6) {
        a(oVar, Q.IntInput, str, Aa.ic_edit, str2, str3, str4, str5, i, i2, i3, str6);
    }

    public static void a(C0139o oVar) {
        M m = (M) oVar.a("com.ChandlerSystemsInc.SignatureAppCore.dialog_compliance");
        if (m == null) {
            m = new M();
        } else {
            D a2 = oVar.a();
            a2.a((C0132h) m);
            a2.a();
        }
        D a3 = oVar.a();
        a3.a((C0132h) m, "com.ChandlerSystemsInc.SignatureAppCore.dialog_compliance");
        a3.a();
    }

    public static void a(C0139o oVar, String str, String str2) {
        c(oVar, BuildConfig.FLAVOR, str, str2, BuildConfig.FLAVOR);
    }

    public static void a(C0139o oVar, String str, String str2, String str3, String str4) {
        c(oVar, str, str2, str3, str4);
    }

    public static void a(C0139o oVar, String str, String[] strArr) {
        X x = (X) oVar.a("com.ChandlerSystemsInc.SignatureAppCore.dialog_view_graph");
        if (x == null) {
            x = new X();
        } else {
            D a2 = oVar.a();
            a2.a((C0132h) x);
            a2.a();
        }
        x.a(str, strArr);
        D a3 = oVar.a();
        a3.a((C0132h) x, "com.ChandlerSystemsInc.SignatureAppCore.dialog_view_graph");
        a3.a();
    }

    public static void a(Context context, C0139o oVar, String str, String str2, String str3, String str4) {
        a(oVar, str, str2, str3, context.getString(Fa.ok), context.getString(Fa.cancel), str4);
    }

    public static void a(C0139o oVar, String str, String str2, String str3, String str4, String str5, String str6) {
        C0139o oVar2 = oVar;
        T t = (T) oVar.a("com.ChandlerSystemsInc.SignatureAppCore.dialog_question");
        if (t == null) {
            t = new T();
        } else {
            D a2 = oVar.a();
            a2.a((C0132h) t);
            a2.a();
        }
        t.a(str, str2, str3, str4, str5, str6);
        D a3 = oVar.a();
        a3.a((C0132h) t, "com.ChandlerSystemsInc.SignatureAppCore.dialog_question");
        a3.a();
    }

    public static void a(C0139o oVar, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        a(oVar, Q.StringInput, str, Aa.ic_edit, str2, str3, str4, str5, i, 0, 0, str6);
    }

    public static void a(C0139o oVar, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6) {
        a(oVar, Q.IntInput, str, Aa.ic_edit, str2, str3, str4, str5, i, i2, i3, str6);
    }

    private static void a(C0139o oVar, Q q, String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6) {
        P p = (P) oVar.a("com.ChandlerSystemsInc.SignatureAppCore.dialog_input");
        if (p == null) {
            p = new P();
        } else {
            D a2 = oVar.a();
            a2.a((C0132h) p);
            a2.a();
        }
        p.a(q, str, i, str2, str3, str4, str5, i2, i3, i4, str6);
        D a3 = oVar.a();
        a3.a((C0132h) p, "com.ChandlerSystemsInc.SignatureAppCore.dialog_input");
        a3.a();
    }

    public static void a(C0139o oVar, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, B b2, String str6) {
        a(oVar, str, Aa.ic_time, str2, str3, str4, str5, i, i2, i3, b2, str6);
    }

    private static void a(C0139o oVar, String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, int i4, B b2, String str6) {
        V v = (V) oVar.a("com.ChandlerSystemsInc.SignatureAppCore.dialog_time_input");
        if (v == null) {
            v = new V();
        } else {
            D a2 = oVar.a();
            a2.a((C0132h) v);
            a2.a();
        }
        v.a(str, i, str2, str3, str4, str5, i2, i3, i4, b2, str6);
        D a3 = oVar.a();
        a3.a((C0132h) v, "com.ChandlerSystemsInc.SignatureAppCore.dialog_time_input");
        a3.a();
    }
}
