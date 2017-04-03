package fcannizzaro.oshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fcannizzaro.oshare.Oshare;
import com.fcannizzaro.oshare.annotations.Callback;
import com.fcannizzaro.oshare.annotations.Share;
import com.fcannizzaro.oshare.interfaces.ReadyListener;
import com.fcannizzaro.oshare.util.Shared;

public class MainActivity extends AppCompatActivity implements ReadyListener {

    @Share
    private void alert(String str) {
        System.out.println("Alert: " + str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // register shared methods
        Shared.register(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // connect and run
        Oshare.init("http://192.168.1.100:3000", Remote.class, this);

    }

    @Override
    public void onReady() {
        System.out.println("// ---- Print values ---- //");
        System.out.println(Remote.obj.node);
        System.out.println(Remote.obj.number);
        System.out.println(Remote.obj.flag);
        System.out.println("// ---------------------- //");
    }

    @Callback
    void apiRun(String value, Integer number) {
        System.out.println(String.format("Callback \"%s\" after %d ms!", value, number));
    }

    @Override
    public void onConnected() {
        System.out.println("sdflkisj");
        Remote.api.run(Oshare.Cb(this));
    }

}
