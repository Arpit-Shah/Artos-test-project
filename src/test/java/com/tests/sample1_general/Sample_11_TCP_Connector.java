package com.tests.sample1_general;

import java.util.concurrent.TimeUnit;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestImportance;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.Importance;
import com.artos.framework.infra.TestContext;
import com.artos.framework.listener.RealTimeLogEventListener;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.TCPClient;
import com.artos.utils.TCPServer;
import com.artos.utils.Transform;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code TCPClient} and {@code TCPServer} classes
 * </PRE>
 */
@Group(group = "SLOW")
@TestImportance(Importance.CRITICAL)
@TestPlan(preparedBy = "arpit", preparationDate = "20/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 11)
public class Sample_11_TCP_Connector implements TestExecutable {

	@TestImportance(Importance.HIGH)
	@Group(group = "GOODPATH")
	@Unit
	public void testUnit_1(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		Thread t = new Thread(new ServerTask(context));
		t.start();

		Transform tfm = new Transform();
		TCPClient client = new TCPClient("127.0.0.1", 9000);
		client.setRealTimeListener(new RealTimeLogEventListener(context));
		client.connect();

		int i = 0;
		client.sendMsg("Hi");
		while (client.isConnected() && i < 100) {
			context.getLogger().info(tfm.bytesToHexString(client.getNextMsg(10000, TimeUnit.MILLISECONDS)));
			client.sendMsg("Hello from a Clinet".getBytes());
			i++;
		}
		client.disconnect();
		// --------------------------------------------------------------------------------------------
	}

}

class ServerTask implements Runnable {

	TCPServer server = new TCPServer(9000);
	Transform tfm = new Transform();
	TestContext context;
	
	public ServerTask(TestContext context) {
		this.context = context;
		server.setRealTimeListener(new RealTimeLogEventListener(context));
	}

	@Override
	public void run() {
		try {
			server.connect();

			int i = 0;
			while (i < 100) {
				context.getLogger().info(tfm.bytesToHexString(server.getNextMsg(10000, TimeUnit.MILLISECONDS)));
				server.sendMsg("Hello from a Server".getBytes());
				i++;
			}
			server.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}