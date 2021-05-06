package com.cdk.service;

import com.cdk.constants.AmountConstants;

import lombok.extern.slf4j.Slf4j;

/*
Customer Type: Regular
Purchase Amount Slab     Discount %
$0 - $ 5,000 				Nil
$ 5,000 - $ 10,000 			10%
$ 10,000 & above 			20%
 */
@Slf4j
public class RegularDiscount implements IdiscountStrategy {

	@Override
	public Double applyDiscount(Double purchaseAmount) {
		log.debug("In regular discount Strategy");
		Double ans = purchaseAmount;
		ans -= Math.max(0, purchaseAmount - AmountConstants.TEN_THOUSAND) * AmountConstants.TWENTY_PERCENT;
		ans -= Math.max(0, Math.min(purchaseAmount, AmountConstants.TEN_THOUSAND) - AmountConstants.FIVE_THOUSAND)
				* AmountConstants.TEN_PERCENT;
		return ans;
	}

}
