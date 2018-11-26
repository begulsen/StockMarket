package application;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import connection.ConnectionDb;
import model.Share;
import responses.ResponseMaxProfit;
import util.CalculateMaxProfit;
import util.ShareGenerator;

@SpringBootApplication
@ComponentScan(basePackages={"controller"})
public class Main {
	public static void main( String[] args ) throws InterruptedException
    {
      SpringApplication.run(Main.class, args);
      
      ArrayList<BigDecimal> shareList = new ArrayList<BigDecimal>();
      
      ShareGenerator generator = new ShareGenerator(shareList);
      
      shareList = generator.getShareList();
      
      ConnectionDb conn = new ConnectionDb();
      Connection connection = conn.connection();
      //Create instance of Share
      Share share = new Share.Sharebuilder()
    		  .setCode("exampleCode")
    		  .setName("exampleName")
    		  .setPrice(shareList.get(shareList.size() - 1))
    		  .setDate(new Date())
    		  .build();
      
      ResponseMaxProfit responseMaxProfit = CalculateMaxProfit.maxProfit(shareList);
      System.out.println("If you buy share when price is " + shareList.get(responseMaxProfit.getMinIndex()));
      System.out.println(" and sell share when price is " + shareList.get(responseMaxProfit.getMaxIndex()));
      System.out.println(responseMaxProfit.getProfit());
      
      try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
    }
}

