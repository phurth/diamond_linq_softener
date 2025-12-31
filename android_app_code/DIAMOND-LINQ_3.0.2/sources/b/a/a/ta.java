package b.a.a;

import a.g.a.a;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.m;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.d.i;
import com.chandlersystemsinc.signatureappcore.views.CsGridGraphView;
import java.util.Calendar;
import no.nordicsemi.android.log.BuildConfig;

public final class ta extends RecyclerView.x {
    private final CsGridGraphView A;
    private final TextView B;
    private final Switch C;
    private final ImageView D;
    private final ImageView E;
    private final ImageView F;
    private final ImageView G;
    private String H;
    private String I;
    private final Context t;
    private final i u;
    private final TextView v;
    private final LinearLayout w;
    private final TextView x;
    private final TextView y;
    private final TextView z;

    public ta(View view, i iVar) {
        super(view);
        this.t = view.getContext();
        this.u = iVar;
        this.v = (TextView) view.findViewById(Ba.title);
        this.w = (LinearLayout) view.findViewById(Ba.regen_step_layout);
        this.x = (TextView) view.findViewById(Ba.regen_step_title);
        this.y = (TextView) view.findViewById(Ba.regen_step);
        this.z = (TextView) view.findViewById(Ba.value);
        this.B = (TextView) view.findViewById(Ba.function);
        this.C = (Switch) view.findViewById(Ba.toggle);
        this.D = (ImageView) view.findViewById(Ba.info_icon);
        this.E = (ImageView) view.findViewById(Ba.data_view);
        this.F = (ImageView) view.findViewById(Ba.data_export);
        this.G = (ImageView) view.findViewById(Ba.battery_icon);
        C0198w wVar = new C0198w(this);
        view.findViewById(Ba.layout).setOnClickListener(wVar);
        view.findViewById(Ba.content).setOnClickListener(wVar);
        this.v.setOnClickListener(wVar);
        this.w.setOnClickListener(wVar);
        this.z.setOnClickListener(wVar);
        this.B.setOnClickListener(wVar);
        this.C.setOnCheckedChangeListener(new C0199x(this));
        this.D.setOnClickListener(new C0200y(this));
        this.E.setOnClickListener(new A(this));
        this.F.setOnClickListener(new C0201z(this));
        this.A = (CsGridGraphView) view.findViewById(Ba.graph);
        this.A.setFragmentManager(((m) view.getContext()).s());
    }

    public /* synthetic */ void a(View view) {
        int f = f();
        if (f != -1) {
            this.u.a(f);
        }
    }

    public /* synthetic */ void b(View view) {
        if (view.getContext() != null) {
            W.a(((m) view.getContext()).s(), this.H, this.I);
        }
    }

    public /* synthetic */ void c(View view) {
        this.u.b(this.v.getText().toString());
    }

    public /* synthetic */ void d(View view) {
        this.u.a(this.v.getText().toString());
    }

    public void c(boolean z2) {
        this.C.setChecked(z2);
        this.C.getThumbDrawable().setColorFilter(a.a(this.t, z2 ? za.switch_thumb_on : za.switch_thumb_off), PorterDuff.Mode.SRC_IN);
        this.C.getTrackDrawable().setColorFilter(a.a(this.t, z2 ? za.switch_track_on : za.switch_track_off), PorterDuff.Mode.SRC_IN);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        this.u.a(z2, this.v.getText().toString());
    }

    public void a(String str) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(boolean z2) {
        this.A.setDrawFilled(z2);
    }

    public void a(String str, int i) {
        this.z.setText(str);
        this.z.setTextColor(i);
    }

    public void a(String str, boolean z2, boolean z3, int i, int i2) {
        this.B.setText(str);
        this.B.setVisibility((!z2 || z3) ? 4 : 0);
        this.B.setTypeface((Typeface) null, z2 ? 1 : 0);
        TextView textView = this.B;
        if (!z2) {
            i = i2;
        }
        textView.setTextColor(i);
    }

    public void a(boolean z2, boolean z3, String str, String str2, String str3, String str4) {
        int i = 0;
        this.w.setVisibility(z2 ? 0 : 8);
        this.x.setText(str);
        this.y.setText(str2);
        TextView textView = this.B;
        if (!z2) {
            str3 = str4;
        }
        textView.setText(str3);
        TextView textView2 = this.B;
        if (!z2 && z3) {
            i = 4;
        }
        textView2.setVisibility(i);
    }

    public void a(boolean z2, String str, String str2) {
        this.H = str;
        this.I = str2;
        this.D.setVisibility(z2 ? 0 : 8);
    }

    public void a(boolean z2, int i) {
        if (i == 0) {
            this.G.setImageResource(Aa.ic_battery_0);
        } else if (i > 0 && i <= 10) {
            this.G.setImageResource(Aa.ic_battery_10);
        } else if (i > 10 && i <= 20) {
            this.G.setImageResource(Aa.ic_battery_20);
        } else if (i > 20 && i <= 30) {
            this.G.setImageResource(Aa.ic_battery_30);
        } else if (i > 30 && i <= 40) {
            this.G.setImageResource(Aa.ic_battery_40);
        } else if (i > 40 && i <= 50) {
            this.G.setImageResource(Aa.ic_battery_50);
        } else if (i > 50 && i <= 60) {
            this.G.setImageResource(Aa.ic_battery_60);
        } else if (i > 60 && i <= 70) {
            this.G.setImageResource(Aa.ic_battery_70);
        } else if (i > 70 && i <= 80) {
            this.G.setImageResource(Aa.ic_battery_80);
        } else if (i > 80 && i <= 90) {
            this.G.setImageResource(Aa.ic_battery_90);
        } else if (i > 90) {
            this.G.setImageResource(Aa.ic_battery_100);
        }
        this.G.setVisibility(z2 ? 0 : 8);
    }

    public void a(qa qaVar) {
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        this.C.setVisibility(8);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        int i = sa.f1183a[qaVar.ordinal()];
        if (i == 1) {
            this.z.setVisibility(0);
        } else if (i == 2) {
            this.C.setVisibility(0);
        } else if (i == 3) {
            this.A.setVisibility(0);
            this.E.setVisibility(0);
            this.F.setVisibility(0);
        }
    }

    public void a(CsGridGraphView.a aVar, String str, float[] fArr, float[] fArr2) {
        Calendar instance = Calendar.getInstance();
        try {
            this.A.setChartType(aVar);
            this.A.setGraphTitle(this.v != null ? this.v.getText().toString() : BuildConfig.FLAVOR);
            this.A.setUnits(str);
            this.A.setBaseTime(instance.getTimeInMillis());
            this.A.setXValues(fArr);
            this.A.setYValues(fArr2);
            this.A.d();
        } catch (Exception unused) {
        }
    }
}
