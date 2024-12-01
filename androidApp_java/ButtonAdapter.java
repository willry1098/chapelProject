package com.example.chapelproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.ArrayList;
import java.util.Arrays;

public class ButtonAdapter extends BaseAdapter {


    ArrayList<String> namesList = new ArrayList<String>(
            Arrays.asList("A. Agular", "C. Anyanwu", "T. Aronoff", "P. Boney", "W. Brady", "J. Burns", "J. Burns", "E. Cadet-Guirand", "P. Callahan", "W. Chicos", "M. Christiano", "S. Cineus", "J. Creedon", "C. Dlugosch", "T. Dolan", "T. Egan", "C. Fortes", "A. Gawrelski", "O. Goodband", "H. Greene", "W. Greenhill", "A. Guo", "R. Ho", "J. Hou", "D. Ivester", "M. Jordan", "J. Langham", "R. Li", "M. Liem", "J. Lockwood", "S. McDonnell", "J. Monahan", "J. Nacar", "S. Norden", "H. O'Connell", "J. Palumbo", "Z. Park", "M. Pena", "C. Quandt", "B. Ragosa", "B. Sayers", "S. Scherer", "C. Schuldt", "A. Stanton", "I. Turevskiy", "N. Unger", "S. Vuono", "M. Waugh", "R. Wellington", "M. Williams", "C. Woods", "H. Wylie", "Z. Xu-Sun", "B. Yoo", "D. Bosco", "L. Boyle", "B. Britt-Webb", "D. Carroll", "C. Carson", "R. Chang-Wu", "A. Chen", "L. Clifford", "U. Copeland", "D. Curtin", "J. Daley Demerle", "W. Days", "J. Eikeboom", "N. Fantasia", "G. Figler", "R. Flynn", "W. Fradette", "E. Fritz", "D. Gibbs", "T. Grossman", "M. Huang", "J. Hurley", "Y. Ibrahim", "C. Jacobs", "C. Kaufman", "C. Kelly", "B. Kilpatrick", "H. Lee", "D. Lundquist", "C. Lynch", "J. Lynch", "J. Ma", "L. MacLean", "B. Mazur", "K. Monteiro", "B. Murphy", "P. Nolan", "I. Novod", "L. Nuernberg", "O. Popkowski-Smith", "G. Ramirez", "W. Raymond", "M. Rich", "T. Rivera-Wills", "D. Robinson", "W. Sandor", "A. Savoulides", "P. Schwab", "A. Sousa", "H. Steeves", "W. Trautz", "P. Wall", "D. Woolbert", "I. Yonis", "S. Zavratsky", "J. Zellner", "W. Achtmeyer", "E. Ackerman", "B. Adams", "D. Alpers", "H. Amenhauser", "J. Bartlett", "A. Black", "P. Brice", "W. Broderick", "W. Butler", "N. Butterworth", "G. Calhoun", "J. Cardichon", "M. Carolan", "W. Cashel", "D. Casillo", "R. Castillo", "D. Chen", "J. Chen", "M. Cotter", "J. Coughlin", "F. Courtney", "R. Curtis", "T. Danahy", "L. Davis", "R. Dean", "J. Dragoumanos", "C. Ezeani", "B. Ezedi", "A. Fiorentino", "N. Fiumara", "S. Flood", "E. Fuse", "P. Gianoukos", "N. Gleason", "B. Gong", "M. Hadley", "A. Hanser", "C. Healey", "W. Hennigar", "E. Ho", "J. Hurd", "M. Iandiorio", "M. Ibrahim", "N. Jones", "W. Jones", "C. Kelley", "F. Kilbride", "L. Kuehberger", "K. Largess", "S. Lawrence", "J. Lee", "B. Li", "J. Li", "B. Lindstrom-Chalpin", "R. Little", "J. Lotin", "A. Lyon", "L. Marobella", "L. Marra", "T. Matos", "C. Maws", "A. Mills", "S. Moreau", "C. Nacar", "E. Norden", "J. OBrien", "B. Palladino", "J. Pena", "H. Ramanathan", "J. Ramanathan", "C. Rice", "B. Saeed", "A. Samuel", "J. Santonelli", "T. Smith", "T. Snail", "J. Somani", "N. Sullivan", "J. Tavares", "C. Teeson", "J. Thibodeau", "G. Turco", "G. Vail", "E. Warn", "E. Willi", "P. Woods", "E. Xie", "C. Yoo", "A. Zhang", "N. Zhang", "B. Adams", "S. Agular", "J. Barrett", "B. Boudreau", "L. Calhoun", "G. Carroll", "G. Cohen", "C. Collins", "Y. Constant", "C. Crowley", "A. Cruz", "B. DaCosta", "H. DeWitt", "D. Doherty", "T. Dolan", "H. Dow", "E. Dresser", "J. Duffy", "C. Emmert", "P. Evans", "S. Fabiano", "J. Fernandez del Castillo", "T. Folan", "N. Folker", "E. Friedman", "M. Fritz", "M. Furey", "D. Gannon", "C. Goodband", "H. Hagedorn", "S. Henao", "A. Hildebrandt", "R. Hoffman", "D. Huang", "Y. Ibrahim", "D. Jones", "G. Kaplan", "J. Karande", "S. Karp", "J. Kastner", "J. Keefe", "J. Kilcoyne", "C. Kokora", "E. Lai", "A. Laidlaw", "I. Langham", "E. Lee", "J. Lee", "W. Lindstrom-Chalpin", "D. Luo", "J. Lyon", "T. Masiiwa", "J. Mazur", "C. McEvoy", "R. McKee", "V. Mezzanotte", "E. Noel", "J. Nolan", "L. Nuernberg", "H. Okurowski", "S. Onuoha", "B. Paquette", "N. Pellagrini", "A. Pimental", "R. Pohl", "A. Popkowski-Smith", "M. Ramanathan", "J. Rich", "J. Robinson", "M. Roman", "T. Rupley", "A. Shaff", "K. Sheehan", "T. Sheehan", "C. Sidel", "J. Stonestreet", "M. Sullivan", "J. Summers", "A. Tan", "C. Tarlie", "A. Tosi", "G. Umlas", "W. Umscheid", "L. Verville", "L. Waldeck", "E. Walker", "W. Walton", "A. Waugh", "C. Webb", "D. Woolbert", "W. Zhu", "G. Zug", "N. Andersen", "N. Ascione", "A. Behn", "M. Beshere", "N. Bibbo", "A. Bittner", "S. Black", "H. Bottiglieri", "J. Boutin", "T. Cannistraro", "B. Cosgrove", "S. Davis", "S. Dean", "B. DiBattista", "N. Farb", "P. Fiumara", "M. Flaherty", "P. Fox", "A. Galvagna", "R. Gaskin", "M. Glick", "J. Gomes", "R. Goodman", "M. Greene", "L. Guleserian", "B. Hack", "E. Hadley", "T. Hanson", "A. Harrison", "C. Hart-Nibbrig", "I. Hendrix", "S. Horkan", "B. Ibrahima", "T. Jonas", "Z. Khozozian", "D. Kilbride", "S. Kilcoyne", "J. Kornmehl", "L. Kuehberger", "A. Lee", "B. Lee", "L. Lenkutis", "J. Luehrman", "C. Mackey", "J. McManus", "J. McWeeny", "L. Micciche", "B. Miller", "A. Monahan", "J. Mullowney", "C. Pagan", "J. Pagan", "N. Pappas", "C. Peterson", "C. Porter", "D. Potamis", "M. Powers", "M. Price", "D. Reilly", "J. Rodriguez Montgomery", "D. Roy", "M. Sandoski", "S. Scales", "I. Schmidek", "J. Schneider", "J. Sheehan", "E. Sidman", "G. Simmons", "D. Slatkavitz", "C. Sparks", "A. Stanger", "W. Stewart", "G. Theberge", "L. Tolkoff", "L. Travaglini", "L. Trevisan", "C. Vallis", "A. Vittal", "N. Voss", "C. Walsh", "K. Weldon", "A. White", "C. Wild", "C. Winchenbaugh", "D. Xie", "W. Yakoobian", "B. Young", "J. Abbrecht", "A. Asherman", "S. Atalla", "W. Austen", "R. Awad", "B. Barlage", "M. Biotti", "M. Bobo", "C. Brunner", "C. Brusie", "M. Butler", "J. Butterworth", "F. Campbell", "J. Cannistraro", "M. Carboni", "C. Carey", "W. Carroll", "D. Carter", "B. Chitkara", "D. Cho", "D. Cho", "D. Ciano", "C. Connell", "R. Cooper", "B. Cummings", "A. Curtis", "M. Daignault", "J. Doolan", "D. Drucker", "J. Dyer", "J. Eaton", "S. Egan", "J. Farrell", "A. Gavronsky", "M. Ghebrelul", "N. Gleason", "J. Goguen", "E. Goldstein", "M. Grant", "A. Green", "J. Gregor", "C. Hazard", "Q. Healey", "N. Henehan", "J. Houston-Davis", "J. Hurd", "N. Keating", "W. Kelly", "J. Krattenmaker", "B. Kuechle", "A. Lavigne", "M. Lindstrom-Chalpin", "W. Lloyd", "A. Lo", "C. LoGrasso", "L. LoPresti", "J. Mack", "T. Mackey", "D. Markham", "W. Marra", "L. Mezzanotte", "J. Milewski", "C. Milmoe", "L. Montoya", "D. Moran", "A. Muse", "C. Nelson", "W. Nolan", "R. O'Donnell", "A. Pellagrini", "T. Penna", "F. Pimental", "J. Puglielli", "T. Rayment", "S. Russell", "H. Schmidek", "J. Shah", "R. Siegel", "K. Simmons", "C. Smirl", "D. Souza Ribeiro", "L. Theberge", "M. Torrey", "M. Wagner", "B. Wood")
    );


    private Context mContext;
    private int btn_id;
    private int total_btns = 300;

    public ButtonAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return total_btns;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ToggleButton btn;

        if (view == null) {
            btn = new ToggleButton(mContext);

            String studentName = namesList.get(btn_id++);
            //String studentName = MainActivity.chapel.get(btn_id++);
            btn.setText(studentName);
            btn.setTextSize(10);
            btn.setTextOff(studentName);
            btn.setTextOn(studentName);
            btn.setBackgroundColor(0xFFFF0000); // red
            //btn.setBackgroundColor(0xFFCCCCCC); // gray

        }
        else {
            btn = (ToggleButton) view;
        }

        // button toggled checker
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //is ABSENT
                    btn.setBackgroundColor(0xFFFF0000); //Set red
                    MainActivity.absentStudents.add((String) btn.getText() + " ~ hello");
                }
                else { // IS PRESENT
                    btn.setBackgroundColor(0xFFFF0000); //Set grey
                    while(MainActivity.absentStudents.remove((String) btn.getText())); //removes all instances
                }
            }
        });

        return btn;


    }
}
