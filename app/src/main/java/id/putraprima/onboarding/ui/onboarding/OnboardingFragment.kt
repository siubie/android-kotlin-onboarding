package id.putraprima.onboarding.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import id.putraprima.onboarding.R
import id.putraprima.onboarding.databinding.FragmentOnboardingBinding

/**
 * A simple [Fragment] subclass.
 */
class OnboardingFragment : Fragment() {
    private var items: List<OnboardingItem?>? = null
    lateinit var binding: FragmentOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_onboarding, container, false)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding, container, false)
        items = listOf<OnboardingItem>(
            OnboardingItem(
                R.drawable.onboarding_wallet,
                "Smart Wallet",
                "Managing your money can be the easiest thing you do all day."
            ),
            OnboardingItem(
                R.drawable.onboarding_money,
                "Effortless Budgeting",
                "Customize your budget categories and stay on top of your spending 24/7."
            ),
            OnboardingItem(
                R.drawable.onboarding_piggybank,
                "Automatic Savings",
                "Set your savings goal, and let Empower figure out how to get you there."
            )
        )
        val adapter = OnboardingAdapter(items as List<OnboardingItem>);
        binding.viewPager.adapter = adapter
        setUpIndicator()
        setActive(0)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setActive(position)
            }
        })

        binding.btnLogin.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment())
        }

        binding.btnSignUp.setOnClickListener { view: View ->
            view.findNavController().navigate(OnboardingFragmentDirections.actionOnboardingFragmentToSignUpFragment())
        }
        return binding.root
    }

    private fun setUpIndicator() {
        val indicators = arrayOfNulls<ImageView>(items!!.size)
        var layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)

        for (item in indicators.indices) {
            indicators[item] = ImageView(context)
            indicators[item].apply {
                this!!.setImageDrawable(
                    ContextCompat.getDrawable(
                        this!!.context,
                        R.drawable.onboarding_indicator_inactive
                    )
                )
                this.layoutParams = layoutParams
            }
            binding.indicator.addView(indicators[item])
        }
    }

    private fun setActive(index: Int) {
        val indicator = binding.indicator
        val childCount = indicator.childCount
        for (i in 0 until childCount) {
            val imageView = indicator[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(context?.let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.onboarding_indicator_active
                    )
                })
            } else {
                imageView.setImageDrawable(context?.let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.onboarding_indicator_inactive
                    )
                })
            }
        }

    }

}
