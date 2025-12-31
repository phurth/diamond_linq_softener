package b.a.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.C0129e;
import androidx.fragment.app.C0134j;
import androidx.fragment.app.C0139o;
import b.a.a.Aa;
import b.a.a.Ba;
import b.a.a.Da;
import b.a.a.Fa;
import b.a.a.ia;
import b.a.a.za;
import b.b.a.a.c.i;
import b.b.a.a.d.j;
import b.b.a.a.d.k;
import b.b.a.a.d.l;
import b.b.a.a.e.d;
import b.b.a.a.e.f;
import com.chandlersystemsinc.signatureappcore.views.CsGridGraphView;
import com.github.mikephil.charting.charts.LineChart;
import java.util.ArrayList;
import java.util.Calendar;
import no.nordicsemi.android.log.BuildConfig;

public final class c extends C0129e {
    private LineChart ga;
    /* access modifiers changed from: private */
    public CsGridGraphView.a ha;
    private float[] ia;
    private float[] ja;
    private boolean ka;
    /* access modifiers changed from: private */
    public long la;
    /* access modifiers changed from: private */
    public String ma;
    private String na;

    class a implements f {
        a() {
        }

        public String a(float f, j jVar, int i, b.b.a.a.j.j jVar2) {
            Context m = c.this.m();
            if (c.this.ma.equals(m != null ? m.getResources().getString(Fa.ic_peak_flow_recorded_per_day) : "Peak Flow Recorded Per Day")) {
                return ia.a((double) f);
            }
            return String.valueOf((int) f);
        }
    }

    class b implements d {
        b() {
        }

        public String a(float f, b.b.a.a.c.a aVar) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(c.this.la);
            if (c.this.ha != CsGridGraphView.a.Daily) {
                return c.this.ha == CsGridGraphView.a.Gallons ? String.valueOf(Integer.valueOf(42 - ((int) f))) : BuildConfig.FLAVOR;
            }
            instance.set(5, (instance.get(5) - 1) - 61);
            instance.add(5, (int) f);
            instance.getTime();
            return String.valueOf(instance.get(2) + 1).concat("/").concat(ia.b(instance.get(5)));
        }
    }

    private void d(String str) {
        this.na = str;
    }

    private void h(boolean z) {
        this.ka = z;
    }

    private void ka() {
        if (this.ia != null && this.ja != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                float[] fArr = this.ja;
                if (i >= fArr.length) {
                    break;
                }
                arrayList.add(new j(this.ia[i], fArr[i]));
                i++;
            }
            i xAxis = this.ga.getXAxis();
            xAxis.a(i.a.BOTTOM);
            xAxis.a(w().getColor(za.graph_detail_text_color));
            xAxis.a((d) new b());
            xAxis.b(1.0f);
            b.b.a.a.c.j axisLeft = this.ga.getAxisLeft();
            axisLeft.a(w().getColor(za.graph_detail_text_color));
            axisLeft.a(0.0f);
            b.b.a.a.c.j axisRight = this.ga.getAxisRight();
            axisRight.d(false);
            axisRight.c(false);
            l lVar = new l(arrayList, BuildConfig.FLAVOR);
            lVar.g(w().getColor(za.graph_circle_color));
            lVar.b(2.0f);
            lVar.a((f) new a());
            lVar.f(w().getColor(za.graph_stroke_color));
            if (this.ka) {
                lVar.c(true);
                lVar.a(w().getDrawable(Aa.graph_fill_color));
            }
            k kVar = new k(lVar);
            kVar.b(w().getColor(za.graph_detail_text_color));
            b.b.a.a.c.c cVar = new b.b.a.a.c.c();
            cVar.a(false);
            this.ga.setDescription(cVar);
            this.ga.setNoDataText(a(Fa.graph_loading));
            this.ga.setMaxVisibleValueCount(20);
            this.ga.getLegend().a(false);
            this.ga.setData(kVar);
            this.ga.invalidate();
        }
    }

    public void e(Bundle bundle) {
        bundle.putFloatArray("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.x_values", this.ia);
        bundle.putFloatArray("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.y_values", this.ja);
        bundle.putLong("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.base_time", this.la);
        bundle.putString("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.title", this.ma);
        bundle.putString("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.units", this.na);
        super.e(bundle);
    }

    public void a(C0139o oVar, CsGridGraphView.a aVar, boolean z, float[] fArr, float[] fArr2, long j, String str, String str2) {
        c cVar = new c();
        cVar.a(aVar);
        cVar.h(z);
        cVar.a(fArr);
        cVar.b(fArr2);
        cVar.a(j);
        cVar.c(str);
        cVar.d(str2);
        cVar.a(oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.graph_dialog_fragment");
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        ka();
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        if (bundle != null) {
            this.ia = bundle.getFloatArray("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.x_values");
            this.ja = bundle.getFloatArray("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.y_values");
            this.la = bundle.getLong("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.base_time");
            this.ma = bundle.getString("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.title", BuildConfig.FLAVOR);
            this.na = bundle.getString("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.units", BuildConfig.FLAVOR);
        }
    }

    private void b(float[] fArr) {
        this.ja = fArr;
    }

    public /* synthetic */ void c(View view) {
        ha();
    }

    private void c(String str) {
        this.ma = str;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(Da.activity_graph_detail, (ViewGroup) null);
        ia().requestWindowFeature(1);
        this.ga = (LineChart) inflate.findViewById(Ba.lineChart);
        TextView textView = (TextView) inflate.findViewById(Ba.title);
        TextView textView2 = (TextView) inflate.findViewById(Ba.y_units_text);
        ImageView imageView = (ImageView) inflate.findViewById(Ba.close_button);
        if (ia.a(this.ma)) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.ma);
        }
        textView2.setText(this.na);
        imageView.setOnClickListener(new b(this));
        ia().requestWindowFeature(1);
        ia().setCancelable(false);
        g(false);
        C0134j f = f();
        Window window = ia().getWindow();
        if (!(f == null || window == null)) {
            window.setFlags(8, 8);
            window.getDecorView().setSystemUiVisibility(f.getWindow().getDecorView().getSystemUiVisibility());
            ia().setOnShowListener(new a(this, window, f));
        }
        return inflate;
    }

    public /* synthetic */ void a(Window window, C0134j jVar, DialogInterface dialogInterface) {
        window.clearFlags(8);
        try {
            ((WindowManager) jVar.getSystemService("window")).updateViewLayout(window.getDecorView(), window.getAttributes());
        } catch (Exception unused) {
        }
        double d = (double) w().getDisplayMetrics().widthPixels;
        Double.isNaN(d);
        double d2 = (double) w().getDisplayMetrics().heightPixels;
        Double.isNaN(d2);
        window.setLayout((int) (d * 0.95d), (int) (d2 * 0.95d));
    }

    private void a(CsGridGraphView.a aVar) {
        this.ha = aVar;
    }

    private void a(float[] fArr) {
        this.ia = fArr;
    }

    private void a(long j) {
        this.la = j;
    }
}
