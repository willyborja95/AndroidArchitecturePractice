package com.anncode.offersandcoupons.model

import android.util.Log
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.presenter.CouponsPresenter
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl (var couponsPresenter: CouponsPresenter): CouponRepository {
    override fun getCouponsAPI() {
        var coupons: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                Log.d("testObject", response.body().toString())
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon =
                        Coupon(jsonObject)
                    Log.d("objectFormed", coupon.category)
                    coupons?.add(coupon)
                }
                couponsPresenter.showCoupons(coupons);
            }
        })
    }
}