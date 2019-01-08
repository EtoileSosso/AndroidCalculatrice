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
    }

    @Override
    public void onClick(View v) {
        TextView input = findViewById(R.id.inputNumber);
        Button b = (Button) v;

        if (v.getTag() == null) {
            Toast.makeText(this, "Oops je sais pas", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (v.getTag().toString()) {
            case "OP":
                operations(b, input);
                break;

            case "NB":
                input.append(b.getText());
                break;

            default:
                Toast.makeText(this, "Oops je sais pas", Toast.LENGTH_SHORT).show();
                break;
        }


    }

    //    CASE CLICK OPERATION
    void operations(Button b, TextView input) {
        switch (b.getText().toString()) {
            case "←":
                String currentString = input.getText().toString();
                if (currentString.length() > 0) {
                    currentString = currentString.substring(0, currentString.length() - 1);
                }
                input.setText(currentString);
                break;

            case "C":
                input.setText("");
                break;

            default:
                String operator = b.getText().toString();
                Toast.makeText(this, operator, Toast.LENGTH_SHORT).show();
                calcul(input, operator);
                break;
        }
    }

    void calcul(TextView input, String operator) {
        TextView stock = findViewById(R.id.stockNumber);
        if(stock.getText()!=null) {
            double stockContent = Double.parseDouble(stock.getText().toString());
        }
        if (input.getText()!=null){
            double inputContent = Double.parseDouble(input.getText().toString());
        }
//        double inputContent = Double.parseDouble(input.getText().toString());

//        switch (operator) {
//            case "+":
//                Toast.makeText(this, "+++", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//        }
//        stock.setText(input.getText());

        input.setText("");
    }


}
