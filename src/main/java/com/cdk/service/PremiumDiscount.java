package com.cdk.service;

import com.cdk.constants.AmountConstants;

import lombok.extern.slf4j.Slf4j;

/*
Customer Type: Premium
Purchase Amount Slab     Discount %
$0 - $ 4,000 				10%
$ 4,000 - $ 8,000 			15%
$ 8,000 - $ 12,000 			20%
$ 12,000 & above 			30%
 
*/
@Slf4j
public class PremiumDiscount implements IdiscountStrategy {
	@Override
	public Double applyDiscount(Double purchaseAmount) {
		log.debug("In premium discount Strategy");
		Double ans = purchaseAmount;
		ans -= Math.max(0, purchaseAmount - AmountConstants.TWELVE_THOUSAND) * AmountConstants.THIRTY_PERCENT;
		ans -= Math.max(0, Math.min(purchaseAmount, AmountConstants.TWELVE_THOUSAND) - AmountConstants.EIGHT_THOUSAND)
				* AmountConstants.TWENTY_PERCENT;
		ans -= Math.max(0, Math.min(purchaseAmount, AmountConstants.EIGHT_THOUSAND) - AmountConstants.FOUR_THOUSAND)
				* AmountConstants.FIFTEEN_PERCENT;
		ans -= Math.max(0, Math.min(purchaseAmount, AmountConstants.FOUR_THOUSAND)) * AmountConstants.TEN_PERCENT;
		return ans;
	}
}
