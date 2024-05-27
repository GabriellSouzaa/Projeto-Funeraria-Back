package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.FuneralParlorRequest;
import funerary.genro.feliz.app.models.requests.FuneralPlanRequest;
import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.FuneralParlorResponse;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;

import java.util.List;
import java.util.Optional;

public interface FuneralParlorGateway {

    List<FuneralParlorResponse> getFuneralParlors();

    FuneralParlorResponse getFuneralParlor(Long id);

    void updateFuneralParlor(Long id, FuneralParlorRequest funeralParlorRequest);

    void createFuneralParlor(FuneralParlorRequest funeralParlorRequest);

    void deleteFuneralParlor(Long id);
}
