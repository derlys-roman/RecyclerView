package br.com.any.recycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.any.recycleview.R
import br.com.any.recycleview.model.SuperHero
import com.squareup.picasso.Picasso

class HeroAdapter(private val superHero: ArrayList<SuperHero>) :
    RecyclerView.Adapter<HeroAdapter.HeroHolder>() {


    override fun getItemCount(): Int = superHero.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_hero_list, parent, false))

    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superHero[position])
    }


    class HeroHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val tvrealname = view.findViewById<TextView>(R.id.tvrealname)
        private val tvheroname = view.findViewById<TextView>(R.id.tvheroname)
        private val tvpublisher = view.findViewById<TextView>(R.id.tvpublisher)
        private val ivherophoto = view.findViewById<ImageView>(R.id.ivherophoto)

        fun render(superHero: SuperHero) {
            tvrealname.text = superHero.realName
            tvheroname.text = superHero.superHeroName
            tvpublisher.text = superHero.publisher
            Picasso.get().load(superHero.image).into(ivherophoto)
            view.setOnClickListener {
                Toast.makeText(
                    view.context,
                    superHero.superHeroName,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
