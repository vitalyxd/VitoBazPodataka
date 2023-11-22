package hr.obrovac.firebase

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class textAdapter(
    private val list:ArrayList<textAdapter>, private val th:Context, private val Listener:(Int)->Unit //dvije varijable koje primaju nasu funkciju o je lista, this od main i ima listener koji vraca int vrijednost
    ):RecyclerView.Adapter<textAdapter.ViewHolder> () //recyclerView je interface, on zahtjeva odredene metode od klase, bit ce crveno dok ne implementiramo te metode, implemetiramo ih alt+enter, mis postavit na class textAdapter
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): textAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: textAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size

    }


}