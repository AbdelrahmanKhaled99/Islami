package com.example.islami.fragments.fragments.sebha

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.R
import com.example.islami.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {
    lateinit var binding: FragmentSebhaBinding
    private val azkarList: Array<String> = arrayOf(
        "سبحان الله",
        "الله اكبر",
        "سبحان الله وبحمده، سبحان الله العظيم.",
        "للهم إني أعوذ بك من زوال نعمتك، وتحول عافيتك، وفجاءة نقمتك، وجميع سخطك",
        "اللهم اهدني وسددني، اللهم إني أسألك الهدى والسداد",
        "اللهم إني أسألك الهدى، والتقى، والعفاف، والغنى",
        "اللهم إني أعوذ بك من جهد البلاء، ودرك الشقاء، وسوء القضاء، وشماتة الأعداء",
        "اللهم إني أعوذ بك من العجز والكسل، والجبن والهرم والبخل، وأعوذ بك من عذاب القبر، ومن فتنة المحيا والممات",
        "اللهم رحمتك أرجو فلا تكلني إلى نفسي طرفة عين، وأصلح لي شأني كله، لا إله إلا أنت",
        "لا إله إلا أنت سبحانك إني كنت من الظالمين",
        "اللهم مصرف القلوب صرف قلوبنا على طاعتك",
        "يا مقلب القلوب ثبت قلبي على دينك",
        "للهم إني أسألك العافية في الدنيا والآخرة",
        "للهم أحسن عاقبتنا في الأمور كلها، وأجرنا من خزي الدنيا وعذاب الآخرة",
        "اللهم إني أعوذ بك من شر سمعي، ومن شر بصري، ومن شر لساني، ومن شر قلبي، ومن شر منيي",
        "اللهم إني أعوذ بك من البرص، والجنون، والجذام، ومن سيئ الأسقام",
        "اللهم إني أعوذ بك من منكرات الأخلاق، والأعمال، والأهواء",
        "اللهم إنك عفو كريم تحب العفو فاعف عني",
        "اللهم إني أعوذ بك من الجبن، وأعوذ بك من البخل، وأعوذ بك من أن أرد إلى أرذل العمر، وأعوذ بك من فتنة الدنيا وعذاب القبر",
        "اللهم اغفر لي خطيئتي، وجهلي، وإسرافي في أمري، وما أنت أعلم به مني، اللهم اغفر لي هزلي وجدي، وخطئي وعمدي، وكل ذلك عندي",
        "اللهم إني ظلمت نفسي ظلماً كثيراً، ولا يغفر الذنوب إلا أنت. فاغفر لي مغفرة من عندك، وارحمني إنك أنت الغفور الرحيم",
        "اللهم اجعل أوسع رزقك علي عند كبر سني، وانقطاع عمري",
        "اللهم اغفر لي ذنبي، ووسع لي في داري، وبارك لي في رزقي",
        "اللهم إني أسألك من فضلك ورحمتك، فإنه لا يملكها إلا أنت",
        "للهم إني أعوذ بك من الفقر، والقلة، والذلة، وأعوذ بك من أن أظلم أو أظلم",
        "اللهم إني أعوذ بك من جار السوء في دار المقامة؛ فإن جار البادية يتحول",
        "اللهم إني أعوذ بك من قلب لا يخشع، ومن دعاء لا يسمع، ومن نفس لا تشبع، ومن علم لا ينفع. أعوذ بك من هؤلاء الأربع",
        "اللهم إني أعوذ بك من يوم السوء، ومن ليلة السوء، ومن ساعة السوء، ومن صاحب السوء، ومن جار السوء في دار المقامة",
        "للهم إني أعوذ بك أن أشرك بك وأنا أعلم، وأستغفرك لما لا أعلم",
        "اللهم انفعني بما علمتني، وعلمني ما ينفعني، وزدني علماً",
        "اللهم إني أسألك علماً نافعاً، ورزقاً طيباً، وعملاً متقبلاً",
        "رب اغفر لي، وتب علي، إنك أنت التواب الغفور",
        "اللهم أعنا على ذكرك، وشكرك، وحسن عبادتك",
        "اللهم إني أسألك إيماناً لا يرتد، ونعيماً لا ينفذ، ومرافقة محمد صلى الله عليه وسلم في أعلى جنة الخلد",
        "اللهم إني أعوذ بك من غلبة الدين، وغلبة العدو، وشماتة الأعداء",
        "اللهم قني شر نفسي، واعزم لي على أرشد أمري، اللهم اغفر لي ما أسررت، وما أعلنت، وما أخطأت، وما عمدت، وما علمت، وما جهلت",
        "اللهم اغفر لي، واهدني، وارزقني، وعافني، أعوذ بالله من ضيق المقام يوم القيامة",
        "للهم متعني بسمعي، وبصري، واجعلهما الوارث مني، وانصرني على من يظلمني، وخذ منه بثأري",
        "اللهم إني أسألك عيشة نقية، وميتة سوية، ومرداً غير مخز ولا فاضح",
        "اللهم اكفنى بحلالك عن حرامك وأعننى بفضلك عمن سواك",
        "اللهم قنى عذابك يوم تبعث عبادك",
        "يا حى يا قيوم برحمتك استغيث",
        "اللهم انى اعوذ بك من شر ماعملت ومن شر مالم اعمل"

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSebhaBinding.inflate(inflater , container , false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.azkarTV.text = azkarList[0]
        sebhaOnClick()
    }

    private fun sebhaOnClick() {
        var counter = 0
        binding.tasbehatNumberTV.text = counter.toString()

        binding.bodySebhaIMG.setOnClickListener {
            counter++
            binding.tasbehatNumberTV.text = counter.toString()
            changeAzkar(counter)
            moveSebha()
        }
    }

    private fun moveSebha() {
        val currentRotation = binding.bodySebhaIMG.rotation
        val newRotation = currentRotation + 15f

        val rotationAnimator = ObjectAnimator.ofFloat(
            binding.bodySebhaIMG,
            View.ROTATION,
            currentRotation,
            newRotation
        )
        rotationAnimator.duration = 250
        rotationAnimator.start()
    }

    private fun changeAzkar(counter: Int) {
        if (counter % 33 == 0) {
            val index = (counter / 33) % azkarList.size
            binding.azkarTV.text = azkarList[index]
        }
    }
}