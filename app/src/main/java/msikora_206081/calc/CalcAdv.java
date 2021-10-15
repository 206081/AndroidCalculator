package msikora_206081.calc;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcAdv extends AppCompatActivity {

    private EditText display;
    private EditText syntax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_calc);

        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);

        if (!DataHolder.isEmpty()) {
            display.setText(DataHolder.getData());
            display.setSelection(DataHolder.getPosition());
        }

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
        syntax = findViewById(R.id.syntax);
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cPos);
        String rightStr = oldStr.substring(cPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));

        }
        int newPosition = cPos + strToAdd.length();
        display.setSelection(newPosition);
        DataHolder.setData(display.getText().toString());
        DataHolder.setPosition(newPosition);

    }

    public void zeroButton(View view) {
        updateText("0");
    }

    public void oneButton(View view) {
        updateText("1");

    }

    public void twoButton(View view) {
        updateText("2");

    }


    public void threeButton(View view) {
        updateText("3");

    }

    public void fourButton(View view) {
        updateText("4");

    }

    public void fiveButton(View view) {
        updateText("5");

    }

    public void sixButton(View view) {
        updateText("6");

    }

    public void sevenButton(View view) {
        updateText("7");

    }

    public void eightButton(View view) {
        updateText("8");

    }

    public void nineButton(View view) {
        updateText("9");

    }

    public void addButton(View view) {
        updateText("+");

    }

    public void subtractButton(View view) {
        updateText("-");

    }

    public void multiplyButton(View view) {
        updateText("×");

    }

    public void divideButton(View view) {
        updateText("÷");

    }

    public void parenthesesStartButton(View view) {
        updateText("(");

    }

    public void parenthesesEndButton(View view) {
        updateText(")");

    }

    public void signChangeButton(View view) {
        updateText("-");

    }


    public void clearClearEnterButton(View view) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cPos = display.getSelectionStart();
                int textLen = display.getText().length();
                if (cPos != 0 && textLen != 0) {
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(cPos - 1, cPos, "");
                    display.setText(selection);
                    int newPosition = cPos - 1;
                    display.setSelection(newPosition);
                    DataHolder.setData(display.getText().toString());
                    DataHolder.setPosition(newPosition);


                }
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                display.setText("");
                DataHolder.setData(display.getText().toString());
                return true;
            }
        });
    }

    public void clearAllButton(View view) {
        display.setText("");
        DataHolder.setData(display.getText().toString());

    }


    public void pointButton(View view) {
        updateText(".");

    }

    public void equalsButton(View view) {
        String inputExpression = display.getText().toString();
        inputExpression = inputExpression.replaceAll("÷", "/");
        inputExpression = inputExpression.replaceAll("×", "*");

        Pattern zeroDivision = Pattern.compile(".*\\/0([^.]|$|\\.(0{4,}.*|0{1,4}([^0-9]|$))).*");
        Matcher matcher = zeroDivision.matcher(inputExpression);

        boolean dividedByZero = false;
        if (matcher.find()) {
            dividedByZero = true;
        }

        Expression expression = new Expression(inputExpression);
        String result = String.valueOf(expression.calculate());

        if (dividedByZero) {
            Toast.makeText(getApplicationContext(), "Cannot divide by ZERO", Toast.LENGTH_SHORT).show();

        } else if (result.equals("NaN")) {
            Toast.makeText(getApplicationContext(), "Something went wrong. Fix your expression", Toast.LENGTH_SHORT).show();

        } else {
            display.setText(result);
            display.setSelection(result.length());
            DataHolder.setData(display.getText().toString());
            DataHolder.setPosition(result.length());
        }
//        syntax.setText(expression.getExpressionString() + result);
    }


    public void sinButton(View view) {
        updateText("sin(");

    }

    public void cosButton(View view) {
        updateText("cos(");

    }

    public void tanButton(View view) {
        updateText("tan(");

    }

    public void logNatButton(View view) {
        updateText("ln(");

    }

    public void logButton(View view) {
        updateText("log(");

    }

    public void percentButton(View view) {
        updateText("%");

    }

    public void sqrtButton(View view) {
        updateText("sqrt(");

    }

    public void powTwoButton(View view) {
        updateText("^2");

    }

    public void powButton(View view) {
        updateText("^");

    }

}