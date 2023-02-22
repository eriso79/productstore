package com.deverything.candidate.productstore.checkout.business;

import com.deverything.candidate.productstore.checkout.dto.CheckoutObject;
import com.deverything.candidate.productstore.checkout.dto.CheckoutSummaryObject;

public interface I_CheckOutBussiness {

	CheckoutSummaryObject doCheckOut(CheckoutObject checkoutObject);

}
