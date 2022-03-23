package com.develop.sary.view.dashboard.fragments.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.develop.sary.R
import com.develop.sary.responses.HomeCatalogResponse
import com.develop.sary.utility.visible
import kotlinx.android.synthetic.main.item_parent_recyclerview.view.*

class ParentRecyclerAdapter(
    private val context: Context
) : RecyclerView.Adapter<ParentRecyclerAdapter.ParentViewHolder>() {

    private lateinit var layoutManager: GridLayoutManager
    private var list: List<HomeCatalogResponse.Catalog> = ArrayList<HomeCatalogResponse.Catalog>()
    var viewPool = RecycledViewPool()

    fun setCatalogList(itemList: List<HomeCatalogResponse.Catalog>) {
        list = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {

        return ParentViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_parent_recyclerview, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {

        val parentOptionItem: HomeCatalogResponse.Catalog = list[position]

        if (parentOptionItem.show_title && parentOptionItem.data.isNotEmpty()) {
            holder.itemView.tvGroupTittle.visible(true)
            holder.itemView.tvGroupTittle.text = parentOptionItem.title
        }

        if (parentOptionItem.data.isEmpty()) {
            holder.itemView.lyChildItemContainer.visible(false)
            holder.itemView.tvGroupTittle.visible(false)
            holder.itemView.childRecyclerView.visible(false)

        }

        layoutManager = when (parentOptionItem.ui_type) {

            "grid" -> GridLayoutManager(
                context,
                parentOptionItem.row_count,
                GridLayoutManager.VERTICAL,
                false
            )

            else -> GridLayoutManager(
                context,
                1,
                GridLayoutManager.HORIZONTAL,
                false
            )

        }

        layoutManager.initialPrefetchItemCount = list.size
        holder.itemView.childRecyclerView.layoutManager = layoutManager

        val childOptionItemAdapter =
            ChildRecyclerAdapter(
                context,
                parentOptionItem.data,
                parentOptionItem.data_type,
                parentOptionItem.ui_type
            )
        holder.itemView.childRecyclerView.adapter = childOptionItemAdapter
        holder.itemView.childRecyclerView.setRecycledViewPool(viewPool)

    }

    inner class ParentViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView)


}