package b.a.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.d.d;

public final class L extends RecyclerView.x {
    private final d t;
    private final TextView u;
    private final ImageView v;

    public L(View view, d dVar) {
        super(view);
        this.t = dVar;
        this.u = (TextView) view.findViewById(Ba.title);
        this.v = (ImageView) view.findViewById(Ba.icon);
        C0165a aVar = new C0165a(this);
        ((ConstraintLayout) view.findViewById(Ba.device_row)).setOnClickListener(aVar);
        this.u.setOnClickListener(aVar);
        this.v.setOnClickListener(aVar);
    }

    public /* synthetic */ void a(View view) {
        this.t.a(view, f(), this.u.getText().toString());
    }

    public void a(String str) {
        this.u.setText(str);
    }

    public void a(Drawable drawable) {
        this.v.setImageDrawable(drawable);
    }
}
