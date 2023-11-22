package hr.obrovac.firebase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import hr.obrovac.firebase.databinding.ActivityMainBinding
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private var db:DatabaseReference=FirebaseDatabase.getInstance("https://fir-1-13390-default-rtdb.firebaseio.com/").getReference("text")
    var list=ArrayList<Text>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        db.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val a:List<Text> =snapshot.children.map { DataSnapshot->DataSnapshot.getValue(Text::class.java)!! } //lista nasih klasa koje smo nazvali tekst, snapshot je prikaz trenutnih podataka sa baze .children sva djeca koja se nalaze u bazi, sve sto je pod elementom baze podataka, .map je mapiranje na odredeni nacin, kako cemo mi to posloziti u listu, poslagat ce se sa .snapshot getValue, !! znaci not null exercion to forcira da ne bude null ovako nam nece izbacivat not null
                    list.addAll(a)
                }catch (_:Exception){}
                    binding.textView3.apply { layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false) //govori o tome kako ce poslagati podatke u listu, to je zapravo drugacija lista viewa, linearlayout je da postavlje jedno ispod drugo  direktno bez constrints, vertikalno smo napisali da ih vertikalno ispisuje, false je za reversanje znaci da ide odozgo prvi element, a  do odozdo zadnji element, a da je true bilo bi obrnuto
                    adapter = text.adapter(list, this@MainActivity){position->Toast.makeText(context, "kliknuli ste na ${position}.element", Toast.LENGTH_LONG ).show() //adapter je stvar koja nam govori na koji nacin cemo dodavati elemetne u recycler view, position nam govori sta adapater treba vratiti
                    }}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

}