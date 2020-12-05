package com.uthoff.adeventskalender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

public class DoorActivity extends AppCompatActivity {
    private int index;
    private ArrayList<Door> content;
    private TextView txtHead;
    private TextView txtContent;
    private ImageView Image;
    private TextView answer;
    private EditText etanswer;
    private Button btnanswer;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        setContentView(R.layout.activity_door);

        Intent intent = getIntent();
        index = intent.getIntExtra("door_index", 0);
        content = new ArrayList<>();
        txtHead = findViewById(R.id.door_txt_head);
        txtContent = new TextView(this);
        Image = findViewById(R.id.door_img);
        answer = findViewById(R.id.answer);
        etanswer = findViewById(R.id.txtanswer);
        btnanswer = findViewById(R.id.answerbtn);
        layout = findViewById(R.id.layout);
        ScrollView scrollView = findViewById(R.id.door_scrollView);
        scrollView.addView(txtContent);

        setContent();
        setLayout();

    }

    private void setLayout() {
        Door currDoor = content.get(index - 1);
        txtHead.setText(index + ". Türchen");
        txtContent.setText(currDoor.getText());
        txtContent.setTextSize(18.0F);
        txtContent.setTextColor(Color.BLACK);

        if (currDoor.getPicture() != null) {
            Image.setImageDrawable(currDoor.getPicture());
        } else {
            Image.setVisibility(View.INVISIBLE);
        }

        if(index == 18) {
            answer.setVisibility(View.VISIBLE);
            btnanswer.setVisibility(View.VISIBLE);
            etanswer.setVisibility(View.VISIBLE);
        }
    }

    public void onAnswer(View view) {
        String Antwort = "";
        try {
            Antwort = etanswer.getText().toString();
        }catch (Exception e) {

        }

        if(Antwort.equals("9")) {
            txtHead.setVisibility(View.INVISIBLE);
            txtContent.setVisibility(View.INVISIBLE);
            Image.setVisibility(View.INVISIBLE);
            answer.setVisibility(View.INVISIBLE);
            btnanswer.setVisibility(View.INVISIBLE);
            etanswer.setVisibility(View.INVISIBLE);
            layout.setBackgroundResource(R.drawable.body);

        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(DoorActivity.this).create();
            alertDialog.setMessage("NÖ :D");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ich probiers nochmal",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    private void setContent() {
        content.add(new Door("Da ich beim Basteln einfach zwei linke Hände habe, dir aber " +
                "trotzdem gerne einen kleinen Adventskalender machen wollte, habe ich mich dazu " +
                "entschieden das hierrüber zu machen. Hinter den Türchen verbergen sich immer " +
                "unterschiedliche Dinge. Manchmal ein kleines Geschenk, manchmal ein Gutschein " +
                "oder auch einfach nur ein kleiner Text. Schließlich sind wir ja beide arm und " +
                "müssen noch etwas Geld für unseren Urlaub übrig lassen. Das ist der erste " +
                "kleine Teil deines Weihnachtsgeschenkes, den wir nicht zusammen machen können. " +
                "Und natürlich hast du es nicht erraten und du lagst auch falsch damit dass man " +
                "es nicht essen kann. Denn wenn du Glück hast enthält ein Türchen auch etwas " +
                "essbares. Ich wünsche dir auf jeden Fall ganz viel Spaß mit dem Adventskalender " +
                "und hoffe er gefällt dir."));

        content.add(new Door("Heute gibt es einen Gutschein und du wirst in lieben! " +
                "Vermutlich hast du es schon am Bild erkannt. Es geht um die Liebe deines Lebens" +
                "\n\nP\nO\nM\nM\nE\nS\n\n" +
                "Wenn es dich mal wieder überkommt und ich auf dem Weg zu dir bin oder bei dir " +
                "bin kannst du jeder Zeit diesen Gutschein einlösen und ich bringe dir Pommes.",
                getResources().getDrawable(R.drawable.pommes)));

        content.add(new Door("Nach Weihnachten kommt Ostern. Als kleines Warm-Up musst du " +
                "dein nächstes kleines Geschenk suchen.\n\nTipp:\nEs befindet sich an einem Ort, " +
                "der mal nach mir gerochen hat.", getResources().getDrawable(R.drawable.osterei)));

        content.add(new Door("Gutschein für eine Massage. Wir können daraus natürlich auch " +
                "mehr als nur eine einfache Massage machen ;)",
                getResources().getDrawable(R.drawable.massage)));

        content.add(new Door("Achja wir hassen es beide ... spühlen. Desswegen schenke " +
                "ich dir heute einen Spühl-Gutschein. Wenn ich mal bei dir bin und du den " +
                "Gutschein einlösen willst spühle ich alles für dich. Kann nur nicht garantieren, " +
                "dass du dabei trocken bleibst :D\nAlso musst du dich vielleicht danach ausziehen ;)"));

        content.add(new Door("Ich hoffe du hast deine Schuhe geputzt! :D\nWas es heute gibt " +
                "ist nicht schwer zu errate. Schau einfach mal in eine der Schubladen unter " +
                "deinem Bett. Ich hoffe das hast du nicht vor heute schon gemacht.",
                getResources().getDrawable(R.drawable.weihnachtsmann)));

        content.add(new Door("Wir gehen bestimmt dieses Jahr zusammen auf einen " +
                "Weihnachtsmarkt. Vielleicht ja auch heute. Und vielleicht finden wir dann " +
                "da eine Kleinigkeit für dich :*", getResources().getDrawable(R.drawable.weihnachtsmarkt)));

        content.add(new Door("Beim nächsten mal, wenn wir einen Film gucken möchten, darfst du entscheiden was wir schauen. " +
                "Du hast die freie Wahl und ich habe nix zu melden :D."));

        content.add(new Door("Zu dem Bild muss ich nicht viel sagen oder? Das ist ein Gutschein für eine Kino Karte.", getResources().getDrawable(R.drawable.cinema)));

        content.add(new Door("Manchmal, wenn du irgendwo Weg bist, ist das ein Problem mit dem nach Hause kommen. " +
                "Vielleicht möchtest du ja auch was triken oder so. Desswegen gibt es heute einen Taxi Gutschein. " +
                "Egal wo du bist, wenn ich ein Auto zur Verfügung habe, hole ich dich ab!", getResources().getDrawable(R.drawable.taxi)));

        content.add(new Door("Gutschein für Frühstück ans Bett. Aber nicht nur irgendein Frühstück. Frische Brötchen und alles was du haben möchtest hole ich dir :*"));

        content.add(new Door("Falls du mich mit ins Kino mitnehmen möchtest gibt es heute erst die zweite Karte. Mussten zwei " +
                "Türchen werden, weil ich arm bin.", getResources().getDrawable(R.drawable.cinema)));

        content.add(new Door("Nach dem dir das letzte mal suchen so viel Spaß gemacht hat, darfst du das direkt nochmal tun." +
                "\n\nDein Tipp heute:\nDie Sache befindet sich in der Nähe von etwas was sich sehr gut oder sehr scheiße anhören kann. " +
                "Kommt immer auf den Zeitpunkt an.", getResources().getDrawable(R.drawable.osterei)));

        content.add(new Door("Der Pommes Gutschein hat dir gefallen oder? Was auch sonst! Hier kriegst du noch einen :D", getResources().getDrawable(R.drawable.pommes)));

        content.add(new Door("Ich würde gerne mal wieder mit dir zocken. Da wir Portal bestimmt bald durch haben, müssen wir etwas " +
                "neues finden. Aber es muss ja nicht unbedingt etwas neues sein oder? Da das mit dem Minecraft Server ja nicht ganz so einfach ist, " +
                "würde ich einen Monat von dem Realam bezahlen, damit wir wieder zusammen zocken können. Natürlich vorrausgesetzt du hast lust auf Minecraft",
                getResources().getDrawable(R.drawable.minecraft)));

        content.add(new Door("Ich hoffe die letzte Massage hat dir gefallen ;)\nFalls ja hast du hier einen Gutschein für eine weitere Massage.",
                getResources().getDrawable(R.drawable.massage)));

        content.add(new Door("Heute würde ich mich gerne bei dir bedanken. Allerdings habe ich überhaupt keine Ahnung wo ich da anfangen soll. " +
                "Erstmal möchte ich mich dafür bedanken, dass es dich gibt und du mich so unglaublich glücklich machst. Mir ging es (abgesehen von meiner Kindheit) " +
                "noch nie so gut in meinem Leben wie mit dir.\nDann möchte ich mich dafür bedanken dass du meine Vergesslichkeit und Verpeiltheit so gut handeln kannst " +
                "und dann auch noch mit meinen Freunden so gut klar kommst. Und natürlich weiß ich es auch unheimlich zu schätzen, dass du es akzeptierst, dass ich so viel " +
                "Zeit mit Johnny, zocken und anderen Hobbys verbringe. Oder dass du mich so sehr in meinem Studium unterstützt und damit klarkommst, dass wir quasi im Moment " +
                "eine Fernbeziehung führen. Das alles ist für mich in keinster Weise selbstverständlich und ich liebe dich so sehr dafür. Ich weiß nicht ob ich diesen Stress " +
                "ohne dich so gut bewältigen würde.\nAber eigentlich möchte ich dir nur sagen das ich dich mehr liebe als du dir irgendwie vorstellen kannst. Ich habe noch " +
                "nie einen Menschen auf die Art geliebt wie ich dich liebe. Auch wenn ich gerade in Aachen bin sollst du dich ganz ganz feste gedrückt und geküsst fühlen. Ich " +
                "freue mich, wenn wir uns am Wochenende endlich wiedersehen. <3<3<3", getResources().getDrawable(R.drawable.herz)));

        content.add(new Door("Ich habe vor mir in einem Regal nebeneinander Uhren in einer Reihe stehen. Zwei davon sind Kuckucksuhren. " +
                "Eine Kuckucksuhr ist die sechste Uhr von links, die andere ist die achte Uhr von rechts! Zwischen den beiden Kuckucksuhren stehen genau drei andere Uhren." +
                "\n\n\nPS:\nMach dieses Rätsel am besten erst, wenn du ein ganz klein wenig scharf bist ;)", getResources().getDrawable(R.drawable.frage)));

        content.add(new Door("Was kann man hier draus machen?" +
                "\n\n - Kartoffeln\n - Mehl\n - Cajun Gewürz\n - Salz\n - Zwiebeln\n - Paprika\n - Pfeffer\n - Bier\n - Jede Menge Öl\n\n" +
                "Ich besorg die Zutaten, du die Fritteuse deiner Eltern."));

        content.add(new Door("Dieses Geschenk kriegst du von mir. Daran musste ich letztens irgendwie denken. Als wir uns noch frisch kannten " +
                "lag diese Sache auf dem Sofa Tisch in deinem Zimmer bei deinen Eltern.\n\nKeine Sorge, du musst nicht erraten wobei es darum geht :D"));

        content.add(new Door("Gutschen, wenn es das nächste mal im Karton rappeln soll ;)\nAußreichend Batterien natürlich inklusive :D"));

        content.add(new Door("Hast du deinen Gutschein zum spühlen schon eingelöst? Bestimmt oder? " +
                "Da mir das vermutlich so wahnsinnig viel Spaß gemacht hat, spühle ich gerne noch einmal für dich :*\n" +
                "Ausziehen darfst du dich natürlich auch dabei wieder, dann gebe ich mir extra Mühe beim spühlen :D"));

        content.add(new Door("Wir nähern uns dem Ende des Adventskalenders. Ich hoffe er hat dir bis hier hin gefallen und hat dir etwas " +
                "Spaß gemacht. Du glaubst garnicht wie lange ich gebraucht habe um Ideen für 24 Türchen zu Sammeln. Mein unkreatives Köppfchen hat da ein " +
                "bisschen länger für gebraucht. Aber Sachen wie Pommes oder Schokolade gehen ja immer :D\nMorgen kommt noch etwas 'besonderes' und dann " +
                "kriegst du auch schon dein richtiges Geschenk. Ich hoffe das gefällt dir genau so wie der Kalender."));

        content.add(new Door("Zum Abschluss gibt es etwas besonders geiles. Lös ihn bitte bald ein, habe gerade mega Hunger." +
                "\nEin Gutschein für Boss Burger.\n\nIch hoffe, wenn du ihn einlösen willst haben sie auch offen ...", getResources().getDrawable(R.drawable.bossburger)));
    }
}
