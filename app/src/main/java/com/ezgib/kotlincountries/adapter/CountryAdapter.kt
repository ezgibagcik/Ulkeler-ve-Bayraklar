package com.ezgib.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ezgib.kotlincountries.R
import com.ezgib.kotlincountries.databinding.ItemCountryRecycBinding
import com.ezgib.kotlincountries.model.Country
import com.ezgib.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country_recyc.view.*

class CountryAdapter(val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
       val inflater =LayoutInflater.from(parent.context)

        val view= DataBindingUtil.inflate<ItemCountryRecycBinding>(inflater,R.layout.item_country_recyc,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       holder.view.country=countryList[position]
        holder.view.listener=this
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(var view: ItemCountryRecycBinding):RecyclerView.ViewHolder(view.root) {


    }

    fun updateCountryList(newCountryList:List<Country>)
    {

        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()

    }

    override fun onCountryClicked(v: View) {

        val uuid=v.country_uuid_text.text.toString().toInt()
        val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}




