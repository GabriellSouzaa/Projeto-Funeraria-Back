package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.domain.FuneralPlan;



public interface EmailGateway {

   void sendEmailToDelayedPlans(FuneralPlan funeralPlan, int diasAtrasado, double valorAPagar);
}
