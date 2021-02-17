package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

interface CouponsPresenter {
    //Al interactor
    fun getCoupons()
    //A la vista
    fun showCoupons(coupons: ArrayList<Coupon>?)
}