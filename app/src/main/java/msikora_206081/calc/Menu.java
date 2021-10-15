package msikora_206081.calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }


    public void moveToSimpleCalc(View view) {
        Intent intent = new Intent(getBaseContext(), Calc.class);
        startActivity(intent);
    }

    public void moveToAdvanceCacl(View view) {
        Intent intent = new Intent(getBaseContext(), CalcAdv.class);
        startActivity(intent);
    }

    public void moveToAbout(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void moveToExit(View view) {
        finishAndRemoveTask();
    }
}
