package id.putraprima.onboarding.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.putraprima.onboarding.R
import kotlinx.android.synthetic.main.item_onboarding.view.*

class OnboardingAdapter(var onboardingItem: List<OnboardingItem>) :
    RecyclerView.Adapter<OnboardingAdapter.ViewPagerViewHolder>() {

    class ViewPagerViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            item: OnboardingItem
        ) {
            itemView.txtTitleOnboarding.text = item.title
            itemView.imgDescriptionOnboarding.setImageResource(item.image)
            itemView.txtDescriptionOnboarding.text = item.description
        }

        companion object {
            fun from(parent: ViewGroup): ViewPagerViewHolder {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_onboarding, parent, false)
                return ViewPagerViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder.from( parent)
    }

    override fun getItemCount() = onboardingItem.size

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val item = onboardingItem.get(position)
        holder.bind(item)
    }


}