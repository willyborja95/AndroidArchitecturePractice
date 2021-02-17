package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponsPresenter

class CouponInteractorImpl (var couponPresenter: CouponsPresenter): CouponInteractor {

    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}