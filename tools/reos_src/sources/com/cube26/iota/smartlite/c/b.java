package com.cube26.iota.smartlite.c;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.android.apps.config.util.CLog;
import com.appyvet.rangebar.RangeBar;
import com.cube26.iota.smartlite.R;
import com.cube26.iota.smartlite.util.ColorCodeChangeListener;
import com.cube26.iota.smartlite.util.ColorPicker;
import com.cube26.iota.smartlite.util.g;
import com.flurry.android.FlurryAgent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import uk.co.deanwild.materialshowcaseview.h;

/* JADX INFO: loaded from: classes.dex */
public class b extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ToggleButton f3257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static uk.co.deanwild.materialshowcaseview.e f3258c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static int f3260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static Button f3261f;
    private File A;
    RangeBar g;
    ColorPicker h;
    int j;
    Bitmap m;
    String n;
    private Button o;
    private ImageView p;
    private Bitmap q;
    private int r;
    private int s;
    private com.cube26.iota.smartlite.a.a t;
    private ImageView w;
    private boolean x;
    private ImageView y;
    private Bitmap z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f3256a = new int[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f3259d = "";
    final h k = new h();
    private int u = 1;
    private int v = 0;
    int l = 0;
    final b.a.a.c i = b.a.a.c.a();

    private Bitmap a(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = getActivity().getContentResolver().openFileDescriptor(uri, "r");
        Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
        parcelFileDescriptorOpenFileDescriptor.close();
        return bitmapDecodeFileDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.h.setVisibility(8);
        this.p.setVisibility(8);
        this.y.setVisibility(0);
        this.y.setImageResource(R.drawable.cool_warm_palette);
        this.g.setConnectingLineColor(getResources().getColor(R.color.colorerror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.p.setVisibility(8);
        this.y.setVisibility(8);
        this.h.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Pick Image"), 101);
    }

    private File f() throws IOException {
        String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_";
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        externalStoragePublicDirectory.mkdirs();
        File fileCreateTempFile = File.createTempFile(str, ".jpg", externalStoragePublicDirectory);
        this.n = "file:" + fileCreateTempFile.getAbsolutePath();
        CLog.a("IOTA", " current photo path :: " + this.n);
        return fileCreateTempFile;
    }

    public void a() {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Color Palette"};
        android.support.v7.a.e.a aVar = new android.support.v7.a.e.a(getActivity());
        aVar.a(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.cube26.iota.smartlite.c.b.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (charSequenceArr[i].equals("Take Photo") && b.this.getActivity().getPackageManager().hasSystemFeature("android.hardware.camera")) {
                    FlurryAgent.logEvent("user_defined_camera_image_set");
                    if (g.a(b.this.getActivity(), "android.permission.CAMERA")) {
                        b.this.b();
                        return;
                    } else {
                        g.a(b.this.getActivity(), "android.permission.CAMERA", 110);
                        return;
                    }
                }
                if (charSequenceArr[i].equals("Choose from Gallery")) {
                    FlurryAgent.logEvent("user_defined_photo_lib_image_selected");
                    b.this.e();
                } else {
                    if (!charSequenceArr[i].equals("Color Palette")) {
                        Toast.makeText(b.this.getActivity(), "Your device does not have camera.", 0).show();
                        return;
                    }
                    b.this.h.setVisibility(0);
                    b.this.p.setVisibility(8);
                    b.this.y.setVisibility(8);
                    b.this.w.setImageResource(R.drawable.temp_wheel_view_picker);
                    b.this.w.setTag(Integer.valueOf(R.drawable.temp_wheel_view_picker));
                    b.this.x = false;
                }
            }
        });
        aVar.c();
    }

    public void b() {
        CLog.a("IOTA", " take picture intent");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getActivity().getPackageManager()) == null) {
            Toast.makeText(getActivity().getApplicationContext(), "Your device does not have any camera app.", 0).show();
            return;
        }
        CLog.a("IOTA", " resolved activity");
        try {
            this.A = f();
            CLog.a("IOTA", " image destination :: " + this.A);
        } catch (IOException e2) {
            CLog.a("IOTA", " io error ");
            e2.printStackTrace();
        }
        if (this.A != null) {
            CLog.a("IOTA", " image destination not null");
            intent.putExtra("output", Uri.fromFile(this.A));
            startActivityForResult(intent, 1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        CLog.a("IOTA", " on activity result");
        if (i2 == -1) {
            try {
                this.x = false;
                if (i != 1) {
                    if (i == 101) {
                        Uri data = intent.getData();
                        try {
                            this.q = a(data);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        if (this.q == null) {
                            CLog.a("IOTA", " bm null");
                            this.h.setVisibility(0);
                            this.y.setVisibility(8);
                            this.p.setVisibility(8);
                            return;
                        }
                        CLog.a("IOTA", " bm not null");
                        this.h.setVisibility(8);
                        this.y.setVisibility(8);
                        this.p.setVisibility(0);
                        try {
                            this.m = com.cube26.iota.smartlite.util.h.a(com.cube26.iota.smartlite.util.h.a(com.cube26.iota.smartlite.util.h.a(this.q, data.getPath()), ColorPicker.f3422b, ColorPicker.f3422b));
                            this.p.setImageBitmap(this.m);
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                try {
                    this.q = a(Uri.fromFile(this.A));
                } catch (IOException | NullPointerException | OutOfMemoryError e4) {
                    e4.printStackTrace();
                }
                if (this.q != null) {
                    this.h.setVisibility(8);
                    this.y.setVisibility(8);
                    this.p.setVisibility(0);
                    try {
                        this.m = com.cube26.iota.smartlite.util.h.a(com.cube26.iota.smartlite.util.h.a(com.cube26.iota.smartlite.util.h.a(this.q, this.A.getAbsolutePath()), ColorPicker.f3422b, ColorPicker.f3422b));
                        this.p.setImageBitmap(this.m);
                        return;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return;
                    }
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    this.q = (Bitmap) extras.get("data");
                }
                CLog.a("IOTA", " bm null");
                if (this.q != null) {
                    try {
                        this.h.setVisibility(8);
                        this.y.setVisibility(8);
                        this.p.setVisibility(0);
                        this.m = com.cube26.iota.smartlite.util.h.a(com.cube26.iota.smartlite.util.h.a(com.cube26.iota.smartlite.util.h.a(this.q, this.A.getAbsolutePath()), ColorPicker.f3422b, ColorPicker.f3422b));
                        this.p.setImageBitmap(this.m);
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                this.h.setVisibility(0);
                this.p.setVisibility(8);
                this.y.setVisibility(8);
                return;
            } catch (OutOfMemoryError e7) {
                Toast.makeText(getActivity(), "Image too large.", 0).show();
            }
            Toast.makeText(getActivity(), "Image too large.", 0).show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i.a(this);
        this.k.a(10L);
        this.k.a(getResources().getColor(R.color.navtabselectedcolor));
        f3258c = new uk.co.deanwild.materialshowcaseview.e(getActivity(), "1");
        this.t = new com.cube26.iota.smartlite.a.a(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_one, viewGroup, false);
        this.h = (ColorPicker) viewInflate.findViewById(R.id.colorpalette);
        f3257b = (ToggleButton) viewInflate.findViewById(R.id.on);
        this.g = (RangeBar) viewInflate.findViewById(R.id.bright);
        f3261f = (Button) viewInflate.findViewById(R.id.off);
        this.g.setSelectorColor(-16777216);
        this.p = (ImageView) viewInflate.findViewById(R.id.imagePalette);
        this.p.setVisibility(8);
        this.o = (Button) viewInflate.findViewById(R.id.imagePicker);
        this.w = (ImageView) viewInflate.findViewById(R.id.color_source_picker_view);
        this.w.setImageResource(R.drawable.temp_wheel_view_picker);
        this.w.setTag(Integer.valueOf(R.drawable.temp_wheel_view_picker));
        this.y = (ImageView) viewInflate.findViewById(R.id.temp_palette);
        this.y.setVisibility(8);
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (((Integer) view.getTag()).intValue()) {
                    case R.drawable.color_palette_view_picker /* 2130837602 */:
                        ((ImageView) view).setImageResource(R.drawable.temp_wheel_view_picker);
                        view.setTag(Integer.valueOf(R.drawable.temp_wheel_view_picker));
                        b.this.x = false;
                        b.this.d();
                        break;
                    case R.drawable.temp_wheel_view_picker /* 2130837827 */:
                        b.this.x = true;
                        ((ImageView) view).setImageResource(R.drawable.color_palette_view_picker);
                        view.setTag(Integer.valueOf(R.drawable.color_palette_view_picker));
                        b.this.c();
                        break;
                }
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.cube26.iota.smartlite.c.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FlurryAgent.logEvent("user_Defined_image_tapped");
                ViewGroup.LayoutParams layoutParams = b.this.p.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = b.this.p.getLayoutParams();
                int i = ColorPicker.f3422b;
                layoutParams2.height = i;
                layoutParams.width = i;
                if (Build.VERSION.SDK_INT <= 22) {
                    b.this.a();
                } else if (b.this.getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    CLog.a("IOTA", "requesting storage permission");
                    android.support.v4.app.a.a(b.this.getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 105);
                } else {
                    CLog.a("IOTA", "We already have storage permission");
                    b.this.a();
                }
            }
        });
        this.p.setOnTouchListener(new View.OnTouchListener() { // from class: com.cube26.iota.smartlite.c.b.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                CLog.a("IOTA", " on touch event ");
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                CLog.a("IOTA", " x :: " + x + " :: y :: " + y);
                b.this.r = ((ImageView) view).getWidth() / 2;
                b.this.s = ((ImageView) view).getHeight() / 2;
                int i = x - b.this.r;
                int i2 = y - b.this.s;
                if (Math.sqrt((i * i) + (i2 * i2)) > b.this.r) {
                    return true;
                }
                CLog.a("IOTA", " pixel value :: " + b.this.m.getPixel(x, y));
                b.this.i.b(new ColorCodeChangeListener(b.this.m.getPixel(x, y)));
                return true;
            }
        });
        this.y.setOnTouchListener(new View.OnTouchListener() { // from class: com.cube26.iota.smartlite.c.b.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int i;
                CLog.a("IOTA", " on touch event ");
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                CLog.a("IOTA", " x :: " + x + " :: y :: " + y);
                b.this.r = ((ImageView) view).getWidth() / 2;
                b.this.s = ((ImageView) view).getHeight() / 2;
                int i2 = x - b.this.r;
                int i3 = y - b.this.s;
                double dSqrt = Math.sqrt((i2 * i2) + (i3 * i3));
                double d2 = b.this.r / 2;
                if (dSqrt <= b.this.r && dSqrt >= b.this.r / 2) {
                    if (x > b.this.r && y < b.this.s) {
                        i = 270;
                    } else if (x <= b.this.r || y <= b.this.s) {
                        i = (x >= b.this.r || y > b.this.s) ? 90 : 90;
                    } else {
                        i = -90;
                    }
                    int iAtan = i + ((int) (Math.atan((((double) (y - b.this.s)) * 1.0d) / ((double) (x - b.this.r))) * 57.29577951308232d));
                    int i4 = iAtan < 0 ? iAtan + 360 : iAtan;
                    if (com.cube26.iota.smartlite.util.h.f3467a) {
                        b.this.z = com.cube26.iota.smartlite.util.h.a(((BitmapDrawable) b.this.y.getDrawable()).getBitmap(), ColorPicker.f3422b, ColorPicker.f3422b);
                        b.this.v = b.this.z.getPixel(x, y);
                    }
                    if (i4 > 20 && i4 < 340) {
                        b.this.u = (int) Math.ceil(0.625d * (((double) i4) - 20.0d));
                        CLog.a("IOTA", "m :" + b.this.u);
                    }
                    com.cube26.iota.smartlite.util.h.a(0, 0, 0, true);
                    for (int i5 = 0; i5 < com.cube26.iota.smartlite.util.h.v.size(); i5++) {
                        if (com.cube26.iota.smartlite.util.h.f3467a) {
                            com.cube26.iota.smartlite.util.h.b(Color.red(b.this.v), Color.green(b.this.v), Color.blue(b.this.v), com.cube26.iota.smartlite.util.h.H, 0, "wheel");
                        }
                        com.cube26.iota.smartlite.util.h.a(b.this.u, i5);
                    }
                }
                return true;
            }
        });
        this.g.setOnRangeBarChangeListener(new RangeBar.a() { // from class: com.cube26.iota.smartlite.c.b.5
            @Override // com.appyvet.rangebar.RangeBar.a
            public void a(RangeBar rangeBar, int i, int i2, String str, String str2) {
                b.f3257b.setChecked(false);
                if (i2 >= 96) {
                    i2 = 96;
                }
                FlurryAgent.logEvent("bulb_brightness_adjusted");
                com.cube26.iota.smartlite.util.h.H = (i2 * 2) + 16;
                CLog.a("IOTA", "r ::" + b.f3256a[0] + "g :: " + b.f3256a[1] + "b ::" + b.f3256a[2]);
                if (com.cube26.iota.smartlite.util.h.G != 0 || com.cube26.iota.smartlite.util.h.N) {
                    return;
                }
                for (int i3 = 0; i3 < com.cube26.iota.smartlite.util.h.v.size(); i3++) {
                    if (b.f3256a[0] != 0 || b.f3256a[1] != 0 || b.f3256a[2] != 0) {
                        if (b.this.x) {
                            if (com.cube26.iota.smartlite.util.h.f3467a) {
                                com.cube26.iota.smartlite.util.h.b(Color.red(b.this.v), Color.green(b.this.v), Color.blue(b.this.v), com.cube26.iota.smartlite.util.h.H, i3, "Wheel");
                            }
                            if (com.cube26.iota.smartlite.util.h.v.get(i3) != null && com.cube26.iota.smartlite.util.h.v.get(i3).c() != null && com.cube26.iota.smartlite.util.h.v.get(i3).c().equalsIgnoreCase("LITE1100")) {
                                com.cube26.iota.smartlite.util.h.a(b.f3256a[0], b.f3256a[1], b.f3256a[2], com.cube26.iota.smartlite.util.h.H, i3, b.this.u);
                            }
                        } else {
                            com.cube26.iota.smartlite.util.h.b(b.f3256a[0], b.f3256a[1], b.f3256a[2], com.cube26.iota.smartlite.util.h.H, i3, "Wheel");
                        }
                    }
                }
            }
        });
        f3257b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cube26.iota.smartlite.c.b.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CLog.a("IOTA", "on checked change");
                if (!z) {
                    for (int i = 0; i < 3; i++) {
                        CLog.a("IOTA", " last rgb code :: " + com.cube26.iota.smartlite.util.h.K[i]);
                        com.cube26.iota.smartlite.util.h.J[i] = com.cube26.iota.smartlite.util.h.K[i];
                    }
                    b.f3257b.setBackgroundResource(R.drawable.on);
                    for (int i2 = 0; i2 < com.cube26.iota.smartlite.util.h.v.size(); i2++) {
                        com.cube26.iota.smartlite.util.h.b(0, 0, 0, 200, i2, "on");
                        b.f3257b.setBackgroundResource(R.drawable.on);
                        b.f3259d = "on";
                    }
                    b.f3259d = "on";
                    CLog.a("IOTA", "on");
                    FlurryAgent.logEvent("bulb_on");
                    return;
                }
                FlurryAgent.logEvent("bulb_off");
                b.f3259d = "off";
                if (!d.f3307d) {
                    try {
                        d.f3307d = true;
                        d.f3309f.setChecked(false);
                        d.a();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        CLog.a("IOTA", "Exception caught while unregistering ::");
                    }
                } else if (com.cube26.iota.smartlite.util.h.N && c.f3272c.equals(c.f3273d)) {
                    try {
                        com.cube26.iota.smartlite.util.h.B.removeCallbacksAndMessages(null);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    com.cube26.iota.smartlite.util.h.N = false;
                    c.f3273d = "";
                    c.f3272c = "";
                    CLog.a("IOTA", "Canceling Handlers from color");
                    c.a();
                    if (c.f3274e.equalsIgnoreCase("candle") || c.f3274e.equalsIgnoreCase("Strobe") || c.f3274e.equalsIgnoreCase("Kaleidoscope")) {
                        for (int i3 = 0; i3 < com.cube26.iota.smartlite.util.h.v.size(); i3++) {
                            com.cube26.iota.smartlite.util.h.b(0, 0, 0, 0, i3, "PhoneCancel");
                        }
                    } else if (c.f3274e.equalsIgnoreCase("shake")) {
                        c.f3275f.unregisterListener(c.B);
                    }
                }
                for (int i4 = 0; i4 < 3; i4++) {
                    CLog.a("IOTA", "rgb code :: " + com.cube26.iota.smartlite.util.h.J[i4]);
                    com.cube26.iota.smartlite.util.h.K[i4] = com.cube26.iota.smartlite.util.h.J[i4];
                }
                b.f3257b.setBackgroundResource(R.drawable.off);
                for (int i5 = 0; i5 < com.cube26.iota.smartlite.util.h.v.size(); i5++) {
                    com.cube26.iota.smartlite.util.h.b(0, 0, 0, 0, i5, "off");
                    b.f3257b.setBackgroundResource(R.drawable.off);
                    b.f3259d = "off";
                }
                CLog.a("IOTA", "off");
            }
        });
        return viewInflate;
    }

    public void onEvent(ColorCodeChangeListener colorCodeChangeListener) {
        int i;
        int i2;
        int i3 = 255;
        if (com.cube26.iota.smartlite.util.h.G == 0) {
            try {
                CLog.a("IOTA", "Color code listner" + com.cube26.iota.smartlite.util.h.N);
                this.j = colorCodeChangeListener.f3421a;
                f3260e = this.j;
                HashMap map = new HashMap();
                map.put("color_code", String.valueOf(colorCodeChangeListener.f3421a));
                FlurryAgent.logEvent("color_wheel_touched", map);
                int iRed = Color.red(this.j);
                int iGreen = Color.green(this.j);
                int iBlue = Color.blue(this.j);
                if (iRed == f3256a[0] && iGreen == f3256a[1] && iBlue == f3256a[2]) {
                    return;
                }
                f3256a[0] = iRed;
                f3256a[1] = iGreen;
                f3256a[2] = iBlue;
                f3261f.setBackgroundColor(this.j);
                this.g.setConnectingLineColor(this.j);
                CLog.a("IOTA", "R: " + iRed + " B: " + iBlue + " G: " + iGreen);
                if (iRed < 235 || iGreen < 235 || iBlue < 235) {
                    i3 = iBlue;
                    i = iGreen;
                    i2 = iRed;
                } else {
                    f3256a[0] = 255;
                    f3256a[1] = 255;
                    f3256a[2] = 255;
                    f3261f.setBackgroundColor(-1);
                    this.g.setSelectorColor(-16777216);
                    i = 255;
                    i2 = 255;
                }
                com.cube26.iota.smartlite.util.h.a(i2, i, i3, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (d.f3309f.isChecked()) {
            d.f3309f.setChecked(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        FlurryAgent.logEvent("color_tab_opened");
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        f3258c = new uk.co.deanwild.materialshowcaseview.e(getActivity(), "1");
        f3258c.a(this.k);
        f3258c.a(this.h, "Tap to change the color", "Got it");
        f3258c.a(f3257b, "Turn the Lite on or off", "Got it");
        f3258c.a(this.g, "Drag to change intensity", "Got it");
    }
}
