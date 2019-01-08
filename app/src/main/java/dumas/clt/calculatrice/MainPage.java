package dumas.clt.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button number0 = (Button) findViewById(R.id.number0);
        Button number1 = findViewById(R.id.number1);
        Button number2 = findViewById(R.id.number2);
        Button number3 = findViewById(R.id.number3);
        Button number4 = findViewById(R.id.number4);
        Button number5 = findViewById(R.id.number5);
        Button number6 = findViewById(R.id.number6);
        Button number7 = findViewById(R.id.number7);
        Button number8 = findViewById(R.id.number8);
        Button number9 = findViewById(R.id.number9);
        final TextView input = (TextView) findViewById(R.id.inputNumber);

    }

    protected void inputNumber(Button button) {

    }

    @Override
    public void onClick(View v) {
        TextView input = (TextView) findViewById(R.id.inputNumber);
        Button b = (Button) v;
        CharSequence text = b.getText();

        if (v.getTag() == null) {
            Toast.makeText(this, "Oops je sais pas", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (v.getTag().toString()) {
            case "OP":
                Toast.makeText(this, "Opération", Toast.LENGTH_SHORT).show();
                break;

            case "NB":
                input.append(b.getText());
                break;

            default:
                Toast.makeText(this, "Oops je sais pas", Toast.LENGTH_SHORT).show();
                break;
        }

        switch (b.getText().toString()) {
            case "←":
                String currentString = input.getText().toString();
                if (currentString != null && currentString.length() > 0) {
                    currentString = currentString.substring(0, currentString.length() - 1);
                }
                input.setText(currentString);
                break;

            case "C":
                input.setText("");
                break;
        }

    }
}
