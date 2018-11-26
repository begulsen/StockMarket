package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShareGenerator{
	
	private final static BigDecimal minShareValue = BigDecimal.ZERO; 
	private final static BigDecimal maxShareValue = BigDecimal.valueOf(50);

	public ShareGenerator(List<BigDecimal> list) {
		this.setList(list);
	}
	
	private void setList(List<BigDecimal> list) {
		
	}

	private BigDecimal generateShare() throws InterruptedException {
		Random rand = new Random();
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal truncatedDouble = BigDecimal.ZERO;
		res = minShareValue.add((maxShareValue.subtract(minShareValue)).multiply(BigDecimal.valueOf(rand.nextDouble())));
		truncatedDouble = res.setScale(2, RoundingMode.HALF_UP);
		return truncatedDouble;
	}
	
	public ArrayList<BigDecimal> getShareList(){
		ArrayList<BigDecimal> shareList = new ArrayList<>();
		BigDecimal sharePrice = BigDecimal.ZERO;
		try {
			sharePrice = generateShare();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			sharePrice = BigDecimal.ZERO;
			e.printStackTrace();
		}
		shareList.add(sharePrice);
		return shareList;
		
	}
}
