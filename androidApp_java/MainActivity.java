/* MainActivity.java
 * William Ryan
 * October 2022
 *
 * Usage: Android app build for galaxy note 7 tablets
 * Application downloaded directly to tablets (not available on app store)
 * Opens to gridView of the lower floor of the chapel
 * Select desired form from drop down menu to highlight all students as red (absent)
 * Toggle student attendance by tapping corresponding button
 * Present student buttons will appear white
 * Submit attendendce to Jim Peck by clicking "submit attendance" button
 * Automatically launches GMail application with absent students loaded into message body
 */

package com.example.chapelproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.*;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // INSTANCE VARIABLES
    private Button clearAbsentsBTN; // resets absent list for all students
    GridView buttonsGV;             // stores grid of buttons for each seat

    // ArrayList which tracks all absent students
    // Initialize as empty
    // Populated by form select below
    // students are removed by the toggleButton located inside GVadapter.java
    static ArrayList<String> absentStudents = new ArrayList<String>(
            Arrays.asList("")
    );

    // ArrayList which holds all students on the lower floor
    // Used to generate the gridview of buttons for each seat
    // CHANGE THIS EACH YEAR
    ArrayList<String> namesList = new ArrayList<String>(
            Arrays.asList("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "J Zellner-Form III", "", "", "", "", "", "", "", "", "", "", "", "S Zavratsky-Form III", "I Yonis-Form III", "D Woolbert-Form III", "P Wall-Form III", "W Trautz-Form III", "L Toland-Form III", "", "", "", "", "H Steeves-Form III", "A Sousa-Form III", "B Sloper-Form III", "", "", "", "", "", "W Skordos-Form III", "A Savoulides-Form III", "W Sandor-Form III", "", "", "", "C Rubel-Form III", "D Roman-Form III", "D Robinson-Form III", "T Rivera-Wills-Form III", "M Rich-Form III", "W Raymond-Form III", "O Popkowski-Smith-Form III", "", "", "", "L Nuernberg-Form III", "I Novod-Form III", "P Nolan-Form III", "", "", "", "", "", "B Murphy-Form III", "K Monteiro-Form III", "B Mazur-Form III", "", "", "", "R Marth-Form III", "L MacLean-Form III", "J Ma-Form III", "J Lynch-Form III", "C Lynch-Form III", "D Lundquist-Form III", "H Liu-Form III", "", "", "", "H Lee-Form III", "H Lavoie-Form III", "Y Lara-Form III", "", "", "", "", "", "Z Kromah-Form III", "B Kilpatrick-Form III", "C Kelly-Form III", "", "", "", "C Kaufman-Form III", "T Jarvis-Form III", "C Jacobs-Form III", "Y Ibrahim-Form III", "J Hurley-Form III", "J Hunnicutt-Form III", "M Huang-Form III", "T Grossman-Form III", "", "", "D Giguere-Form III", "D Gibbs-Form III", "E Fritz-Form III", "", "", "", "", "", "W Fradette-Form III", "R Flynn-Form III", "G Figler-Form III", "N Fantasia-Form III", "", "", "J Eikeboom-Form III", "N Ehler-Form III", "W Dunn-Form III", "W Devens-Form III", "W Days-Form III", "J Daley Demerle-Form III", "D Curtin-Form III", "U Copeland-Form III", "", "S Colberg Reyes-Form III", "L Clifford-Form III", "A Chen-Form III", "R Chang-Wu-Form III", "", "", "", "", "", "P Chamberland-Form III", "C Carson-Form III", "", "", "", "D Carroll-Form III", "B Britt-Webb-Form III", "L Boyle-Form III", "J Bowhers-Form III", "D Bosco-Form III", "N Zhang-Form IV", "A Zhang-Form IV", "C Yoo-Form IV", "E Xie-Form IV", "", "", "", "", "", "", "", "", "", "", "P Woods-Form IV", "E Willi-Form IV", "", "", "", "E Warn-Form IV", "G Vail-Form IV", "G Turco-Form IV", "J Thibodeau-Form IV", "C Teeson-Form IV", "J Tavares-Form IV", "N Sullivan-Form IV", "J Somani-Form IV", "T Snail-Form IV", "", "", "", "", "", "", "", "", "", "", "T Smith-Form IV", "B Seo-Form IV", "J Santonelli-Form IV", "A Samuel-Form IV", "", "B Saeed-Form IV", "C Rice-Form IV", "J Ramanathan-Form IV", "H Ramanathan-Form IV", "J Pena-Form IV", "B Palladino-Form IV", "J O'Brien-Form IV", "E Norden-Form IV", "S Moreau-Form IV", "", "A Mills-Form IV", "C Maws-Form IV", "T Matos-Form IV", "L Marra-Form IV", "", "", "", "", "", "L Marabella-Form IV", "A Lyon-Form IV", "J Lotin-Form IV", "R Little-Form IV", "", "B Lindstrom-Chalpin-Form IV", "J Li-Form IV", "B Li-Form IV", "J Lee-Form IV", "S Lawrence-Form IV", "K Largess-Form IV", "L Kuehberger-Form IV", "F Kilbride-Form IV", "C Kelley-Form IV", "", "W Jones-Form IV", "N Jones-Form IV", "M Ibrahim-Form IV", "M Iandiorio-Form IV", "", "", "", "", "", "J Hurd-Form IV", "E Ho-Form IV", "W Henniger-Form IV", "C Healey-Form IV", "", "A Hanser-Form IV", "M Hadley-Form IV", "M Griffin-Form IV", "B Gong-Form IV", "N Gleason-Form IV", "P Gianoukos-Form IV", "E Fuse-Form IV", "S Flood-Form IV", "N Fiumara-Form IV", "", "A Fiorentino-Form IV", "B Ezedi-Form IV", "C Ezeani-Form IV", "J Dragoumanos-Form IV", "", "", "", "", "", "R Dean-Form IV", "L Davis-Form IV", "T Danahy-Form IV", "B DaCosta-Form IV", "", "R Curtis-Form IV", "F Courtney-Form IV", "J Coughlin-Form IV", "M Cotter-Form IV", "J Chen-Form IV", "D Chen-Form IV", "R Castillo-Form IV", "D Casillo-Form IV", "W Cashel-Form IV", "", "M Carolan-Form IV", "J Cardichon-Form IV", "G Calhoun-Form IV", "N Butterworth-Form IV", "", "", "", "", "", "W Butler-Form IV", "P Brice-Form IV", "A Black-Form IV", "T Batchelder-Form IV", "", "J Bartlett-Form IV", "H Amenhauser-Form IV", "D Alpers-Form IV", "B Adams-Form IV", "W Achtmeyer-Form IV", "G Zug-Form V", "W Zhu-Form V", "D Woolbert-Form V", "K Wilson-Form V", "", "A White-Form V", "C Webb-Form V", "A Waugh-Form V", "W Walton-Form V", "", "", "", "", "", "E Walker-Form V", "L Waldeck-Form V", "L Verville-Form V", "W Umscheid-Form V", "", "G Umlas-Form V", "A Tosi-Form V", "C Tarlie-Form V", "A Tan-Form V", "J Summers-Form V", "M Sullivan-Form V", "J Stonestreet-Form V", "C Sidel-Form V", "T Sheehan-Form V", "", "K Sheehan-Form V", "A Shaff-Form V", "T Rupley-Form V", "M Roman-Form V", "", "", "", "", "", "J Robinson-Form V", "J Rich-Form V", "M Ramanathan-Form V", "A Popkowski-Smith-Form V", "", "R Pohl-Form V", "A Pimental-Form V", "N Pellagrini-Form V", "B Paquette-Form V", "S Onuoha-Form V", "H Okurowski-Form V", "L Nuernberg-Form V", "J Nolan-Form V", "V Mezzanotte-Form V", "", "R McKee-Form V", "C McEvoy-Form V", "J Mazur-Form V", "T Masiiwa-Form V", "", "", "", "", "", "J Lyon-Form V", "D Luo-Form V", "W Lindstrom-Chalpin-Form V", "J Lee-Form V", "", "E Lee-Form V", "I Langham-Form V", "A Laidlaw-Form V", "E Lai-Form V", "L Kuehberger-Form V", "C Kokora-Form V", "J Kilcoyne-Form V", "J Keefe-Form V", "J Kastner-Form V", "", "J Karande-Form V", "G Kaplan-Form V", "D Jones-Form V", "Y Ibrahim-Form V", "", "", "", "", "", "R Hoffman-Form V", "A Hildebrandt-Form V", "S Henao-Form V", "H Hagedorn-Form V", "", "", "", "C Goodband-Form V", "J Gomes-Form V", "D Gannon-Form V", "M Furey-Form V", "M Fritz-Form V", "", "", "", "E Friedman-Form V", "N Folker-Form V", "T Folan-Form V", "J Fernandez del Castillo-Form V", "", "", "", "", "", "", "", "", "", "", "", "", "S Fabiano-Form V", "P Evans-Form V", "C Emmert-Form V", "J Duffy-Form V", "E Dresser-Form V", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "D Roy-Form VI", "J Pagan-Form VI", "", "", "", "H Dow-Form V", "T Dolan-Form V", "D Doherty-Form V", "H DeWitt-Form V", "A Cruz-Form V", "C Crowley-Form V", "Y Constant-Form V", "C Collins-Form V", "G Cohen-Form V", "G Carroll-Form V", "L Calhoun-Form V", "H Buckley-Jones-Form V", "B Boudreau-Form V", "M Beckett-Form V", "", "", "", "M Greene-Form VI", "T Jonas-Form VI", "J Rodriguez-Montgomery-Form VI", "C Pagan-Form VI", "", "", "", "J Barrett-Form V", "S Agular-Form V", "B Adams-Form V", "B Young-Form VI", "W Yakoobian-Form VI", "D Xie-Form VI", "C Winchenbaugh-Form VI", "C Wild-Form VI", "K Weldon-Form VI", "C Walsh-Form VI", "N Voss-Form VI", "A Vittal-Form VI", "C Vallis-Form VI", "L Trevisan-Form VI", "", "", "", "R Goodman-Form VI", "S Horkan-Form VI", "D Reilly-Form VI", "J Mullowney-Form VI", "J McManus-Form VI", "A Lee-Form VI", "", "L Travaglini-Form VI", "L Tolkov-Form VI", "G Theberge-Form VI", "W Stewart-Form VI", "A Stanger-Form VI", "C Sparks-Form VI", "D Slatkavitz-Form VI", "G Simmons-Form VI", "E Sidman-Form VI", "J Sheehan-Form VI", "J Schneider-Form VI", "I Schmidek-Form VI", "S Scales-Form VI", "M Sandoski-Form VI", "", "A Bittner-Form VI", "S Dean-Form VI", "M Glick-Form VI", "I Hendrix-Form VI", "M Price-Form VI", "A Monahan-Form VI", "C Mackey-Form VI", "J Kornmehl-Form VI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "N Bibbo-Form VI", "S Davis-Form VI", "A Galvagna-Form VI", "C Hart-Nibbrig-Form VI", "M Powers-Form VI", "B Miller-Form VI", "J Luehrman-Form VI", "S Kilcoyne-Form VI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "M Beshere-Form VI", "B Cosgrove-Form VI", "P Fox-Form VI", "A Harrison-Form VI", "D Potamis-Form VI", "L Micciche-Form VI", "L Lenkutis-Form VI", "D Kilbride-Form VI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "A Behn-Form VI", "T Cannistraro-Form VI", "M Flaherty-Form VI", "T Hanson-Form VI", "C Porter-Form VI", "J McWeeny-Form VI", "B Lee-Form VI", "Z Khozozian-Form VI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "I Barry-Form VI", "J Boutin-Form VI", "P Fiumara-Form VI", "E Hadley-Form VI", "C Peterson-Form VI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "N Ascione-Form VI", "H Bottiglieri-Form VI", "N Farb-Form VI", "B Hack-Form VI", "N Pappas-Form VI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "N Andersen-Form VI", "S Black-Form VI", "B DiBattista-Form VI", "L Guleserian-Form VI"
            )
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // removes all instances of empty string from absent students
        // empty seats ("") are needed in namesList for blank buttons
        // but should not be considered as absent
        while(absentStudents.remove(""));

        // Create gridView of toggle buttons from list of student names
        buttonsGV = findViewById(R.id.activity_grid);
        GVadapter myAdapter = new GVadapter(this, namesList);
        buttonsGV.setAdapter(myAdapter);

        // "Clear Absents" button
        // Currently used to empty the absent list, should fill it
        clearAbsentsBTN = findViewById(R.id.clearAbsentsButton);
        clearAbsentsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absentStudents.clear();
                buttonsGV.setAdapter(myAdapter);
            }
        });

        // Form Selector Spinner
        // Used to delete all other forms from the current absent list
        // Keeps selected form marked as absent
        Spinner dropdown = findViewById(R.id.formSpinner);
        String[] formSelections = new String[]{"Form  ", "Form VI", "Form V", "Form IV"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, formSelections);
        dropdown.setAdapter(adapter);

        // Action: when form is selected -- remove other forms from "absent list"
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // On form selected, add that form to the missing list of kids
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedForm = dropdown.getSelectedItem().toString();

                for (int i = 0; i < namesList.size(); i++){
                    if (namesList.get(i).endsWith(selectedForm)){
                        absentStudents.add(namesList.get(i));
                    }
                }
                // refresh gridView
                buttonsGV.setAdapter(myAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });




    }

    // Preview "absentStudents" in response to viewListButtonClick
    public void viewList(View view){
        Intent intent = new Intent(this, DisplayListActivity.class);
        intent.putExtra("StudentList", absentStudents);
        startActivity(intent);
    }

}