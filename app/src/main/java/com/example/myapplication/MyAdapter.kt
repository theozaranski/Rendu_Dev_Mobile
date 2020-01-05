package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.myapplication.model.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter (private val dataList: MutableList<Data> )  : RecyclerView.Adapter<MyHolder>(){



    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context

        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int)
    {
        val data = dataList[position]

        /* Récupération des IDs du XML */
        val userFullNameTextView1 = holder.itemView.id_id
        val userFullNameTextView2 = holder.itemView.id_name
        val userFullNameTextView3 = holder.itemView.id_author
        val userFullNameTextView4 = holder.itemView.id_title
        val userFullNameTextView5 = holder.itemView.id_description
        val userFullNameTextView6 = holder.itemView.id_url
        val userFullNameTextView7 = holder.itemView.id_urlToImage
        val userFullNameTextView8 = holder.itemView.id_publishedAt
        val userFullNameTextView9 = holder.itemView.id_content
        val redirection_button    = holder.itemView.redirection_button



        val userAvatarImgView = holder.itemView.user_avatar



        /* Récupération des variables de Data.kt */
        val id              = "${data.id}"
        val name            = "${data.name}"
        val author          = "${data.author}"
        val title           = "${data.title}"
        val description     = "${data.description}"
        val url             = "${data.url}"
        val urlToImage      = "${data.urlToImage}"
        val publishedAt     = "${data.publishedAt}"
        val content         = "${data.content}"

        /* Affichage des variables sur les IDs du XML */
        userFullNameTextView1.text = id
        userFullNameTextView2.text = name
        userFullNameTextView3.text = author
        userFullNameTextView4.text = title
        userFullNameTextView5.text = description
        userFullNameTextView6.text = url
        userFullNameTextView7.text = urlToImage
        userFullNameTextView8.text = publishedAt
        userFullNameTextView9.text = content



        /* Permet d'afficher l'image grace à l'url */
        Picasso.get()
            .load(data.urlToImage)
            .into(userAvatarImgView)





        /* Permet de creer une petite fenetre popup lorsqu'on clique sur la vue */
            userFullNameTextView1.setOnClickListener { Toast.makeText(context, "ID"                             , Toast.LENGTH_LONG).show() }
            userFullNameTextView2.setOnClickListener { Toast.makeText(context, "Name"                           , Toast.LENGTH_LONG).show() }
            userFullNameTextView3.setOnClickListener { Toast.makeText(context, "Auteur"                         , Toast.LENGTH_LONG).show() }
            userFullNameTextView4.setOnClickListener { Toast.makeText(context, "Titre"                          , Toast.LENGTH_LONG).show() }
            userFullNameTextView5.setOnClickListener { Toast.makeText(context, "Description"                    , Toast.LENGTH_LONG).show() }
            userFullNameTextView6.setOnClickListener { Toast.makeText(context, "Url de l'article"               , Toast.LENGTH_LONG).show() }
            userFullNameTextView7.setOnClickListener { Toast.makeText(context, "Url de l'image de l'article"    , Toast.LENGTH_LONG).show() }
            userFullNameTextView8.setOnClickListener { Toast.makeText(context, "Date de publication"            , Toast.LENGTH_LONG).show() }
            userFullNameTextView9.setOnClickListener { Toast.makeText(context, "Contenu"                        , Toast.LENGTH_LONG).show() }

       /* val webView = WebView(this)
        webView.loadUrl(url)
        this.context.content*/

        redirection_button.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            context.startActivity(i)
            }
    }
}
