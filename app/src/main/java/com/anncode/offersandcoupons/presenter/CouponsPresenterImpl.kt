package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponInteractor
import com.anncode.offersandcoupons.model.CouponInteractorImpl
import com.anncode.offersandcoupons.view.CouponView

class CouponsPresenterImpl(var coupon: CouponView): CouponsPresenter {

    private var couponInteractor: CouponInteractor = CouponInteractorImpl(this)

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        coupon.showCoupons(coupons)
    }

}