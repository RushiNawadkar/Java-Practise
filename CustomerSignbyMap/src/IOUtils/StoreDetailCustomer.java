package IOUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import com.customer.Customer;

public interface StoreDetailCustomer {
	static void writeDetails(Stream<Customer>Stream,String FileName) throws IOException{
		try (
			PrintWriter PW=new PrintWriter(new FileWriter(FileName)) )
		{
			Stream.forEach(s->PW.println(s));
		}
	}
}
