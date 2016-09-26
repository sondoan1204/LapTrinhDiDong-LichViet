package com.example.sonpc.myapplication;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout manhinh;
    TextView txtDate,txtDate1,txtDate2,txtDate3,txtDay1;
    Calendar cal;
    //Date date;
    Button btntoi,btnlui,btntoday;
    //Calendar day,month,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manhinh=(RelativeLayout)findViewById(R.id.NenApp);
        manhinh.setBackgroundResource(R.drawable.hinhnen1);
        txtDate=(TextView)findViewById(R.id.txtdate) ;
        txtDate1=(TextView)findViewById(R.id.txtdate1);
        txtDate2=(TextView)findViewById(R.id.txtdate2);
        txtDate3=(TextView)findViewById(R.id.txtdate3);
        txtDay1=(TextView)findViewById(R.id.txtDay);
        cal=Calendar.getInstance();
        SimpleDateFormat dft=null;
        SimpleDateFormat dft1=null;
        dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        //dft1=new SimpleDateFormat("EEE",Locale.getDefault());
        String strDate=dft.format(cal.getTime());

        //int day= cal.DAY_OF_WEEK;
        int day=cal.get(Calendar.DAY_OF_WEEK);
        //boolean isWeekday = ((day >= Calendar.MONDAY) && (day <= Calendar.FRIDAY));


        //String strDay=dft1.format(cal.getFirstDayOfWeek());
        txtDate.setText(strDate);
        String s=txtDate.getText()+"";
        String strArrtmp[]=s.split("/");
        int ngay=Integer.parseInt(strArrtmp[0]);
        int thang=Integer.parseInt(strArrtmp[1]);
        int nam=Integer.parseInt(strArrtmp[2]);
        //int thu=Integer.parseInt(strArrtmp[3]);
        double TZ = 7.0;
         //int ngay=31;
         //int thang=10;
         //int nam=2016;

        int[] tam =convertSolar2Lunar(ngay,thang,nam,TZ);
        ngay=tam[0];
        thang=tam[1];
        //nam=tam[2];

        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,,demo);

        String txtngayam=Integer.toString(ngay);
        String txtthangam=Integer.toString(thang);
        //String txtnamam=Integer.toString(nam);
        txtDate1.setText(txtngayam);
        txtDate2.setText(txtthangam);
        //txtDate3.setText(txtnamam);
        GetDay(day);
        Getcanchi(nam);

        btntoi=(Button)findViewById(R.id.btnditoi);
        btntoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> manghinhnen=new ArrayList<Integer>();
                manghinhnen.add(R.drawable.hinhnen1);
                manghinhnen.add(R.drawable.hinhnen2);
                manghinhnen.add(R.drawable.hinhnen3);
                manghinhnen.add(R.drawable.hinhnen4);

                Random r=new Random();
                int random=r.nextInt(manghinhnen.size());
                manhinh.setBackgroundResource(manghinhnen.get(random));
               // finalDft.add(Calendar.DAY_OF_MONTH,1);
                cal.add(Calendar.DAY_OF_MONTH,1);
                SimpleDateFormat dft=null;
                dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String strDate=dft.format(cal.getTime());
                txtDate.setText(strDate);
                String s=txtDate.getText()+"";
                String strArrtmp[]=s.split("/");
                int ngay=Integer.parseInt(strArrtmp[0]);
                int thang=Integer.parseInt(strArrtmp[1]);
                int nam=Integer.parseInt(strArrtmp[2]);
                double TZ = 7.0;
                convertSolar2Lunar(ngay,thang,nam,TZ);

                int[] tam =convertSolar2Lunar(ngay,thang,nam,TZ);
                int ngaytam=tam[0];
                int thangtam=tam[1];
                //int namtam=tam[2];

                String txtngayam=Integer.toString(ngaytam);
                String txtthangam=Integer.toString(thangtam);
                //String txtnamam=Integer.toString(namtam);
                txtDate1.setText(txtngayam);
                txtDate2.setText(txtthangam);
                //txtDate3.setText(txtnamam);
                Getcanchi(nam);
                int day=cal.get(Calendar.DAY_OF_WEEK);
                GetDay(day);


            }
        });
        btnlui=(Button)findViewById(R.id.btndilui);
        btnlui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> manghinhnen=new ArrayList<Integer>();
                manghinhnen.add(R.drawable.hinhnen1);
                manghinhnen.add(R.drawable.hinhnen2);
                manghinhnen.add(R.drawable.hinhnen3);
                manghinhnen.add(R.drawable.hinhnen4);

                Random r=new Random();
                int random=r.nextInt(manghinhnen.size());
                manhinh.setBackgroundResource(manghinhnen.get(random));

                cal.add(Calendar.DAY_OF_MONTH,-1);
                SimpleDateFormat dft=null;
                dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String strDate=dft.format(cal.getTime());
                txtDate.setText(strDate);
                String s=txtDate.getText()+"";
                String strArrtmp[]=s.split("/");
                int ngay=Integer.parseInt(strArrtmp[0]);
                int thang=Integer.parseInt(strArrtmp[1]);
                int nam=Integer.parseInt(strArrtmp[2]);
                double TZ = 7.0;
                convertSolar2Lunar(ngay,thang,nam,TZ);
                int[] tam =convertSolar2Lunar(ngay,thang,nam,TZ);
                ngay=tam[0];
                thang=tam[1];
                //nam=tam[2];

                String txtngayam=Integer.toString(ngay);
                String txtthangam=Integer.toString(thang);
                //String txtnamam=Integer.toString(nam);
                txtDate1.setText(txtngayam);
                txtDate2.setText(txtthangam);
                //txtDate3.setText(txtnamam);
                Getcanchi(nam);
                int day=cal.get(Calendar.DAY_OF_WEEK);
                GetDay(day);


            }
        });
        btntoday=(Button)findViewById(R.id.btntoday);
        btntoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> manghinhnen=new ArrayList<Integer>();
                manghinhnen.add(R.drawable.hinhnen1);
                manghinhnen.add(R.drawable.hinhnen2);
                manghinhnen.add(R.drawable.hinhnen3);
                manghinhnen.add(R.drawable.hinhnen4);

                Random r=new Random();
                int random=r.nextInt(manghinhnen.size());
                manhinh.setBackgroundResource(manghinhnen.get(random));

                cal=Calendar.getInstance();
                SimpleDateFormat dft=null;
                dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String strDate=dft.format(cal.getTime());
                txtDate.setText(strDate);
                String s=txtDate.getText()+"";
                String strArrtmp[]=s.split("/");
                int ngay=Integer.parseInt(strArrtmp[0]);
                int thang=Integer.parseInt(strArrtmp[1]);
                int nam=Integer.parseInt(strArrtmp[2]);
                double TZ = 7.0;
                convertSolar2Lunar(ngay,thang,nam,TZ);
                int[] tam =convertSolar2Lunar(ngay,thang,nam,TZ);
                ngay=tam[0];
                thang=tam[1];
                //nam=tam[2];

                String txtngayam=Integer.toString(ngay);
                String txtthangam=Integer.toString(thang);
                //String txtnamam=Integer.toString(nam);
                txtDate1.setText(txtngayam);
                txtDate2.setText(txtthangam);
                //txtDate3.setText(txtnamam);
                Getcanchi(nam);
                int day=cal.get(Calendar.DAY_OF_WEEK);
                GetDay(day);


            }
        });

    }
    public void showDatePicker(View v){
        cal = Calendar.getInstance();
        int mYear = cal.get(Calendar.YEAR);
        int mMonth = cal.get(Calendar.MONTH);
        int mDay = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
                // Update the editText to display the selected date
                txtDate.setText(selectedDay + "-" + (selectedMonth + 1) + "-" + selectedYear);
                // Set the mCurrentDate to the selected date-month-year
                cal.set(selectedYear, selectedMonth, selectedDay);

                SimpleDateFormat dft=null;
                dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String strDate=dft.format(cal.getTime());
                txtDate.setText(strDate);
                String s=txtDate.getText()+"";
                String strArrtmp[]=s.split("/");
                int ngay=Integer.parseInt(strArrtmp[0]);
                int thang=Integer.parseInt(strArrtmp[1]);
                int nam=Integer.parseInt(strArrtmp[2]);
                double TZ = 7.0;
                convertSolar2Lunar(ngay,thang,nam,TZ);
                int[] tam =convertSolar2Lunar(ngay,thang,nam,TZ);
                ngay=tam[0];
                thang=tam[1];
                //nam=tam[2];

                String txtngayam=Integer.toString(ngay);
                String txtthangam=Integer.toString(thang);
                //String txtnamam=Integer.toString(nam);
                txtDate1.setText(txtngayam);
                txtDate2.setText(txtthangam);
                //txtDate3.setText(txtnamam);
                Getcanchi(nam);
                int day=cal.get(Calendar.DAY_OF_WEEK);
                GetDay(day);
                //mGeneratedDateIcon = mImageGenerator.generateDateImage(mCurrentDate, R.drawable.empty_calendar);
                //mDisplayGeneratedImage.setImageBitmap(mGeneratedDateIcon);

            }
        }, mYear, mMonth, mDay);
        mDatePicker.show();

    }
    public void GetDay(int day){
        if(day==1)
        {
            txtDay1.setText("Chủ Nhật");
            txtDay1.setTextColor(Color.parseColor("#F00000"));
        }
        if(day==2)
        {
            txtDay1.setText("Thứ Hai");
            txtDay1.setTextColor(Color.parseColor("#0000FF"));
        }
        if(day==3)
        {
            txtDay1.setText("Thứ Ba");
            txtDay1.setTextColor(Color.parseColor("#0000FF"));
        }
        if(day==4)
        {
            txtDay1.setText("Thứ Tư");
            txtDay1.setTextColor(Color.parseColor("#0000FF"));
        }
        if(day==5)
        {
            txtDay1.setText("Thứ Năm");
            txtDay1.setTextColor(Color.parseColor("#0000FF"));
        }
        if(day==6)
        {
            txtDay1.setText("Thứ Sáu");
            txtDay1.setTextColor(Color.parseColor("#0000FF"));
        }
        if(day==7)
        {
            txtDay1.setText("Thứ Bảy");
            txtDay1.setTextColor(Color.parseColor("#0000FF"));
        }
    }

    public void Getcanchi (int yy){
        int can=yy%10;
        int chi=yy%12;
        String ketqua1="";
        String ketqua2="";
        switch (can)
        {
            case 0:
                ketqua1="Canh";
                break;
            case 1:
                ketqua1="Tân";
                break;
            case 2:
                ketqua1="Nhâm";
                break;
            case 3:
                ketqua1="Quý";
                break;
            case 4:
                ketqua1="Giáp";
                break;
            case 5:
                ketqua1="Ất";
                break;
            case 6:
                ketqua1="Bính";
                break;
            case 7:
                ketqua1="Đinh";
                break;
            case 8:
                ketqua1="Mậu";
                break;
            case 9:
                ketqua1="Kỷ";
                break;
            default:
                ketqua1="";
                break;
        }
        switch (chi)
        {
            case 0:
                ketqua2="Thân";
                break;
            case 1:
                ketqua2="Dậu";
                break;
            case 2:
                ketqua2="Tuất";
                break;
            case 3:
                ketqua2="Hợi";
                break;
            case 4:
                ketqua2="Tý";
                break;
            case 5:
                ketqua2="Sửu";
                break;
            case 6:
                ketqua2="Dần";
                break;
            case 7:
                ketqua2="Mẹo";
                break;
            case 8:
                ketqua2="Thìn";
                break;
            case 9:
                ketqua2="Tỵ";
                break;
            case 10:
                ketqua2="Ngọ";
                break;
            case 11:
                ketqua2="Mùi";
                break;
            default:
                ketqua2="";
                break;
        }
        String s=ketqua1+" "+ketqua2;
        txtDate3.setText(s);
    }

    public static final double PI = Math.PI;
    /**
     *
     * @param dd
     * @param mm
     * @param yy
     * @return the number of days since 1 January 4713 BC (Julian calendar)
     */
    public static int jdFromDate(int dd, int mm, int yy) {
        int a = (14 - mm) / 12;
        int y = yy+4800-a;
        int m = mm+12*a-3;
        int jd = dd + (153*m+2)/5 + 365*y + y/4 - y/100 + y/400 - 32045;
        if (jd < 2299161) {
            jd = dd + (153*m+2)/5 + 365*y + y/4 - 32083;
        }
        //jd = jd - 1721425;
        return jd;
    }
    /**
     * http://www.tondering.dk/claus/calendar.html
     * Section: Is there a formula for calculating the Julian day number?
     * @param jd - the number of days since 1 January 4713 BC (Julian calendar)
     * @return
     */
    public static int[] jdToDate(int jd) {
        int a, b, c;
        if (jd > 2299160) { // After 5/10/1582, Gregorian calendar
            a = jd + 32044;
            b = (4*a+3)/146097;
            c = a - (b*146097)/4;
        } else {
            b = 0;
            c = jd + 32082;
        }
        int d = (4*c+3)/1461;
        int e = c - (1461*d)/4;
        int m = (5*e+2)/153;
        int day = e - (153*m+2)/5 + 1;
        int month = m + 3 - 12*(m/10);
        int year = b*100 + d - 4800 + m/10;
        return new int[]{day, month, year};
    }
    /**
     * Solar longitude in degrees
     * Algorithm from: Astronomical Algorithms, by Jean Meeus, 1998
     * @param jdn - number of days since noon UTC on 1 January 4713 BC
     * @return
     */
    public static double SunLongitude(double jdn) {
        //return CC2K.sunLongitude(jdn);
        return SunLongitudeAA98(jdn);
    }
    public static double SunLongitudeAA98(double jdn) {
        double T = (jdn - 2451545.0 ) / 36525; // Time in Julian centuries from 2000-01-01 12:00:00 GMT
        double T2 = T*T;
        double dr = PI/180; // degree to radian
        double M = 357.52910 + 35999.05030*T - 0.0001559*T2 - 0.00000048*T*T2; // mean anomaly, degree
        double L0 = 280.46645 + 36000.76983*T + 0.0003032*T2; // mean longitude, degree
        double DL = (1.914600 - 0.004817*T - 0.000014*T2)*Math.sin(dr*M);
        DL = DL + (0.019993 - 0.000101*T)*Math.sin(dr*2*M) + 0.000290*Math.sin(dr*3*M);
        double L = L0 + DL; // true longitude, degree
        L = L - 360*(INT(L/360)); // Normalize to (0, 360)
        return L;
    }
    public static double NewMoon(int k) {
        //return CC2K.newMoonTime(k);
        return NewMoonAA98(k);
    }
    /**
     * Julian day number of the kth new moon after (or before) the New Moon of 1900-01-01 13:51 GMT.
     * Accuracy: 2 minutes
     * Algorithm from: Astronomical Algorithms, by Jean Meeus, 1998
     * @param k
     * @return the Julian date number (number of days since noon UTC on 1 January 4713 BC) of the New Moon
     */

    public static double NewMoonAA98(int k) {
        double T = k/1236.85; // Time in Julian centuries from 1900 January 0.5
        double T2 = T * T;
        double T3 = T2 * T;
        double dr = PI/180;
        double Jd1 = 2415020.75933 + 29.53058868*k + 0.0001178*T2 - 0.000000155*T3;
        Jd1 = Jd1 + 0.00033*Math.sin((166.56 + 132.87*T - 0.009173*T2)*dr); // Mean new moon
        double M = 359.2242 + 29.10535608*k - 0.0000333*T2 - 0.00000347*T3; // Sun's mean anomaly
        double Mpr = 306.0253 + 385.81691806*k + 0.0107306*T2 + 0.00001236*T3; // Moon's mean anomaly
        double F = 21.2964 + 390.67050646*k - 0.0016528*T2 - 0.00000239*T3; // Moon's argument of latitude
        double C1=(0.1734 - 0.000393*T)*Math.sin(M*dr) + 0.0021*Math.sin(2*dr*M);
        C1 = C1 - 0.4068*Math.sin(Mpr*dr) + 0.0161*Math.sin(dr*2*Mpr);
        C1 = C1 - 0.0004*Math.sin(dr*3*Mpr);
        C1 = C1 + 0.0104*Math.sin(dr*2*F) - 0.0051*Math.sin(dr*(M+Mpr));
        C1 = C1 - 0.0074*Math.sin(dr*(M-Mpr)) + 0.0004*Math.sin(dr*(2*F+M));
        C1 = C1 - 0.0004*Math.sin(dr*(2*F-M)) - 0.0006*Math.sin(dr*(2*F+Mpr));
        C1 = C1 + 0.0010*Math.sin(dr*(2*F-Mpr)) + 0.0005*Math.sin(dr*(2*Mpr+M));
        double deltat;
        if (T < -11) {
            deltat= 0.001 + 0.000839*T + 0.0002261*T2 - 0.00000845*T3 - 0.000000081*T*T3;
        } else {
            deltat= -0.000278 + 0.000265*T + 0.000262*T2;
        };
        double JdNew = Jd1 + C1 - deltat;
        return JdNew;
    }
    public static int INT(double d) {
        return (int)Math.floor(d);
    }
    public static double getSunLongitude(int dayNumber, double timeZone) {
        return SunLongitude(dayNumber - 0.5 - timeZone/24);
    }
    public static int getNewMoonDay(int k, double timeZone) {
        double jd = NewMoon(k);
        return INT(jd + 0.5 + timeZone/24);
    }
    public static int getLunarMonth11(int yy, double timeZone) {
        double off = jdFromDate(31, 12, yy) - 2415021.076998695;
        int k = INT(off / 29.530588853);
        int nm = getNewMoonDay(k, timeZone);
        int sunLong = INT(getSunLongitude(nm, timeZone)/30);
        if (sunLong >= 9) {
            nm = getNewMoonDay(k-1, timeZone);
        }
        return nm;
    }
    public static int getLeapMonthOffset(int a11, double timeZone) {
        int k = INT(0.5 + (a11 - 2415021.076998695) / 29.530588853);
        int last; // Month 11 contains point of sun longutide 3*PI/2 (December solstice)
        int i = 1; // We start with the month following lunar month 11
        int arc = INT(getSunLongitude(getNewMoonDay(k+i, timeZone), timeZone)/30);
        do {
            last = arc;
            i++;
            arc = INT(getSunLongitude(getNewMoonDay(k+i, timeZone), timeZone)/30);
        } while (arc != last && i < 14);
        return i-1;
    }
    /**
     *
     * @param dd
     * @param mm
     * @param yy
     * @param timeZone
     * @return array of [lunarDay, lunarMonth, lunarYear, leapOrNot]
     */
    public static int[] convertSolar2Lunar(int dd, int mm, int yy, double timeZone) {
        int lunarDay, lunarMonth, lunarYear, lunarLeap;
        int dayNumber = jdFromDate(dd, mm, yy);
        int k = INT((dayNumber - 2415021.076998695) / 29.530588853);
        int monthStart = getNewMoonDay(k+1, timeZone);
        if (monthStart > dayNumber) {
            monthStart = getNewMoonDay(k, timeZone);
        }
        int a11 = getLunarMonth11(yy, timeZone);
        int b11 = a11;
        if (a11 >= monthStart) {
            lunarYear = yy;
            a11 = getLunarMonth11(yy-1, timeZone);
        } else {
            lunarYear = yy+1;
            b11 = getLunarMonth11(yy+1, timeZone);
        }
        lunarDay = dayNumber-monthStart+1;
        int diff = INT((monthStart - a11)/29);
        lunarLeap = 0;
        lunarMonth = diff + 11;
        if (b11 - a11 > 365) {
            int leapMonthDiff = getLeapMonthOffset(a11, timeZone);
            if (diff >= leapMonthDiff) {
                lunarMonth = diff + 10;
                if (diff == leapMonthDiff) {
                    lunarLeap = 1;
                }
            }
        }
        if (lunarMonth > 12) {
            lunarMonth = lunarMonth - 12;
        }
        if (lunarMonth >= 11 && diff < 4) {
            lunarYear -= 1;
        }
        return new int[]{lunarDay, lunarMonth, lunarYear, lunarLeap};
    }
    public static int[] convertLunar2Solar(int lunarDay, int lunarMonth, int lunarYear, int lunarLeap, double timeZone) {
        int a11, b11;
        if (lunarMonth < 11) {
            a11 = getLunarMonth11(lunarYear-1, timeZone);
            b11 = getLunarMonth11(lunarYear, timeZone);
        } else {
            a11 = getLunarMonth11(lunarYear, timeZone);
            b11 = getLunarMonth11(lunarYear+1, timeZone);
        }
        int k = INT(0.5 + (a11 - 2415021.076998695) / 29.530588853);
        int off = lunarMonth - 11;
        if (off < 0) {
            off += 12;
        }
        if (b11 - a11 > 365) {
            int leapOff = getLeapMonthOffset(a11, timeZone);
            int leapMonth = leapOff - 2;
            if (leapMonth < 0) {
                leapMonth += 12;
            }
            if (lunarLeap != 0 && lunarMonth != leapMonth) {
                System.out.println("Invalid input!");
                return new int[]{0, 0, 0};
            } else if (lunarLeap != 0 || off >= leapOff) {
                off += 1;
            }
        }
        int monthStart = getNewMoonDay(k+off, timeZone);
        return jdToDate(monthStart+lunarDay-1);
    }
}
