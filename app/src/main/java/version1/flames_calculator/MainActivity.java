package version1.flames_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
class Flames {
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    private String fname;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    private String sname;
        public Flames() { }
        public final String getuniqueletters( String fname,String sname) {
        ArrayList<Character> editablefname = new ArrayList<>();
        ArrayList<Character> editablesname = new ArrayList<>();
        //to make mutablenames
        for (int i = 0; i < fname.length(); i++) {
            editablefname.add(fname.charAt(i)); }
        for (int i = 0; i < sname.length(); i++) {
            editablesname.add(sname.charAt(i)); }
        for (int i = 0; i < editablefname.size(); i++) {
            for (int i1 = 0; i1 < editablesname.size(); i1++) {
                if (editablefname.get(i).equals(editablesname.get(i1))) {
                    editablefname.remove(i);
                    editablesname.remove(i1);
                }
            }
        }
        int finalsize = count(editablefname, editablesname);//to get final names count+ stringbuilder to string
        String s = finallogictofindflames(finalsize);
        return s;}
    public int count(ArrayList<Character> x, ArrayList<Character> y) {//method to find lenghth of name after removing duplicate letters
        int i = x.size()
                +y.size();
        return i; }
    public String finallogictofindflames(int finalsize) {
        StringBuilder flames = new StringBuilder("FLAMES");
        int amd = 6;
        while (amd > 1){
            for (int i = 0; i < amd; i++) {
                amd = flames.toString().length();
                if (flames.toString().length() > 1) {
                    flames.deleteCharAt(((i + finalsize - 1) % amd)); }
            } }
            if (flames.charAt(0) == 'F'){
                return "FRIENDS";
//                + flames + " " + flames.length()+"+"+finalsize
            } else if (flames.charAt(0) == 'L') {
                return "LOVE";
            } else if (flames.charAt(0) == 'A') {
                return "ATTRACTION ";
            }else if (flames.charAt(0) == 'M') {
                return "MARRIAGE"; }
            else if (flames.charAt(0) == 'E') {
                return "ENEMY" ;}
            else if (flames.charAt(0) == 'S') {
                return "SIBLINGS"; }
            else {
                return "error"; }
    }
}

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button onclick;
        onclick = (Button) findViewById(R.id.onclick);
        onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name1;//to create instance in java code using constructor
                EditText name2;

                final TextView output;
                name1 = (EditText) findViewById(R.id.name2);
                name2 = (EditText) findViewById(R.id.name3);

                output=(TextView)findViewById(R.id.output);
                final Flames flames = new Flames();
                String st1=name1.getText().toString();
                String st2=name2.getText().toString();
                flames.setFname(st1);
                flames.setSname(st2);
               String ANS = flames.getuniqueletters(flames.getFname(), flames.getSname());
                output.setText(ANS);
            }
        });
    }
}