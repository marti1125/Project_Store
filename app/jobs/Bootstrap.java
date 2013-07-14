package jobs;

import play.jobs.*;

@OnApplicationStart
public class Bootstrap  extends Job{
	
	public void doJob() {
		System.out.println("El sistema a iniciado");
	}
	
}
