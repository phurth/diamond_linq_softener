package b.c.a.a.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1286a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1287b = new float[9];
    private final Matrix c = new Matrix();

    public Matrix a(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f1286a);
        matrix2.getValues(this.f1287b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f1287b;
            float f2 = fArr[i];
            float[] fArr2 = this.f1286a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.c.setValues(this.f1287b);
        return this.c;
    }
}
