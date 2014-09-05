package jobs;

import models.Usuario;
import play.jobs.*;
import play.mvc.Before;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {
	
	public void doJob() {
        if(Usuario.count() == 0){
            //Fixtures.loadModels("initial-data.yml");
        }
    }
	
}
