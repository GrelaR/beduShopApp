package com.example.besushopproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class ListFragment : Fragment() {

    private lateinit var mAdapter : RecyclerAdapter
    private lateinit var listener : (Product) -> Unit
    private lateinit var recyclerProducts : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerProducts = view.findViewById(R.id.recyclerProducts)
        //Setting the listener that will be executed any time a product is clicked
        //then navigates to Detail Fragment passing the product information by safeArgs
        listener = {
            val direction = ListFragmentDirections.actionInicioFragmentToDetailFragment(it)
            findNavController().navigate(direction)
        }
        setUpRecyclerView()
    }
    private fun setUpRecyclerView(){
        recyclerProducts.setHasFixedSize(true)
        recyclerProducts.layoutManager = LinearLayoutManager(activity)
        //setting the adapter
        mAdapter = RecyclerAdapter(requireActivity(), getProducts(), listener)
        //assigning the adapter to RecyclerView
        recyclerProducts.adapter = mAdapter
    }
    //Function to get and open the Json file located on assets directory.
    //This JSON contains every product information
    private fun getJsonDataFromAsset(context: Context, fileName: String = "products.json"): String? {

        val jsonString: String

        try {

            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }

        } catch (ioException: IOException) {

            ioException.printStackTrace()

            return null

        }

        return jsonString

    }
    //Function to get the json by calling "getJsonDataFromAsset" and then return an MutableList of objects from
    //Json using the Gson() method
    fun getProducts(): MutableList<Product> {

        val jsonString = getJsonDataFromAsset(requireContext(),"products.json")

        val listProductType = object : TypeToken<List<Product>>() {}.type

        return Gson().fromJson(jsonString, listProductType)

    }

}





