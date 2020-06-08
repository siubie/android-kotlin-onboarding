package id.putraprima.onboarding.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.putraprima.onboarding.R
import kotlinx.android.synthetic.main.item_onboarding.view.*

class OnboardingAdapter(var onboardingItem: List<OnboardingItem>) : RecyclerView.Adapter<OnboardingAdapter.ViewPagerViewHolder>(){

    inner class ViewPagerViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return onboardingItem.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val item = onboardingItem.get(position)
        holder.itemView.txtTitleOnboarding.text= item.title
        holder.itemView.imgDescriptionOnboarding.setImageResource(item.image)
        holder.itemView.txtDescriptionOnboarding.text = item.description
    }
}