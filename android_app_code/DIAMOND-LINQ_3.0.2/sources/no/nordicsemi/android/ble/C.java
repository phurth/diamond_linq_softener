package no.nordicsemi.android.ble;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import no.nordicsemi.android.ble.E;
import no.nordicsemi.android.ble.N;
import no.nordicsemi.android.ble.a.c;
import no.nordicsemi.android.ble.a.k;
import no.nordicsemi.android.ble.d.b;

public abstract class C<E extends E> extends T implements no.nordicsemi.android.ble.d.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final UUID f1572a = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    /* renamed from: b  reason: collision with root package name */
    private static final UUID f1573b = UUID.fromString("0000180F-0000-1000-8000-00805f9b34fb");
    /* access modifiers changed from: private */
    public static final UUID c = UUID.fromString("00002A19-0000-1000-8000-00805f9b34fb");
    private static final UUID d = UUID.fromString("00001801-0000-1000-8000-00805f9b34fb");
    /* access modifiers changed from: private */
    public static final UUID e = UUID.fromString("00002A05-0000-1000-8000-00805f9b34fb");
    /* access modifiers changed from: private */
    public O A;
    /* access modifiers changed from: private */
    public final HashMap<BluetoothGattCharacteristic, W> B = new HashMap<>();
    /* access modifiers changed from: private */
    public X C;
    /* access modifiers changed from: private */
    @Deprecated
    public W D;
    private final BroadcastReceiver E = new C0250y(this);
    private BroadcastReceiver F = new z(this);
    private final BroadcastReceiver G = new A(this);
    private final Object f = new Object();
    private final Context g;
    final Handler h;
    /* access modifiers changed from: private */
    public BluetoothGatt i;
    /* access modifiers changed from: private */
    public BluetoothDevice j;
    /* access modifiers changed from: private */
    public C<E>.a k;
    protected E l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public long p;
    /* access modifiers changed from: private */
    public boolean q;
    /* access modifiers changed from: private */
    public boolean r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public int t = 0;
    /* access modifiers changed from: private */
    public int u = 0;
    @Deprecated
    private int v = -1;
    /* access modifiers changed from: private */
    public int w = 23;
    /* access modifiers changed from: private */
    public boolean x;
    /* access modifiers changed from: private */
    public F y;
    /* access modifiers changed from: private */
    public N z;

    protected abstract class a extends MainThreadBluetoothGattCallback {

        /* renamed from: b  reason: collision with root package name */
        private final Deque<N> f1574b = new LinkedList();
        /* access modifiers changed from: private */
        public Deque<N> c;
        private boolean d;
        /* access modifiers changed from: private */
        public boolean e;
        private boolean f = false;

        protected a() {
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public Deque<N> a(BluetoothGatt bluetoothGatt) {
            return null;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor) {
        }

        /* access modifiers changed from: protected */
        public abstract void b();

        /* access modifiers changed from: protected */
        @Deprecated
        public void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor) {
        }

        /* access modifiers changed from: protected */
        public boolean b(BluetoothGatt bluetoothGatt) {
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract void c();

        /* access modifiers changed from: protected */
        @Deprecated
        public void c(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        }

        /* access modifiers changed from: package-private */
        public final void c(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
            if (i == 0) {
                C c2 = C.this;
                c2.a(4, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value: " + b.a(bArr));
                c(bluetoothGatt, bluetoothGattCharacteristic);
                if (C.this.z instanceof L) {
                    L l = (L) C.this.z;
                    boolean a2 = l.a(bArr);
                    if (a2) {
                        l.a(bluetoothGatt.getDevice(), bArr);
                    }
                    if (!a2 || l.g()) {
                        b((N) l);
                    } else {
                        l.c(bluetoothGatt.getDevice());
                    }
                }
            } else if (i == 5 || i == 8 || i == 137) {
                C c3 = C.this;
                c3.a(5, "Authentication required (" + i + ")");
                if (bluetoothGatt.getDevice().getBondState() != 10) {
                    Log.w("BleManager", "Phone has lost bonding information");
                    C.this.l.a(bluetoothGatt.getDevice(), "Phone has lost bonding information", i);
                    return;
                }
                return;
            } else {
                Log.e("BleManager", "onCharacteristicRead error " + i);
                if (C.this.z instanceof L) {
                    C.this.z.a(bluetoothGatt.getDevice(), i);
                }
                X unused = C.this.C = null;
                a(bluetoothGatt.getDevice(), "Error on reading characteristic", i);
            }
            a(true);
        }

        /* access modifiers changed from: protected */
        public abstract boolean c(BluetoothGatt bluetoothGatt);

        /* access modifiers changed from: protected */
        public void d() {
            C c2 = C.this;
            c2.l.a(c2.i.getDevice());
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void d(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        }

        /* access modifiers changed from: protected */
        public void e() {
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void e(BluetoothGatt bluetoothGatt, int i) {
        }

        /* access modifiers changed from: package-private */
        public final void e(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                C c2 = C.this;
                c2.a(4, "MTU changed to: " + i);
                int unused = C.this.w = i;
                f(bluetoothGatt, i);
                if (C.this.z instanceof I) {
                    ((I) C.this.z).b(bluetoothGatt.getDevice(), i);
                    C.this.z.c(bluetoothGatt.getDevice());
                }
            } else {
                Log.e("BleManager", "onMtuChanged error: " + i2 + ", mtu: " + i);
                if (C.this.z instanceof I) {
                    C.this.z.a(bluetoothGatt.getDevice(), i2);
                    X unused2 = C.this.C = null;
                }
                a(bluetoothGatt.getDevice(), "Error on mtu request", i2);
            }
            a(true);
        }

        /* access modifiers changed from: protected */
        @TargetApi(26)
        @Deprecated
        public void e(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void f(BluetoothGatt bluetoothGatt, int i) {
        }

        /* access modifiers changed from: package-private */
        public final void f(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                C c2 = C.this;
                c2.a(4, "Remote RSSI received: " + i + " dBm");
                if (C.this.z instanceof M) {
                    ((M) C.this.z).b(bluetoothGatt.getDevice(), i);
                    C.this.z.c(bluetoothGatt.getDevice());
                }
            } else {
                C c3 = C.this;
                c3.a(5, "Reading remote RSSI failed with status " + i2);
                if (C.this.z instanceof M) {
                    C.this.z.a(bluetoothGatt.getDevice(), i2);
                }
                X unused = C.this.C = null;
                C.this.l.a(bluetoothGatt.getDevice(), "Error on RSSI read", i2);
            }
            a(true);
        }

        /* access modifiers changed from: package-private */
        public final void d(BluetoothGatt bluetoothGatt, int i, int i2) {
            C c2 = C.this;
            c2.a(3, "[Callback] Connection state changed with status: " + i + " and new state: " + i2 + " (" + C.this.c(i2) + ")");
            boolean z = true;
            if (i != 0 || i2 != 2) {
                if (i2 == 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    boolean z2 = C.this.p > 0;
                    boolean z3 = z2 && elapsedRealtime > C.this.p + 20000;
                    if (i != 0) {
                        C c3 = C.this;
                        c3.a(5, "Error: (0x" + Integer.toHexString(i) + "): " + no.nordicsemi.android.ble.c.a.b(i));
                    }
                    if (i == 0 || !z2 || z3 || C.this.y == null || !C.this.y.g()) {
                        this.e = true;
                        a();
                        this.c = null;
                        boolean unused = C.this.q = false;
                        boolean d2 = C.this.o;
                        b(bluetoothGatt.getDevice());
                        if (!(C.this.z == null || C.this.z.c == N.a.DISCONNECT || C.this.z.c == N.a.REMOVE_BOND)) {
                            C.this.z.a(bluetoothGatt.getDevice(), i == 0 ? -1 : i);
                            N unused2 = C.this.z = null;
                        }
                        if (C.this.C != null) {
                            C.this.C.a(C.this.j, -1);
                            X unused3 = C.this.C = null;
                        }
                        if (C.this.y != null) {
                            C.this.y.a(bluetoothGatt.getDevice(), C.this.r ? -2 : i == 0 ? -1 : (i != 133 || !z3) ? i : -5);
                            F unused4 = C.this.y = null;
                        }
                        this.e = false;
                        if (!d2 || !C.this.n) {
                            boolean unused5 = C.this.n = false;
                            a(false);
                        } else {
                            boolean unused6 = C.this.a(bluetoothGatt.getDevice(), (F) null);
                        }
                        if (d2 || i == 0) {
                            return;
                        }
                    } else {
                        int j = C.this.y.j();
                        if (j > 0) {
                            C c4 = C.this;
                            c4.a(3, "wait(" + j + ")");
                        }
                        C.this.h.postDelayed(new C0230d(this, bluetoothGatt), (long) j);
                        return;
                    }
                } else if (i != 0) {
                    C c5 = C.this;
                    c5.a(6, "Error (0x" + Integer.toHexString(i) + "): " + no.nordicsemi.android.ble.c.a.b(i));
                }
                C.this.l.a(bluetoothGatt.getDevice(), "Error on connection state change", i);
            } else if (C.this.j == null) {
                Log.e("BleManager", "Device received notification after disconnection.");
                C.this.a(3, "gatt.close()");
                bluetoothGatt.close();
            } else {
                C c6 = C.this;
                c6.a(4, "Connected to " + bluetoothGatt.getDevice().getAddress());
                boolean unused7 = C.this.o = true;
                long unused8 = C.this.p = 0;
                int unused9 = C.this.u = 2;
                C.this.l.h(bluetoothGatt.getDevice());
                if (!C.this.s) {
                    if (bluetoothGatt.getDevice().getBondState() != 12) {
                        z = false;
                    }
                    int a2 = C.this.a(z);
                    if (a2 > 0) {
                        C c7 = C.this;
                        c7.a(3, "wait(" + a2 + ")");
                    }
                    C.this.h.postDelayed(new C0232f(this, C.g(C.this), bluetoothGatt), (long) a2);
                }
            }
        }

        /* access modifiers changed from: private */
        public void b(BluetoothDevice bluetoothDevice) {
            boolean d2 = C.this.o;
            boolean unused = C.this.o = false;
            boolean unused2 = C.this.r = false;
            boolean unused3 = C.this.s = false;
            this.d = false;
            int unused4 = C.this.u = 0;
            if (!d2) {
                C.this.a(5, "Connection attempt timed out");
                C.this.d();
                C.this.l.b(bluetoothDevice);
            } else if (C.this.m) {
                C.this.a(4, "Disconnected");
                C.this.d();
                C.this.l.b(bluetoothDevice);
                N t = C.this.z;
                if (t != null && t.c == N.a.DISCONNECT) {
                    t.c(bluetoothDevice);
                }
            } else {
                C.this.a(5, "Connection lost");
                C.this.l.j(bluetoothDevice);
            }
            c();
        }

        private void a(BluetoothDevice bluetoothDevice, String str, int i) {
            C c2 = C.this;
            c2.a(6, "Error (0x" + Integer.toHexString(i) + "): " + no.nordicsemi.android.ble.c.a.a(i));
            C.this.l.a(bluetoothDevice, str, i);
        }

        public /* synthetic */ void a(int i, BluetoothGatt bluetoothGatt) {
            if (i == C.this.t && C.this.o && bluetoothGatt.getDevice().getBondState() != 11) {
                boolean unused = C.this.s = true;
                C.this.a(2, "Discovering services...");
                C.this.a(3, "gatt.discoverServices()");
                bluetoothGatt.discoverServices();
            }
        }

        /* access modifiers changed from: private */
        public void a(N n) {
            (this.d ? this.c : this.f1574b).add(n);
            n.m = true;
        }

        /* access modifiers changed from: protected */
        public void a() {
            this.f1574b.clear();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Can't wrap try/catch for region: R(9:34|35|(2:37|(1:39))|40|41|42|43|44|45) */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x03ba, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00a8 */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x0246  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x0289 A[SYNTHETIC, Splitter:B:118:0x0289] */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x0291  */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x0299  */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x02a1  */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x02a9  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x02b3  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x02bd  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x02c7  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x02d1  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x02d9  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x02e1  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x02fd  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0319  */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x0322  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x0344  */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x034d  */
        /* JADX WARNING: Removed duplicated region for block: B:149:0x0359 A[SYNTHETIC, Splitter:B:149:0x0359] */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x0360  */
        /* JADX WARNING: Removed duplicated region for block: B:152:0x0367  */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x036e  */
        /* JADX WARNING: Removed duplicated region for block: B:156:0x0388  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x005f A[Catch:{ Exception -> 0x006c }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x006f A[SYNTHETIC, Splitter:B:34:0x006f] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00c9  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00f0  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0141  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0143  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0180  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x019e  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01a6  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x01d3 A[SYNTHETIC, Splitter:B:90:0x01d3] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x020c A[SYNTHETIC, Splitter:B:99:0x020c] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x00b4=Splitter:B:46:0x00b4, B:42:0x00a8=Splitter:B:42:0x00a8} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void a(boolean r10) {
            /*
                r9 = this;
                monitor-enter(r9)
                no.nordicsemi.android.ble.C r0 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C$a r0 = r0.k     // Catch:{ all -> 0x03c8 }
                if (r0 != 0) goto L_0x000b
                monitor-exit(r9)
                return
            L_0x000b:
                r0 = 0
                r1 = 1
                if (r10 == 0) goto L_0x001c
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.X r10 = r10.C     // Catch:{ all -> 0x03c8 }
                if (r10 == 0) goto L_0x0019
                r10 = 1
                goto L_0x001a
            L_0x0019:
                r10 = 0
            L_0x001a:
                r9.e = r10     // Catch:{ all -> 0x03c8 }
            L_0x001c:
                boolean r10 = r9.e     // Catch:{ all -> 0x03c8 }
                if (r10 == 0) goto L_0x0022
                monitor-exit(r9)
                return
            L_0x0022:
                r10 = 0
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.O r2 = r2.A     // Catch:{ Exception -> 0x006c }
                if (r2 == 0) goto L_0x005c
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.O r2 = r2.A     // Catch:{ Exception -> 0x006c }
                boolean r2 = r2.h()     // Catch:{ Exception -> 0x006c }
                if (r2 == 0) goto L_0x0048
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.O r2 = r2.A     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.N r2 = r2.g()     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.N r2 = r2.a((no.nordicsemi.android.ble.C) r3)     // Catch:{ Exception -> 0x006c }
                goto L_0x005d
            L_0x0048:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.O r2 = r2.A     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ Exception -> 0x006c }
                android.bluetooth.BluetoothDevice r3 = r3.j     // Catch:{ Exception -> 0x006c }
                r2.c(r3)     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.O unused = r2.A = r10     // Catch:{ Exception -> 0x006c }
            L_0x005c:
                r2 = r10
            L_0x005d:
                if (r2 != 0) goto L_0x006d
                java.util.Deque<no.nordicsemi.android.ble.N> r2 = r9.c     // Catch:{ Exception -> 0x006c }
                if (r2 == 0) goto L_0x006c
                java.util.Deque<no.nordicsemi.android.ble.N> r2 = r9.c     // Catch:{ Exception -> 0x006c }
                java.lang.Object r2 = r2.poll()     // Catch:{ Exception -> 0x006c }
                no.nordicsemi.android.ble.N r2 = (no.nordicsemi.android.ble.N) r2     // Catch:{ Exception -> 0x006c }
                goto L_0x006d
            L_0x006c:
                r2 = r10
            L_0x006d:
                if (r2 != 0) goto L_0x00b4
                java.util.Deque<no.nordicsemi.android.ble.N> r2 = r9.c     // Catch:{ all -> 0x03c8 }
                if (r2 == 0) goto L_0x009f
                r9.c = r10     // Catch:{ all -> 0x03c8 }
                r9.e = r1     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean unused = r2.q = r1     // Catch:{ all -> 0x03c8 }
                r9.d()     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.F r2 = r2.y     // Catch:{ all -> 0x03c8 }
                if (r2 == 0) goto L_0x009f
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.F r2 = r2.y     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.F r3 = r3.y     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r3 = r3.h()     // Catch:{ all -> 0x03c8 }
                r2.c(r3)     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.F unused = r2.y = r10     // Catch:{ all -> 0x03c8 }
            L_0x009f:
                java.util.Deque<no.nordicsemi.android.ble.N> r2 = r9.f1574b     // Catch:{ Exception -> 0x00a8 }
                java.lang.Object r2 = r2.remove()     // Catch:{ Exception -> 0x00a8 }
                no.nordicsemi.android.ble.N r2 = (no.nordicsemi.android.ble.N) r2     // Catch:{ Exception -> 0x00a8 }
                goto L_0x00b4
            L_0x00a8:
                r9.e = r0     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r0 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N unused = r0.z = r10     // Catch:{ all -> 0x03c8 }
                r9.e()     // Catch:{ all -> 0x03c8 }
                monitor-exit(r9)
                return
            L_0x00b4:
                r9.e = r1     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N unused = r3.z = r2     // Catch:{ all -> 0x03c8 }
                r3 = 16
                int[] r4 = no.nordicsemi.android.ble.B.f1571a     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N$a r5 = r2.c     // Catch:{ all -> 0x03c8 }
                int r5 = r5.ordinal()     // Catch:{ all -> 0x03c8 }
                r4 = r4[r5]     // Catch:{ all -> 0x03c8 }
                if (r4 == r1) goto L_0x00ce
                r5 = 2
                if (r4 == r5) goto L_0x00d0
                r3 = 0
                goto L_0x010e
            L_0x00ce:
                r3 = 32
            L_0x00d0:
                r4 = r2
                no.nordicsemi.android.ble.X r4 = (no.nordicsemi.android.ble.X) r4     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r5 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r5 = r5.o     // Catch:{ all -> 0x03c8 }
                if (r5 == 0) goto L_0x00ed
                no.nordicsemi.android.ble.C r5 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r5 = r5.j     // Catch:{ all -> 0x03c8 }
                if (r5 == 0) goto L_0x00ed
                android.bluetooth.BluetoothGattCharacteristic r5 = r4.d     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattDescriptor r3 = no.nordicsemi.android.ble.C.b((android.bluetooth.BluetoothGattCharacteristic) r5, (int) r3)     // Catch:{ all -> 0x03c8 }
                if (r3 == 0) goto L_0x00ed
                r3 = 1
                goto L_0x00ee
            L_0x00ed:
                r3 = 0
            L_0x00ee:
                if (r3 == 0) goto L_0x010e
                no.nordicsemi.android.ble.C r5 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.X unused = r5.C = r4     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r5 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r5 = r5.j     // Catch:{ all -> 0x03c8 }
                r4.b(r5)     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N r5 = r4.g()     // Catch:{ all -> 0x03c8 }
                if (r5 != 0) goto L_0x0105
                goto L_0x0130
            L_0x0105:
                no.nordicsemi.android.ble.N r2 = r4.g()     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N unused = r4.z = r2     // Catch:{ all -> 0x03c8 }
            L_0x010e:
                no.nordicsemi.android.ble.N$a r4 = r2.c     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N$a r5 = no.nordicsemi.android.ble.N.a.CONNECT     // Catch:{ all -> 0x03c8 }
                if (r4 != r5) goto L_0x011f
                r4 = r2
                no.nordicsemi.android.ble.F r4 = (no.nordicsemi.android.ble.F) r4     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r5 = r4.h()     // Catch:{ all -> 0x03c8 }
                r4.b(r5)     // Catch:{ all -> 0x03c8 }
                goto L_0x0130
            L_0x011f:
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r4 = r4.j     // Catch:{ all -> 0x03c8 }
                if (r4 == 0) goto L_0x03bb
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r4 = r4.j     // Catch:{ all -> 0x03c8 }
                r2.b((android.bluetooth.BluetoothDevice) r4)     // Catch:{ all -> 0x03c8 }
            L_0x0130:
                int[] r4 = no.nordicsemi.android.ble.B.f1571a     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N$a r5 = r2.c     // Catch:{ all -> 0x03c8 }
                int r5 = r5.ordinal()     // Catch:{ all -> 0x03c8 }
                r4 = r4[r5]     // Catch:{ all -> 0x03c8 }
                r5 = 21
                r6 = 26
                switch(r4) {
                    case 3: goto L_0x036e;
                    case 4: goto L_0x0367;
                    case 5: goto L_0x0360;
                    case 6: goto L_0x0359;
                    case 7: goto L_0x034d;
                    case 8: goto L_0x0344;
                    case 9: goto L_0x0322;
                    case 10: goto L_0x0319;
                    case 11: goto L_0x02fd;
                    case 12: goto L_0x02e1;
                    case 13: goto L_0x02d9;
                    case 14: goto L_0x02d1;
                    case 15: goto L_0x02c7;
                    case 16: goto L_0x02bd;
                    case 17: goto L_0x02b3;
                    case 18: goto L_0x02a9;
                    case 19: goto L_0x02a1;
                    case 20: goto L_0x0299;
                    case 21: goto L_0x0291;
                    case 22: goto L_0x0289;
                    case 23: goto L_0x0246;
                    case 24: goto L_0x020c;
                    case 25: goto L_0x01d3;
                    case 26: goto L_0x01a6;
                    case 27: goto L_0x019e;
                    case 28: goto L_0x0180;
                    case 29: goto L_0x0143;
                    default: goto L_0x0141;
                }     // Catch:{ all -> 0x03c8 }
            L_0x0141:
                goto L_0x0385
            L_0x0143:
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r4 = r4.j     // Catch:{ all -> 0x03c8 }
                if (r4 == 0) goto L_0x0385
                no.nordicsemi.android.ble.S r2 = (no.nordicsemi.android.ble.S) r2     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                r5 = 3
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c8 }
                r6.<init>()     // Catch:{ all -> 0x03c8 }
                java.lang.String r7 = "sleep("
                r6.append(r7)     // Catch:{ all -> 0x03c8 }
                long r7 = r2.g()     // Catch:{ all -> 0x03c8 }
                r6.append(r7)     // Catch:{ all -> 0x03c8 }
                java.lang.String r7 = ")"
                r6.append(r7)     // Catch:{ all -> 0x03c8 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x03c8 }
                r3.a((int) r5, (java.lang.String) r6)     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.os.Handler r3 = r3.h     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.b r5 = new no.nordicsemi.android.ble.b     // Catch:{ all -> 0x03c8 }
                r5.<init>(r9, r2, r4)     // Catch:{ all -> 0x03c8 }
                long r6 = r2.g()     // Catch:{ all -> 0x03c8 }
                r3.postDelayed(r5, r6)     // Catch:{ all -> 0x03c8 }
                r2 = 1
                goto L_0x0386
            L_0x0180:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.u()     // Catch:{ all -> 0x03c8 }
                if (r2 == 0) goto L_0x0386
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r3 = r3.j     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.os.Handler r4 = r4.h     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.e r5 = new no.nordicsemi.android.ble.e     // Catch:{ all -> 0x03c8 }
                r5.<init>(r9, r3)     // Catch:{ all -> 0x03c8 }
                r6 = 200(0xc8, double:9.9E-322)
                r4.postDelayed(r5, r6)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x019e:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.t()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x01a6:
                no.nordicsemi.android.ble.K r2 = (no.nordicsemi.android.ble.K) r2     // Catch:{ all -> 0x03c8 }
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03c8 }
                if (r3 < r6) goto L_0x01b4
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.s()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x01b4:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r3 = r3.o     // Catch:{ all -> 0x03c8 }
                if (r3 == 0) goto L_0x0385
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r10 = r10.j     // Catch:{ all -> 0x03c8 }
                r2.d(r10)     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r10 = r10.j     // Catch:{ all -> 0x03c8 }
                r2.c(r10)     // Catch:{ all -> 0x03c8 }
                r9.a((boolean) r1)     // Catch:{ all -> 0x03c8 }
                monitor-exit(r9)
                return
            L_0x01d3:
                no.nordicsemi.android.ble.K r2 = (no.nordicsemi.android.ble.K) r2     // Catch:{ all -> 0x03c8 }
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03c8 }
                if (r3 < r6) goto L_0x01ed
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                int r4 = r2.i()     // Catch:{ all -> 0x03c8 }
                int r5 = r2.h()     // Catch:{ all -> 0x03c8 }
                int r2 = r2.g()     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.a((int) r4, (int) r5, (int) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x01ed:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r3 = r3.o     // Catch:{ all -> 0x03c8 }
                if (r3 == 0) goto L_0x0385
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r10 = r10.j     // Catch:{ all -> 0x03c8 }
                r2.d(r10)     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r10 = r10.j     // Catch:{ all -> 0x03c8 }
                r2.c(r10)     // Catch:{ all -> 0x03c8 }
                r9.a((boolean) r1)     // Catch:{ all -> 0x03c8 }
                monitor-exit(r9)
                return
            L_0x020c:
                no.nordicsemi.android.ble.G r2 = (no.nordicsemi.android.ble.G) r2     // Catch:{ all -> 0x03c8 }
                int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03c8 }
                if (r4 < r6) goto L_0x0220
                r9.f = r1     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                int r2 = r2.g()     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.e((int) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0220:
                int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03c8 }
                if (r4 < r5) goto L_0x0385
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                int r4 = r2.g()     // Catch:{ all -> 0x03c8 }
                boolean r3 = r3.e((int) r4)     // Catch:{ all -> 0x03c8 }
                if (r3 == 0) goto L_0x0385
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r4 = r4.j     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r5 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.os.Handler r5 = r5.h     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.c r6 = new no.nordicsemi.android.ble.c     // Catch:{ all -> 0x03c8 }
                r6.<init>(r9, r2, r4)     // Catch:{ all -> 0x03c8 }
                r7 = 100
                r5.postDelayed(r6, r7)     // Catch:{ all -> 0x03c8 }
                goto L_0x0385
            L_0x0246:
                no.nordicsemi.android.ble.I r2 = (no.nordicsemi.android.ble.I) r2     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                int r3 = r3.w     // Catch:{ all -> 0x03c8 }
                int r4 = r2.g()     // Catch:{ all -> 0x03c8 }
                if (r3 == r4) goto L_0x0264
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03c8 }
                if (r3 < r5) goto L_0x0264
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                int r2 = r2.g()     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.f((int) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0264:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r3 = r3.o     // Catch:{ all -> 0x03c8 }
                if (r3 == 0) goto L_0x0385
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r10 = r10.j     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r0 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                int r0 = r0.w     // Catch:{ all -> 0x03c8 }
                r2.b(r10, r0)     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r10 = r10.j     // Catch:{ all -> 0x03c8 }
                r2.c(r10)     // Catch:{ all -> 0x03c8 }
                r9.a((boolean) r1)     // Catch:{ all -> 0x03c8 }
                monitor-exit(r9)
                return
            L_0x0289:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.l()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0291:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.b((boolean) r0)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0299:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.b((boolean) r1)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x02a1:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.r()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x02a9:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattCharacteristic r2 = r2.d     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.d((android.bluetooth.BluetoothGattCharacteristic) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x02b3:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattCharacteristic r2 = r2.d     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.e((android.bluetooth.BluetoothGattCharacteristic) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x02bd:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattCharacteristic r2 = r2.d     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.f((android.bluetooth.BluetoothGattCharacteristic) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x02c7:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattCharacteristic r2 = r2.d     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.g((android.bluetooth.BluetoothGattCharacteristic) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x02d1:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.m()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x02d9:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.q()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x02e1:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.n()     // Catch:{ all -> 0x03c8 }
                if (r2 == 0) goto L_0x0386
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N r10 = r10.z     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r0 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r0 = r0.j     // Catch:{ all -> 0x03c8 }
                r10.c(r0)     // Catch:{ all -> 0x03c8 }
                r9.a((boolean) r1)     // Catch:{ all -> 0x03c8 }
                monitor-exit(r9)
                return
            L_0x02fd:
                r3 = r2
                no.nordicsemi.android.ble.Y r3 = (no.nordicsemi.android.ble.Y) r3     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattDescriptor r2 = r2.e     // Catch:{ all -> 0x03c8 }
                if (r2 == 0) goto L_0x0311
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                int r4 = r4.w     // Catch:{ all -> 0x03c8 }
                byte[] r3 = r3.a((int) r4)     // Catch:{ all -> 0x03c8 }
                r2.setValue(r3)     // Catch:{ all -> 0x03c8 }
            L_0x0311:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.b((android.bluetooth.BluetoothGattDescriptor) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0319:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattDescriptor r2 = r2.e     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.a((android.bluetooth.BluetoothGattDescriptor) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0322:
                r3 = r2
                no.nordicsemi.android.ble.Y r3 = (no.nordicsemi.android.ble.Y) r3     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattCharacteristic r2 = r2.d     // Catch:{ all -> 0x03c8 }
                if (r2 == 0) goto L_0x033d
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                int r4 = r4.w     // Catch:{ all -> 0x03c8 }
                byte[] r4 = r3.a((int) r4)     // Catch:{ all -> 0x03c8 }
                r2.setValue(r4)     // Catch:{ all -> 0x03c8 }
                int r3 = r3.g()     // Catch:{ all -> 0x03c8 }
                r2.setWriteType(r3)     // Catch:{ all -> 0x03c8 }
            L_0x033d:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.i((android.bluetooth.BluetoothGattCharacteristic) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0344:
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothGattCharacteristic r2 = r2.d     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.h((android.bluetooth.BluetoothGattCharacteristic) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x034d:
                no.nordicsemi.android.ble.C r10 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.O r2 = (no.nordicsemi.android.ble.O) r2     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.O unused = r10.A = r2     // Catch:{ all -> 0x03c8 }
                r9.a((boolean) r1)     // Catch:{ all -> 0x03c8 }
                monitor-exit(r9)
                return
            L_0x0359:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.v()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0360:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.o()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0367:
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r2 = r2.p()     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x036e:
                no.nordicsemi.android.ble.F r2 = (no.nordicsemi.android.ble.F) r2     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.F unused = r3.y = r2     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N unused = r3.z = r10     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r4 = r2.h()     // Catch:{ all -> 0x03c8 }
                boolean r2 = r3.a((android.bluetooth.BluetoothDevice) r4, (no.nordicsemi.android.ble.F) r2)     // Catch:{ all -> 0x03c8 }
                goto L_0x0386
            L_0x0385:
                r2 = r3
            L_0x0386:
                if (r2 != 0) goto L_0x03b9
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.N r2 = r2.z     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r3 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                android.bluetooth.BluetoothDevice r3 = r3.j     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r4 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                boolean r4 = r4.o     // Catch:{ all -> 0x03c8 }
                if (r4 == 0) goto L_0x039e
                r4 = -3
                goto L_0x03ac
            L_0x039e:
                android.bluetooth.BluetoothAdapter r4 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch:{ all -> 0x03c8 }
                boolean r4 = r4.isEnabled()     // Catch:{ all -> 0x03c8 }
                if (r4 == 0) goto L_0x03aa
                r4 = -1
                goto L_0x03ac
            L_0x03aa:
                r4 = -100
            L_0x03ac:
                r2.a((android.bluetooth.BluetoothDevice) r3, (int) r4)     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r2 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.X unused = r2.C = r10     // Catch:{ all -> 0x03c8 }
                r9.f = r0     // Catch:{ all -> 0x03c8 }
                r9.a((boolean) r1)     // Catch:{ all -> 0x03c8 }
            L_0x03b9:
                monitor-exit(r9)
                return
            L_0x03bb:
                r2.f()     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.C r0 = no.nordicsemi.android.ble.C.this     // Catch:{ all -> 0x03c8 }
                no.nordicsemi.android.ble.X unused = r0.C = r10     // Catch:{ all -> 0x03c8 }
                r9.a((boolean) r1)     // Catch:{ all -> 0x03c8 }
                monitor-exit(r9)
                return
            L_0x03c8:
                r10 = move-exception
                monitor-exit(r9)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.ble.C.a.a(boolean):void");
        }

        /* access modifiers changed from: package-private */
        public final void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            if (b(bluetoothGattCharacteristic)) {
                this.e = true;
                a();
                this.c = null;
                C.this.a(4, "Service Changed indication received");
                C.this.a(2, "Discovering Services...");
                C.this.a(3, "gatt.discoverServices()");
                bluetoothGatt.discoverServices();
                return;
            }
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(C.f1572a);
            boolean z = false;
            if (descriptor == null || descriptor.getValue() == null || descriptor.getValue().length != 2 || descriptor.getValue()[0] == 1) {
                z = true;
            }
            String a2 = b.a(bArr);
            if (z) {
                C c2 = C.this;
                c2.a(4, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value: " + a2);
                b(bluetoothGatt, bluetoothGattCharacteristic);
            } else {
                C c3 = C.this;
                c3.a(4, "Indication received from " + bluetoothGattCharacteristic.getUuid() + ", value: " + a2);
                a(bluetoothGatt, bluetoothGattCharacteristic);
            }
            if (C.this.D != null && a(bluetoothGattCharacteristic)) {
                C.this.D.a(bluetoothGatt.getDevice(), bArr);
            }
            W w = (W) C.this.B.get(bluetoothGattCharacteristic);
            if (w != null && w.a(bArr)) {
                w.a(bluetoothGatt.getDevice(), bArr);
            }
            X w2 = C.this.C;
            if (w2 != null && w2.d == bluetoothGattCharacteristic && !w2.j() && w2.a(bArr)) {
                w2.a(bluetoothGatt.getDevice(), bArr);
                if (!w2.h()) {
                    w2.c(bluetoothGatt.getDevice());
                    X unused = C.this.C = null;
                    if (w2.i()) {
                        a(true);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void c(BluetoothGatt bluetoothGatt, int i) {
            boolean z = C.this.z.c == N.a.EXECUTE_RELIABLE_WRITE;
            boolean unused = C.this.x = false;
            if (i != 0) {
                Log.e("BleManager", "onReliableWriteCompleted execute " + z + ", error " + i);
                C.this.z.a(bluetoothGatt.getDevice(), i);
                a(bluetoothGatt.getDevice(), "Error on Execute Reliable Write", i);
            } else if (z) {
                C.this.a(4, "Reliable Write executed");
                C.this.z.c(bluetoothGatt.getDevice());
            } else {
                C.this.a(5, "Reliable Write aborted");
                C.this.z.c(bluetoothGatt.getDevice());
                C.this.A.a(bluetoothGatt.getDevice(), -4);
            }
            a(true);
        }

        /* access modifiers changed from: package-private */
        public void c(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, int i) {
            if (i == 0) {
                C c2 = C.this;
                c2.a(4, "Read Response received from descr. " + bluetoothGattDescriptor.getUuid() + ", value: " + b.a(bArr));
                a(bluetoothGatt, bluetoothGattDescriptor);
                if (C.this.z instanceof L) {
                    L l = (L) C.this.z;
                    l.a(bluetoothGatt.getDevice(), bArr);
                    if (l.g()) {
                        b((N) l);
                    } else {
                        l.c(bluetoothGatt.getDevice());
                    }
                }
            } else if (i == 5 || i == 8 || i == 137) {
                C c3 = C.this;
                c3.a(5, "Authentication required (" + i + ")");
                if (bluetoothGatt.getDevice().getBondState() != 10) {
                    Log.w("BleManager", "Phone has lost bonding information");
                    C.this.l.a(bluetoothGatt.getDevice(), "Phone has lost bonding information", i);
                    return;
                }
                return;
            } else {
                Log.e("BleManager", "onDescriptorRead error " + i);
                if (C.this.z instanceof L) {
                    C.this.z.a(bluetoothGatt.getDevice(), i);
                }
                X unused = C.this.C = null;
                a(bluetoothGatt.getDevice(), "Error on reading descriptor", i);
            }
            a(true);
        }

        /* access modifiers changed from: package-private */
        public final void c(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (i3 == 0) {
                C c2 = C.this;
                c2.a(4, "PHY read (TX: " + C.this.i(i) + ", RX: " + C.this.i(i2) + ")");
                if (C.this.z instanceof K) {
                    ((K) C.this.z).a(bluetoothGatt.getDevice(), i, i2);
                    C.this.z.c(bluetoothGatt.getDevice());
                }
            } else {
                C c3 = C.this;
                c3.a(5, "PHY read failed with status " + i3);
                if (C.this.z instanceof K) {
                    C.this.z.a(bluetoothGatt.getDevice(), i3);
                }
                X unused = C.this.C = null;
                C.this.l.a(bluetoothGatt.getDevice(), "Error on PHY read", i3);
            }
            a(true);
        }

        /* access modifiers changed from: package-private */
        public final void b(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            if (i8 == 0) {
                C c2 = C.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Connection parameters updated (interval: ");
                double d2 = (double) i5;
                Double.isNaN(d2);
                sb.append(d2 * 1.25d);
                sb.append("ms, latency: ");
                sb.append(i6);
                sb.append(", timeout: ");
                sb.append(i7 * 10);
                sb.append("ms)");
                c2.a(4, sb.toString());
                e(bluetoothGatt, i, i2, i3);
                if (C.this.z instanceof G) {
                    ((G) C.this.z).a(bluetoothGatt.getDevice(), i5, i6, i7);
                    C.this.z.c(bluetoothGatt.getDevice());
                }
            } else if (i8 == 59) {
                Log.e("BleManager", "onConnectionUpdated received status: Unacceptable connection interval, interval: " + i5 + ", latency: " + i6 + ", timeout: " + i7);
                C c3 = C.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Connection parameters update failed with status: UNACCEPT CONN INTERVAL (0x3b) (interval: ");
                double d3 = (double) i5;
                Double.isNaN(d3);
                sb2.append(d3 * 1.25d);
                sb2.append("ms, latency: ");
                sb2.append(i6);
                sb2.append(", timeout: ");
                sb2.append(i7 * 10);
                sb2.append("ms)");
                c3.a(5, sb2.toString());
                if (C.this.z instanceof G) {
                    C.this.z.a(bluetoothGatt.getDevice(), i8);
                    X unused = C.this.C = null;
                }
            } else {
                Log.e("BleManager", "onConnectionUpdated received status: " + i8 + ", interval: " + i5 + ", latency: " + i6 + ", timeout: " + i7);
                C c4 = C.this;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Connection parameters update failed with status ");
                sb3.append(i8);
                sb3.append(" (interval: ");
                double d4 = (double) i5;
                Double.isNaN(d4);
                sb3.append(d4 * 1.25d);
                sb3.append("ms, latency: ");
                sb3.append(i6);
                sb3.append(", timeout: ");
                sb3.append(i7 * 10);
                sb3.append("ms)");
                c4.a(5, sb3.toString());
                if (C.this.z instanceof G) {
                    C.this.z.a(bluetoothGatt.getDevice(), i8);
                    X unused2 = C.this.C = null;
                }
                C.this.l.a(bluetoothGatt.getDevice(), "Error on connection priority request", i8);
            }
            if (this.f) {
                this.f = false;
                a(true);
            }
        }

        public /* synthetic */ void d(BluetoothGatt bluetoothGatt) {
            boolean unused = C.this.a(bluetoothGatt.getDevice(), C.this.y);
        }

        /* access modifiers changed from: package-private */
        public final void d(BluetoothGatt bluetoothGatt, int i) {
            boolean unused = C.this.s = false;
            if (i == 0) {
                C.this.a(4, "Services discovered");
                boolean unused2 = C.this.r = true;
                if (c(bluetoothGatt)) {
                    C.this.a(2, "Primary service found");
                    boolean b2 = b(bluetoothGatt);
                    if (b2) {
                        C.this.a(2, "Secondary service found");
                    }
                    C.this.l.a(bluetoothGatt.getDevice(), b2);
                    this.d = true;
                    this.e = true;
                    this.c = a(bluetoothGatt);
                    boolean z = this.c != null;
                    if (z) {
                        for (N n : this.c) {
                            n.m = true;
                        }
                    }
                    if (this.c == null) {
                        this.c = new LinkedList();
                    }
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 < 23 || i2 == 26 || i2 == 27 || i2 == 28) {
                        Y d2 = N.d();
                        d2.a(C.this);
                        b((N) d2);
                    }
                    if (z) {
                        C.this.i();
                        if (C.this.l.k(bluetoothGatt.getDevice())) {
                            C.this.f();
                        }
                    }
                    b();
                    this.d = false;
                    a(true);
                    return;
                }
                C.this.a(5, "Device is not supported");
                C.this.l.c(bluetoothGatt.getDevice());
                boolean unused3 = C.this.p();
                return;
            }
            Log.e("BleManager", "onServicesDiscovered error " + i);
            a(bluetoothGatt.getDevice(), "Error on discovering services", i);
            if (C.this.y != null) {
                C.this.y.a(bluetoothGatt.getDevice(), -4);
                F unused4 = C.this.y = null;
            }
            boolean unused5 = C.this.p();
        }

        /* access modifiers changed from: private */
        public void b(N n) {
            (this.d ? this.c : this.f1574b).addFirst(n);
            n.m = true;
        }

        private boolean b(BluetoothGattDescriptor bluetoothGattDescriptor) {
            return bluetoothGattDescriptor != null && C.e.equals(bluetoothGattDescriptor.getCharacteristic().getUuid());
        }

        private boolean b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return bluetoothGattCharacteristic != null && C.e.equals(bluetoothGattCharacteristic.getUuid());
        }

        /* access modifiers changed from: package-private */
        public final void d(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
            if (i == 0) {
                C c2 = C.this;
                c2.a(4, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value: " + b.a(bArr));
                d(bluetoothGatt, bluetoothGattCharacteristic);
                if (C.this.z instanceof Y) {
                    Y y = (Y) C.this.z;
                    if (!y.a(bluetoothGatt.getDevice(), bArr)) {
                        O unused = C.this.A;
                    }
                    if (y.h()) {
                        b((N) y);
                    } else {
                        y.c(bluetoothGatt.getDevice());
                    }
                }
            } else if (i == 5 || i == 8 || i == 137) {
                C c3 = C.this;
                c3.a(5, "Authentication required (" + i + ")");
                if (bluetoothGatt.getDevice().getBondState() != 10) {
                    Log.w("BleManager", "Phone has lost bonding information");
                    C.this.l.a(bluetoothGatt.getDevice(), "Phone has lost bonding information", i);
                    return;
                }
                return;
            } else {
                Log.e("BleManager", "onCharacteristicWrite error " + i);
                if (C.this.z instanceof Y) {
                    C.this.z.a(bluetoothGatt.getDevice(), i);
                    O unused2 = C.this.A;
                }
                X unused3 = C.this.C = null;
                a(bluetoothGatt.getDevice(), "Error on writing characteristic", i);
            }
            a(true);
        }

        /* access modifiers changed from: package-private */
        public final void d(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, int i) {
            if (i == 0) {
                C c2 = C.this;
                c2.a(4, "Data written to descr. " + bluetoothGattDescriptor.getUuid() + ", value: " + b.a(bArr));
                if (b(bluetoothGattDescriptor)) {
                    C.this.a(4, "Service Changed notifications enabled");
                } else if (!a(bluetoothGattDescriptor)) {
                    b(bluetoothGatt, bluetoothGattDescriptor);
                } else if (bArr != null && bArr.length == 2 && bArr[1] == 0) {
                    byte b2 = bArr[0];
                    if (b2 == 0) {
                        C.this.B.remove(bluetoothGattDescriptor.getCharacteristic());
                        C.this.a(4, "Notifications and indications disabled");
                    } else if (b2 == 1) {
                        C.this.a(4, "Notifications enabled");
                    } else if (b2 == 2) {
                        C.this.a(4, "Indications enabled");
                    }
                    b(bluetoothGatt, bluetoothGattDescriptor);
                }
                if (C.this.z instanceof Y) {
                    Y y = (Y) C.this.z;
                    if (!y.a(bluetoothGatt.getDevice(), bArr)) {
                        O unused = C.this.A;
                    }
                    if (y.h()) {
                        b((N) y);
                    } else {
                        y.c(bluetoothGatt.getDevice());
                    }
                }
            } else if (i == 5 || i == 8 || i == 137) {
                C c3 = C.this;
                c3.a(5, "Authentication required (" + i + ")");
                if (bluetoothGatt.getDevice().getBondState() != 10) {
                    Log.w("BleManager", "Phone has lost bonding information");
                    C.this.l.a(bluetoothGatt.getDevice(), "Phone has lost bonding information", i);
                    return;
                }
                return;
            } else {
                Log.e("BleManager", "onDescriptorWrite error " + i);
                if (C.this.z instanceof Y) {
                    C.this.z.a(bluetoothGatt.getDevice(), i);
                    O unused2 = C.this.A;
                }
                X unused3 = C.this.C = null;
                a(bluetoothGatt.getDevice(), "Error on writing descriptor", i);
            }
            a(true);
        }

        /* access modifiers changed from: package-private */
        public final void d(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (i3 == 0) {
                C c2 = C.this;
                c2.a(4, "PHY updated (TX: " + C.this.i(i) + ", RX: " + C.this.i(i2) + ")");
                if (C.this.z instanceof K) {
                    ((K) C.this.z).a(bluetoothGatt.getDevice(), i, i2);
                    C.this.z.c(bluetoothGatt.getDevice());
                }
            } else {
                C c3 = C.this;
                c3.a(5, "PHY updated failed with status " + i3);
                if (C.this.z instanceof K) {
                    C.this.z.a(bluetoothGatt.getDevice(), i3);
                    X unused = C.this.C = null;
                }
                C.this.l.a(bluetoothGatt.getDevice(), "Error on PHY update", i3);
            }
            if (C.this.z instanceof K) {
                a(true);
            }
        }

        public /* synthetic */ void a(G g2, BluetoothDevice bluetoothDevice) {
            g2.c(bluetoothDevice);
            a(true);
        }

        public /* synthetic */ void a(BluetoothDevice bluetoothDevice) {
            C.this.a(4, "Cache refreshed");
            C.this.z.c(bluetoothDevice);
            N unused = C.this.z = null;
            if (C.this.C != null) {
                C.this.C.a(bluetoothDevice, -3);
                X unused2 = C.this.C = null;
            }
            a();
            this.c = null;
            if (C.this.o) {
                c();
                C.this.a(2, "Discovering Services...");
                C.this.a(3, "gatt.discoverServices()");
                C.this.i.discoverServices();
            }
        }

        public /* synthetic */ void a(S s, BluetoothDevice bluetoothDevice) {
            s.c(bluetoothDevice);
            a(true);
        }

        @Deprecated
        private boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return bluetoothGattCharacteristic != null && C.c.equals(bluetoothGattCharacteristic.getUuid());
        }

        private boolean a(BluetoothGattDescriptor bluetoothGattDescriptor) {
            return bluetoothGattDescriptor != null && C.f1572a.equals(bluetoothGattDescriptor.getUuid());
        }
    }

    public C(Context context) {
        this.g = context.getApplicationContext();
        this.h = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ int g(C c2) {
        int i2 = c2.t + 1;
        c2.t = i2;
        return i2;
    }

    /* access modifiers changed from: protected */
    public int a(boolean z2) {
        return z2 ? 1600 : 300;
    }

    /* access modifiers changed from: protected */
    public String a(int i2) {
        switch (i2) {
            case 10:
                return "BOND_NONE";
            case 11:
                return "BOND_BONDING";
            case 12:
                return "BOND_BONDED";
            default:
                return "UNKNOWN";
        }
    }

    public abstract void a(int i2, String str);

    /* access modifiers changed from: protected */
    public void a(BluetoothDevice bluetoothDevice, int i2) {
    }

    /* access modifiers changed from: protected */
    public String b(int i2) {
        switch (i2) {
            case 0:
                return "PAIRING_VARIANT_PIN";
            case 1:
                return "PAIRING_VARIANT_PASSKEY";
            case 2:
                return "PAIRING_VARIANT_PASSKEY_CONFIRMATION";
            case 3:
                return "PAIRING_VARIANT_CONSENT";
            case 4:
                return "PAIRING_VARIANT_DISPLAY_PASSKEY";
            case 5:
                return "PAIRING_VARIANT_DISPLAY_PIN";
            case 6:
                return "PAIRING_VARIANT_OOB_CONSENT";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: protected */
    public String c(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "DISCONNECTED" : "DISCONNECTING" : "CONNECTED" : "CONNECTING";
    }

    /* access modifiers changed from: protected */
    public abstract C<E>.a g();

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean j() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean k();

    /* access modifiers changed from: private */
    public boolean i(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || !this.o || (bluetoothGattCharacteristic.getProperties() & 12) == 0) {
            return false;
        }
        a(2, "Writing characteristic " + bluetoothGattCharacteristic.getUuid() + " (" + d(bluetoothGattCharacteristic.getWriteType()) + ")");
        StringBuilder sb = new StringBuilder();
        sb.append("gatt.writeCharacteristic(");
        sb.append(bluetoothGattCharacteristic.getUuid());
        sb.append(")");
        a(3, sb.toString());
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    /* access modifiers changed from: private */
    public boolean l() {
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o || bluetoothGatt.getDevice().getBondState() != 12 || (service = bluetoothGatt.getService(d)) == null || (characteristic = service.getCharacteristic(e)) == null) {
            return false;
        }
        a(4, "Service Changed characteristic found on a bonded device");
        return f(characteristic);
    }

    /* access modifiers changed from: private */
    public boolean m() {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o || !this.x) {
            return false;
        }
        a(2, "Aborting reliable write...");
        if (Build.VERSION.SDK_INT >= 19) {
            a(3, "gatt.abortReliableWrite()");
            bluetoothGatt.abortReliableWrite();
            return true;
        }
        a(3, "gatt.abortReliableWrite(device)");
        bluetoothGatt.abortReliableWrite(this.j);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean n() {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o) {
            return false;
        }
        if (this.x) {
            return true;
        }
        a(2, "Beginning reliable write...");
        a(3, "gatt.beginReliableWrite()");
        boolean beginReliableWrite = bluetoothGatt.beginReliableWrite();
        this.x = beginReliableWrite;
        return beginReliableWrite;
    }

    /* access modifiers changed from: private */
    public boolean o() {
        BluetoothDevice bluetoothDevice = this.j;
        if (bluetoothDevice == null) {
            return false;
        }
        a(2, "Starting pairing...");
        if (bluetoothDevice.getBondState() == 12) {
            a(5, "Device already bonded");
            this.z.c(bluetoothDevice);
            this.k.a(true);
            return true;
        } else if (Build.VERSION.SDK_INT >= 19) {
            a(3, "device.createBond()");
            return bluetoothDevice.createBond();
        } else {
            try {
                Method method = bluetoothDevice.getClass().getMethod("createBond", new Class[0]);
                a(3, "device.createBond() (hidden)");
                return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
            } catch (Exception e2) {
                Log.w("BleManager", "An exception occurred while creating bond", e2);
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean p() {
        this.m = true;
        this.n = false;
        this.q = false;
        if (this.i != null) {
            this.u = 3;
            a(2, this.o ? "Disconnecting..." : "Cancelling connection...");
            this.l.e(this.i.getDevice());
            boolean z2 = this.o;
            a(3, "gatt.disconnect()");
            this.i.disconnect();
            if (z2) {
                return true;
            }
            this.u = 0;
            a(4, "Disconnected");
            this.l.b(this.i.getDevice());
        }
        N n2 = this.z;
        if (n2 != null && n2.c == N.a.DISCONNECT) {
            BluetoothDevice bluetoothDevice = this.j;
            if (bluetoothDevice != null) {
                n2.c(bluetoothDevice);
            } else {
                n2.f();
            }
        }
        C<E>.a aVar = this.k;
        if (aVar != null) {
            aVar.a(true);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean q() {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o || !this.x) {
            return false;
        }
        a(2, "Executing reliable write...");
        a(3, "gatt.executeReliableWrite()");
        return bluetoothGatt.executeReliableWrite();
    }

    /* access modifiers changed from: private */
    @Deprecated
    public boolean r() {
        BluetoothGattService service;
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o || (service = bluetoothGatt.getService(f1573b)) == null) {
            return false;
        }
        return h(service.getCharacteristic(c));
    }

    /* access modifiers changed from: private */
    public boolean s() {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o) {
            return false;
        }
        a(2, "Reading PHY...");
        a(3, "gatt.readPhy()");
        bluetoothGatt.readPhy();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean t() {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o) {
            return false;
        }
        a(2, "Reading remote RSSI...");
        a(3, "gatt.readRemoteRssi()");
        return bluetoothGatt.readRemoteRssi();
    }

    /* access modifiers changed from: private */
    public boolean u() {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null) {
            return false;
        }
        a(2, "Refreshing device cache...");
        a(3, "gatt.refresh() (hidden)");
        try {
            return ((Boolean) bluetoothGatt.getClass().getMethod("refresh", new Class[0]).invoke(bluetoothGatt, new Object[0])).booleanValue();
        } catch (Exception e2) {
            Log.w("BleManager", "An exception occurred while refreshing device", e2);
            a(5, "gatt.refresh() method not found");
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean v() {
        BluetoothDevice bluetoothDevice = this.j;
        if (bluetoothDevice == null) {
            return false;
        }
        a(2, "Removing bond information...");
        if (bluetoothDevice.getBondState() == 10) {
            a(5, "Device is not bonded");
            this.z.c(bluetoothDevice);
            this.k.a(true);
            return true;
        }
        try {
            Method method = bluetoothDevice.getClass().getMethod("removeBond", new Class[0]);
            a(3, "device.removeBond() (hidden)");
            return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
        } catch (Exception e2) {
            Log.w("BleManager", "An exception occurred while removing bond", e2);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean g(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattDescriptor b2;
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || !this.o || (b2 = b(bluetoothGattCharacteristic, 16)) == null) {
            return false;
        }
        a(3, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)");
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        b2.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        a(2, "Enabling notifications for " + bluetoothGattCharacteristic.getUuid());
        a(3, "gatt.writeDescriptor(" + f1572a + ", value=0x01-00)");
        return c(b2);
    }

    public final boolean h() {
        return this.o;
    }

    /* access modifiers changed from: private */
    public boolean f(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattDescriptor b2;
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || !this.o || (b2 = b(bluetoothGattCharacteristic, 32)) == null) {
            return false;
        }
        a(3, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)");
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        b2.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        a(2, "Enabling indications for " + bluetoothGattCharacteristic.getUuid());
        a(3, "gatt.writeDescriptor(" + f1572a + ", value=0x02-00)");
        return c(b2);
    }

    /* access modifiers changed from: private */
    public boolean h(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || !this.o || (bluetoothGattCharacteristic.getProperties() & 2) == 0) {
            return false;
        }
        a(2, "Reading characteristic " + bluetoothGattCharacteristic.getUuid());
        a(3, "gatt.readCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        return bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
    }

    public void d() {
        try {
            this.g.unregisterReceiver(this.E);
            this.g.unregisterReceiver(this.F);
            this.g.unregisterReceiver(this.G);
        } catch (Exception unused) {
        }
        synchronized (this.f) {
            if (this.i != null) {
                if (k()) {
                    if (u()) {
                        a(4, "Cache refreshed");
                    } else {
                        a(5, "Refreshing failed");
                    }
                }
                a(3, "gatt.close()");
                this.i.close();
                this.i = null;
            }
            this.o = false;
            this.n = false;
            this.x = false;
            this.B.clear();
            this.u = 0;
            if (this.k != null) {
                this.k.a();
                Deque unused2 = this.k.c = null;
            }
            this.k = null;
            this.j = null;
        }
    }

    public final H e() {
        H a2 = N.a();
        a2.a(this);
        return a2;
    }

    /* access modifiers changed from: private */
    public boolean e(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattDescriptor b2;
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || !this.o || (b2 = b(bluetoothGattCharacteristic, 16)) == null) {
            return false;
        }
        a(3, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", false)");
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, false);
        b2.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        a(2, "Disabling notifications and indications for " + bluetoothGattCharacteristic.getUuid());
        a(3, "gatt.writeDescriptor(" + f1572a + ", value=0x00-00)");
        return c(b2);
    }

    /* access modifiers changed from: protected */
    public W c(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        W w2 = this.B.get(bluetoothGattCharacteristic);
        if (w2 == null) {
            w2 = new W();
            if (bluetoothGattCharacteristic != null) {
                this.B.put(bluetoothGattCharacteristic, w2);
            }
        }
        w2.a();
        return w2;
    }

    /* access modifiers changed from: private */
    public static BluetoothGattDescriptor b(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        if (bluetoothGattCharacteristic == null || (i2 & bluetoothGattCharacteristic.getProperties()) == 0) {
            return null;
        }
        return bluetoothGattCharacteristic.getDescriptor(f1572a);
    }

    /* access modifiers changed from: protected */
    public L b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        L b2 = N.b(bluetoothGattCharacteristic);
        b2.a(this);
        return b2;
    }

    /* access modifiers changed from: private */
    public boolean b(BluetoothGattDescriptor bluetoothGattDescriptor) {
        if (this.i == null || bluetoothGattDescriptor == null || !this.o) {
            return false;
        }
        a(2, "Writing descriptor " + bluetoothGattDescriptor.getUuid());
        a(3, "gatt.writeDescriptor(" + bluetoothGattDescriptor.getUuid() + ")");
        return c(bluetoothGattDescriptor);
    }

    private boolean c(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || bluetoothGattDescriptor == null || !this.o) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
        int writeType = characteristic.getWriteType();
        characteristic.setWriteType(2);
        boolean writeDescriptor = bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
        characteristic.setWriteType(writeType);
        return writeDescriptor;
    }

    private String h(int i2) {
        switch (i2) {
            case 1:
                return "LE 1M";
            case 2:
                return "LE 2M";
            case 3:
                return "LE 1M or LE 2M";
            case 4:
                return "LE Coded";
            case 5:
                return "LE 1M or LE Coded";
            case 6:
                return "LE 2M or LE Coded";
            case 7:
                return "LE 1M, LE 2M or LE Coded";
            default:
                return "UNKNOWN (" + i2 + ")";
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void i() {
        L e2 = N.e();
        e2.a(this);
        e2.a((c) new C0234h(this));
        e2.b();
    }

    private String g(int i2) {
        if (i2 == 0) {
            return "No preferred";
        }
        if (i2 == 1) {
            return "S2";
        }
        if (i2 == 2) {
            return "S8";
        }
        return "UNKNOWN (" + i2 + ")";
    }

    /* access modifiers changed from: private */
    public String i(int i2) {
        if (i2 == 1) {
            return "LE 1M";
        }
        if (i2 == 2) {
            return "LE 2M";
        }
        if (i2 == 3) {
            return "LE Coded";
        }
        return "UNKNOWN (" + i2 + ")";
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void f() {
        if (this.D == null) {
            W w2 = new W();
            w2.a((c) new C0235i(this));
            this.D = w2;
        }
        Y c2 = N.c();
        c2.a(this);
        c2.a((k) new C0236j(this));
        c2.b();
    }

    /* access modifiers changed from: private */
    public boolean e(int i2) {
        String str;
        String str2;
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o) {
            return false;
        }
        if (i2 == 1) {
            str2 = Build.VERSION.SDK_INT >= 23 ? "HIGH (11.25–15ms, 0, 20s)" : "HIGH (7.5–10ms, 0, 20s)";
            str = "HIGH";
        } else if (i2 != 2) {
            str2 = "BALANCED (30–50ms, 0, 20s)";
            str = "BALANCED";
        } else {
            str2 = "LOW POWER (100–125ms, 2, 20s)";
            str = "LOW POWER";
        }
        a(2, "Requesting connection priority: " + str2 + "...");
        a(3, "gatt.requestConnectionPriority(" + str + ")");
        return bluetoothGatt.requestConnectionPriority(i2);
    }

    public void a(E e2) {
        this.l = e2;
    }

    public /* synthetic */ void b(BluetoothDevice bluetoothDevice, no.nordicsemi.android.ble.b.b bVar) {
        if (bVar.b() == 1) {
            int intValue = bVar.a(17, 0).intValue();
            a(4, "Battery Level received: " + intValue + "%");
            this.v = intValue;
            C<E>.a aVar = this.k;
            if (aVar != null) {
                aVar.e(this.i, intValue);
            }
            this.l.a(bluetoothDevice, intValue);
        }
    }

    public final F a(BluetoothDevice bluetoothDevice) {
        if (this.l == null) {
            throw new NullPointerException("Set callbacks using setGattCallbacks(E callbacks) before connecting");
        } else if (bluetoothDevice != null) {
            F a2 = N.a(bluetoothDevice);
            a2.a(j());
            a2.a(this);
            return a2;
        } else {
            throw new NullPointerException("Bluetooth device not specified");
        }
    }

    /* access modifiers changed from: private */
    public boolean f(int i2) {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o) {
            return false;
        }
        a(2, "Requesting new MTU...");
        a(3, "gatt.requestMtu(" + i2 + ")");
        return bluetoothGatt.requestMtu(i2);
    }

    /* access modifiers changed from: private */
    public boolean a(BluetoothDevice bluetoothDevice, F f2) {
        boolean isEnabled = BluetoothAdapter.getDefaultAdapter().isEnabled();
        if (this.o || !isEnabled) {
            BluetoothDevice bluetoothDevice2 = this.j;
            if (!isEnabled || bluetoothDevice2 == null || !bluetoothDevice2.equals(bluetoothDevice)) {
                F f3 = this.y;
                if (f3 != null) {
                    f3.a(bluetoothDevice, isEnabled ? -4 : -100);
                }
            } else {
                this.y.c(bluetoothDevice);
            }
            this.y = null;
            C<E>.a aVar = this.k;
            if (aVar != null) {
                aVar.a(true);
            }
            return true;
        }
        synchronized (this.f) {
            if (this.i == null) {
                this.g.registerReceiver(this.E, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                this.g.registerReceiver(this.F, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
                this.g.registerReceiver(this.G, new IntentFilter("android.bluetooth.device.action.PAIRING_REQUEST"));
            } else if (!this.n) {
                a(3, "gatt.close()");
                this.i.close();
                this.i = null;
                try {
                    a(3, "wait(200)");
                    Thread.sleep(200);
                } catch (InterruptedException unused) {
                }
            } else {
                this.n = false;
                this.p = 0;
                this.u = 1;
                a(2, "Connecting...");
                this.l.d(bluetoothDevice);
                a(3, "gatt.connect()");
                this.i.connect();
                return true;
            }
        }
        if (f2 == null) {
            return false;
        }
        boolean l2 = f2.l();
        this.m = !l2;
        if (l2) {
            this.n = true;
        }
        this.j = bluetoothDevice;
        this.k.a(this.h);
        a(2, f2.k() ? "Connecting..." : "Retrying...");
        this.u = 1;
        this.l.d(bluetoothDevice);
        this.p = SystemClock.elapsedRealtime();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            int i3 = f2.i();
            a(3, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, " + h(i3) + ")");
            this.i = bluetoothDevice.connectGatt(this.g, false, this.k, 2, i3);
        } else if (i2 >= 23) {
            a(3, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE)");
            this.i = bluetoothDevice.connectGatt(this.g, false, this.k, 2);
        } else {
            a(3, "gatt = device.connectGatt(autoConnect = false)");
            this.i = bluetoothDevice.connectGatt(this.g, false, this.k);
        }
        return true;
    }

    public /* synthetic */ void b(BluetoothDevice bluetoothDevice) {
        a(4, "Battery Level notifications enabled");
    }

    /* access modifiers changed from: private */
    @Deprecated
    public boolean b(boolean z2) {
        BluetoothGattService service;
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o || (service = bluetoothGatt.getService(f1573b)) == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(c);
        if (z2) {
            return g(characteristic);
        }
        return e(characteristic);
    }

    /* access modifiers changed from: private */
    public boolean d(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return e(bluetoothGattCharacteristic);
    }

    /* access modifiers changed from: protected */
    public String d(int i2) {
        if (i2 == 1) {
            return "WRITE COMMAND";
        }
        if (i2 == 2) {
            return "WRITE REQUEST";
        }
        if (i2 == 4) {
            return "WRITE SIGNED";
        }
        return "UNKNOWN: " + i2;
    }

    /* access modifiers changed from: protected */
    public Y a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Y a2 = N.a(bluetoothGattCharacteristic);
        a2.a(this);
        return a2;
    }

    /* access modifiers changed from: protected */
    public Y a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        Y a2 = N.a(bluetoothGattCharacteristic, bArr);
        a2.a(this);
        return a2;
    }

    /* access modifiers changed from: private */
    public boolean a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || bluetoothGattDescriptor == null || !this.o) {
            return false;
        }
        a(2, "Reading descriptor " + bluetoothGattDescriptor.getUuid());
        a(3, "gatt.readDescriptor(" + bluetoothGattDescriptor.getUuid() + ")");
        return bluetoothGatt.readDescriptor(bluetoothGattDescriptor);
    }

    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, no.nordicsemi.android.ble.b.b bVar) {
        if (bVar.b() == 1) {
            int intValue = bVar.a(17, 0).intValue();
            this.v = intValue;
            C<E>.a aVar = this.k;
            if (aVar != null) {
                aVar.e(this.i, intValue);
            }
            this.l.a(bluetoothDevice, intValue);
        }
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, int i3, int i4) {
        BluetoothGatt bluetoothGatt = this.i;
        if (bluetoothGatt == null || !this.o) {
            return false;
        }
        a(2, "Requesting preferred PHYs...");
        a(3, "gatt.setPreferredPhy(" + h(i2) + ", " + h(i3) + ", coding option = " + g(i4) + ")");
        bluetoothGatt.setPreferredPhy(i2, i3, i4);
        return true;
    }

    /* access modifiers changed from: protected */
    public S a(long j2) {
        S a2 = N.a(j2);
        a2.a(this);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public final void a(N n2) {
        C<E>.a aVar = this.k;
        if (aVar == null) {
            aVar = g();
            this.k = aVar;
        }
        aVar.a(n2);
        a((Runnable) new C0233g(aVar));
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.h.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(U u2) {
        this.z = null;
        this.C = null;
        N.a aVar = u2.c;
        if (aVar == N.a.CONNECT) {
            this.y = null;
            p();
        } else if (aVar == N.a.DISCONNECT) {
            d();
        } else {
            C<E>.a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.a(true);
            }
        }
    }
}
