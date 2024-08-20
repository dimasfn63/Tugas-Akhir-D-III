SPLASHSCREEN.XML

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".login"
    android:id="@+id/splash_screen">

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scaleType="fitXY"
        android:src="@drawable/desain2" />



    <ProgressBar
        android:id="@+id/progresBar1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="80dp"/>

</RelativeLayout>

SPLASHSCREEN.Java

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;


public class splashsSceen extends AppCompatActivity {
    TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splashs);




        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), login.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }
}

LOGIN.xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.NestedScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_height="match_parent"
    tools:context=".login">

    <android.support.v7.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:orientation="vertical">


        <android.support.v7.widget.AppCompatTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Kost Modern"
            android:textSize="38sp"
            android:textColor="#ffffff"
            android:layout_gravity="center_horizontal"/>

        <android.support.design.widget.TextInputLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp">

            <android.support.design.widget.TextInputEditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:layout_marginStart="10dp"
                android:layout_marginEnd="10dp"
                android:id="@+id/username"
                android:hint="Username"/>

        </android.support.design.widget.TextInputLayout>

        <android.support.design.widget.TextInputLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:passwordToggleEnabled="true"
            android:layout_marginTop="5dp">

            <android.support.design.widget.TextInputEditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:inputType="textPassword"
                android:layout_gravity="center_horizontal"
                android:layout_marginStart="10dp"
                android:layout_marginEnd="10dp"
                android:id="@+id/password"
                android:hint="Password"/>

        </android.support.design.widget.TextInputLayout>

        <android.support.v7.widget.AppCompatButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:layout_gravity="center_horizontal"
            android:background="#acbcd6"
            android:id="@+id/lgn"
            android:text="LOGIN" />

    </android.support.v7.widget.LinearLayoutCompat>

</android.support.v4.widget.NestedScrollView>

LOGIN.java

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText us, pw;
    Button lgn;
    String nama = "kos";
    String kode = "123";
    Toast toast1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        us = (EditText) (findViewById(R.id.username));
        pw = (EditText) (findViewById(R.id.password));
        lgn =  (findViewById(R.id.lgn));

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = us.getText().toString();
                String b = pw.getText().toString();
                if(a.equals(nama) && b.equals(kode)) {
                    if(toast1!=null) {
                        toast1.cancel();
                    }
                    toast1 = Toast.makeText(getApplicationContext(), "Sukses!!", Toast.LENGTH_SHORT);
                    toast1.show();
                    Intent intent = new Intent(login.this, koneksi.class);
                    login.this.startActivity(intent);
                }
                else if(!a.equals(nama) && b.equals(kode)){
                    if(toast1!=null) {
                        toast1.cancel();
                    }
                    toast1 = Toast.makeText(getApplicationContext(), "Username Salah", Toast.LENGTH_SHORT);
                    toast1.show();
                }
                else if(a.equals(nama) && !b.equals(kode)) {
                    if(toast1!=null) {
                        toast1.cancel();
                    }
                    toast1 = Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT);
                    toast1.show();
                }
                else{
                    if(toast1!=null) {
                        toast1.cancel();
                    }
                    toast1 = Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });

    }
/**
    private void lg(View view){
        Intent intent = new Intent(login.this, MainActivity.class);
    }

    public void setLgn(Button lgn) {
        this.lgn = lgn;
        public void onClick(View view){
        Toast.makeText(getApplicationContext(), "Menghidupkan Bluetooth",
                Toast.LENGTH_SHORT).show();
    }**/
}

KONEKSI.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".koneksi">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Kost Modern"
        android:textSize="38sp"
        android:textColor="#ffffff"
        android:layout_marginTop="10dp"
        android:layout_gravity="center_horizontal"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5sp"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnTurn"
            android:background="#acbcd6"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:layout_marginStart="10dp"
            android:layout_marginEnd="10dp"
            android:layout_marginBottom="5dp"
            android:onClick="on"
            android:layout_weight="1" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="5sp"
        android:weightSum="2"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnScan"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:onClick="list1"
            android:layout_marginStart="10dp"
            android:layout_marginEnd="5dp"
            android:background="#acbcd6"
            android:text="paired device" />

        <Button
            android:id="@+id/btnScan2"
            android:layout_marginStart="5dp"
            android:layout_marginEnd="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="list2"
            android:layout_weight="1"
            android:background="#acbcd6"
            android:text="new device"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/txt1"
            android:layout_marginTop="20dp"
            android:layout_marginLeft="10dp"
            android:textColor="#ffffff"
            android:textSize="18sp" />

        <ListView
            android:id="@+id/listView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            />
    </LinearLayout>

</LinearLayout>

KONEKSI.java

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

public class koneksi extends AppCompatActivity {
    Button btns, btnt, btns2;
    TextView txt1;
    Toast toast1;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lst;
    private int Bluetooth = 1;
    private ArrayList<String> mDeviceList = new ArrayList<String>();
    private ArrayList<BluetoothDevice> mDevices = new ArrayList<>();
    public static String EXTRA_ADDRESS = "device_address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koneksi);

        btnt = (Button) findViewById(R.id.btnTurn);
        btns = (Button) findViewById(R.id.btnScan);
        btns2 = (Button) findViewById(R.id.btnScan2);
        BA = (BluetoothAdapter.getDefaultAdapter());
        lst = (ListView) findViewById(R.id.listView);
        txt1 = (TextView) findViewById(R.id.txt1);

        if (BA == null){
            if(toast1!=null) {
                toast1.cancel();
            }
            toast1 = Toast.makeText(getApplicationContext(),"Tidak Support Bluetooth", Toast.LENGTH_SHORT );
            toast1.show();
            finish();
        }

        if(!BA.isEnabled()){
            btnt.setText("Turn ON");
        }
        else if(BA.isEnabled()){
            btnt.setText("Turn OFF");
        }
    }

    public void on(View view) {
        if (!BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            if(toast1!=null) {
                toast1.cancel();
            }
            toast1 = Toast.makeText(getApplicationContext(), "Menghidupkan Bluetooth", Toast.LENGTH_SHORT);
            toast1.show();
            btnt.setText("Turn OFF");
        }
        else if (BA.isEnabled()){
            BA.disable();
            if(toast1!=null) {
                toast1.cancel();
            }
            toast1 = Toast.makeText(getApplicationContext(), "Mematikan Bluetooth", Toast.LENGTH_SHORT);
            toast1.show();
            btnt.setText("Turn ON");
        }
    }

    public void list1 (View view){
        pairedDevices = BA.getBondedDevices();
        ArrayList list = new ArrayList();
        if (pairedDevices.size()>0)
        {
            for(BluetoothDevice bt : pairedDevices)
            {
                list.add(bt.getName() + "\n" + bt.getAddress()); //Get the device's name and the address
                txt1.setText("Perangkat Tersanding : ");
                if(toast1!=null) {
                    toast1.cancel();
                }
                toast1 = Toast.makeText(getApplicationContext(),"Menampilkan Perangkat Tersanding",Toast.LENGTH_SHORT);
                toast1.show();
            }
        }
        else
        {
            if(toast1!=null) {
                toast1.cancel();
            }
            toast1 = Toast.makeText(getApplicationContext(), "Hidupkan Bluetooth Terlebih Dahulu", Toast.LENGTH_SHORT);
            toast1.show();
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(myListClickListener); //Method called when the device from the list is clicked
        /**
        if(BA.isEnabled()) {
            pairedDevices = BA.getBondedDevices();
            {
                ArrayList list = new ArrayList();
                for (BluetoothDevice bt : pairedDevices)
                    list.add(bt.getName());
                Toast.makeText(getApplicationContext(), "Menampilkan perangkat bluetooth",
                        Toast.LENGTH_SHORT).show();

                final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
                lst.setAdapter(adapter);
            }
        }
        else if(!BA.isEnabled()){
            Toast.makeText(getApplicationContext(), "Hidupkan Bluetooth Terlebih Dahulu",
                    Toast.LENGTH_SHORT).show();
        }**/
    }

    public void list2 (View view){
        if (BA.isEnabled()){
            txt1.setText("Perangkat Baru : ");
            if(toast1!=null) {
                toast1.cancel();
            }
            toast1 = Toast.makeText(getApplicationContext(), "Mencari Perangkat di Sekitar...", Toast.LENGTH_SHORT);
            toast1.show();
            BA.startDiscovery();
            IntentFilter intentFilter= new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mReceiver,intentFilter);
        }
        else {
            if(toast1!=null) {
                toast1.cancel();
            }
            toast1 = Toast.makeText(getApplicationContext(), "Hidupkan Bluetooth Terlebih Dahulu", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

    /**@Override
    public void onDestroy() {
    unregisterReceiver(mReceiver);
    super.onDestroy();
    }**/

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, final Intent intent) {
            final BluetoothDevice device = intent
                    .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Add the recently discovered device in a list
                mDevices.add(bluetoothDevice);
                mDeviceList.add(bluetoothDevice.getName() + "\n"
                        + bluetoothDevice.getAddress());
                lst.setAdapter(new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, mDeviceList));
            }
            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapter, View view, int pos, long id){
                    String devicep=lst.getAdapter().getItem(pos).toString();
                    Log.i("device",devicep);
                    // Get the BluetoothDevice corresponding to the clicked item
                    pairDevice(mDevices.get(pos));
                }
            });
        }
    };

    private void pairDevice(BluetoothDevice b1) {
        try {
            Method method = b1.getClass().getMethod("createBond", (Class[]) null);
            method.invoke(b1, (Object[]) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AdapterView.OnItemClickListener myListClickListener = new AdapterView.OnItemClickListener()
    {
        public void onItemClick (AdapterView<?> av, View v, int arg2, long arg3)
        {
            // Get the device MAC address, the last 17 chars in the View
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);

            // Make an intent to start next activity.
            Intent i = new Intent(koneksi.this, coba.class);

            //Change the activity.
            i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
            startActivity(i);
        }
    };
}


KONTROL.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="20dp"
    tools:context=".coba">


    <TextView
        android:id="@+id/receive_text"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:freezesText="true"
        android:gravity="bottom"
        android:scrollbars="vertical"
        android:textAppearance="@style/TextAppearance.AppCompat.Medium" />

    <View
        android:layout_width="match_parent"
        android:background="?android:attr/listDivider"
        android:layout_height="2dp" />

    <LinearLayout
        android:padding="20dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:layout_margin="5dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Rp."
            android:textSize="20sp"/>

        <EditText
            android:id="@+id/data"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:hint="0"
            android:textSize="20sp" />

        <TextView
            android:layout_margin="5dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="000"
            android:textSize="20sp"/>

        <TextView
            android:layout_margin="5dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="="
            android:textSize="20sp"/>

        <TextView
            android:id="@+id/data_konv"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="5dp"
            android:text="Hasil Konversi"
            android:textSize="20sp" />

        <TextView
            android:layout_margin="5dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="W/s"
            android:textSize="10sp"/>
    </LinearLayout>


    <Button
        android:id="@+id/hrg"
        android:layout_width="270dp"
        android:layout_height="37dp"
        android:layout_marginTop="10dp"
        android:background="#FF8C00"
        android:text="Cek Harga"
        android:textColor="#FFFFFF"
        android:textSize="20sp" />

    <Button
        android:id="@+id/krm"
        android:layout_width="270dp"
        android:layout_height="37dp"
        android:layout_marginTop="10dp"
        android:background="#FF00FF00"
        android:text="Kirim Kwh"
        android:textColor="#FFFFFF"
        android:textSize="20sp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="120dp">
    <Button
        android:id="@+id/dsc"
        android:layout_width="170dp"
        android:layout_height="37dp"
        android:layout_gravity="bottom"
        android:layout_marginTop="10dp"
        android:background="#FF8C00"
        android:text="disconect"
        android:textColor="#FFFFFF"
        android:textSize="20sp" />

        <Button
            android:id="@+id/rest"
            android:layout_width="170dp"
            android:layout_height="37dp"
            android:layout_gravity="bottom"
            android:layout_marginTop="10dp"
            android:background="#DC43"
            android:text="RESET"
            android:textColor="#FFFFFF"
            android:textSize="20sp" />

    </LinearLayout>

</LinearLayout>

KONTROL.java

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class coba extends AppCompatActivity {

    EditText data;
    Button kirim, harga, dsc, reset;
    TextView data_konv;

    Toast toast1;
    String address = null;
    Vibrator vibe;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    //SPP UUID. Look for it
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        Intent newint = getIntent();
        address = newint.getStringExtra(koneksi.EXTRA_ADDRESS); //receive the address of the bluetooth device

        new ConnectBT().execute(); //Call the class to connect

        data = (EditText) findViewById(R.id.data);
        harga = (Button) findViewById(R.id.hrg);
        kirim = (Button) findViewById(R.id.krm);
        dsc = (Button) findViewById(R.id.dsc);
        reset = (Button) findViewById(R.id.rest);
        data_konv = (TextView) findViewById(R.id.data_konv);

        harga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datanya = data.getText().toString();
                int value= Integer.parseInt(datanya);
                int dataKirim = value * 3600000;
                String a = String.valueOf(dataKirim);
                data_konv.setText(a);
            }
        });

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datanya = data.getText().toString();
                int value= Integer.parseInt(datanya);
                int dataKirim = value * 3600000;
                String a = String.valueOf(dataKirim);
                data_konv.setText(a);
                if (btSocket!=null)
                {
                    try
                    {
                        if(toast1!=null) {
                            toast1.cancel();
                        }
                        toast1 = Toast.makeText(getApplicationContext(),"Data Berhasil dikirim. datanya : "+datanya,Toast.LENGTH_SHORT);
                        toast1.show();
                        btSocket.getOutputStream().write("1,admin,admin,".getBytes());
                        btSocket.getOutputStream().write(a.getBytes());
                        btSocket.getOutputStream().write("\n".getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btSocket!=null)
                {
                    try
                    {
                        if(toast1!=null) {
                            toast1.cancel();
                        }
                        toast1 = Toast.makeText(getApplicationContext(),"Menghapus data",Toast.LENGTH_SHORT);
                        toast1.show();
                        btSocket.getOutputStream().write("3,admin,admin,".getBytes());
                        btSocket.getOutputStream().write("\n".getBytes());
                    }
                    catch (IOException e)
                    {
                        msg("Error");
                    }
                }
            }
        });

        dsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disconnect();
            }
        });
    }

    private void Disconnect()
    {
        if (btSocket!=null) //If the btSocket is busy
        {
            try
            {
                btSocket.close(); //close connection
            }
            catch (IOException e)
            { msg("Error");}
        }
        finish(); //return to the first layout

    }

    // fast way to call Toast
    private void msg(String s)
    {
        if(toast1!=null) {
            toast1.cancel();
        }
        toast1 = Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG);
        toast1.show();
    }


    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(coba.this, "Menghubungkan...", "Tunggu!!!");  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();//start connection
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Koneksi Gagal. Coba Lagi");
                finish();
            }
            else
            {
                msg("Terhubung.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }
}
