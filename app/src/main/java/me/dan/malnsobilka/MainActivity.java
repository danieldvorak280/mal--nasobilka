package me.dan.malnsobilka;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.zadaniView) TextView taskOutput;
    @BindView(R.id.vyhodnoceniView) TextView resultOutput;
    @BindView (R.id.pocetPrikladuView) TextView exampleCountOutput;
    @BindView (R.id.vstupEditText) EditText taskInput;
    @BindView (R.id.kliknutiButton) Button clickButton;

    Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        exampleCountOutput.setText("1. příklad z 10");
        taskInput.setText("");
        taskOutput.setText(model.n1 + " x " + model.n2 + " = ");
        resultOutput.setText("");
    }

        @OnClick (R.id.kliknutiButton)
        public void click (View view) {
            finalOutput();
            model.exampleCount++;
            exampleCountOutput.setText(model.exampleCount + ". příklad z 10");
            if (model.exampleCount == 11) {
                exampleCountOutput.setText("10. příklad z 10");
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Gratuluji");
                dialog.setMessage("Správně: " + model.rightAnswers + "\nŠpatně: " + model.wrongAnswers + "\nChcete pokračovat?");
                dialog.setPositiveButton("Ano", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        model.setNewValues();
                        model.exampleCount = 1;
                        model.rightAnswers = 0;
                        model.wrongAnswers = 0;
                        exampleCountOutput.setText("1. příklad z 10");
                        resultOutput.setText("");
                        taskInput.setText(null);
                        taskOutput.setText(model.n1 + " x " + model.n2 + " = ");

                    }
                });
                dialog.setNegativeButton("Ne", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(1);
                    }
                });
                dialog.show();
            }
        }


    private void rightAnswersOutput() {
        resultOutput.setText("Správně máte: " + Integer.toString(model.result));
        model.rightAnswers++;
        model.setNewValues();
        taskOutput.setText(model.n1 + " x " + model.n2 + " = ");
        taskInput.setText(null);
    }

    private void wrongAnswersOutput() {
        resultOutput.setText("Špatně, správně je: " + Integer.toString(model.result));
        model.wrongAnswers++;
        model.setNewValues();
        taskOutput.setText(model.n1 + " x " + model.n2 + " = ");
        taskInput.setText(null);
    }

    private void finalOutput() {
        {
            try {
                int inputValue = Integer.parseInt(taskInput.getText().toString());
                if (inputValue == model.result) {
                    rightAnswersOutput();
                } else {
                    wrongAnswersOutput();
                }
            }
            catch (NumberFormatException ex) {
                Toast.makeText(getApplicationContext(), "Zadejte číslo",Toast.LENGTH_SHORT).show();
                model.exampleCount--;
            }
            catch (NullPointerException ex) {
                Toast.makeText(getApplicationContext(), "Zadejte číslo", Toast.LENGTH_SHORT).show();
                model.exampleCount--;
            }
        }
    }

}
