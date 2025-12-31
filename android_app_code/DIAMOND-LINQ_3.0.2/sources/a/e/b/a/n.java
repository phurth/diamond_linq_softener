package a.e.b.a;

import java.util.Arrays;

public class n extends h implements m {
    protected h[] ua = new h[4];
    protected int va = 0;

    public void a(h hVar) {
        int i = this.va + 1;
        h[] hVarArr = this.ua;
        if (i > hVarArr.length) {
            this.ua = (h[]) Arrays.copyOf(hVarArr, hVarArr.length * 2);
        }
        h[] hVarArr2 = this.ua;
        int i2 = this.va;
        hVarArr2[i2] = hVar;
        this.va = i2 + 1;
    }

    public void a() {
        this.va = 0;
    }
}
