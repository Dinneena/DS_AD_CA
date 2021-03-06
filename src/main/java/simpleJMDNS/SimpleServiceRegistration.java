package simpleJMDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class SimpleServiceRegistration {
	
	public void run(int port, String serviceType, String serviceName) {

		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			int service_port = port;
			String service_desc = "test integration of jmDNS with gRPC";

			ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, service_port, service_desc);

			jmdns.registerService(serviceInfo);

			System.out.printf("registering service with type: %s and name: %s on port %d ", serviceType, serviceName,
					service_port);

			Thread.sleep(10000);
			System.out.println("\nService Registered");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
