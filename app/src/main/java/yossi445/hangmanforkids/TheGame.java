package yossi445.hangmanforkids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class TheGame extends AppCompatActivity implements View.OnClickListener {

    Button[] btns = new Button[23] ;
    TextView tvCategory, tvGuess;
    String word = "יפתח מרסיאנו";
    String guess;
    int errors = 0;
    ImageButton ibHelp1,ibHelp2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_game);


        tvCategory = findViewById(R.id.tvCategory);
        tvGuess = findViewById(R.id.tvGuess);
        ibHelp1 = findViewById(R.id.ibHelp1);
        ibHelp2 = findViewById(R.id.ibHelp2);



        btns[1] = findViewById(R.id.btn1);
        btns[2] = findViewById(R.id.btn2);
        btns[3] = findViewById(R.id.btn3);
        btns[4] = findViewById(R.id.btn4);
        btns[5] = findViewById(R.id.btn5);
        btns[6] = findViewById(R.id.btn6);
        btns[7] = findViewById(R.id.btn7);
        btns[8] = findViewById(R.id.btn8);
        btns[9] = findViewById(R.id.btn9);
        btns[10] = findViewById(R.id.btn10);
        btns[11] = findViewById(R.id.btn11);
        btns[12] = findViewById(R.id.btn12);
        btns[13] = findViewById(R.id.btn13);
        btns[14] = findViewById(R.id.btn14);
        btns[15] = findViewById(R.id.btn15);
        btns[16] = findViewById(R.id.btn16);
        btns[17] = findViewById(R.id.btn17);
        btns[18] = findViewById(R.id.btn18);
        btns[19] = findViewById(R.id.btn19);
        btns[20] = findViewById(R.id.btn20);
        btns[21] = findViewById(R.id.btn21);
        btns[22] = findViewById(R.id.btn22);

        for (int i = 1; i < 23; i++) {
            btns[i].setOnClickListener(this);

        }

        generateGuess();

    }



    private void generateGuess() {

        guess = "";
        int len = word.length();

        for (int i = 0; i < len; i++) {

            if(word.charAt(i) == ' ')
                guess += " ";
            else
                guess += '*';
        }


        tvGuess.setText(guess);


    }


    @Override
    public void onClick(View v) {


        Button btn = (Button)v;
        String letter = btn.getText().toString();
        char c = letter.charAt(0);


        if(word.contains(letter))
        {
            reveaLetter(c);
            tvGuess.setText(guess);
        }

        btn.setVisibility(View.INVISIBLE);

    }

    public void help1(View v) {//reveal 1 letter


        Random rand = new Random();

        int n = rand.nextInt(word.length()-1) + 0;
        char c = word.charAt(n);

        while (c == ' ' || c == '*')
        {
             n = rand.nextInt(word.length()-1) + 0;
             c = word.charAt(n);
        }
        //String letter = String.valueOf(word.charAt(n)) ;

        reveaLetter(c);
        tvGuess.setText(guess);

        //Invisible the letter button
        for (int i = 1; i < btns.length; i++) {

            if(btns[i].getText().charAt(0) == c)
                btns[i].setVisibility(View.INVISIBLE);

        }

    }

    public void reveaLetter(char c)
    {
        String prevGuess = guess;
        guess = "";

        for (int i = 0; i < word.length(); i++) {


            if(word.charAt(i) == c)
                guess += String.valueOf(word.charAt(i));
            else if(prevGuess.charAt(i) != '*' && prevGuess.charAt(i) != ' ' )
                guess += String.valueOf(word.charAt(i));
            else
                guess += String.valueOf(prevGuess.charAt(i));
        }
    }
}
