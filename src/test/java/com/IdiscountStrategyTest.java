package com;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cdk.service.IdiscountStrategy;
import com.cdk.service.PremiumDiscount;
import com.cdk.service.RegularDiscount;

@RunWith(SpringJUnit4ClassRunner.class)
public class IdiscountStrategyTest {
	
	private Map<String, List<Double>> customerPurchanseMap;
	private List<Double> amount;
	private IdiscountStrategy discount;

	@Before
	public void setUp() {
		customerPurchanseMap = new HashMap<>();
		amount = new ArrayList<>();
		amount.add(4000.0);
		amount.add(5000.0);
		amount.add(8000.0);
		amount.add(10000.0);
		amount.add(12000.0);
		amount.add(15000.0);
		amount.add(20000.0);
		customerPurchanseMap.put("premium", amount);
		customerPurchanseMap.put("regular", amount);
	}

	@Test
	public void shouldApplyDiscountStrategies() {
		for (Map.Entry<String, List<Double>> entry : customerPurchanseMap.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("premium")) {
				discount = new PremiumDiscount();
				assertTrue(discount.applyDiscount(4000.0) == 3600);
				assertTrue(discount.applyDiscount(8000.0) == 7000);
				assertTrue(discount.applyDiscount(12000.0) == 10200);
				assertTrue(discount.applyDiscount(20000.0) == 15800);
			} else {
				System.out.println("\n");
				discount = new RegularDiscount();
				assertTrue(discount.applyDiscount(5000.0) == 5000);
				assertTrue(discount.applyDiscount(10000.0) == 9500);
				assertTrue(discount.applyDiscount(15000.0) == 13500);
			}
		}
	}

}
