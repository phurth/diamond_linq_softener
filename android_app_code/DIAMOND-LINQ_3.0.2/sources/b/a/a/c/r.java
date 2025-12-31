package b.a.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import b.a.a.C0168ba;
import b.a.a.ia;
import java.io.InputStream;
import java.io.OutputStream;

public final class r extends C {
    /* access modifiers changed from: private */
    public final BluetoothAdapter f = BluetoothAdapter.getDefaultAdapter();
    /* access modifiers changed from: private */
    public a g;
    private b h;
    private BluetoothDevice i;

    private class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final BluetoothSocket f1107a;

        /* renamed from: b  reason: collision with root package name */
        private final BluetoothDevice f1108b;

        a(BluetoothDevice bluetoothDevice) {
            BluetoothSocket bluetoothSocket;
            try {
                bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(r.this.c.b());
            } catch (Exception unused) {
                bluetoothSocket = null;
            }
            this.f1108b = bluetoothDevice;
            this.f1107a = bluetoothSocket;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|(1:3)|4|5|7) */
        /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r1 = this;
                android.bluetooth.BluetoothSocket r0 = r1.f1107a     // Catch:{ Exception -> 0x0009 }
                if (r0 == 0) goto L_0x0009
                android.bluetooth.BluetoothSocket r0 = r1.f1107a     // Catch:{ Exception -> 0x0009 }
                r0.close()     // Catch:{ Exception -> 0x0009 }
            L_0x0009:
                r1.interrupt()     // Catch:{ Exception -> 0x000c }
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.c.r.a.a():void");
        }

        public void run() {
            setName("ConnectThread");
            if (r.this.f.isDiscovering()) {
                r.this.f.cancelDiscovery();
            }
            try {
                if (this.f1107a != null) {
                    this.f1107a.connect();
                }
                synchronized (r.this) {
                    a unused = r.this.g = null;
                }
                BluetoothSocket bluetoothSocket = this.f1107a;
                if (bluetoothSocket != null) {
                    r.this.a(bluetoothSocket, this.f1108b);
                }
            } catch (Exception e) {
                e.printStackTrace();
                r.this.f();
                try {
                    this.f1107a.close();
                } catch (Exception unused2) {
                }
            }
        }
    }

    private class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final BluetoothSocket f1109a;

        /* renamed from: b  reason: collision with root package name */
        private final InputStream f1110b;
        private final OutputStream c;
        private boolean d = false;

        b(BluetoothSocket bluetoothSocket) {
            InputStream inputStream;
            OutputStream outputStream = null;
            try {
                inputStream = bluetoothSocket.getInputStream();
                try {
                    outputStream = bluetoothSocket.getOutputStream();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                inputStream = null;
            }
            this.f1109a = bluetoothSocket;
            this.f1110b = inputStream;
            this.c = outputStream;
        }

        public /* synthetic */ void a(byte[] bArr, int i) {
            r.this.e.a(bArr, i);
        }

        public void run() {
            byte[] bArr = new byte[1024];
            byte[] bArr2 = new byte[1024];
            while (!this.d) {
                try {
                    if (this.f1110b != null) {
                        int read = this.f1110b.read(bArr);
                        Thread.sleep(150);
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        C0168ba.b(ia.a(">>>+  Read", bArr2, read));
                        if (r.this.e != null) {
                            r.this.a(new C0175f(this, bArr2, read), 150);
                        }
                        Thread.sleep(150);
                    }
                } catch (Exception unused) {
                    r.this.g();
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(byte[] bArr) {
            try {
                if (this.c != null) {
                    C0168ba.b(ia.a("<<<- Write", bArr, bArr.length));
                    this.c.write(bArr);
                    this.c.flush();
                }
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|(1:6)|7|8|10) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x000c A[Catch:{ Exception -> 0x0011 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r1 = this;
                r0 = 1
                r1.d = r0
                android.bluetooth.BluetoothSocket r0 = r1.f1109a     // Catch:{ Exception -> 0x0008 }
                r0.close()     // Catch:{ Exception -> 0x0008 }
            L_0x0008:
                java.io.InputStream r0 = r1.f1110b     // Catch:{ Exception -> 0x0011 }
                if (r0 == 0) goto L_0x0011
                java.io.InputStream r0 = r1.f1110b     // Catch:{ Exception -> 0x0011 }
                r0.close()     // Catch:{ Exception -> 0x0011 }
            L_0x0011:
                r1.interrupt()     // Catch:{ Exception -> 0x0014 }
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.c.r.b.a():void");
        }
    }

    protected r(s sVar) {
        super(sVar);
        this.d = D.Disconnected;
    }

    /* access modifiers changed from: private */
    public void f() {
        b(D.Disconnected);
    }

    /* access modifiers changed from: private */
    public void g() {
        b(D.Disconnected);
    }

    public synchronized void e() {
        a();
        if (C.f1079a == this) {
            C.f1079a = null;
        }
    }

    public BluetoothDevice b() {
        return this.i;
    }

    public synchronized void a(BluetoothDevice bluetoothDevice) {
        a();
        if (bluetoothDevice != null) {
            this.g = new a(bluetoothDevice);
            this.g.start();
            b(D.Connecting);
        }
    }

    public void a() {
        a aVar = this.g;
        if (aVar != null) {
            aVar.a();
            this.g = null;
        }
        b bVar = this.h;
        if (bVar != null) {
            bVar.a();
            this.h = null;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        this.i = bluetoothDevice;
        this.h = new b(bluetoothSocket);
        this.h.start();
        b(D.Connected);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            b.a.a.c.D r0 = r2.d     // Catch:{ all -> 0x0014 }
            b.a.a.c.D r1 = b.a.a.c.D.Connected     // Catch:{ all -> 0x0014 }
            if (r0 == r1) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            b.a.a.c.r$b r0 = r2.h     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0012
            if (r3 == 0) goto L_0x0012
            r0.a(r3)     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r2)
            return
        L_0x0014:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.c.r.a(byte[]):void");
    }
}
