package com.example.probabilitycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graphView = findViewById(R.id.idGraphView);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(2, 0.25),
                new DataPoint(3, 0.5),
                new DataPoint(4, 0.75),
                new DataPoint(5, 1.0),
                new DataPoint(6, 1.25),
                new DataPoint(7, 1.5),
                new DataPoint(8, 1.75),
                new DataPoint(9, 2.0),
                new DataPoint(10,2.25)
        });
        graphView.setTitle("Probability Graph");
        graphView.setTitleColor(R.color.purple_200);
        graphView.setTitleTextSize(18);
        graphView.addSeries(series);

        Button runprobforsettarget = findViewById(R.id.prob_button);
        runprobforsettarget.setOnClickListener(v -> {
            runProbForSetTarget();
        });

        Button runprobforallpossibilities = findViewById(R.id.prob_button_all);
        runprobforallpossibilities.setOnClickListener(v -> {
            runProbForAllPossibleOutcomes();
        });

        Button runprobfortwosettargets = findViewById(R.id.prob_1617);
        runprobfortwosettargets.setOnClickListener(v -> {
            runProbForTwoSetNo();
        });

        Button submitNo = findViewById(R.id.submitNo);
        submitNo.setOnClickListener(v -> {
            EditText No1 = findViewById(R.id.no_1);
            EditText No2 = findViewById(R.id.no_2);
            String UserInput1 = String.valueOf(No1.getText());
            int UserNo1 = Integer.parseInt(UserInput1);
            String UserInput2 = String.valueOf(No2.getText());
            int UserNo2 = Integer.parseInt(UserInput2);
            runProbForTwoUserGenNum(UserNo1, UserNo2);
        });
    }

    public void runProbForSetTarget()
    {
        ArrayList<Integer> diceNo = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            diceNo.add(i);
        }

        int target = 16;

        int rollstotarget = 0;
        for(int i = 1; i <=diceNo.size(); i++)
        {
            for(int j = 1; j <=diceNo.size(); j++)
            {
                if(i + j == target)
                {
                    rollstotarget++;
                }
            }
        }

        double probability = (double) rollstotarget / (diceNo.size() * diceNo.size());

        DecimalFormat df = new DecimalFormat("#.##");
        Toast toast = Toast.makeText(this, "The Probability of rolling a " + target + " on two d" + diceNo.size() + " is " + probability + " or " + probability * 100 + "%", Toast.LENGTH_LONG);
        toast.show();
    }

    public void runProbForAllPossibleOutcomes()
    {
        ArrayList<Integer> diceNo = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            diceNo.add(i);
        }

        int target;
        DecimalFormat df = new DecimalFormat("#.##");
        for(target = 2; target <= 40; target++)
        {
            int rollstotarget = 0;
            for(int i = 1; i <= diceNo.size(); i++)
            {
                for(int j = 1; j <= diceNo.size(); j++)
                {
                    if(i + j == target)
                    {
                        rollstotarget++;
                    }
                }
            }
            double probability = (double) rollstotarget / (diceNo.size() * diceNo.size());
            System.out.println("The probability of rolling a total of " + target + " on two " + diceNo.size() + " sided dice is: " + probability + " or " + probability * 100 + "%");
        }
    }

    public void runProbForTwoSetNo()
    {
        ArrayList<Integer> diceNo = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            diceNo.add(i);
        }

        int target1 = 16;
        int target2 = 17;

        int rollstotarget = 0;
        for(int i = 1; i <=diceNo.size(); i++)
        {
            for(int j = 1; j <=diceNo.size(); j++)
            {
                if(i + j == target1)
                {
                    rollstotarget++;
                }
                else if(i + j == target2)
                {
                    rollstotarget++;
                }
            }
        }

        double probability = (double) rollstotarget / (diceNo.size() * diceNo.size());

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("The probability of rolling either a " + target1 + " or " + target2 + " on two " + diceNo.size() + " sided dice is: " + probability + " or " + probability * 100 + "%");
    }

    public void runProbForTwoUserGenNum(Integer No1, Integer No2)
    {
        ArrayList<Integer> diceNo = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            diceNo.add(i);
        }

        int target1 = No1;
        int target2 = No2;

        int rollstotarget = 0;
        for(int i = 1; i <=diceNo.size(); i++)
        {
            for(int j = 1; j <=diceNo.size(); j++)
            {
                if(i + j == target1)
                {
                    rollstotarget++;
                }
                else if(i + j == target2)
                {
                    rollstotarget++;
                }
            }
        }

        double probability = (double) rollstotarget / (diceNo.size() * diceNo.size());

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("The probability of rolling either a " + target1 + " or " + target2 + " on two " + diceNo.size() + " sided dice is: " + probability + " or " + probability * 100 + "%");
    }

}

