package b.b.a.a.e;

import b.b.a.a.d.k;
import b.b.a.a.g.a.d;
import b.b.a.a.g.b.e;

public class b implements e {
    public float a(e eVar, d dVar) {
        float yChartMax = dVar.getYChartMax();
        float yChartMin = dVar.getYChartMin();
        k lineData = dVar.getLineData();
        if (eVar.b() > 0.0f && eVar.g() < 0.0f) {
            return 0.0f;
        }
        if (lineData.g() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.h() < 0.0f) {
            yChartMin = 0.0f;
        }
        return eVar.g() >= 0.0f ? yChartMin : yChartMax;
    }
}
