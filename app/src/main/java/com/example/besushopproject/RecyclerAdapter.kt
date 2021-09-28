package com.example.besushopproject


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import kotlin.random.Random

//Constructor Declaration
class RecyclerAdapter(
    private val context:Context,
    private val products: MutableList<Product>,
    private val clickListener: (Product) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //Binding the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.view.setOnClickListener { clickListener(product) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_contact, parent, false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    //Viewholder binding data from the RecyclerView to the View in order to display the information
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //getting the View's references
        private val productName = view.findViewById(R.id.productName) as TextView
        private val price = view.findViewById(R.id.productPrice) as TextView
        private val image = view.findViewById(R.id.imgProduct) as ImageView
        private val rbRate: RatingBar = view.findViewById(R.id.productRate)

        //Binding data to Views
        fun bind(product: Product) {
            productName.text = product.title
            price.text = "$${product.price.toString()}"
            image.load(product.image)
            rbRate.rating = randomBetweenOneAndFive()
        }

        //function to get a random number between 1 and 5.
        fun randomBetweenOneAndFive() = Random.nextInt(1, 5).toFloat()
    }
}
