package util;

import java.math.BigDecimal;
import java.util.ArrayList;

import responses.ResponseMaxProfit;

public class CalculateMaxProfit {

	public static ResponseMaxProfit maxProfit(ArrayList<BigDecimal> prices) {
		ResponseMaxProfit response = new ResponseMaxProfit();
		if (prices == null || prices.size() == 0) {
			response.setProfit(BigDecimal.ZERO);
			response.setMinIndex(0);
			response.setMaxIndex(0);
			return response;
		}
		int minIndex = 0;
		int maxIndex = 0;
		BigDecimal minPrice = prices.get(0);
		BigDecimal max = BigDecimal.ZERO;
		for (int i = 1; i < prices.size(); i++) {
			if (prices.get(i).compareTo(minPrice) < 0) {
				minPrice = prices.get(i);
				minIndex = i;
			}
			if (prices.get(i).subtract(minPrice).compareTo(max) > 0) {
				max = prices.get(i).subtract(minPrice);
				maxIndex = i;

			}
		}
		response.setProfit(max);
		response.setMinIndex(minIndex);
		response.setMaxIndex(maxIndex);
		return response;
	}
}
