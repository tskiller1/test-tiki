package vn.hungho.androidhometest.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_product.view.*
import vn.hungho.androidhometest.R
import vn.hungho.androidhometest.base.IOnAdapterListener
import vn.hungho.androidhometest.model.Product
import vn.hungho.androidhometest.utils.AppUtils

class ProductAdapter(context: Context, list: List<Product>, listener: IOnAdapterListener) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    var mContext: Context = context
    var mList: List<Product> = list
    var mListener: IOnAdapterListener = listener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_product, p0, false))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Product? = mList[position]

        holder.tvName.text = item?.name
        holder.tvPrice.text = mContext.getString(R.string.price, AppUtils.formatNumberToText(item?.price!!))

        if (item.discountRate != null && item.discountRate!! > 0) {
            holder.tvDiscount.visibility = View.VISIBLE
            holder.tvDiscount.text = mContext.getString(R.string.discount, item.discountRate)
        } else {
            holder.tvDiscount.visibility = View.GONE
        }

        if (item.reviewCount != null && item.reviewCount!! > 0) {
            holder.lnlRating.visibility = View.VISIBLE
            holder.rtbRating.rating = item.ratingAverage!!
            holder.tvReviewCount.text = mContext.getString(R.string.review_count, item.reviewCount)
        } else {
            holder.lnlRating.visibility = View.GONE
        }

        Glide.with(mContext)
            .load(item.thumbnailUrl)
            .placeholder(R.drawable.ic_image)
            .error(R.drawable.ic_image)
            .centerCrop()
            .into(holder.imvProduct)

        holder.imvTikiNow.visibility = View.GONE
        holder.lnlFastDelivery.visibility = View.GONE
        holder.tvOptionColor.visibility = View.GONE

        //Check 3 type of badge
        for (badge in item.badges!!) {
            if (badge.code.equals("tikinow")) {
                holder.imvTikiNow.visibility = View.VISIBLE
            } else if (badge.code.equals("fast_delivery")) {
                holder.lnlFastDelivery.visibility = View.VISIBLE
                holder.tvFastDelivery.text = mContext.getString(R.string.fast_delivery, badge.text, badge.option)
            } else if (badge.code.equals("option_color")) {
                holder.tvOptionColor.visibility = View.VISIBLE
            }
        }

        //Handle action click item
        holder.itemView.setOnClickListener { view ->
            mListener.onItemClickListener(view!!, holder.adapterPosition, item)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tv_name
        val imvProduct = itemView.imv_product
        val imvTikiNow = itemView.imv_tiki_now
        val tvPrice = itemView.tv_price
        val tvDiscount = itemView.tv_discount
        val lnlFastDelivery = itemView.lnl_fast_delivery
        val tvFastDelivery = itemView.tv_fast_delivery
        val tvOptionColor = itemView.tv_option_color
        val lnlRating = itemView.lnl_rating
        val rtbRating = itemView.rtb_rating
        val tvReviewCount = itemView.tv_review_count
    }
}