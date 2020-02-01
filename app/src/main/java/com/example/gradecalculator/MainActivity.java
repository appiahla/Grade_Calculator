package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private final double indivAssign = 0.20, teamProject = 0.30, midtermExam = 0.30, finalExam = 0.20;
    private final DecimalFormat FORMAT = new DecimalFormat("#.#");
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.textViewResult);

    }

    public void handleClick(View view) {
        EditText assignEarned = findViewById(R.id.editAssignmentEarned);
        EditText assignPoss = findViewById(R.id.editAssignmentPossible);
        EditText projEarned = findViewById(R.id.editProjectEarned);
        EditText projPoss = findViewById(R.id.editProjectPossible);
        EditText midPoss = findViewById(R.id.editExamPossible);
        EditText midEarned = findViewById(R.id.editExamEarned);
        EditText finalEarned = findViewById(R.id.editFinalEarned);
        EditText finalPoss = findViewById(R.id.editFinalPossible);

        double assign = 0, project = 0, midterm = 0, fin = 0;

        assign = Double.parseDouble(assignEarned.getText().toString())
                    / Double.parseDouble(assignPoss.getText().toString());
        project = Double.parseDouble(projEarned.getText().toString())
                    / Double.parseDouble(projPoss.getText().toString());
        midterm = Double.parseDouble(midEarned.getText().toString())
                    / Double.parseDouble(midPoss.getText().toString());
        fin = Double.parseDouble(finalEarned.getText().toString())
                    / Double.parseDouble(finalPoss.getText().toString());

        double assignWeight = assign * indivAssign;
        double projectWeight = project * teamProject;
        double midWeight = midterm * midtermExam;
        double finalWeight = fin * finalExam;

        double total = (assignWeight + projectWeight + midWeight + finalWeight) * 100;

        String grade;
        if (total < 60.00)
            grade = "F";
        else if (total >= 60.00 && total < 70.00)
            grade = "D";
        else if (total >= 70.00 && total < 80.00)
            grade = "C";
        else if (total >= 80.00 && total < 90.00)
            grade = "B";
        else
            grade = "A";

        String result = "Your course grade calculates to " + FORMAT.format(total) + "% " + grade;
        output.setText(result);

    }
}
