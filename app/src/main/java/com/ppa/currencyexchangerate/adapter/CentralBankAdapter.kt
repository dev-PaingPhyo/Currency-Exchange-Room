package com.ppa.currencyexchangerate.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ppa.currencyexchangerate.ConvertActivity
import com.ppa.currencyexchangerate.R
import com.ppa.currencyexchangerate.database.CentralExchange
import kotlinx.android.synthetic.main.item_list.view.*

class CentralBankAdapter(private var centralList: List<CentralExchange>
) : RecyclerView.Adapter<CentralBankAdapter.CentralBankViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CentralBankViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return CentralBankViewHolder(view)
    }

    override fun getItemCount(): Int {
        return centralList.size
    }

    override fun onBindViewHolder(holder: CentralBankViewHolder, position: Int) {
        val central = centralList[position]

        holder.txRate.text = centralList[position].centralRate
        holder.txFlag.setImageResource(centralList[position].centralFlag)
        holder.txName.text = centralList[position].centralName
        holder.txNameLong.text = centralList[position].centralNameLong

        val context = holder.itemView.central_ExchangeRate.context
        holder.itemView.central_Layout.setOnClickListener {
            val intent = Intent(context, ConvertActivity::class.java)
            intent.putExtra("app_bar"," Central Bank Convert")
            intent.putExtra("Flag",central.centralFlag)
            intent.putExtra("Currency",central.centralName)
            intent.putExtra("Rate", central.centralRate)
            context.startActivity(intent)
        }
    }

    inner class CentralBankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txRate: TextView = itemView.findViewById(R.id.central_ExchangeRate)
        var txFlag: ImageView = itemView.findViewById(R.id.central_Flag)
        var txName : TextView = itemView.findViewById(R.id.central_Currency_Short)
        var txNameLong : TextView = itemView.findViewById(R.id.central_Currency_Long)

    }



}