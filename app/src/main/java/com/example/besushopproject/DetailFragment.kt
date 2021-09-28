package com.example.besushopproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.api.load
import kotlin.random.Random


class DetailFragment : Fragment() {
    //Declaring variables to get every needed view
    private lateinit var productName: TextView
    private lateinit var description: TextView
    private lateinit var rbRate: RatingBar
    private lateinit var imgProduct: ImageView
    private lateinit var productPrice: TextView
    //Variable to get the product by safeArgs using navigation
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        //Getting every view from XML "fragment_Detail" then they will be assigned
        //When onViewCreated method runs
        productName = view.findViewById(R.id.productName)
        description = view.findViewById(R.id.productDescription)
        rbRate = view.findViewById(R.id.productRate)
        imgProduct = view.findViewById(R.id.imgProduct)
        productPrice = view.findViewById(R.id.productPrice)
        return view
    }


    //function to get a random number between 1 and 5.
    private fun randomBetweenOneAndFive() = Random.nextInt(1, 5).toFloat()

    //When the view is created, get the product clicked from the list sent by safe args
    //Then assigning every view to the corresponding product value
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product : Product = args.product
            productName.text = product.title
            productPrice.text = product.price.toString()
            description.text = product.description
            imgProduct.load(product.image)
            rbRate.rating = randomBetweenOneAndFive()
        //Button to navigate to "carrito" fragment when clicked.
        val agregarAlCarritoBtn = view.findViewById<Button>(R.id.btnAgregarAlCarrito)
        agregarAlCarritoBtn.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_carritoFragment,null)
        }
    }
}

