package com.ppa.currencyexchangerate

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ppa.currencyexchangerate.adapter.CentralBankAdapter
import com.ppa.currencyexchangerate.api.ApiClient.Companion.BASE_URL
import com.ppa.currencyexchangerate.api.ApiInterface
import com.ppa.currencyexchangerate.dateformat.getDateTime
import com.ppa.currencyexchangerate.database.CentralExchange
import com.ppa.currencyexchangerate.model.CentralResponse
import com.ppa.currencyexchangerate.viewmodel.CentralViewModel
import kotlinx.android.synthetic.main.fragment_central_bank.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DecimalFormat


class CentralBankFragment : Fragment() {

    private lateinit var centralViewModel : CentralViewModel
    private lateinit var centralBankAdapter: CentralBankAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_central_bank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val call = retrofit.create(ApiInterface::class.java).getLatest()

        call.enqueue(object : Callback<CentralResponse> {
            override fun onFailure(call: Call<CentralResponse>, t: Throwable) {
                Log.d("error",t.message)
            }

            override fun onResponse(
                call: Call<CentralResponse>,
                response: Response<CentralResponse>
            ) {
                var resResult = response.body()!!

                val centralList0 = ArrayList<CentralExchange>()

                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.uSD.toString(),
                        R.drawable.ic_usd,
                        "USD",
                        "United State Dollar"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.sGD.toString(),
                        R.drawable.ic_singapore,
                        "SGD",
                        "Singapore Dollar"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        DecimalFormat("##.###").format(
                            resResult.rates!!.jPY!!.replace(",", "").toDouble() / 100
                        ),
                        R.drawable.ic_japan,
                        "JPY",
                        "Japanese Yen"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.eUR.toString(),
                        R.drawable.ic_european_union,
                        "EUR",
                        "Euro"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.tHB.toString(),
                        R.drawable.ic_thailand,
                        "THB",
                        "Thailand Bath"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.gBP.toString(),
                        R.drawable.ic_england,
                        "GBP",
                        "Pound Sterling"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.mYR.toString(),
                        R.drawable.ic_malaysia,
                        "MYR",
                        "Malaysian Ringgit"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        DecimalFormat("##.###").format(
                            resResult.rates!!.kRW!!.replace(",", "").toDouble() / 100
                        ),
                        R.drawable.ic_south_korea,
                        "KRW",
                        "Korean Won"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.hKD.toString(),
                        R.drawable.ic_hong_kong,
                        "HKD",
                        "Hong Kong Dollar"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.cAD.toString(),
                        R.drawable.ic_canada,
                        "CAD",
                        "Canadian Dollar"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.iNR.toString(),
                        R.drawable.ic_india,
                        "INR",
                        "Indian Rupee"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.aUD.toString(),
                        R.drawable.ic_australia,
                        "AUD",
                        "Australian Dollar"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.cHF.toString(),
                        R.drawable.ic_france,
                        "CHF",
                        "Swiss Franc"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.bDT.toString(),
                        R.drawable.ic_bangladesh,
                        "BDT",
                        "Bangladesh Taka"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.bND.toString(),
                        R.drawable.ic_brunei,
                        "BND",
                        "Brunei Dollar"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        DecimalFormat("##.###").format(
                            resResult.rates!!.kHR!!.replace(",", "").toDouble() / 100
                        ),
                        R.drawable.ic_cambodia,
                        "KHR",
                        "Cambodian Riel"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.pHP.toString(),
                        R.drawable.ic_philippines,
                        "PHP",
                        "Philippines Peso"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.bRL.toString(),
                        R.drawable.ic_brazil,
                        "BRL",
                        "Brazilian Real"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        DecimalFormat("##.###").format(
                            resResult.rates!!.vND!!.replace(",", "").toDouble() / 100
                        ),
                        R.drawable.ic_vietnam,
                        "VND",
                        "Vietnamese Dong"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        DecimalFormat("##.###").format(
                            resResult.rates!!.lAK!!.replace(",", "").toDouble() / 100
                        ),
                        R.drawable.ic_laos,
                        "LAK",
                        "Lao Kip"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.nOK.toString(),
                        R.drawable.ic_norway,
                        "NOK",
                        "Norwegian Kroner"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.sEK.toString(),
                        R.drawable.ic_sweden,
                        "SEK",
                        "Swedish Krona"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.rUB.toString(),
                        R.drawable.ic_russia,
                        "RUB",
                        "Russian Rouble"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        DecimalFormat("##.###").format(
                            resResult.rates!!.iDR!!.replace(",", "").toDouble() / 100
                        ),
                        R.drawable.ic_indonesia,
                        "IDR",
                        "Indonesian Rupiah"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.zAR.toString(),
                        R.drawable.ic_south_africa,
                        "ZAR",
                        "South Africa Rand"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.cNY.toString(),
                        R.drawable.ic_china,
                        "CNY",
                        "Chinese Yuan"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.nZD.toString(),
                        R.drawable.ic_new_zealand,
                        "NZD",
                        "New Zealand Dollar"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.pKR.toString(),
                        R.drawable.ic_pakistan,
                        "PKR",
                        "Pakistani Rupee"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.lKR.toString(),
                        R.drawable.ic_sri_lanka,
                        "LKR",
                        "Sri Lankan Rupee"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.cZK.toString(),
                        R.drawable.ic_czech_republic,
                        "CZK",
                        "Czech Koruna"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.dKK.toString(),
                        R.drawable.ic_denmark,
                        "DKK",
                        "Danish Krone"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.eGP.toString(),
                        R.drawable.ic_egypt,
                        "EGP",
                        "Egyptian Pound"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.iLS.toString(),
                        R.drawable.ic_israel,
                        "ILS",
                        "Israeli Shekel"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.kES.toString(),
                        R.drawable.ic_kenya,
                        "KES",
                        "Kenya Shilling"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.kWD.toString(),
                        R.drawable.ic_kuwait,
                        "KWD",
                        "Duwaiti Dinar"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.nPR.toString(),
                        R.drawable.ic_nepal,
                        "NPR",
                        "Nepalese Rupee"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.sAR.toString(),
                        R.drawable.ic_saudi_arabia,
                        "SAR",
                        "Saudi Arabian Riyal"
                    )
                )
                centralList0.add(
                    CentralExchange(
                        resResult.rates!!.rSD.toString(),
                        R.drawable.ic_serbia,
                        "RSD",
                        "Serbian Dinar"
                    )
                )

                central_Time.text = getDateTime(resResult.timestamp!!)

                val centralBankAdapter = CentralBankAdapter(centralList0)
                val centralRecyclerView : RecyclerView = view.findViewById(R.id.recycler_Central)
                centralRecyclerView.layoutManager = LinearLayoutManager(context)
                centralRecyclerView.adapter = centralBankAdapter

                // Animation
                val lac = LayoutAnimationController(AnimationUtils.loadAnimation(context,R.anim.item_anim))
                lac.delay = 0.2f
                lac.order = LayoutAnimationController.ORDER_NORMAL
                recycler_Central.layoutAnimation = lac

            }

        })
        observeViewModel()
    }

    private fun observeViewModel(){
        centralViewModel = ViewModelProviders.of(this).get(CentralViewModel::class.java)

        centralViewModel.getResult().observe(
            viewLifecycleOwner, Observer {
                centralViewModel.loadResult()
                recycler_Central.visibility = View.VISIBLE
                progress_Bar.visibility = View.INVISIBLE
                connection_Error.visibility = View.INVISIBLE
                connection_Error1.visibility = View.INVISIBLE
                    swipe_Central.isRefreshing = false

            }
        )

        centralViewModel.getLoading().observe(
            viewLifecycleOwner, Observer { isLoading ->
                if (isLoading){
                    progress_Bar.visibility = View.VISIBLE
                    recycler_Central.visibility = View.INVISIBLE
                    connection_Error1.visibility = View.INVISIBLE
                    connection_Error.visibility = View.INVISIBLE

                } else {
                    progress_Bar.visibility = View.INVISIBLE
                    connection_Error.visibility = View.VISIBLE
                    connection_Error1.visibility = View.VISIBLE
                }

            }
        )

        centralViewModel.getError().observe(
            viewLifecycleOwner, Observer {isError ->
                if (isError) {
                    connection_Error1.visibility = View.VISIBLE
                    connection_Error.visibility = View.VISIBLE
                    recycler_Central.visibility = View.INVISIBLE

                }else {
                    connection_Error.visibility = View.INVISIBLE
                    connection_Error1.visibility = View.INVISIBLE
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        centralViewModel.loadResult()
        swipe_Central.setOnRefreshListener {
            centralViewModel.loadResult()
            swipe_Central.isRefreshing = false
        }
    }

}