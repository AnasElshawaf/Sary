package com.develop.sary.view.dashboard.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.develop.sary.R
import com.develop.sary.responses.HomeCatalogResponse
import kotlinx.android.synthetic.main.item_banner_recyclerview.view.*
import kotlinx.android.synthetic.main.item_group_grid_recyclerview.view.*
import kotlinx.android.synthetic.main.item_smart_recyclerview.view.*


class ChildRecyclerAdapter(
    private val context: Context,
    private val list: List<HomeCatalogResponse.CatalogItems>,
    private val dataType: String,
    private val uiType: String
) : RecyclerView.Adapter<ChildRecyclerAdapter.ChildViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {

        return when (dataType) {
            "smart" -> {
                ChildViewHolder(
                    LayoutInflater.from(context)
                        .inflate(R.layout.item_smart_recyclerview, parent, false)
                )
            }
            "group" -> {

                if (uiType == "grid") {
                    return ChildViewHolder(
                        LayoutInflater.from(context)
                            .inflate(R.layout.item_group_grid_recyclerview, parent, false)
                    )
                } else {
                    ChildViewHolder(
                        LayoutInflater.from(context)
                            .inflate(R.layout.item_group_linear_recyclerview, parent, false)
                    )
                }
            }
            else -> {
                ChildViewHolder(
                    LayoutInflater.from(context)
                        .inflate(R.layout.item_banner_recyclerview, parent, false)
                )
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {

        val catalogItem: HomeCatalogResponse.CatalogItems = list[position]

        when (dataType) {

            "smart" -> {
                holder.itemView.tvSmartItemTittle.text = catalogItem.name
                Glide.with(context).load(catalogItem.image).into(holder.itemView.ivSmartItem)
            }
            "group" -> {
                holder.itemView.tvGroupItemTittle.text = catalogItem.name
                Glide.with(context).load(catalogItem.image).into(holder.itemView.ivGroupItem)
            }
            "banner" -> {
                holder.itemView.tvBannerItemTittle.text = catalogItem.name
                Glide.with(context).load(catalogItem.image).into(holder.itemView.ivBannerItem)
            }


        }

    }

    inner class ChildViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView)


}